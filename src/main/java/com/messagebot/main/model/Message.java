package com.messagebot.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message implements Serializable {

	@JsonProperty("message_id")
	private int messageId;

	@JsonProperty("from")
	private User from;

	@JsonProperty("date")
	private int date;

	@JsonProperty("chat")
	private Chat chat;

	@JsonProperty("forward_from")
	private User forwardFrom;

	@JsonProperty("forward_date")
	private int forwardDate;

	@JsonProperty("reply_to_message")
	private Message replyToMessage;

	@JsonProperty("text")
	private String text;


	@JsonProperty("location")
	private Location location;


	public Message() {

	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getForwardFrom() {
		return forwardFrom;
	}

	public void setForwardFrom(User forwardFrom) {
		this.forwardFrom = forwardFrom;
	}

	public int getForwardDate() {
		return forwardDate;
	}

	public void setForwardDate(int forwardDate) {
		this.forwardDate = forwardDate;
	}

	public Message getReplyToMessage() {
		return replyToMessage;
	}

	public void setReplyToMessage(Message replyToMessage) {
		this.replyToMessage = replyToMessage;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public boolean hasText() {
		return this.text != null && !this.text.isEmpty();
	}

}
