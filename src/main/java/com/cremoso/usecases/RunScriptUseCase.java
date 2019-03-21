package com.cremoso.usecases;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.val;

@Service
@Transactional
public class RunScriptUseCase {

	@PersistenceContext
	EntityManager em;
	
	public void run(HashMap<String, String> parameters) {
		val criteria = em.createNativeQuery("");
		
	}
}
