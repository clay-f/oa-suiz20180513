package com.f.pojo;

import com.fasterxml.jackson.annotation.JsonView;

public class OaPosition extends BasePojo {
    private String name;

    public OaPosition() {
    }

    public OaPosition(String name) {
        this.name = name;
    }

    public static interface OaPositionPojoView extends BasePojoView {
    }

    @JsonView(OaPositionPojoView.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
