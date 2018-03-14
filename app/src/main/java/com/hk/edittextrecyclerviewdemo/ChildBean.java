package com.hk.edittextrecyclerviewdemo;

/**
 * Created by Administrator on 2018/3/14.
 */

public class ChildBean {

    private String name;
    private String unit;
    private String key;

    public ChildBean(String name, String unit, String key) {
        this.name = name;
        this.unit = unit;
        this.key = key;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ChildBean(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
