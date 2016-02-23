package com.py.py.domain;

import java.util.Date;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.IndexNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.enumeration.PAYMENT_MARK;
import com.py.py.domain.enumeration.PAYMENT_STATE;
import com.py.py.domain.enumeration.PAYMENT_TYPE;
import com.py.py.dto.DTO;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.PAYMENT_STATE_LAST_MODIFIED, 
			def = "{'" + Payment.MARKED + "':1,'"
					+ Payment.STATE + "':1,'"
					+ Payment.LAST_MODIFIED + "':-1}")
})
@Document(collection = CollectionNames.PAYMENT)
public class Payment {

	public static final String ID = SharedFields.ID;
	public static final String AMOUNT = SharedFields.AMOUNT;
	public static final String REFERENCE_ID = SharedFields.REFERENCE_ID;
	public static final String PAY_KEY = SharedFields.PAY_KEY;
	public static final String STATE = SharedFields.STATE;
	public static final String TYPE = SharedFields.TYPE;
	public static final String SOURCE_ID = SharedFields.SOURCE_ID;
	public static final String TARGET_ID = SharedFields.TARGET_ID;
	public static final String TARGET_PAYMENT_ID = SharedFields.TARGET_PAYMENT_ID;
	public static final String BENEFICIARIES = SharedFields.BENEFICIARIES;
	public static final String CREATED = SharedFields.CREATED;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	public static final String DTO = SharedFields.DTO;
	public static final String MARKED = SharedFields.MARKED;
	
	@Id
	private ObjectId id;
	@Field(AMOUNT)
	private long amount = 0L;
	@Field(REFERENCE_ID)
	private ObjectId referenceId = null;
	@Indexed(sparse = true)
	@Field(PAY_KEY)
	private String payKey = null;
	@Field(STATE)
	private PAYMENT_STATE state = PAYMENT_STATE.INITIAL;
	@Field(TYPE)
	private PAYMENT_TYPE type = PAYMENT_TYPE.PURCHASE_CURRENCY;
	@Field(SOURCE_ID)
	private ObjectId sourceId = null;
	@Field(TARGET_ID)
	private ObjectId targetId = null;
	@Field(TARGET_PAYMENT_ID)
	private String targetPaymentId = null;
	@Field(BENEFICIARIES)
	private Map<ObjectId, String> beneficiaries = null;
	@Field(CREATED)
	private Date created = new Date();
	@Field(LAST_MODIFIED)
	private Date lastModified = new Date();
	@Field(DTO)
	private DTO dto = null;
	@Field(MARKED)
	private PAYMENT_MARK mark = PAYMENT_MARK.NONE;
	
	public Payment() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public ObjectId getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(ObjectId referenceId) {
		this.referenceId = referenceId;
	}

	public PAYMENT_STATE getState() {
		return state;
	}

	public void setState(PAYMENT_STATE state) {
		this.state = state;
	}

	public PAYMENT_TYPE getType() {
		return type;
	}

	public void setType(PAYMENT_TYPE type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public DTO getDto() {
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}

	public ObjectId getSourceId() {
		return sourceId;
	}

	public void setSourceId(ObjectId sourceId) {
		this.sourceId = sourceId;
	}

	public ObjectId getTargetId() {
		return targetId;
	}

	public void setTargetId(ObjectId targetId) {
		this.targetId = targetId;
	}

	public String getTargetPaymentId() {
		return targetPaymentId;
	}

	public void setTargetPaymentId(String targetPaymentId) {
		this.targetPaymentId = targetPaymentId;
	}

	public Map<ObjectId, String> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(Map<ObjectId, String> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}
	
}
