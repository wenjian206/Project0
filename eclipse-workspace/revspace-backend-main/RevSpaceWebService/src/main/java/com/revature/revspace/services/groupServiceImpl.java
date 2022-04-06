package com.revature.revspace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.revspace.models.GroupInfo;
import com.revature.revspace.repositories.GroupRepo;

//groupServiceImpl
public class groupServiceImpl implements groupService{
	
	@Autowired
	GroupRepo groupRepo;
	
	@Override
	@Transactional
	public String addGroup(GroupInfo group) {
		if(group.getGroupName().length()<0)
			return "Group could not be saved without Group Name";
		else {
			groupRepo.save(group);
			return "Group saved successfully!";
		}
	}

	@Override
	@Transactional
	public String updateGroup(int groupId, GroupInfo group) {
		if(group.getGroupName().length()<0)
			return "Group could not be updated";
		else {
			groupRepo.save(group);
			return "Group updated successfully!";
		}
	}

	@Override
	public List<GroupInfo> getGroups() {
		return (List<GroupInfo>) groupRepo.findAll();
	}

	@Override
	public GroupInfo getGroup(int groupId) {
		Optional<GroupInfo> group =  groupRepo.findById(groupId);
		return group.get();
	}

	@Override
	public boolean isGroupExists(int groupId) {
		Optional<GroupInfo> group =  groupRepo.findById(groupId);
		return group.isPresent();
	}

	@Override
	public String deleteGroup() {
		groupRepo.deleteAll();
		return "Group deleted successfully!";
	}

	@Override
	public String deleteGroup(int groupId) {
		 groupRepo.deleteById(groupId);
		 return "Group deleted successfully!";
	}
	
	@Override
	public List<GroupInfo> getGroupByName(String groupName) {
	return groupRepo.findByGroupName(groupName);
	}

	@Override
	public List<GroupInfo> getGroupByType(String groupType) {
	return groupRepo.findByGroupType(groupType);
	}

}
