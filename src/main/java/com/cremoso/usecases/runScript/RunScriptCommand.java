package com.cremoso.usecases.runScript;

import lombok.Data;

import java.util.HashMap;


public @Data class RunScriptCommand {
    private int databaseId;
    private int scriptId;
    private HashMap<String, String> params = new HashMap<>();
}
