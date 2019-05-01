package com.cremoso.usecases.runScript;

import com.cremoso.model.Database;
import com.cremoso.repository.DatabaseRepository;
import com.cremoso.repository.ScriptRepository;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Properties;

@Service
@Transactional
public class RunScriptUseCase {

	private ScriptRepository scriptRepository;
	private DatabaseRepository databaseRepository;

	public RunScriptUseCase(
			ScriptRepository scriptRepository,
			DatabaseRepository databaseRepository) {
		this.scriptRepository = scriptRepository;
		this.databaseRepository = databaseRepository;
	}

	public List run(RunScriptCommand command) {
		val script = scriptRepository.getOne(command.getScriptId());
		val database = databaseRepository.getOne(command.getDatabaseId());
		val connection = createDatabaseConnection(database).createEntityManager();
		val query = connection.createNativeQuery(script.getCurrentCommand().getText());

		command.getParams().entrySet().forEach(x -> query.setParameter(x.getKey(), x.getValue()));

		return query.getResultList();
	}

	private EntityManagerFactory createDatabaseConnection(Database database) {
		val props = new Properties();

		props.setProperty("username", database.getUsername());
		props.setProperty("password", database.getPassword());

		return Persistence
				.createEntityManagerFactory(database.getName(), props);
	}
}
