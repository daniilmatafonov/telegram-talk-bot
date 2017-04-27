package com.messagebot.main.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Update implements Serializable {

	@JsonProperty("update_id")
	private long updateId;

	@JsonProperty("message")
	private Message message;

	public Update() {

	}

	public long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean hasMessage() {
		return this.message != null;
	}
}
