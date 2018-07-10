package com.f.core.pojo;

public class Dict extends BasePojo {
    private String dictName;
    private DictType dictType;
    private Integer value;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public DictType getDictType() {
        return dictType;
    }

    public void setDictType(DictType dictType) {
        this.dictType = dictType;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
