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

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.MESSAGE_AUTHOR_TARGET_CREATED, 
			def = "{'" + Message.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Message.TARGET + "." + CachedUsername.OID + "':1,'"
					+ Message.AUTHOR + "." + CachedUsername.EXISTS + "':1,'"
					+ Message.TARGET + "." + CachedUsername.EXISTS + "':1,'"
					+ Message.CREATED + "':-1}"),
	@CompoundIndex(name = IndexNames.MESSAGE_TARGET_CREATED, 
			def = "{'" + Message.TARGET + "." + CachedUsername.OID + "':1,'"
					+ Message.AUTHOR + "." + CachedUsername.EXISTS + "':1,'"
					+ Message.TARGET + "." + CachedUsername.EXISTS + "':1,'"
					+ Message.CREATED + "':-1}"),
	@CompoundIndex(name = IndexNames.MESSAGE_AUTHOR_CREATED, 
			def = "{'" + Message.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Message.AUTHOR + "." + CachedUsername.EXISTS + "':1,'"
					+ Message.TARGET + "." + CachedUsername.EXISTS + "':1,'"
					+ Message.CREATED + "':-1}"),
})
@Document(collection = CollectionNames.MESSAGE)
public class Message {

	public static final String ID = SharedFields.ID;
	public static final String MESSAGE = SharedFields.MESSAGE;
	public static final String AUTHOR = SharedFields.AUTHOR;
	public static final String TARGET = SharedFields.TARGET;
	public static final String READ = SharedFields.READ;
	public static final String CREATED = SharedFields.CREATED;
	
	@Id
	private ObjectId id;
	@Field(MESSAGE)
	private String message = null;
	@Field(AUTHOR)
	private CachedUsername author = null;
	@Field(TARGET)
	private CachedUsername target = null;
	@Field(READ)
	private boolean read = false;
	@Field(CREATED)
	private Date created = new Date();
	
	public Message() {
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public CachedUsername getTarget() {
		return target;
	}

	public void setTarget(CachedUsername target) {
		this.target = target;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
}
