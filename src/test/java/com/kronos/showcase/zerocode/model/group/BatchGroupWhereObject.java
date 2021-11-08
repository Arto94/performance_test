package com.kronos.showcase.zerocode.model.group;

import com.kronos.showcase.zerocode.model.ObjectRef;

import java.util.List;

public class BatchGroupWhereObject {
    private List<Long> ids;
    private List<String> qualifiers;
    private List<ObjectRef> refs;

    public BatchGroupWhereObject() {
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<String> getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(List<String> qualifiers) {
        this.qualifiers = qualifiers;
    }

    public List<ObjectRef> getRefs() {
        return refs;
    }

    public void setRefs(List<ObjectRef> refs) {
        this.refs = refs;
    }
}
