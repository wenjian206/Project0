package com.revature.revspace.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.revspace.models.GroupInfo;

//groupRepo
public interface GroupRepo extends CrudRepository<GroupInfo, Integer>{	
	List<GroupInfo> findByGroupName(String groupName);
	List<GroupInfo> findByGroupType(String groupType);
}
