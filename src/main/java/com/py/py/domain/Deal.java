package com.py.py.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.py.py.domain.enumeration.DEAL_STATE;
import com.py.py.domain.enumeration.DEAL_TYPE;
import com.py.py.domain.subdomain.FinanceDescription;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.DEAL_STATE_LAST_MODIFIED, 
			def = "{'" + Deal.STATE + "':1,'"
					+ Deal.LAST_MODIFIED + "':-1}")
})
@Document(collection = CollectionNames.DEAL)
public class Deal {
	
	public static final String ID = SharedFields.ID;
	public static final String SOURCE = SharedFields.SOURCE;
	public static final String TARGETS = SharedFields.TARGETS;
	public static final String REFERENCE = SharedFields.REFERENCE;
	public static final String TYPE = SharedFields.TYPE;
	public static final String STATE = SharedFields.STATE;
	public static final String PRIMARY_AMOUNT = SharedFields.PRIMARY_AMOUNT;
	public static final String SECONDARY_AMOUNT = SharedFields.SECONDARY_AMOUNT;
	public static final String CREATE_REFERENCE_COST = SharedFields.CREATE_REFERENCE_COST;
	public static final String REFERENCE_COLLECTION = SharedFields.REFERENCE_COLLECTION;
	public static final String PAYMENT_ID = SharedFields.PAYMENT_ID;
	public static final String SOURCE_ADDED = SharedFields.SOURCE_ADDED;
	public static final String TARGETS_ADDED = SharedFields.TARGETS_ADDED;
	public static final String REFERENCE_ADDED = SharedFields.REFERENCE_ADDED;
	public static final String CREATED = SharedFields.CREATED;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	
	@Id
	private ObjectId id;
	@Field(SOURCE)
	private FinanceDescription source = null;
	@Field(TARGETS)
	private List<FinanceDescription> targets = new ArrayList<FinanceDescription>();
	@Field(REFERENCE)
	private ObjectId reference = null;
	@Field(TYPE)
	private DEAL_TYPE type = DEAL_TYPE.GENERIC;
	@Field(STATE)
	private DEAL_STATE state = DEAL_STATE.UNDEFINED;
	@Field(PRIMARY_AMOUNT)
	private Long primaryAmount = null;
	@Field(SECONDARY_AMOUNT)
	private Long secondaryAmount = null;
	@Field(CREATE_REFERENCE_COST)
	private boolean createReferenceCost = true;
	@Field(REFERENCE_COLLECTION)
	private String referenceCollection = null;
	@Indexed(sparse = true)
	@Field(PAYMENT_ID)
	private ObjectId paymentId = null;
	@Field(SOURCE_ADDED)
	private boolean sourceAdded = false;
	@Field(TARGETS_ADDED)
	private boolean targetsAdded = false;
	@Field(REFERENCE_ADDED)
	private boolean referenceAdded = false;
	@Field(CREATED)
	private Date created = new Date();
	@Field(LAST_MODIFIED)
	private Date lastModified = new Date();
	
	public Deal() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public DEAL_TYPE getType() {
		return type;
	}

	public void setType(DEAL_TYPE type) {
		this.type = type;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public DEAL_STATE getState() {
		return state;
	}

	public void setState(DEAL_STATE state) {
		this.state = state;
	}

	public ObjectId getReference() {
		return reference;
	}

	public void setReference(ObjectId reference) {
		this.reference = reference;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public boolean isCreateReferenceCost() {
		return createReferenceCost;
	}

	public void setCreateReferenceCost(boolean createReferenceCost) {
		this.createReferenceCost = createReferenceCost;
	}

	public String getReferenceCollection() {
		return referenceCollection;
	}

	public void setReferenceCollection(String referenceCollection) {
		this.referenceCollection = referenceCollection;
	}

	public boolean isSourceAdded() {
		return sourceAdded;
	}

	public void setSourceAdded(boolean sourceAdded) {
		this.sourceAdded = sourceAdded;
	}

	public boolean isTargetsAdded() {
		return targetsAdded;
	}

	public void setTargetsAdded(boolean targetsAdded) {
		this.targetsAdded = targetsAdded;
	}

	public boolean isReferenceAdded() {
		return referenceAdded;
	}

	public void setReferenceAdded(boolean referenceAdded) {
		this.referenceAdded = referenceAdded;
	}

	public FinanceDescription getSource() {
		return source;
	}

	public void setSource(FinanceDescription source) {
		this.source = source;
	}

	public List<FinanceDescription> getTargets() {
		return targets;
	}

	public void setTargets(List<FinanceDescription> targets) {
		this.targets = targets;
	}

	public Long getPrimaryAmount() {
		return primaryAmount;
	}

	public void setPrimaryAmount(Long primaryAmount) {
		this.primaryAmount = primaryAmount;
	}

	public Long getSecondaryAmount() {
		return secondaryAmount;
	}

	public void setSecondaryAmount(Long secondaryAmount) {
		this.secondaryAmount = secondaryAmount;
	}

	public ObjectId getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(ObjectId paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
