package com.revature.revspace.services;

import java.util.List;

import com.revature.revspace.models.Group;

public interface groupService {
	
	public String addGroup(Group group);
	public String updateGroup(int groupId, Group group);
	public List<Group> getGroups();
	public Group getGroup(int groupId);
	public boolean isGroupExists(int groupId);
	public String deleteGroup();
	public String deleteGroup(int groupId);
	
	public List<Group> getGroupByName(String groupName);	
}

