package com.cremoso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cremoso.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
