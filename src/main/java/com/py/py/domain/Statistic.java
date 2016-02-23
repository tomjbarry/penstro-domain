package com.py.py.domain;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.SharedFields;

// should have no need of indexes, it should only be accessed by id
@Document(collection = CollectionNames.STATISTIC)
public class Statistic {

	public static final String ID = SharedFields.ID;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	public static final String DATA = SharedFields.DATA;
	public static final String VALUE = SharedFields.VALUE;
	
	public static final String DELIMITER = ":";
	public static final String TYPE_AGGREGATION = "agg" + DELIMITER;
	
	@Id
	private String id;
	@Field(LAST_MODIFIED)
	private Date lastModified;
	@Field(DATA)
	private Map<String, Object> data;
	@Field(VALUE)
	private String value;
	
	public Statistic() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
