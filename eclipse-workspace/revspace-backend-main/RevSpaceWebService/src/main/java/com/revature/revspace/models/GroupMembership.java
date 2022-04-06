package com.revature.revspace.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.revature.revspace.models.GroupInfo;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "groupMembers ")
public class GroupMembership {
	
	@OneToOne
	@JoinColumn
	public GroupInfo info ;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;
	
	
	 
 
	@OneToOne 
	@JoinColumn(name="userId")
	private User user;
	
	@Column(unique=true)
	private String groupName;
	
	private String groupType;
	private String groupDesc;

	
}
