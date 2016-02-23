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
import com.py.py.domain.subdomain.RestrictedWord;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.RESTRICTED_WORD_TYPE_CREATED,
			def = "{'" + Restricted.ID + "." + RestrictedWord.WORD + "':1,'"
					+ Restricted.ID + "." + RestrictedWord.TYPE + "':1,'"
					+ Restricted.CREATED + "':-1}"),
	@CompoundIndex(name = IndexNames.RESTRICTED_TYPE_CREATED,
			def = "{'" + Restricted.ID + "." + RestrictedWord.TYPE + "':1,'"
					+ Restricted.CREATED + "':-1}")
})
@Document(collection = CollectionNames.RESTRICTED)
public class Restricted {

	public static final String ID = SharedFields.ID;
	public static final String CREATED = SharedFields.CREATED;
	
	@Id
	private RestrictedWord id;
	@Field(CREATED)
	private Date created;
	
	public Restricted() {
	}

	public RestrictedWord getId() {
		return id;
	}

	public void setId(RestrictedWord id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
