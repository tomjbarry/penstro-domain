package com.py.py.domain.subdomain;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class TallyApproximation {
	
	public static final String VALUE = SharedFields.VALUE;
	public static final String APPRECIATION = SharedFields.APPRECIATION;
	public static final String PROMOTION = SharedFields.PROMOTION;
	public static final String COST = SharedFields.COST;
	
	@Field(VALUE)
	private Long value = new Long(0);
	@Field(APPRECIATION)
	private Long appreciation = new Long(0);
	@Field(PROMOTION)
	private Long promotion = new Long(0);
	@Field(COST)
	private Long cost = new Long(0);

	public TallyApproximation() {
	}

	public Long getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(Long appreciation) {
		this.appreciation = appreciation;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
		this.value = this.cost + this.promotion;
	}

	public Long getValue() {
		return this.value;
	}

	public Long getPromotion() {
		return promotion;
	}

	public void setPromotion(Long promotion) {
		this.promotion = promotion;
		this.value = this.cost + this.promotion;
	}
}
