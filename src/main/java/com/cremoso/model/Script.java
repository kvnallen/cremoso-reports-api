package com.cremoso.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Script extends EntityBase {
	private String name;
	private String command;
}
