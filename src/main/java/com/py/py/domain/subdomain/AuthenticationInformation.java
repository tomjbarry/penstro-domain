package com.py.py.domain.subdomain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class AuthenticationInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4696327260650987441L;
	
	public static final String TOKEN = SharedFields.TOKEN;
	public static final String EXPIRY = SharedFields.EXPIRY;
	public static final String INACTIVITY = SharedFields.INACTIVITY;

	@Field(TOKEN)
	private byte[] token = null;
	@Field(EXPIRY)
	private Date expiry = null;
	@Field(INACTIVITY)
	private long inactivity;
	
	public AuthenticationInformation(byte[] token, Date expiry, long inactivity) {
		this.token = token;
		this.expiry = expiry;
		this.inactivity = inactivity;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	public long getInactivity() {
		return inactivity;
	}

	public void setInactivity(long inactivity) {
		this.inactivity = inactivity;
	}
}
