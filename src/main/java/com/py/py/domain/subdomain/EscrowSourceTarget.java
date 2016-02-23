package com.py.py.domain.subdomain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.constants.DomainRegex;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.enumeration.ESCROW_TYPE;

public class EscrowSourceTarget implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -274389055809718479L;
	
	public static final String SOURCE = SharedFields.SOURCE;
	public static final String TARGET = SharedFields.TARGET;
	public static final String TYPE = SharedFields.TYPE;
	
	@Field(SOURCE)
	private String source;
	@Field(TARGET)
	private String target;
	@Field(TYPE)
	private ESCROW_TYPE type = ESCROW_TYPE.OFFER;
	
	public EscrowSourceTarget(String source, String target, ESCROW_TYPE type) {
		this.source = source;
		this.target = target;
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getId() {
		String s = source;
		String t = target;
		if(s == null) {
			s = "";
		}
		if(t == null) {
			t = "";
		}
		return s + DomainRegex.ESCROW_ID_DELIMITER_STRING
				+ t + DomainRegex.ESCROW_ID_DELIMITER_STRING
				+ type.toString();
	}
	
	public void setId(String id) {
		if(id == null) {
			source = null;
			target = null;
			type = ESCROW_TYPE.OFFER;
		} else {
			String[] splitId = id.split(DomainRegex.ESCROW_ID_DELIMITER);
			// should throw error if not correct type of string
			source = splitId[0];
			target = splitId[1];
			setType(splitId[2]);
		}
	}

	public ESCROW_TYPE getType() {
		return type;
	}

	public void setType(ESCROW_TYPE type) {
		this.type = type;
	}
	
	public void setType(String type) {
		// avoid reflection here
		//if(type != null && Arrays.asList(ESCROW_TYPE.values()).contains(type)) {
		if(type != null) {
			this.type = ESCROW_TYPE.valueOf(type);
		}
	}
}
