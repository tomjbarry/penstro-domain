package com.py.py.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.CollectionNames;
import com.py.py.domain.constants.SharedFields;
import com.py.py.domain.subdomain.AuthenticationInformation;
import com.py.py.domain.subdomain.EmailToken;
import com.py.py.domain.subdomain.LoginAttempt;
import com.py.py.enumeration.LOCK_REASON;

@Document(collection = CollectionNames.USER)
public class User {
	
	public static final String ID = SharedFields.ID;
	public static final String UNIQUE_NAME = SharedFields.UNIQUE_NAME;
	public static final String USERNAME = SharedFields.USERNAME;
	public static final String UNIQUE_EMAIL = SharedFields.UNIQUE_EMAIL;
	public static final String RENAME = SharedFields.RENAME;
	public static final String EMAIL = SharedFields.EMAIL;
	public static final String PAYMENT_ID = SharedFields.PAYMENT_ID;
	public static final String PASSWORD = SharedFields.PASSWORD;
	public static final String ROLES = SharedFields.ROLES;
	public static final String OVERRIDE_ROLES = SharedFields.OVERRIDE_ROLES;
	public static final String SAVED_LOCATIONS = SharedFields.SAVED_LOCATIONS;
	public static final String ACCOUNT_NON_EXPIRED = SharedFields.ACCOUNT_NON_EXPIRED;
	public static final String LOCKED_UNTIL = SharedFields.LOCKED_UNTIL;
	public static final String SUSPENSIONS = SharedFields.SUSPENSIONS;
	public static final String DELETED = SharedFields.DELETED;
	public static final String LOGIN_ATTEMPTS = SharedFields.LOGIN_ATTEMPTS;
	public static final String LOCKREASON = SharedFields.LOCK_REASON;
	public static final String LAST_MODIFIED = SharedFields.LAST_MODIFIED;
	public static final String CREATED = SharedFields.CREATED;
	public static final String AUTHENTICATION_INFORMATION = SharedFields.AUTHENTICATION_INFORMATION;
	public static final String EMAIL_TOKENS = SharedFields.EMAIL_TOKENS;
	public static final String PENDING_SCHEMA_UPDATES = SharedFields.PENDING_SCHEMA_UPDATES;
	public static final String LAST_ATTEMPT = SharedFields.LAST_ATTEMPT;
	public static final String PASSWORD_FAILS = SharedFields.PASSWORD_FAILS;
	
	@Id
	private ObjectId id = null;
	@Indexed(unique = true)
	@Field(UNIQUE_NAME)
	private String uniqueName = null;
	@Field(USERNAME)
	private String username = null;
	@Indexed(unique = true)
	@Field(UNIQUE_EMAIL)
	private String uniqueEmail = null;
	@Indexed(unique = true, sparse = true)
	@Field(RENAME)
	private String rename = null;
	@Field(EMAIL)
	private String email = null;
	@Field(PAYMENT_ID)
	private String paymentId = null;
	@Field(PASSWORD)
	private String password = null;
	@Field(ROLES)
	private List<String> roles = new ArrayList<String>();
	// the override roles replace the roles if they exist
	@Field(OVERRIDE_ROLES)
	private List<String> overrideRoles = new ArrayList<String>();
	@Field(SAVED_LOCATIONS)
	private List<String> savedLocations = new ArrayList<String>();
	@Field(ACCOUNT_NON_EXPIRED)
	private boolean accountNonExpired = true;
	@Field(LOCKED_UNTIL)
	private Date lockedUntil = null;
	@Field(SUSPENSIONS)
	private long suspensions = 0;
	@Field(DELETED)
	private Date deleted = null;
	@Field(LOGIN_ATTEMPTS)
	private List<LoginAttempt> loginAttempts = new ArrayList<LoginAttempt>();
	@Field(LOCKREASON)
	private LOCK_REASON lockReason = LOCK_REASON.UNLOCKED;
	@Field(LAST_MODIFIED)
	private Date lastModified = new Date();
	@Field(CREATED)
	private Date created = new Date();
	@Field(AUTHENTICATION_INFORMATION)
	private List<AuthenticationInformation> authenticationInformation = new ArrayList<AuthenticationInformation>();
	@Field(EMAIL_TOKENS)
	private List<EmailToken> emailTokens = new ArrayList<EmailToken>();
	@Field(PENDING_SCHEMA_UPDATES)
	private List<String> pendingSchemaUpdates = new ArrayList<String>();
	@Field(LAST_ATTEMPT)
	private Date lastAttempt = null;
	@Field(PASSWORD_FAILS)
	private int passwordFails = 0;
	
