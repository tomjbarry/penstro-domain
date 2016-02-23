package com.py.py.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.IndexNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.enumeration.AGGREGATION_TYPE;
import com.py.py.domain.subdomain.AggregationInfo;
import com.py.py.enumeration.TIME_OPTION;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.VALUE_AGGREGATION_TYPE_SEGMENT_START, 
			def = "{'" + ValueAggregation.ID + "." + AggregationInfo.TYPE + "':1,'"
					+ ValueAggregation.ID + "." + AggregationInfo.SEGMENT + "':1,'"
					+ ValueAggregation.ID + "." + AggregationInfo.START_TIME + "':-1,'"
					+ ValueAggregation.ID + "." + AggregationInfo.REFERENCE_ID + "':1}")
})
@Document(collection = CollectionNames.VALUE_AGGREGATION)
public class ValueAggregation {

	public static final String ID = SharedFields.ID;
	public static final String VALUE = SharedFields.VALUE;
	
	@Id
	private AggregationInfo id = new AggregationInfo();
	@Field(VALUE)
	private long value = 0L;
	
	public ValueAggregation() {
	}

	public String getReferenceId() {
		if(id == null) {
			id = new AggregationInfo();
		}
		return id.getReferenceId();
	}

	public void setReferenceId(String referenceId) {
		if(id == null) {
			id = new AggregationInfo();
		}
		id.setReferenceId(referenceId);
	}

	public Date getStartTime() {
		if(id == null) {
			id = new AggregationInfo();
		}
		return id.getStartTime();
	}

	public void setStartTime(Date startTime) {
		if(id == null) {
			id = new AggregationInfo();
		}
		id.setStartTime(startTime);
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public TIME_OPTION getSegment() {
		if(id == null) {
			id = new AggregationInfo();
		}
		return id.getSegment();
	}

	public void setSegment(TIME_OPTION segment) {
		if(id == null) {
			id = new AggregationInfo();
		}
		id.setSegment(segment);
	}

	public AGGREGATION_TYPE getType() {
		if(id == null) {
			id = new AggregationInfo();
		}
		return id.getType();
	}

	public void setType(AGGREGATION_TYPE type) {
		if(id == null) {
			id = new AggregationInfo();
		}
		id.setType(type);
	}

	
}
