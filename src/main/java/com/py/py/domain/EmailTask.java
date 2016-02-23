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
import com.py.py.domain.enumeration.EMAIL_TYPE;
import com.py.py.domain.enumeration.TASK_STATE;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.EMAIL_TASK_STATE_TYPE_COMPLETED_CREATED, 
			def = "{'" + EmailTask.COMPLETED + "':1,'"
					+ EmailTask.CREATED + "':1,'"
					+ EmailTask.STATE + "':1,'"
					+ EmailTask.TYPE + "':1}")
})
@Document(collection = CollectionNames.TASK_EMAIL)
public class EmailTask {

	public static final String ID = SharedFields.ID;
	public static final String USERNAME = SharedFields.USERNAME;
	public static final String TARGET = SharedFields.TARGET;
	public static final String COMPLETED = SharedFields.COMPLETED;
	public static final String CREATED = SharedFields.CREATED;
	public static final String STATE = SharedFields.STATE;
	public static final String TYPE = SharedFields.TYPE;
	
	@Id
	private ObjectId id;
	@Field(USERNAME)
	private String username;
	@Field(TARGET)
	private String target;
	@Field(COMPLETED)
	private Date completed;
	@Field(CREATED)
	private Date created = new Date();
	@Field(STATE)
	private TASK_STATE state = TASK_STATE.INITIAL;
	@Field(TYPE)
	private EMAIL_TYPE type = EMAIL_TYPE.RESET;
	
	public EmailTask() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Date getCompleted() {
		return completed;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public TASK_STATE getState() {
		return state;
	}

	public void setState(TASK_STATE state) {
		this.state = state;
	}

	public EMAIL_TYPE getType() {
		return type;
	}

	public void setType(EMAIL_TYPE type) {
		this.type = type;
	}
	
	
}
