package com.cremoso.model;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
public class Command extends EntityBase {

	public Command(String text, String comments) {
		super();
		this.text = text;
		this.comments = comments;
	}

	private String text;

	@Setter(value = AccessLevel.PRIVATE)
	private boolean actual;
	
	private String comments;
}
