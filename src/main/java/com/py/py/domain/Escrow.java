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
import com.py.py.domain.enumeration.ESCROW_TYPE;
import com.py.py.domain.subdomain.Balance;
import com.py.py.domain.subdomain.EscrowSourceTarget;
import com.py.py.domain.subdomain.Wallet;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.ESCROW_SOURCE_TARGET_TYPE_BALANCE, 
			def = "{'" + Escrow.ID + "." + EscrowSourceTarget.SOURCE + "':1,'"
					+ Escrow.ID + "." + EscrowSourceTarget.TARGET + "':1,'"
					+ Escrow.ID + "." + EscrowSourceTarget.TYPE + "':1,'"
					+ Escrow.BALANCE + "." + Balance.GOLD + "':-1}"),
	@CompoundIndex(name = IndexNames.ESCROW_TARGET_TYPE_BALANCE, 
			def = "{'" + Escrow.ID + "." + EscrowSourceTarget.TARGET + "':1,'"
					+ Escrow.ID + "." + EscrowSourceTarget.TYPE + "':1,'"
					+ Escrow.BALANCE + "." + Balance.GOLD + "':-1}"),
	@CompoundIndex(name = IndexNames.ESCROW_SOURCE_TYPE_BALANCE, 
			def = "{'" + Escrow.ID + "." + EscrowSourceTarget.SOURCE + "':1,'"
					+ Escrow.ID + "." + EscrowSourceTarget.TYPE + "':1,'"
					+ Escrow.BALANCE + "." + Balance.GOLD + "':-1}"),
	@CompoundIndex(name = IndexNames.ESCROW_TYPE_CREATED, 
			def = "{'" + Escrow.ID + "." + EscrowSourceTarget.TYPE + "':1,'"
					+ Escrow.CREATED + "':-1}"),
})
@Document(collection = CollectionNames.ESCROW)
public class Escrow implements Wallet {
	
	public static final String ID = SharedFields.ID;
	public static final String BALANCE = SharedFields.BALANCE;
	public static final String CREATED = SharedFields.CREATED;
	public static final String SOURCE_NAME = SharedFields.SOURCE_NAME;
	public static final String SOURCE_UNIQUE_NAME = SharedFields.SOURCE_UNIQUE_NAME;
	public static final String SOURCE_EXISTS = SharedFields.SOURCE_EXISTS;
	public static final String TARGET_NAME = SharedFields.TARGET_NAME;
	public static final String TARGET_UNIQUE_NAME = SharedFields.TARGET_UNIQUE_NAME;
	public static final String TARGET_EXISTS = SharedFields.TARGET_EXISTS;
	
	@Id
	private EscrowSourceTarget id = new EscrowSourceTarget(null, null, ESCROW_TYPE.OFFER);
	@Field(BALANCE)
	private Balance balance = new Balance();
	@Field(CREATED)
	private Date created = new Date();
	@Field(SOURCE_NAME)
	private String sourceName = null;
	@Field(SOURCE_UNIQUE_NAME)
	private String sourceUniqueName = null;
	@Field(SOURCE_EXISTS)
	private boolean sourceExists = true;
	@Field(TARGET_NAME)
	private String targetName = null;
	@Field(TARGET_UNIQUE_NAME)
	private String targetUniqueName = null;
	@Field(TARGET_EXISTS)
	private boolean targetExists = true;
	
	public Escrow() {
	}
	
	public EscrowSourceTarget getId() {
		return id;
	}
	
	public void setId(EscrowSourceTarget id) {
		this.id = id;
	}
	
	@Override
	public String getIdAsString() {
		if(id == null) {
			return null;
		}
		return id.getId();
	}

	@Override
	public void setIdAsString(String id) {
		this.id = new EscrowSourceTarget(null, null, ESCROW_TYPE.OFFER);
		this.id.setId(id);
	}
	
	public EscrowSourceTarget getSourceTarget() {
		return this.id;
	}

	@Override
	public Balance getBalance() {
		return this.balance;
	}

	@Override
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public String getSource() {
		if(id == null) {
			return null;
		}
		return id.getSource();
	}

	public void setSource(String source) {
		if(id == null) {
			id = new EscrowSourceTarget(null, null, ESCROW_TYPE.OFFER);
		}
		id.setSource(source);
	}

	public String getTarget() {
		if(id == null) {
			return null;
		}
		return id.getTarget();
	}

	public void setTarget(String target) {
		if(id == null) {
			id = new EscrowSourceTarget(null, null, ESCROW_TYPE.OFFER);
		}
		id.setTarget(target);
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public ESCROW_TYPE getType() {
		if(id == null) {
			id = new EscrowSourceTarget(null, null, ESCROW_TYPE.OFFER);
		}
		return id.getType();
	}

	public void setType(ESCROW_TYPE type) {
		if(id == null) {
			id = new EscrowSourceTarget(null, null, ESCROW_TYPE.OFFER);
		}
		id.setType(type);
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
		if(sourceName != null) {
			sourceUniqueName = sourceName.toLowerCase();
		}
	}

	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
		if(targetName != null) {
			targetUniqueName = targetName.toLowerCase();
		}
	}

	public String getSourceUniqueName() {
		return sourceUniqueName;
	}

	public String getTargetUniqueName() {
		return targetUniqueName;
	}

	public boolean isSourceExists() {
		return sourceExists;
	}

	public void setSourceExists(boolean sourceExists) {
		this.sourceExists = sourceExists;
	}

	public boolean isTargetExists() {
		return targetExists;
	}

	public void setTargetExists(boolean targetExists) {
		this.targetExists = targetExists;
	}
}
