package com.cremoso.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Entity
public @Data class Script extends EntityBase {
	private String name;
	private String description;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Command> commands = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Tag> tags = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Permission> permissions = new HashSet<>();

	public Command getCurrentCommand() {
		return this.commands
				.stream()
				.filter(x -> x.isActual())
				.findFirst()
				.get();
	}
}
