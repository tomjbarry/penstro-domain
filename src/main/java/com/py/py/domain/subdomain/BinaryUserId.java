package com.py.py.domain.subdomain;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class BinaryUserId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3924411157022526457L;
	public static final String FIRST = SharedFields.FIRST;
	public static final String SECOND = SharedFields.SECOND;
	
	@Field(FIRST)
	private ObjectId first;
	@Field(SECOND)
	private ObjectId second;
	
	private int customHash(String s) {
		if(s == null) {
			return -1;
		}
		int h = 0;
		if(s.length() > 0) {
			char val[] = s.toCharArray();
			for(int i = 0; i < s.length(); i++) {
				h = 31 * h + val[i];
			}
		}
		return h;
	}
	
	private boolean compare(ObjectId a, ObjectId b) {
		if(a == null || b == null) {
			return false;
		}
		
		String sa = a.toStringMongod();
		String sb = b.toStringMongod();
		if(sa == null || sb == null) {
			return false;
		}
		
		int ha = customHash(sa);
		int hb = customHash(sb);

		return ha > hb;
	}
	
	protected BinaryUserId() {
	}
	
	public BinaryUserId(ObjectId a, ObjectId b) {
		if(compare(a, b)) {
			this.first = a;
			this.second = b;
		} else {
			this.first = b;
			this.second = a;
		}
	}

	public ObjectId getFirst() {
		return first;
	}

	public ObjectId getSecond() {
		return second;
	}
	
}
