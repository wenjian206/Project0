package com.revature.revspace.services;

import java.util.List;

import com.revature.revspace.models.GroupInfo;

//groupService
public interface groupService {
	
	public String addGroup(GroupInfo group);
	public String updateGroup(int groupId, GroupInfo group);
	public List<GroupInfo> getGroups();
	public GroupInfo getGroup(int groupId);
	public boolean isGroupExists(int groupId);
	public String deleteGroup();
	public String deleteGroup(int groupId);
	
	public List<GroupInfo> getGroupByName(String groupName);
	public List<GroupInfo> getGroupByType(String groupType);
}

