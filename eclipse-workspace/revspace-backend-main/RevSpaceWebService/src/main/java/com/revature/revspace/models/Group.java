package com.revature.revspace.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Model class
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "group")
public class Group {
	@Id
	private int groupId;
	
	private String groupName;
	private int userId;
	private int groupInfoId;
	private String groupDesc;
}

