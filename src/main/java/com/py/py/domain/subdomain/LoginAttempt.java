package com.py.py.domain.subdomain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class LoginAttempt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1271728299797481802L;
	
	public static final String TIME = SharedFields.TIME;
	public static final String SUCCESS = SharedFields.SUCCESS;
	public static final String LOCATION = SharedFields.LOCATION;
	
	@Field(TIME)
	private Date time = new Date();
	@Field(SUCCESS)
	private boolean success = false;
	@Field(LOCATION)
	private String location = null;
	
	public LoginAttempt() {
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
