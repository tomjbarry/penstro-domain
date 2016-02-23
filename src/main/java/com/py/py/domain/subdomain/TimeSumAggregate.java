package com.py.py.domain.subdomain;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class TimeSumAggregate {

	public static final String HOUR = SharedFields.HOUR;
	public static final String DAY = SharedFields.DAY;
	public static final String MONTH = SharedFields.MONTH;
	public static final String YEAR = SharedFields.YEAR;
	
	@Field(HOUR)
	private long hour = 0;
	@Field(DAY)
	private long day = 0;
	@Field(MONTH)
	private long month = 0;
	@Field(YEAR)
	private long year = 0;
	
	public TimeSumAggregate() {
	}

	public long getHour() {
		return hour;
	}

	public void setHour(long hour) {
		this.hour = hour;
	}

	public long getDay() {
		return day;
	}

	public void setDay(long day) {
		this.day = day;
	}

	public long getMonth() {
		return month;
	}

	public void setMonth(long month) {
		this.month = month;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}
}
