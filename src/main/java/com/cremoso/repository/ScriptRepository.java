package com.cremoso.repository;

import com.cremoso.model.Script;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScriptRepository extends JpaRepository<Script, Integer> {
}
