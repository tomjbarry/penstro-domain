package com.py.py.domain.subdomain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.SharedFields;

public class FinanceDescription {

	public static String getId(FinanceDescription fd) {
		if(fd == null) {
			return null;
		}
		ObjectId userId = fd.getUserId();
		EscrowSourceTarget escrow = fd.getEscrow();
		if(escrow != null) {
			return escrow.getId();
		} else if(userId != null) {
			return userId.toStringMongod();
		} else {
			return null;
		}
	}
	
	public static String getCollection(FinanceDescription fd) {
		if(fd == null) {
			return CollectionNames.USER_INFO;
		}
		EscrowSourceTarget escrow = fd.getEscrow();
		if(escrow != null) {
			return CollectionNames.ESCROW;
		} else {
			return CollectionNames.USER_INFO;
		}
	}
	
	public static final String USER_ID = SharedFields.USER_ID;
	public static final String AMOUNT = SharedFields.AMOUNT;
	public static final String CURRENCY = SharedFields.CURRENCY;
	public static final String ESCROW = SharedFields.ESCROW;
	
	@Field(USER_ID)
	private ObjectId userId = null;
	@Field(AMOUNT)
	private long amount = 0;
	@Field(CURRENCY)
	private String currency;
	@Field(ESCROW)
	private EscrowSourceTarget escrow = null;

	public FinanceDescription() {
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public EscrowSourceTarget getEscrow() {
		return escrow;
	}

	public void setEscrow(EscrowSourceTarget escrow) {
		this.escrow = escrow;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
}
