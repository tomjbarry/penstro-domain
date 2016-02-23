package com.py.py.domain.subdomain;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.constants.CurrencyNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.util.PyUtils;

public class Balance {

	public static final String GOLD = SharedFields.GOLD;
	public static final String PENDING_TRANSACTIONS = SharedFields.PENDING_TRANSACTIONS;
	
	@Field(GOLD)
	private Long gold = new Long(0);
	@Field(PENDING_TRANSACTIONS)
	private List<ObjectId> pendingTransactions = new ArrayList<ObjectId>();
	
	public Balance() {
	}

	public Long getGold() {
		return gold;
	}

	public void setGold(Long gold) {
		this.gold = gold;
	}

	public List<ObjectId> getPendingTransactions() {
		return pendingTransactions;
	}

	public void setPendingTransactions(List<ObjectId> pendingTransactions) {
		this.pendingTransactions = pendingTransactions;
	}

	public void addPendingTransaction(ObjectId pendingTransaction) {
		this.pendingTransactions.add(pendingTransaction);
	}
	
	public void setValue(Long value, String currency) {
		if(PyUtils.stringCompare(CurrencyNames.GOLD, currency)) {
			this.gold = value;
		} else {
			this.gold = value;
		}
	}

}
