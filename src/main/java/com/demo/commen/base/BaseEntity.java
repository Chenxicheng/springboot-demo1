package com.demo.commen.base;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String id;


    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
