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
import com.py.py.domain.subdomain.TagId;
import com.py.py.domain.subdomain.TallyApproximation;
import com.py.py.domain.subdomain.TimeSumAggregate;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.TAG_NAME_LANGUAGE_LOCKED, 
			def = "{'" + Tag.ID + "." + TagId.NAME + "':1,'"
					+ Tag.ID + "." + TagId.LANGUAGE + "':1,'"
					+ Tag.LOCKED + "':1}"),
	@CompoundIndex(name = IndexNames.TAG_AGGREGATE_HOUR_TIME_LANGUAGE,
			def = "{'" + Tag.AGGREGATE + "." + TimeSumAggregate.HOUR + "':-1,'"
					+ Tag.LAST_PROMOTION + "':-1,'" 
					+ Tag.ID + "." + TagId.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.TAG_AGGREGATE_DAY_TIME_LANGUAGE,
			def = "{'" + Tag.AGGREGATE + "." + TimeSumAggregate.DAY + "':-1,'"
					+ Tag.LAST_PROMOTION + "':-1,'" 
					+ Tag.ID + "." + TagId.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.TAG_AGGREGATE_MONTH_TIME_LANGUAGE,
			def = "{'" + Tag.AGGREGATE + "." + TimeSumAggregate.MONTH + "':-1,'"
					+ Tag.LAST_PROMOTION + "':-1,'" 
					+ Tag.ID + "." + TagId.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.TAG_AGGREGATE_YEAR_TIME_LANGUAGE,
			def = "{'" + Tag.AGGREGATE + "." + TimeSumAggregate.YEAR + "':-1,'"
					+ Tag.LAST_PROMOTION + "':-1,'" 
					+ Tag.ID + "." + TagId.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.TAG_VALUE_TIME_LANGUAGE,
			def = "{'" + Tag.VALUE + "':-1,'"
					+ Tag.LAST_PROMOTION + "':-1,'" 
					+ Tag.ID + "." + TagId.LANGUAGE + "':1}"),
})
@Document(collection = CollectionNames.TAG)
public class Tag {
	
	public static final String ID = SharedFields.ID;
	public static final String VALUE = SharedFields.VALUE;
	public static final String APPRECIATION = SharedFields.APPRECIATION;
	public static final String COMMENT_COUNT = SharedFields.COMMENT_COUNT;
	public static final String COMMENT_TALLY = SharedFields.COMMENT_TALLY;
	public static final String AGGREGATE = SharedFields.AGGREGATE;
	public static final String LAST_PROMOTION = SharedFields.LAST_PROMOTION;
	public static final String LOCKED = SharedFields.LOCKED;
	
	@Id
	private TagId id;
	@Field(VALUE)
	private long value = 0L;
	@Field(APPRECIATION)
	private long appreciation = 0L;
	@Field(COMMENT_COUNT)
	private long commentCount = 0L;
	@Field(COMMENT_TALLY)
	private TallyApproximation commentTally = new TallyApproximation();
	@Field(AGGREGATE)
	private TimeSumAggregate aggregate = new TimeSumAggregate();
	@Field(LAST_PROMOTION)
	private Date lastPromotion = new Date();
	@Field(LOCKED)
	private boolean locked = false;
	
	public Tag() {
	}

	public TagId getId() {
		return id;
	}

	public void setId(TagId id) {
		this.id = id;
	}
	
	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}
	
	public long getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(long appreciation) {
		this.appreciation = appreciation;
	}

	public long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}

	public TallyApproximation getCommentTally() {
		return commentTally;
	}

	public void setCommentTally(TallyApproximation commentTally) {
		this.commentTally = commentTally;
	}

	public Date getLastPromotion() {
		return lastPromotion;
	}

	public void setLastPromotion(Date lastPromotion) {
		this.lastPromotion = lastPromotion;
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
}
