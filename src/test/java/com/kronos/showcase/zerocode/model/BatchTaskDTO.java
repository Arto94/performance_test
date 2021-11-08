package com.kronos.showcase.zerocode.model;

import java.util.List;


public class BatchTaskDTO {
    private Long id;
    private String name;
    private String description;
    private String context;
    private boolean active;
    private List<BatchTaskItemDTO> batchTaskItems;

    public BatchTaskDTO() {
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<BatchTaskItemDTO> getBatchTaskItems() {
        return batchTaskItems;
    }

    public void setBatchTaskItems(List<BatchTaskItemDTO> value) {
        this.batchTaskItems = value;
    }

}
