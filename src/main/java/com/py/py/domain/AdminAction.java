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
import com.py.py.domain.subdomain.CachedUsername;
import com.py.py.dto.DTO;
import com.py.py.enumeration.ADMIN_STATE;
import com.py.py.enumeration.ADMIN_TYPE;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.ADMIN_ACTION_BATCH_CHECK, 
			def = "{'" + AdminAction.STATE + "':1,'" + AdminAction.LAST_MODIFIED + "':1}")
})
@Document(collection = CollectionNames.ADMIN)
public class AdminAction {

	public static final String ID = SharedFields.ID;
	public static final String TYPE = SharedFields.TYPE;
	public static final String STATE = SharedFields.STATE;
	public static final String TARGET = SharedFields.TARGET;
	public static final String DTO = SharedFields.DTO;
	public static final String REFERENCE = SharedFields.REFERENCE;
	public static final String CREATED = SharedFields.CREATED;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	public static final String ADMIN = SharedFields.ADMIN;
	
	@Id
	private ObjectId id;
	@Field(TYPE)
	private String type = ADMIN_TYPE.UNDEFINED.toString();
	@Field(STATE)
	private String state = ADMIN_STATE.INITIAL.toString();
	@Field(TARGET)
	private String target = null;
	@Field(DTO)
	private DTO dto = null;
	@Field(REFERENCE)
	private Object reference = null;
	@Field(CREATED)
	private Date created = new Date();
	@Field(LAST_MODIFIED)
	private Date lastModified = new Date();
	@Field(ADMIN)
	private CachedUsername admin = null;
	
	public AdminAction() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public ADMIN_TYPE getType() {
		try {
			return ADMIN_TYPE.valueOf(type);
		} catch(Exception e) {
			return ADMIN_TYPE.UNDEFINED;
		}
	}

	public void setType(ADMIN_TYPE type) {
		this.type = type.toString();
	}

	public ADMIN_STATE getState() {
		try {
			return ADMIN_STATE.valueOf(state);
		} catch(Exception e) {
			return ADMIN_STATE.INITIAL;
		}
	}

	public void setState(ADMIN_STATE state) {
		this.state = state.toString();
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public DTO getDto() {
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Object getReference() {
		return reference;
	}

	public void setReference(Object reference) {
		this.reference = reference;
	}

	public CachedUsername getAdmin() {
		return admin;
	}

	public void setAdmin(CachedUsername admin) {
		this.admin = admin;
	}
}