	public User() {
	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roleList) {
		this.roles = roleList;
	}
	
	public void addRole(String role) {
		if(roles == null) {
			roles = new ArrayList<String>();
		}
		roles.add(role);
	}
	
	public void addRoles(List<String> roleList) {
		if(roles == null) {
			roles = new ArrayList<String>();
		}
		if(roleList != null) {
			roles.addAll(roleList);
		}
	}
	
	public void removeRole(String role) {
		if(roles != null && roles.contains(role)) {
			roles.remove(role);
		}
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null) {
			this.uniqueEmail = email.toLowerCase();
		}
		this.email = email;
	}

	public void setUsername(String username) {
		if(username != null) {
			this.uniqueName = username.toLowerCase();
		}
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public LOCK_REASON getLockReason() {
		return lockReason;
	}

	public void setLockReason(LOCK_REASON lockReason) {
		this.lockReason = lockReason;
	}

	public List<LoginAttempt> getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(List<LoginAttempt> attempts) {
		this.loginAttempts = attempts;
	}
	
	public void addLoginAttempt(LoginAttempt attempt) {
		loginAttempts.add(attempt);
	}

	public List<AuthenticationInformation> getAuthenticationInformation() {
		return authenticationInformation;
	}

	public void setAuthenticationInformation(List<AuthenticationInformation> authenticationInformation) {
		this.authenticationInformation = authenticationInformation;
	}

	public List<EmailToken> getEmailTokens() {
		return emailTokens;
	}

	public void setEmailTokens(List<EmailToken> emailTokens) {
		this.emailTokens = emailTokens;
	}

	public List<String> getOverrideRoles() {
		return overrideRoles;
	}

	public void setOverrideRoles(List<String> roleList) {
		this.overrideRoles = roleList;
	}
	
	public void addOverrideRole(String role) {
		if(overrideRoles == null) {
			overrideRoles = new ArrayList<String>();
		}
		overrideRoles.add(role);
	}
	
	public void addOverrideRoles(List<String> roleList) {
		if(overrideRoles == null) {
			overrideRoles = new ArrayList<String>();
		}
		if(roleList != null) {
			overrideRoles.addAll(roleList);
		}
	}
	
	public void removeOverrideRole(String role) {
		if(overrideRoles != null && overrideRoles.contains(role)) {
			overrideRoles.remove(role);
		}
	}

	public List<String> getSavedLocations() {
		return savedLocations;
	}

	public void setSavedLocations(List<String> savedLocations) {
		this.savedLocations = savedLocations;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public String getUniqueEmail() {
		return uniqueEmail;
	}

	public Date getLockedUntil() {
		return lockedUntil;
	}

	public void setLockedUntil(Date lockedUntil) {
		this.lockedUntil = lockedUntil;
	}

	public long getSuspensions() {
		return suspensions;
	}

	public void setSuspensions(long suspensions) {
		this.suspensions = suspensions;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public List<String> getPendingSchemaUpdates() {
		return pendingSchemaUpdates;
	}

	public void setPendingSchemaUpdates(List<String> pendingSchemaUpdates) {
		this.pendingSchemaUpdates = pendingSchemaUpdates;
	}
	
	public boolean hasPendingSchemaUpdate(String s) {
		if(this.pendingSchemaUpdates == null || this.pendingSchemaUpdates.isEmpty()) {
			return false;
		}
		
		return this.getPendingSchemaUpdates().contains(s);
	}

	public Date getLastAttempt() {
		return lastAttempt;
	}

	public void setLastAttempt(Date lastAttempt) {
		this.lastAttempt = lastAttempt;
	}

	public int getPasswordFails() {
		return passwordFails;
	}

	public void setPasswordFails(int passwordFails) {
		this.passwordFails = passwordFails;
	}
	
	
}
