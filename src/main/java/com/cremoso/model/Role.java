package com.cremoso.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
public @Data class Role extends EntityBase {

	private String title;
	private boolean enabled;
}
