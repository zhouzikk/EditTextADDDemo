package com.hk.edittextrecyclerviewdemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 */

public class FatherBean implements MultiItemEntity {
    public static final int TITLE=1;
    public static final int CONTENT=2;
    private int itemType;
    private String title;
    private List<ChildBean> childBeans;

    public List<ChildBean> getChildBeans() {
        return childBeans;
    }

    public void setChildBeans(List<ChildBean> childBeans) {
        this.childBeans = childBeans;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FatherBean(int itemType){
        this.itemType=itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
