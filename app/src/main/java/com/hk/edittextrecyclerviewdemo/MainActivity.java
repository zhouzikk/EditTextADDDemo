package com.hk.edittextrecyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_father;
    private FatherAdapter fatherAdapter;

    private Map<String,String> mapp=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        rv_father = findViewById(R.id.rv_father);

        List<FatherBean> beans = new ArrayList<>();
        List<ChildBean> childBeans=new ArrayList<>();
        List<ChildBean> childBeans2=new ArrayList<>();

        ChildBean childBean0=new ChildBean("微信","%");
        ChildBean childBean1=new ChildBean("支付宝","%");
        ChildBean childBean2=new ChildBean("银联","%");
        ChildBean childBean3=new ChildBean("平安","%");

        childBeans.add(childBean0);
        childBeans.add(childBean1);
//        for (int i = 0; i < 2; i++) {
//            FatherBean fatherBean = new FatherBean(1);
//            fatherBean.setTitle("支付宝" + i);
//            beans.add(fatherBean);
//
//                FatherBean fatherBean1 = new FatherBean(2);
//                fatherBean1.setChildBeans(childBeans);
//
//                beans.add(fatherBean1);
//
//        }

        FatherBean fatherBean = new FatherBean(1);
        fatherBean.setTitle("支付宝");
        beans.add(fatherBean);

        FatherBean fatherBean1 = new FatherBean(2);
        fatherBean1.setChildBeans(childBeans);

        beans.add(fatherBean1);

        childBeans2.add(childBean2);
        childBeans2.add(childBean3);

        FatherBean fatherBean2 = new FatherBean(1);
        fatherBean2.setTitle("平安");
        beans.add(fatherBean2);

        FatherBean fatherBean3 = new FatherBean(2);
        fatherBean3.setChildBeans(childBeans2);

        beans.add(fatherBean3);




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_father.setLayoutManager(linearLayoutManager);
        fatherAdapter = new FatherAdapter(beans,this);
        rv_father.setAdapter(fatherAdapter);

        fatherAdapter.setOnEditTextListener(new FatherAdapter.OnEditTextListener() {
            @Override
            public void onEditTextListener(ChildAdapter adapter) {
                adapter.setOnEditTextListener(new ChildAdapter.OnEditTextListener() {
                    @Override
                    public void onEditTextListener(Map<String, String> map, List<String> strings) {

                        mapp.putAll(map);

                        for (Map.Entry<String,String> entry:
                                mapp.entrySet()) {
                            Log.e("TAG","Key:"+entry.getKey()+"----Value:"+entry.getValue());
                        }

                    }
                });
            }
        });


    }
}
