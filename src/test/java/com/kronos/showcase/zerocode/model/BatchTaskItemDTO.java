package com.kronos.showcase.zerocode.model;

public class BatchTaskItemDTO {
    private ObjectRef actionName;
    private ObjectRef actionType;
    private String parameterString;
    private Integer sequenceNumber;

    public BatchTaskItemDTO() {
    }

    public ObjectRef getActionName() {
        return actionName;
    }

    public void setActionName(ObjectRef actionName) {
        this.actionName = actionName;
    }

    public ObjectRef getActionType() {
        return actionType;
    }

    public void setActionType(ObjectRef actionType) {
        this.actionType = actionType;
    }

    public String getParameterString() {
        return parameterString;
    }

    public void setParameterString(String parameterString) {
        this.parameterString = parameterString;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

}
