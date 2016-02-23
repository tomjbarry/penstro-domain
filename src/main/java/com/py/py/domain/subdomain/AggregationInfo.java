package com.py.py.domain.subdomain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.enumeration.AGGREGATION_TYPE;
import com.py.py.enumeration.TIME_OPTION;

public class AggregationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6608818567711415090L;
	
	public static final String REFERENCE_ID = SharedFields.REFERENCE_ID;
	public static final String START_TIME = SharedFields.START_TIME;
	public static final String SEGMENT = SharedFields.SEGMENT;
	public static final String TYPE = SharedFields.TYPE;
	
	@Field(REFERENCE_ID)
	private String referenceId;
	@Field(START_TIME)
	private Date startTime = new Date();
	@Field(SEGMENT)
	private TIME_OPTION segment = TIME_OPTION.ALLTIME;
	@Field(TYPE)
	private AGGREGATION_TYPE type = AGGREGATION_TYPE.POSTING;
	
	public AggregationInfo() {
	}
	
	public AggregationInfo(String referenceId, Date startTime, Date endTime,
			TIME_OPTION segment, AGGREGATION_TYPE type) {
		this.referenceId = referenceId;
		this.startTime = startTime;
		this.segment = segment;
		this.type = type;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public TIME_OPTION getSegment() {
		return segment;
	}

	public void setSegment(TIME_OPTION segment) {
		this.segment = segment;
	}

	public AGGREGATION_TYPE getType() {
		return type;
	}

	public void setType(AGGREGATION_TYPE type) {
		this.type = type;
	}
	
}
