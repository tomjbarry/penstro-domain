package com.py.py.domain.subdomain;

import org.bson.types.ObjectId;

public interface Reference {
	ObjectId getId();
	void setId(ObjectId id);
	
	CachedUsername getAuthor();
	void setAuthor(CachedUsername author);
	
	Tally getTally();
	void setTally(Tally tally);
	
	boolean isPaid();
	void setPaid(boolean paid);
	
	boolean isInitialized();
	void setInitialized(boolean initialized);
	
}
