package com.py.py.domain.subdomain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.py.py.domain.constants.SharedFields;

public class Role {
	
	public static final String NAME = SharedFields.NAME;
	public static final String PERMISSIONS = SharedFields.PERMISSIONS;
	public static final String RANK = SharedFields.RANK;
	
	@Field(NAME)
	private String name;
	@Field(PERMISSIONS)
	private List<Permission> permissions;
	@Field(RANK)
	private int rank = 0;

	public Role(String n) {
		this.name = n;
		permissions = new ArrayList<Permission>();
	}
	
	public void addPermission(Permission p) {
		permissions.add(p);
	}

	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
