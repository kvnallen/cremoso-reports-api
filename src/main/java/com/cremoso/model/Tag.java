package com.cremoso.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
public @Data class Tag extends EntityBase {
	private String title;
}
