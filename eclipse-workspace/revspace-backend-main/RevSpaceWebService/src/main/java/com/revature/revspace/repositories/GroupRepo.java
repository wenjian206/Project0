package com.revature.revspace.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.revspace.models.Group;


public interface GroupRepo extends CrudRepository<Group, Integer>{	
	List<Group> findByGroupName(String groupName);
}
