package com.py.py.domain.subdomain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.constants.DomainRegex;
import com.py.py.domain.constants.SharedFields;

public class TagId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3539391094660672659L;
	
	public static final String NAME = SharedFields.NAME;
	public static final String LANGUAGE = SharedFields.LANGUAGE;
	
	@Field(NAME)
	private String name;
	@Field(LANGUAGE)
	private String language;
	
	public TagId() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String toString() {
		return name + DomainRegex.TAG_ID_DELIMITER_STRING + language;
	}
	
	public void fromString(String s) {
		this.name = null;
		this.language = null;
		try {
			String[] sp = s.split(DomainRegex.TAG_ID_DELIMITER);
			this.name = sp[0];
			this.language = sp[1];
		} catch(Exception e) {
			// nothing
		}
	}
}
