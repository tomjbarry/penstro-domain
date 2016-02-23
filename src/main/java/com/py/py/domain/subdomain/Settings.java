package com.py.py.domain.subdomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;
import com.py.py.generic.Filter;

public class Settings {
	
	public static final String HIDDEN_NOTIFICATIONS = SharedFields.HIDDEN_NOTIFICATIONS;
	public static final String FILTERS = SharedFields.FILTERS;
	public static final String LANGUAGE = SharedFields.LANGUAGE;
	public static final String INTERFACE_LANGUAGE = SharedFields.INTERFACE_LANGUAGE;
	public static final String OPTIONS = SharedFields.OPTIONS;
	
	@Field(HIDDEN_NOTIFICATIONS)
	private List<String> hiddenNotifications = new ArrayList<String>();
	@Field(FILTERS)
	private Map<String, Filter> filters = new HashMap<String, Filter>();
	@Field(LANGUAGE)
	private String language = null;
	@Field(INTERFACE_LANGUAGE)
	private String interfaceLanguage = null;
	// string must be of SETTING_OPTION
	@Field(OPTIONS)
	private Map<String, Boolean> options = new HashMap<String, Boolean>();
	
	public Settings() {
	}

	public Map<String, Boolean> getOptions() {
		return options;
	}

	public void setOptions(Map<String, Boolean> options) {
		this.options = options;
	}

	public List<String> getHiddenNotifications() {
		return hiddenNotifications;
	}

	public void setHiddenNotifications(List<String> hiddenNotifications) {
		this.hiddenNotifications = hiddenNotifications;
	}

	public Map<String, Filter> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Filter> filters) {
		this.filters = filters;
	}
	
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}

	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
