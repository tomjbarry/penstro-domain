package com.py.py.domain;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.constants.TimeValues;
import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.IndexNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.subdomain.AppreciationDate;
import com.py.py.domain.subdomain.Balance;
import com.py.py.domain.subdomain.Settings;
import com.py.py.domain.subdomain.TallyApproximation;
import com.py.py.domain.subdomain.TimeSumAggregate;
import com.py.py.domain.subdomain.Wallet;

@CompoundIndexes({
	@CompoundIndex(name = IndexNames.USER_INFO_AGGREGATE_HOUR_TIME_HIDDEN_LANGUAGE,
			def = "{'" + UserInfo.AGGREGATE + "." + TimeSumAggregate.HOUR + "':-1,'"
					+ UserInfo.LAST_PROMOTION + "':-1,'"
					+ UserInfo.SETTINGS + "." + Settings.OPTIONS + ".HIDE_USER_PROFILE':1,'"
					+ UserInfo.SETTINGS + "." + Settings.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.USER_INFO_AGGREGATE_DAY_TIME_HIDDEN_LANGUAGE,
			def = "{'" + UserInfo.AGGREGATE + "." + TimeSumAggregate.DAY + "':-1,'"
					+ UserInfo.LAST_PROMOTION + "':-1,'"
					+ UserInfo.SETTINGS + "." + Settings.OPTIONS + ".HIDE_USER_PROFILE':1,'"
					+ UserInfo.SETTINGS + "." + Settings.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.USER_INFO_AGGREGATE_MONTH_TIME_HIDDEN_LANGUAGE,
			def = "{'" + UserInfo.AGGREGATE + "." + TimeSumAggregate.MONTH + "':-1,'"
					+ UserInfo.LAST_PROMOTION + "':-1,'"
					+ UserInfo.SETTINGS + "." + Settings.OPTIONS + ".HIDE_USER_PROFILE':1,'"
					+ UserInfo.SETTINGS + "." + Settings.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.USER_INFO_AGGREGATE_YEAR_TIME_HIDDEN_LANGUAGE,
			def = "{'" + UserInfo.AGGREGATE + "." + TimeSumAggregate.YEAR + "':-1,'"
					+ UserInfo.LAST_PROMOTION + "':-1,'"
					+ UserInfo.SETTINGS + "." + Settings.OPTIONS + ".HIDE_USER_PROFILE':1,'"
					+ UserInfo.SETTINGS + "." + Settings.LANGUAGE + "':1}"),
	@CompoundIndex(name = IndexNames.USER_INFO_VALUE_TIME_HIDDEN_LANGUAGE,
			def = "{'" + UserInfo.PROMOTION + "':-1,'"
					+ UserInfo.LAST_PROMOTION + "':-1,'"
					+ UserInfo.SETTINGS + "." + Settings.OPTIONS + ".HIDE_USER_PROFILE':1,'"
					+ UserInfo.SETTINGS + "." + Settings.LANGUAGE + "':1}"),
})
@Document(collection = CollectionNames.USER_INFO)
public class UserInfo implements Wallet {

