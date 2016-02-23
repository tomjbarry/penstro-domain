package com.py.py.domain;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.IndexNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.subdomain.FlagInfo;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.FLAG_DATA_TYPE_VALUE, 
			def = "{'" + FlagData.ID + "." + FlagInfo.TYPE + "':1,'"
					+ FlagData.VALUE + "':-1}")
})
@Document(collection = CollectionNames.FLAG_DATA)
public class FlagData {

	public static final String ID = SharedFields.ID;
	public static final String TARGET = SharedFields.TARGET;
	public static final String VALUE = SharedFields.VALUE;
	public static final String TOTAL = SharedFields.TOTAL;
	public static final String REASONS = SharedFields.REASONS;
	
	@Id
	protected FlagInfo id = new FlagInfo();
	@Field(TARGET)
	private String target = null;
	@Field(VALUE)
	private long value = 0L;
	@Field(TOTAL)
	private long total = 0L;
	@Field(REASONS)
	private Map<String, Long> reasons = null;
	
	public FlagData() {
	}

	public FlagInfo getId() {
		return id;
	}

	public void setId(FlagInfo id) {
		this.id = id;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Map<String, Long> getReasons() {
		return reasons;
	}

	public void setReasons(Map<String, Long> reasons) {
		this.reasons = reasons;
	}
	
}
