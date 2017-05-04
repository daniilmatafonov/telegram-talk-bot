package com.messagebot.main.bot;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.messagebot.main.consts.TelegramBotConsts;
import com.messagebot.main.model.Message;
import com.messagebot.main.model.RequestType;
import com.messagebot.main.utils.Utils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmatafonov on 04.05.2017.
 */
public class WebhookBot {

	private static Logger logger = LoggerFactory.getLogger(WebhookBot.class);

	public static Message sendMessage(int chatId, String text) throws Exception {
		Map<String, Object> query = new HashMap<>();
		query.put("chat_id", chatId);
		query.put("text", text);
		return sendMessage(query);
	}

	private static Message sendMessage(Map<String, Object> query) throws Exception {
		JSONObject messageObject = makeRequest(RequestType.sendMessage, query);
		Message message = Utils.toObject(messageObject, Message.class);
		if (message == null) {
			throw new Exception("Cannot parse sent message");
		}

		return message;
	}

	private static JSONObject makeRequest(RequestType requestType, Map<String, Object> params) throws Exception {
		try {
			HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get(TelegramBotConsts.BOT_URL).routeParam("api_token", TelegramBotConsts.BOT_API_KEY).
					routeParam("request", requestType.name()).queryString(params).asJson();
			JSONObject resultJson = jsonNodeHttpResponse.getBody().getObject();
			boolean ok = resultJson.getBoolean("ok");
			if (!ok) {
				String description = resultJson.getString("description");
				throw new Exception("Telegram API error: " + description);
			}
			return resultJson.optJSONObject("result");
		}
			catch (Exception e) {
			logger.error("Failed to make request: " + requestType);
			throw e;
		}
	}
}