	public static final String ID = SharedFields.ID;
	public static final String USERNAME = SharedFields.USERNAME;
	public static final String COMMENT_COUNT = SharedFields.COMMENT_COUNT;
	public static final String APPRECIATION = SharedFields.APPRECIATION;
	public static final String APPRECIATION_COUNT = SharedFields.APPRECIATION_COUNT;
	public static final String PROMOTION = SharedFields.PROMOTION;
	public static final String PROMOTION_COUNT = SharedFields.PROMOTION_COUNT;
	public static final String CONTRIBUTED_COMMENTS = SharedFields.CONTRIBUTED_COMMENTS;
	public static final String CONTRIBUTED_POSTINGS = SharedFields.CONTRIBUTED_POSTINGS;
	public static final String CONTRIBUTED_APPRECIATION_COUNT = SharedFields.CONTRIBUTED_APPRECIATION_COUNT;
	public static final String CONTRIBUTED_PROMOTION_COUNT = SharedFields.CONTRIBUTED_PROMOTION_COUNT;
	public static final String FOLLOWER_COUNT = SharedFields.FOLLOWER_COUNT;
	public static final String FOLLOWEE_COUNT = SharedFields.FOLLOWEE_COUNT;
	public static final String CONTRIBUTION_TALLY = SharedFields.CONTRIBUTION_TALLY;
	public static final String COMMENT_TALLY = SharedFields.COMMENT_TALLY;
	public static final String SETTINGS = SharedFields.SETTINGS;
	public static final String BALANCE = SharedFields.BALANCE;
	public static final String LAST_CHECKED_NOTIFICATIONS = SharedFields.LAST_CHECKED_NOTIFICATIONS;
	public static final String LAST_CHECKED_FEED = SharedFields.LAST_CHECKED_FEED;
	public static final String WARNING = SharedFields.WARNING;
	public static final String FLAGGED = SharedFields.FLAGGED;
	public static final String VOTES = SharedFields.VOTES;
	public static final String FLAG_VALUE = SharedFields.FLAG_VALUE;
	public static final String DESCRIPTION = SharedFields.DESCRIPTION;
	public static final String APPRECIATION_RESPONSE = SharedFields.APPRECIATION_RESPONSE;
	public static final String APPRECIATION_RESPONSE_WARNING = SharedFields.APPRECIATION_RESPONSE_WARNING;
	public static final String APPRECIATION_DATES = SharedFields.APPRECIATION_DATES;
	public static final String AGGREGATE = SharedFields.AGGREGATE;
	public static final String LAST_PROMOTION = SharedFields.LAST_PROMOTION;
	public static final String PENDING_ACTIONS = SharedFields.PENDING_ACTIONS;
	
	@Id
	private ObjectId id;
	@Field(USERNAME)
	private String username;
	@Field(COMMENT_COUNT)
	private long commentCount = 0L;
	@Field(APPRECIATION)
	private long appreciation = 0L;
	@Field(APPRECIATION_COUNT)
	private long appreciationCount = 0L;
	@Field(PROMOTION)
	private long promotion = 0L;
	@Field(PROMOTION_COUNT)
	private long promotionCount = 0L;
	@Field(CONTRIBUTED_COMMENTS)
	private long contributedComments = 0L;
	@Field(CONTRIBUTED_POSTINGS)
	private long contributedPostings = 0L;
	@Field(CONTRIBUTED_APPRECIATION_COUNT)
	private long contributedAppreciationCount = 0L;
	@Field(CONTRIBUTED_PROMOTION_COUNT)
	private long contributedPromotionCount = 0L;
	@Field(FOLLOWER_COUNT)
	private long followerCount = 0L;
	@Field(FOLLOWEE_COUNT)
	private long followeeCount = 0L;
	@Field(CONTRIBUTION_TALLY)
	private TallyApproximation contributionTally = new TallyApproximation();
	@Field(COMMENT_TALLY)
	private TallyApproximation commentTally = new TallyApproximation();
	@Field(SETTINGS)
	private Settings settings = new Settings();
	@Field(BALANCE)
	private Balance balance = new Balance();
	@Field(LAST_CHECKED_NOTIFICATIONS)
	private Date lastCheckedNotifications = new Date();
	@Field(LAST_CHECKED_FEED)
	private Date lastCheckedFeed = new Date();
	@Field(WARNING)
	private boolean warning = false;
	@Field(FLAGGED)
	private Date flagged = new Date(new Date().getTime() - TimeValues.TIME_YEAR);
	@Field(VOTES)
	private List<ObjectId> votes = null;
	@Field(FLAG_VALUE)
	private long flagValue = 0L;
	@Field(DESCRIPTION)
	private String description = null;
	@Field(APPRECIATION_RESPONSE)
	private String appreciationResponse = null;
	@Field(APPRECIATION_RESPONSE_WARNING)
	private boolean appreciationResponseWarning = false;
	@Field(APPRECIATION_DATES)
	private List<AppreciationDate> appreciationDates = null;
	@Field(AGGREGATE)
	private TimeSumAggregate aggregate = new TimeSumAggregate();
	@Field(LAST_PROMOTION)
	private Date lastPromotion = new Date();
	@Field(PENDING_ACTIONS)
	private List<String> pendingActions = null;
	
