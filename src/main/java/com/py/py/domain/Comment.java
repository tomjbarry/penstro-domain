package com.py.py.domain;

import java.util.Date;
import java.util.List;

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
import com.py.py.domain.subdomain.Reference;
import com.py.py.domain.subdomain.Tally;
import com.py.py.domain.subdomain.TallyApproximation;
import com.py.py.domain.subdomain.TimeSumAggregate;
import com.py.py.enumeration.COMMENT_TYPE;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.COMMENT_AUTHOR, 
			def = "{'" + Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.INITIALIZED + "':1,'" 
					+ Comment.LAST_PROMOTION + "':-1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'" 
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_BENEFICIARY, 
			def = "{'" + Comment.BENEFICIARY + "." + CachedUsername.OID + "':1,'" 
					+ Comment.INITIALIZED + "':1,'" 
					+ Comment.LAST_PROMOTION + "':-1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'" 
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_AGGREGATE_HOUR, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.AGGREGATE + "." + TimeSumAggregate.HOUR + "':-1,'"
					+ Comment.LAST_PROMOTION + "':-1,'" 
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_AGGREGATE_DAY, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.AGGREGATE + "." + TimeSumAggregate.DAY + "':-1,'"
					+ Comment.LAST_PROMOTION + "':-1,'" 
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_AGGREGATE_MONTH, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.AGGREGATE + "." + TimeSumAggregate.MONTH + "':-1,'"
					+ Comment.LAST_PROMOTION + "':-1,'" 
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_AGGREGATE_YEAR, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.AGGREGATE + "." + TimeSumAggregate.YEAR + "':-1,'"
					+ Comment.LAST_PROMOTION + "':-1,'" 
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_VALUE, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.TALLY + "." + Tally.VALUE + "':-1,'"
					+ Comment.CREATED + "':-1,'"
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_PROMOTION, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.TALLY + "." + Tally.PROMOTION + "':-1,'"
					+ Comment.CREATED + "':-1,'"
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.COMMENT_COST, 
			def = "{'" + Comment.INITIALIZED + "':1,'" 
					+ Comment.ENABLED + "':1,'" 
					+ Comment.REMOVED + "':1,'" 
					+ Comment.FLAGGED + "':1,'"
					+ Comment.TALLY + "." + Tally.COST + "':-1,'"
					+ Comment.CREATED + "':-1,'"
					+ Comment.TYPE + "':1,'"
					+ Comment.LANGUAGE + "':1,'"
					+ Comment.AUTHOR + "." + CachedUsername.OID + "':1,'" 
					+ Comment.PARENT + "':1,'"
					+ Comment.BASE_ID + "':1,'"
					+ Comment.WARNING + "':1}"),
})
@Document(collection = CollectionNames.COMMENT)
public class Comment implements Reference {
	
	public static final String ID = SharedFields.ID;
	public static final String BASE_ID = SharedFields.BASE_ID;
	public static final String BASE_STRING = SharedFields.BASE_STRING;
	public static final String PARENT = SharedFields.PARENT;
	public static final String CONTENT = SharedFields.CONTENT;
	public static final String AUTHOR = SharedFields.AUTHOR;
	public static final String BENEFICIARY = SharedFields.BENEFICIARY;
	public static final String TALLY = SharedFields.TALLY;
	public static final String CREATED = SharedFields.CREATED;
	public static final String REPLY_COUNT = SharedFields.REPLY_COUNT;
	public static final String APPRECIATION_COUNT = SharedFields.APPRECIATION_COUNT;
	public static final String PROMOTION_COUNT = SharedFields.PROMOTION_COUNT;
	public static final String REPLY_TALLY = SharedFields.REPLY_TALLY;
	public static final String PAID = SharedFields.PAID;
	public static final String INITIALIZED = SharedFields.INITIALIZED;
	public static final String ENABLED = SharedFields.ENABLED;
	public static final String REMOVED = SharedFields.REMOVED;
	public static final String WARNING = SharedFields.WARNING;
	public static final String FLAGGED = SharedFields.FLAGGED;
	public static final String LOCKED = SharedFields.LOCKED;
	public static final String VOTES = SharedFields.VOTES;
	public static final String FLAG_VALUE = SharedFields.FLAG_VALUE;
	public static final String WARNING_VALUE = SharedFields.WARNING_VALUE;
	public static final String LANGUAGE = SharedFields.LANGUAGE;
	public static final String AGGREGATE = SharedFields.AGGREGATE;
	public static final String LAST_PROMOTION = SharedFields.LAST_PROMOTION;
	public static final String TYPE = SharedFields.TYPE;
	public static final String ARCHIVED = SharedFields.ARCHIVED;
	
