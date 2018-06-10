package com.demo.modules.sys.entity;

import com.demo.commen.base.DataEntity;

public class Role extends DataEntity<Role> {

    private String name;

    private String cnName;

    public Role() {
        super();
    }

    public Role(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
