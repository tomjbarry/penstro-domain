package com.py.py.domain.subdomain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class FollowInfo {

	public static final String USERNAME = SharedFields.USERNAME;
	public static final String ADDED = SharedFields.ADDED;
	
	@Field(USERNAME)
	private CachedUsername username;
	@Field(ADDED)
	private Date added;
	
	public FollowInfo() {
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public CachedUsername getUsername() {
		return username;
	}

	public void setUsername(CachedUsername username) {
		this.username = username;
	}
	
	
}
