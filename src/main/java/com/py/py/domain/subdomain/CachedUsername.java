package com.py.py.domain.subdomain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class CachedUsername {

	public static boolean compare(CachedUsername a, CachedUsername b) {
		if(a == null && b == null) {
			return true;
		}
		if(a == null || b == null) {
			return false;
		}
		if(a.equals(b)) {
			return true;
		}
		return false;
	}
	
	public static final String OID = SharedFields.OID;
	public static final String USERNAME = SharedFields.USERNAME;
	public static final String EXISTS = SharedFields.EXISTS;
	
	@Field(OID)
	private ObjectId oid;
	@Field(USERNAME)
	private String username;
	@Field(EXISTS)
	private boolean exists;
	
	public CachedUsername(ObjectId oid, String username) {
		this.oid = oid;
		this.username = username;
		this.exists = true;
	}

	public ObjectId getId() {
		return oid;
	}

	public void setId(ObjectId oid) {
		this.oid = oid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (exists ? 1231 : 1237);
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CachedUsername other = (CachedUsername) obj;
		if (exists != other.exists)
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
