package com.cremoso.model;

import lombok.val;
import org.junit.Test;


public class DatabaseTest {

    @Test
    public void database_shouldCreateValid(){
        val db = new Database("mydb", "root", "root");
    }

    @Test(expected = Exception.class)
    public void database_whenMissingParams_throwsException(){
        val db = new Database(null, null, null);
    }
}