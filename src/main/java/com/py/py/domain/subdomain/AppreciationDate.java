package com.py.py.domain.subdomain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class AppreciationDate {

	public static final String CACHED_USERNAME = SharedFields.CACHED_USERNAME;
	public static final String DATE = SharedFields.DATE;
	
	@Field(CACHED_USERNAME)
	private CachedUsername cachedUsername;
	@Field(DATE)
	private Date date;
	
	public AppreciationDate(CachedUsername cachedUsername, Date date) {
		this.setCachedUsername(cachedUsername);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CachedUsername getCachedUsername() {
		return cachedUsername;
	}

	public void setCachedUsername(CachedUsername cachedUsername) {
		this.cachedUsername = cachedUsername;
	}
	
}
