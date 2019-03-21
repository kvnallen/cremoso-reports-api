package com.cremoso.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Permission extends EntityBase {

	@ManyToOne
	private Role role;
	
	@ManyToOne
	private User user;
	
	private boolean canRead;
	private boolean canEdit;
	private boolean canRemove;
}