	@Id
	private ObjectId id;
	@Field(BASE_ID)
	private ObjectId baseId = null;
	@Field(BASE_STRING)
	private String baseString = null;
	@Field(PARENT)
	private ObjectId parent = null;
	@Field(CONTENT)
	private String content = null;
	@Field(AUTHOR)
	private CachedUsername author = null;
	@Field(BENEFICIARY)
	private CachedUsername beneficiary = null;
	@Field(TALLY)
	private Tally tally = new Tally();
	@Field(CREATED)
	private Date created = new Date();
	@Field(REPLY_COUNT)
	private long replyCount = 0L;
	@Field(APPRECIATION_COUNT)
	private long appreciationCount = 0L;
	@Field(PROMOTION_COUNT)
	private long promotionCount = 0L;
	@Field(REPLY_TALLY)
	private TallyApproximation replyTally = new TallyApproximation();
	@Field(PAID)
	private boolean paid = false;
	@Field(INITIALIZED)
	private boolean initialized = false;
	@Field(ENABLED)
	private boolean enabled = true;
	@Field(REMOVED)
	private boolean removed = false;
	@Field(WARNING)
	private boolean warning = false;
	@Field(FLAGGED)
	private boolean flagged = false;
	@Field(LOCKED)
	private boolean locked = false;
	@Field(ARCHIVED)
	private Date archived = null;
	@Field(VOTES)
	private List<ObjectId> votes = null;
	@Field(FLAG_VALUE)
	private long flagValue = 0L;
	@Field(WARNING_VALUE)
	private long warningValue = 0L;
	@Field(LANGUAGE)
	private String language = null;
	@Field(AGGREGATE)
	private TimeSumAggregate aggregate = new TimeSumAggregate();
	@Field(LAST_PROMOTION)
	private Date lastPromotion = new Date();
	@Field(TYPE)
	private COMMENT_TYPE type = COMMENT_TYPE.POSTING;
	
	public Comment() {
	}

	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public CachedUsername getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(CachedUsername author) {
		this.author = author;
	}

	@Override
	public Tally getTally() {
		return tally;
	}

	@Override
	public void setTally(Tally tally) {
		this.tally = tally;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public ObjectId getParent() {
		return parent;
	}

	public void setParent(ObjectId parent) {
		this.parent = parent;
	}
	
	@Override
	public boolean isPaid() {
		return this.paid;
	}
	
	@Override
	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(long replyCount) {
		this.replyCount = replyCount;
	}

	public long getAppreciationCount() {
		return appreciationCount;
	}

	public void setAppreciationCount(long appreciationCount) {
		this.appreciationCount = appreciationCount;
	}

	public TallyApproximation getReplyTally() {
		return replyTally;
	}

	public void setReplyTally(TallyApproximation replyTally) {
		this.replyTally = replyTally;
	}

	public COMMENT_TYPE getType() {
		return type;
	}

	public void setType(COMMENT_TYPE type) {
		this.type = type;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	public boolean isFlagged() {
		return flagged;
	}

	public void setFlagged(boolean flagged) {
		this.flagged = flagged;
	}

	public List<ObjectId> getVotes() {
		return votes;
	}

	public void setVotes(List<ObjectId> votes) {
		this.votes = votes;
	}

	public long getFlagValue() {
		return flagValue;
	}

	public void setFlagValue(long flagValue) {
		this.flagValue = flagValue;
	}

	public long getWarningValue() {
		return warningValue;
	}

	public void setWarningValue(long warningValue) {
		this.warningValue = warningValue;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public ObjectId getBaseId() {
		return baseId;
	}

	public void setBaseId(ObjectId baseId) {
		this.baseId = baseId;
	}

	public String getBaseString() {
		return baseString;
	}

	public void setBaseString(String baseString) {
		this.baseString = baseString;
	}

	public TimeSumAggregate getAggregate() {
		return aggregate;
	}

	public void setAggregate(TimeSumAggregate aggregate) {
		this.aggregate = aggregate;
	}

	public Date getLastPromotion() {
		return lastPromotion;
	}

	public void setLastPromotion(Date lastPromotion) {
		this.lastPromotion = lastPromotion;
	}

	public long getPromotionCount() {
		return promotionCount;
	}

	public void setPromotionCount(long promotionCount) {
		this.promotionCount = promotionCount;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public CachedUsername getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(CachedUsername beneficiary) {
		this.beneficiary = beneficiary;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public Date getArchived() {
		return archived;
	}

	public void setArchived(Date archived) {
		this.archived = archived;
	}
	
}
