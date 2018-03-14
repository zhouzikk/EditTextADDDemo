package com.hk.edittextrecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

/**
 * Created by Administrator on 2018/3/14.
 */

public class FatherAdapter extends BaseMultiItemQuickAdapter<FatherBean,BaseViewHolder> {

    private RecyclerView item_father_rv;
    private Context context;

    private OnEditTextListener onEditTextListener;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public FatherAdapter(List<FatherBean> data,Context context) {
        super(data);
        addItemType(FatherBean.TITLE, R.layout.item_father_title);
        addItemType(FatherBean.CONTENT, R.layout.item_father_content);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FatherBean item) {
        switch (helper.getItemViewType()){
            case FatherBean.TITLE:
                helper.setText(R.id.tv_item_father,item.getTitle());
                break;
            case FatherBean.CONTENT:
                item_father_rv=helper.getView(R.id.item_father_rv);
                FlexboxLayoutManager flexboxLayoutManager=new FlexboxLayoutManager(context);
                flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);//设置 主轴为水平方向，起点在左端
                flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);//设置 按正常方向换行
                flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);//设置 如果项目未设置高度或设为auto，将占满整个容器的高度。
                flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);//左对齐  默认 可不写
//                GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);

                item_father_rv.setLayoutManager(flexboxLayoutManager);

                ChildAdapter childAdapter=new ChildAdapter(R.layout.item_child,item.getChildBeans());
                item_father_rv.setAdapter(childAdapter);

                onEditTextListener.onEditTextListener(childAdapter);

                break;
        }
    }

    public interface OnEditTextListener{
        void onEditTextListener(ChildAdapter adapter);
    }

    public void setOnEditTextListener(OnEditTextListener onEditTextListener){
        this.onEditTextListener=onEditTextListener;
    }

}
