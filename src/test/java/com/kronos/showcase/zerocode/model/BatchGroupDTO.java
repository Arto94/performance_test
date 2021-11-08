package com.kronos.showcase.zerocode.model;


import java.util.List;


public class BatchGroupDTO {
    private Long id;
    private String name;
    private String description;
    private boolean active;
    private List<ObjectRef> batchEvents;

    public BatchGroupDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ObjectRef> getBatchEvents() {
        return batchEvents;
    }

    public void setBatchEvents(List<ObjectRef> batchEvents) {
        this.batchEvents = batchEvents;
    }
}
