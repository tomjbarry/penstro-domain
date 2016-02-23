package com.py.py.domain.subdomain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;
import com.py.py.enumeration.RESTRICTED_TYPE;

public class RestrictedWord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5591287596126464612L;
	
	public static final String WORD = SharedFields.WORD;
	public static final String TYPE = SharedFields.TYPE;
	
	@Field(WORD)
	private String word;
	@Field(TYPE)
	private RESTRICTED_TYPE type;
	
	public RestrictedWord() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public RESTRICTED_TYPE getType() {
		return type;
	}

	public void setType(RESTRICTED_TYPE type) {
		this.type = type;
	}
}
