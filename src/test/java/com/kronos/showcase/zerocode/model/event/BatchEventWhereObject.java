package com.kronos.showcase.zerocode.model.event;

import com.kronos.showcase.zerocode.model.ObjectRef;

import java.util.List;

public class BatchEventWhereObject {
    private List<Long> ids;
    private List<String> qualifiers;
    private List<ObjectRef> refs;

    public BatchEventWhereObject() {
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
