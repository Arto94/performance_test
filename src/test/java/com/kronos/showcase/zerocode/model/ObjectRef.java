package com.kronos.showcase.zerocode.model;

public class ObjectRef {
    private Long id;
    private String qualifier;

    public ObjectRef(Long id, String qualifier) {
        this.id = id;
        this.qualifier = qualifier;
    }

    public ObjectRef() {
    }

    public Long getId() {
        return id;
    }

    public String getQualifier() {
        return qualifier;
    }
}
