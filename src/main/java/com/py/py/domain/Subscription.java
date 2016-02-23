package com.py.py.domain;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.subdomain.FollowInfo;

@Document(collection = CollectionNames.SUBSCRIPTION)
public class Subscription {

	public static final String ID = SharedFields.ID;
	public static final String HIDDEN_FEED_EVENTS = SharedFields.HIDDEN_FEED_EVENTS;
	public static final String FOLLOWS = SharedFields.FOLLOWS;
	public static final String BLOCKED = SharedFields.BLOCKED;
	
	@Id
	private ObjectId id;
	@Field(HIDDEN_FEED_EVENTS)
	private List<String> hiddenFeedEvents = null;
	@Field(FOLLOWS)
	private List<FollowInfo> follows = new ArrayList<FollowInfo>();
	@Field(BLOCKED)
	private List<FollowInfo> blocked = new ArrayList<FollowInfo>();
	
	public Subscription() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public List<FollowInfo> getFollows() {
		return follows;
	}

	public void setFollows(List<FollowInfo> follows) {
		this.follows = follows;
	}

	public List<String> getHiddenFeedEvents() {
		return hiddenFeedEvents;
	}

	public void setHiddenFeedEvents(List<String> hiddenFeedEvents) {
		this.hiddenFeedEvents = hiddenFeedEvents;
	}

	public List<FollowInfo> getBlocked() {
		return blocked;
	}

	public void setBlocked(List<FollowInfo> blocked) {
		this.blocked = blocked;
	}
}
