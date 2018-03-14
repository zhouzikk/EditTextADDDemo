package com.hk.edittextrecyclerviewdemo;

import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/14.
 */

public class ChildAdapter extends BaseQuickAdapter<ChildBean,BaseViewHolder> {

    private EditText editText;
    private Map<String,String> map;
    private List<String> strings;

    private OnEditTextListener onEditTextListener;


    public ChildAdapter(int layoutResId, @Nullable List<ChildBean> data) {
        super(layoutResId, data);
        map=new HashMap<>();
        strings=new ArrayList<>();
    }

    @Override
    protected void convert(final BaseViewHolder helper, final ChildBean item) {
        helper.setText(R.id.tv_item_child_name,item.getName());
        editText=helper.getView(R.id.et_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                map.put(item.getKey()+"-"+item.getName(),editable.toString());
                onEditTextListener.onEditTextListener(map,strings);
            }
        });
    }

    public interface OnEditTextListener{
        void onEditTextListener(Map<String,String> map,List<String> strings);
    }

    public void setOnEditTextListener(OnEditTextListener onEditTextListener){
        this.onEditTextListener=onEditTextListener;
    }

}
