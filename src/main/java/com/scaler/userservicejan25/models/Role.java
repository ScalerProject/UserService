package com.scaler.userservicejan25.models;

import jakarta.persistence.Entity;

@Entity(name="roles")
public class Role extends BaseModel {
    private String value;
}