	public UserInfo() {
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}

	@Override
	public String getIdAsString() {
		if(id == null) {
			return null;
		}
		return id.toStringMongod();
	}

	@Override
	public void setIdAsString(String id) {
		this.id = new ObjectId(id);
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

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	@Override
	public Balance getBalance() {
		return balance;
	}

	@Override
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	public Date getLastCheckedNotifications() {
		return lastCheckedNotifications;
	}

	public void setLastCheckedNotifications(Date lastCheckedNotifications) {
		this.lastCheckedNotifications = lastCheckedNotifications;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(long appreciation) {
		this.appreciation = appreciation;
	}

	public TallyApproximation getContributionTally() {
		return contributionTally;
	}

	public void setContributionTally(TallyApproximation contributionTally) {
		this.contributionTally = contributionTally;
	}

	public long getContributedComments() {
		return contributedComments;
	}

	public void setContributedComments(long contributedComments) {
		this.contributedComments = contributedComments;
	}

	public long getContributedPostings() {
		return contributedPostings;
	}

	public void setContributedPostings(long contributedPostings) {
		this.contributedPostings = contributedPostings;
	}

	public long getAppreciationCount() {
		return appreciationCount;
	}

	public void setAppreciationCount(long appreciationCount) {
		this.appreciationCount = appreciationCount;
	}

	public Date getLastCheckedFeed() {
		return lastCheckedFeed;
	}

	public void setLastCheckedFeed(Date lastCheckedFeed) {
		this.lastCheckedFeed = lastCheckedFeed;
	}

	public long getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(long followerCount) {
		this.followerCount = followerCount;
	}

	public long getFolloweeCount() {
		return followeeCount;
	}

	public void setFolloweeCount(long followeeCount) {
		this.followeeCount = followeeCount;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	public Date getFlagged() {
		return flagged;
	}

	public void setFlagged(Date flagged) {
		this.flagged = flagged;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public long getContributedAppreciationCount() {
		return contributedAppreciationCount;
	}

	public void setContributedAppreciationCount(long contributedAppreciationCount) {
		this.contributedAppreciationCount = contributedAppreciationCount;
	}

	public TimeSumAggregate getAggregate() {
		return aggregate;
	}

	public void setAggregate(TimeSumAggregate aggregate) {
		this.aggregate = aggregate;
	}

	public long getPromotion() {
		return promotion;
	}

	public void setPromotion(long promotion) {
		this.promotion = promotion;
	}

	public long getPromotionCount() {
		return promotionCount;
	}

	public void setPromotionCount(long promotionCount) {
		this.promotionCount = promotionCount;
	}

	public long getContributedPromotionCount() {
		return contributedPromotionCount;
	}

	public void setContributedPromotionCount(long contributedPromotionCount) {
		this.contributedPromotionCount = contributedPromotionCount;
	}

	public Date getLastPromotion() {
		return lastPromotion;
	}

	public void setLastPromotion(Date lastPromotion) {
		this.lastPromotion = lastPromotion;
	}

	public String getAppreciationResponse() {
		return appreciationResponse;
	}

	public void setAppreciationResponse(String appreciationResponse) {
		this.appreciationResponse = appreciationResponse;
	}

	public boolean isAppreciationResponseWarning() {
		return appreciationResponseWarning;
	}

	public void setAppreciationResponseWarning(boolean appreciationResponseWarning) {
		this.appreciationResponseWarning = appreciationResponseWarning;
	}

	public List<AppreciationDate> getAppreciationDates() {
		return appreciationDates;
	}

	public void setAppreciationDates(List<AppreciationDate> appreciationDates) {
		this.appreciationDates = appreciationDates;
	}
	
	public List<String> getPendingActions() {
		return pendingActions;
	}
	
	public void setPendingActions(List<String> pendingActions) {
		this.pendingActions = pendingActions;
	}
	
}
