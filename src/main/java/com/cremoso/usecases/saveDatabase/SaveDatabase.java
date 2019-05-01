package com.cremoso.usecases.saveDatabase;

import com.cremoso.model.Database;
import com.cremoso.repository.DatabaseRepository;
import lombok.val;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SaveDatabase {

    private DatabaseRepository repository;

    public SaveDatabase(DatabaseRepository repository) {
        this.repository = repository;
    }

    public void save(Database database){
        //TODO: crypto password
        var db = new Database(
                database.getName(),
                database.getUsername(),
                database.getPassword());

        repository.save(db);
    }
}
