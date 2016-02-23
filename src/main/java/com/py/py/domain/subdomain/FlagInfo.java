package com.py.py.domain.subdomain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;
import com.py.py.enumeration.FLAG_TYPE;

public class FlagInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3303559279179031707L;

	public static final String REFERENCE_ID = SharedFields.REFERENCE_ID;
	public static final String TYPE = SharedFields.TYPE;

	@Field(REFERENCE_ID)
	protected ObjectId referenceId;
	@Field(TYPE)
	protected FLAG_TYPE type = FLAG_TYPE.POSTING;
	
	public FlagInfo() {
	}
	
	public FlagInfo(ObjectId referenceId, FLAG_TYPE type) {
		this.referenceId = referenceId;
		this.type = type;
	}

	public ObjectId getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(ObjectId referenceId) {
		this.referenceId = referenceId;
	}

	public FLAG_TYPE getType() {
		return type;
	}

	public void setType(FLAG_TYPE type) {
		this.type = type;
	}
	
}
