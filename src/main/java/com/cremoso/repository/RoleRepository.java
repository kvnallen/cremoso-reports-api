package com.cremoso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cremoso.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
