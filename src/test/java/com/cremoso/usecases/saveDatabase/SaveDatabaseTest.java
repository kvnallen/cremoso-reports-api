package com.cremoso.usecases.saveDatabase;

import com.cremoso.model.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class SaveDatabaseTest {

    @Autowired
    SaveDatabase saveDatabase;

    @Test
    public void saveTest() {
        saveDatabase.save(new Database("", "", ""));
    }

    @Test
    public void save_whenCalled_shouldCryptoPassword()
    {
        fail();
    }
}