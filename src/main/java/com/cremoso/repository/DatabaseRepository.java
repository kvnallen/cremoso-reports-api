package com.cremoso.repository;

import com.cremoso.model.Database;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseRepository extends JpaRepository<Database, Integer> {
}
