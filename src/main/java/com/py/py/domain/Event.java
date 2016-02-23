package com.py.py.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.IndexNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.subdomain.CachedUsername;
import com.py.py.enumeration.COMMENT_TYPE;
import com.py.py.enumeration.EVENT_TYPE;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.EVENT_TARGET_TYPE_CREATED, 
			def = "{'" + Event.CREATED + "':-1,'" 
					+ Event.TARGET + "." + CachedUsername.OID + "':1,'"
					+ Event.TYPE + "':1}"),
	@CompoundIndex(name = IndexNames.EVENT_BENEFICIARY_TYPE_CREATED, 
			def = "{'" + Event.CREATED + "':-1,'" 
					+ Event.BENEFICIARY + "." + CachedUsername.OID + "':1,'"
					+ Event.TYPE + "':1}"),
	@CompoundIndex(name = IndexNames.EVENT_AUTHOR_TYPE_CREATED,
			def = "{'" + Event.CREATED + "':-1,'" 
					+ Event.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Event.TYPE + "':1}"),
})
@Document(collection = CollectionNames.EVENT)
public class Event {

	public static final String ID = SharedFields.ID;
	public static final String AUTHOR = SharedFields.AUTHOR;
	public static final String TARGET = SharedFields.TARGET;
	public static final String BENEFICIARY = SharedFields.BENEFICIARY;
	public static final String BASE_ID = SharedFields.BASE_ID;
	public static final String BASE_STRING = SharedFields.BASE_STRING;
	public static final String BASE_TYPE = SharedFields.BASE_TYPE;
	public static final String PRIMARY_ID = SharedFields.PRIMARY_ID;
	public static final String PARENT_ID = SharedFields.PARENT_ID;
	public static final String TARGETS = SharedFields.TARGETS;
	public static final String TYPE = SharedFields.TYPE;
	public static final String CREATED = SharedFields.CREATED;
	
	@Id
	private ObjectId id;
	@Field(AUTHOR)
	private CachedUsername author = null;
	@Field(TARGET)
	private CachedUsername target = null;
	@Field(BENEFICIARY)
	private CachedUsername beneficiary = null;
	@Field(BASE_ID)
	private ObjectId baseId = null;
	@Field(BASE_STRING)
	private String baseString = null;
	@Field(BASE_TYPE)
	private COMMENT_TYPE baseType = null;
	@Field(PRIMARY_ID)
	private ObjectId primaryId = null;
	@Field(PARENT_ID)
	private ObjectId parentId = null;
	@Field(TARGETS)
	private Map<String, String> targets = new HashMap<String, String>();
	@Field(TYPE)
	private EVENT_TYPE type = EVENT_TYPE.ANY;
	@Field(CREATED)
	private Date created = new Date();
	
	public Event() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public CachedUsername getAuthor() {
		return author;
	}

	public void setAuthor(CachedUsername author) {
		this.author = author;
	}

	public EVENT_TYPE getType() {
		return type;
	}

	public void setType(EVENT_TYPE type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Map<String, String> getTargets() {
		return targets;
	}

	public void setTargets(Map<String, String> targets) {
		this.targets = targets;
	}

	public CachedUsername getTarget() {
		return target;
	}

	public void setTarget(CachedUsername target) {
		this.target = target;
	}

	public CachedUsername getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(CachedUsername beneficiary) {
		this.beneficiary = beneficiary;
	}

	public ObjectId getParentId() {
		return parentId;
	}

	public void setParentId(ObjectId parentId) {
		this.parentId = parentId;
	}

	public ObjectId getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(ObjectId primaryId) {
		this.primaryId = primaryId;
	}

	public ObjectId getBaseId() {
		return baseId;
	}

	public void setBaseId(ObjectId baseId) {
		this.baseId = baseId;
	}

	public COMMENT_TYPE getBaseType() {
		return baseType;
	}

	public void setBaseType(COMMENT_TYPE baseType) {
		this.baseType = baseType;
	}

	public String getBaseString() {
		return baseString;
	}

	public void setBaseString(String baseString) {
		this.baseString = baseString;
	}
}
