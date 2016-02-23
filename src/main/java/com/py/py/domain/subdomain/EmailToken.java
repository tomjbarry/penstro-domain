package com.py.py.domain.subdomain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.enumeration.EMAIL_TYPE;

public class EmailToken {

	public static final String CREATED = SharedFields.CREATED;
	public static final String TOKEN = SharedFields.TOKEN;
	public static final String TYPE = SharedFields.TYPE;
	
	@Field(CREATED)
	private Date created = new Date();
	@Field(TOKEN)
	private String token;
	@Field(TYPE)
	private EMAIL_TYPE type = EMAIL_TYPE.CONFIRMATION;
	
	public EmailToken() {
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public EMAIL_TYPE getType() {
		return type;
	}

	public void setType(EMAIL_TYPE type) {
		this.type = type;
	}
	
	
}
