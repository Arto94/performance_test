package com.kronos.showcase.zerocode.model;

import java.util.List;

public class BatchEventDTO {
    private Long id;
    private String name;
    private String description;
    private String context;
    private boolean active;
    private List<ObjectRef> batchEventTasks;

    public BatchEventDTO() {
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ObjectRef> getBatchEventTasks() {
        return batchEventTasks;
    }

    public void setBatchEventTasks(List<ObjectRef> batchEventTasks) {
        this.batchEventTasks = batchEventTasks;
    }

}
