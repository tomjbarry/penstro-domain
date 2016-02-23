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
import com.py.py.domain.subdomain.BinaryUserId;
import com.py.py.domain.subdomain.CachedUsername;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.CORRESPONDENCE_FIRST, 
			def = "{'" + Correspondence.FIRST + "." + CachedUsername.OID + "':1,'"
					+ Correspondence.FIRST_HIDDEN + "':1,'"
					+ Correspondence.LAST_MODIFIED + "':-1}"),
	@CompoundIndex(name = IndexNames.CORRESPONDENCE_SECOND, 
			def = "{'" + Correspondence.SECOND + "." + CachedUsername.OID + "':1,'"
					+ Correspondence.SECOND_HIDDEN + "':1,'"
					+ Correspondence.LAST_MODIFIED + "':-1}")
})
@Document(collection = CollectionNames.CORRESPONDENCE)
public class Correspondence {

	public static final String ID = SharedFields.ID;
	public static final String FIRST = SharedFields.FIRST;
	public static final String SECOND = SharedFields.SECOND;
	public static final String CREATED = SharedFields.CREATED;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	public static final String FIRST_HIDDEN = SharedFields.FIRST_HIDDEN;
	public static final String SECOND_HIDDEN = SharedFields.SECOND_HIDDEN;
	public static final String MESSAGE = SharedFields.MESSAGE;
	public static final String AUTHOR = SharedFields.AUTHOR;
	public static final String TARGET = SharedFields.TARGET;
	
	@Id
	private BinaryUserId id;
	@Field(FIRST)
	private CachedUsername first = null;
	@Field(SECOND)
	private CachedUsername second = null;
	@Field(CREATED)
	private Date created = new Date();
	@Field(LAST_MODIFIED)
	private Date lastModified = new Date();
	@Field(FIRST_HIDDEN)
	private boolean firstHidden = false;
	@Field(SECOND_HIDDEN)
	private boolean secondHidden = false;
	// these fields are for caching the last message
	@Field(MESSAGE)
	private String message;
	@Field(AUTHOR)
	private ObjectId author;
	@Field(TARGET)
	private ObjectId target;
	
	public Correspondence() {
	}

	public BinaryUserId getId() {
		return id;
	}

	public void setId(BinaryUserId id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public CachedUsername getFirst() {
		return first;
	}

	public void setFirst(CachedUsername first) {
		this.first = first;
	}

	public CachedUsername getSecond() {
		return second;
	}

	public void setSecond(CachedUsername second) {
		this.second = second;
	}

	public boolean isFirstHidden() {
		return firstHidden;
	}

	public void setFirstHidden(boolean firstHidden) {
		this.firstHidden = firstHidden;
	}

	public boolean isSecondHidden() {
		return secondHidden;
	}

	public void setSecondHidden(boolean secondHidden) {
		this.secondHidden = secondHidden;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ObjectId getAuthor() {
		return author;
	}

	public void setAuthor(ObjectId author) {
		this.author = author;
	}

	public ObjectId getTarget() {
		return target;
	}

	public void setTarget(ObjectId target) {
		this.target = target;
	}
	
}
