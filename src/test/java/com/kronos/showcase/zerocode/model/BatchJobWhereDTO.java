package com.kronos.showcase.zerocode.model;

public class BatchJobWhereDTO {

    private String launchDate;
    private String createdBy;
    private String status;
    private ObjectRef group;
    private boolean includeBatchDetails;

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ObjectRef getGroup() {
        return group;
    }

    public void setGroup(ObjectRef group) {
        this.group = group;
    }

    public boolean isIncludeBatchDetails() {
        return includeBatchDetails;
    }

    public void setIncludeBatchDetails(boolean includeBatchDetails) {
        this.includeBatchDetails = includeBatchDetails;
    }


}
