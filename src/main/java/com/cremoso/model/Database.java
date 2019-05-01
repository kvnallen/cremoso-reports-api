package com.cremoso.model;

import lombok.Data;
import lombok.NonNull;

public @Data class Database extends EntityBase {

    public Database(@NonNull String name,
                    @NonNull String username,
                    @NonNull String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }


    private String name;
    private String username;
    private String password;
}
