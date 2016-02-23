package com.py.py.domain;

import java.util.Date;

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
import com.py.py.enumeration.FEEDBACK_CONTEXT;
import com.py.py.enumeration.FEEDBACK_STATE;
import com.py.py.enumeration.FEEDBACK_TYPE;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.FEEDBACK_STATE_TYPE_CONTEXT_LAST_MODIFIED, 
			def = "{'" + Feedback.LAST_MODIFIED + "':-1,'"
					+ Feedback.TYPE + "':1,'"
					+ Feedback.CONTEXT + "':1,'"
					+ Feedback.STATE + "':1}")
})
@Document(collection = CollectionNames.FEEDBACK)
public class Feedback {

	public static final String ID = SharedFields.ID;
	public static final String AUTHOR = SharedFields.AUTHOR;
	public static final String TYPE = SharedFields.TYPE;
	public static final String STATE = SharedFields.STATE;
	public static final String CONTEXT = SharedFields.CONTEXT;
	public static final String SUMMARY = SharedFields.SUMMARY;
	public static final String CREATED = SharedFields.CREATED;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	
	@Id
	private ObjectId id;
	@Field(AUTHOR)
	private CachedUsername author;
	@Field(TYPE)
	private FEEDBACK_TYPE type = FEEDBACK_TYPE.BUG;
	@Field(STATE)
	private FEEDBACK_STATE state = FEEDBACK_STATE.INITIAL;
	@Field(CONTEXT)
	private FEEDBACK_CONTEXT context = FEEDBACK_CONTEXT.GENERAL;
	@Field(SUMMARY)
	private String summary;
	@Field(CREATED)
	private Date created = new Date();
	@Field(LAST_MODIFIED)
	private Date lastModified = new Date();
	
	public Feedback() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public FEEDBACK_TYPE getType() {
		return type;
	}

	public void setType(FEEDBACK_TYPE type) {
		this.type = type;
	}

	public FEEDBACK_STATE getState() {
		return state;
	}

	public void setState(FEEDBACK_STATE state) {
		this.state = state;
	}

	public FEEDBACK_CONTEXT getContext() {
		return context;
	}

	public void setContext(FEEDBACK_CONTEXT context) {
		this.context = context;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public CachedUsername getAuthor() {
		return author;
	}

	public void setAuthor(CachedUsername author) {
		this.author = author;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
}
