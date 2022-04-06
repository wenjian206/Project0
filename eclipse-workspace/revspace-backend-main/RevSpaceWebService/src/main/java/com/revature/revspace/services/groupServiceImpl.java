package com.revature.revspace.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.revspace.models.Group;
import com.revature.revspace.repositories.GroupRepo;

public class groupServiceImpl implements groupService{
	
	@Autowired
	GroupRepo groupRepo;
	
	@Override
	@Transactional
	public String addGroup(Group group) {
		if(group.getGroupName().length()<0)
			return "Group could not be saved without Group Name";
		else {
			groupRepo.save(group);
			return "Group saved successfully!";
		}
	}

	@Override
	@Transactional
	public String updateGroup(int groupId, Group group) {
		if(group.getGroupName().length()<0)
			return "Group could not be updated";
		else {
			groupRepo.save(group);
			return "Group updated successfully!";
		}
	}

	@Override
	public List<Group> getGroups() {
		return (List<Group>) groupRepo.findAll();
	}

	@Override
	public Group getGroup(int groupId) {
		Optional<Group> group =  groupRepo.findById(groupId);
		return group.get();
	}

	@Override
	public boolean isGroupExists(int groupId) {
		Optional<Group> group =  groupRepo.findById(groupId);
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
	public List<Group> getGroupByName(String groupName) {
	return groupRepo.findByGroupName(groupName);
	}


}
