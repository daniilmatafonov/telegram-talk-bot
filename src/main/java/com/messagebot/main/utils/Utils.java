package com.messagebot.main.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.messagebot.main.model.Message;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dmatafonov on 04.05.2017.
 */

public class Utils {
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String getUserName(Message message){
		return message.getFrom().getFirstName() + " " + message.getFrom().getLastName();
	}

	public static String getUserNameAPI(org.telegram.telegrambots.api.objects.Message message){
		return message.getFrom().getFirstName() + " " + message.getFrom().getLastName();
	}

	public static <T> T toObject(JSONObject object, Class<T> cls) {
		try {
			return (T)objectMapper.readValue(object.toString(), cls);
		} catch(ClassCastException e) {
			logger.error("Can't cast to " + cls.getName(), e);
		} catch(Exception e) {
			logger.error("Unable to convert json to object", e);
		}
		return null;
	}
}
