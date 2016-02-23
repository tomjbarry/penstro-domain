package com.py.py.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.py.py.domain.subdomain.ImageLink;
import com.py.py.domain.subdomain.Reference;
import com.py.py.domain.subdomain.Tally;
import com.py.py.domain.subdomain.TallyApproximation;
import com.py.py.domain.subdomain.TimeSumAggregate;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.POSTING_AUTHOR, 
			def = "{'" + Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.INITIALIZED + "':1,'"
					+ Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_BENEFICIARY, 
			def = "{'" + Posting.BENEFICIARY + "." + CachedUsername.OID + "':1,'"
					+ Posting.INITIALIZED + "':1,'"
					+ Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_AGGREGATE_HOUR, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.AGGREGATE + "." + TimeSumAggregate.HOUR + "':-1,'"
					+ Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_AGGREGATE_DAY, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.AGGREGATE + "." + TimeSumAggregate.DAY + "':-1,'"
					+ Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_AGGREGATE_MONTH, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.AGGREGATE + "." + TimeSumAggregate.MONTH + "':-1,'"
					+ Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_AGGREGATE_YEAR, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.AGGREGATE + "." + TimeSumAggregate.YEAR + "':-1,'"
					+ Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_VALUE, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.TALLY + "." + Tally.VALUE + "':-1,'"
					+ Posting.CREATED + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_PROMOTION, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.TALLY + "." + Tally.PROMOTION + "':-1,'"
					+ Posting.CREATED + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_COST, 
			def = "{'" + Posting.INITIALIZED + "':1,'"
					+ Posting.ENABLED + "':1,'"
					+ Posting.REMOVED + "':1,'"
					+ Posting.FLAGGED + "':1,'"
					+ Posting.TALLY + "." + Tally.COST + "':-1,'"
					+ Posting.CREATED + "':-1,'"
					+ Posting.LANGUAGE + "':1,'"
					+ Posting.AUTHOR + "." + CachedUsername.OID + "':1,'"
					+ Posting.TAGS + "':1,'"
					+ Posting.WARNING + "':1}"),
	@CompoundIndex(name = IndexNames.POSTING_LAST_PROMOTION, 
			def = "{'" + Posting.LAST_PROMOTION + "':-1,'"
					+ Posting.TAG_VALUES + "':1}"),
})
@Document(collection = CollectionNames.POSTING)
public class Posting implements Reference {
	
	public static final String ID = SharedFields.ID;
	public static final String AUTHOR = SharedFields.AUTHOR;
	public static final String BENEFICIARY = SharedFields.BENEFICIARY;
	public static final String CONTENT = SharedFields.CONTENT;
	public static final String PREVIEW = SharedFields.PREVIEW;
	public static final String CREATED = SharedFields.CREATED;
	public static final String TITLE = SharedFields.TITLE;
	public static final String TAGS_SUM = SharedFields.TAGS_SUM;
	public static final String TAGS = SharedFields.TAGS;
	public static final String TAG_VALUES = SharedFields.TAG_VALUES;
	public static final String TALLY = SharedFields.TALLY;
	public static final String COMMENT_COUNT = SharedFields.COMMENT_COUNT;
	public static final String APPRECIATION_COUNT = SharedFields.APPRECIATION_COUNT;
	public static final String PROMOTION_COUNT = SharedFields.PROMOTION_COUNT;
	public static final String COMMENT_TALLY = SharedFields.COMMENT_TALLY;
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
	public static final String ARCHIVED = SharedFields.ARCHIVED;
	public static final String IMAGE = SharedFields.IMAGE;
	
	@Id
	private ObjectId id;
	@Field(AUTHOR)
	private CachedUsername author = null;
	@Field(BENEFICIARY)
	private CachedUsername beneficiary = null;
	@Field(CONTENT)
	private String content = null;
	@Field(PREVIEW)
	private String preview = null;
	@Field(CREATED)
	private Date created = new Date();
	@Field(TITLE)
	private String title = null;
	@Field(TAGS_SUM)
	private long tagsSum = 0L;
	@Field(TAG_VALUES)
	private Map<String, Long> tagValues = null;
	@Field(TAGS)
	private List<String> tags = null;
	@Field(TALLY)
	private Tally tally = new Tally();
	// approximation
	@Field(COMMENT_COUNT)
	private long commentCount = 0L;
	@Field(APPRECIATION_COUNT)
	private long appreciationCount = 0L;
	@Field(PROMOTION_COUNT)
	private long promotionCount = 0L;
	@Field(COMMENT_TALLY)
	private TallyApproximation commentTally = new TallyApproximation();
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
	// necessary for alterative time sorting
	@Field(AGGREGATE)
	private TimeSumAggregate aggregate = new TimeSumAggregate();
	@Field(LAST_PROMOTION)
	private Date lastPromotion = new Date();
	@Field(IMAGE)
	private ImageLink image = null;

	public Posting() {
	}
	
	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	@Override
	public CachedUsername getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(CachedUsername author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public Tally getTally() {
		return tally;
	}

	@Override
	public void setTally(Tally tally) {
		this.tally = tally;
	}

	@Override
	public boolean isPaid() {
		return paid;
	}

	@Override
	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public long getAppreciationCount() {
		return appreciationCount;
	}

	public void setAppreciationCount(long appreciationCount) {
		this.appreciationCount = appreciationCount;
	}

	public TallyApproximation getCommentTally() {
		return commentTally;
	}

	public void setCommentTally(TallyApproximation commentTally) {
		this.commentTally = commentTally;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public long getTagsSum() {
		return tagsSum;
	}

	public void setTagsSum(long tagsSum) {
		this.tagsSum = tagsSum;
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

	public Map<String, Long> getTagValues() {
		return tagValues;
	}

	public void setTagValues(Map<String, Long> tagValues) {
		this.tagValues = tagValues;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public Date getArchived() {
		return archived;
	}

	public void setArchived(Date archived) {
		this.archived = archived;
	}

	public ImageLink getImage() {
		return image;
	}

	public void setImage(ImageLink image) {
		this.image = image;
	}
	
}
