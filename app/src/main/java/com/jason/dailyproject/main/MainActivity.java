package com.jason.dailyproject.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jason.dailyproject.R;
import com.jason.dailyproject.daysign.DaySignActivity;
import com.jason.dailyproject.gallery1.RecyclerviewCard.GalleryMainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecycleviewAdapter mAdapter;

    private List<IntentBean> intentBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_rv);

        initData();

        mAdapter = new RecycleviewAdapter(this, intentBeanList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
//        DividerItemDecoration.HORIZONTAL_LIST
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        IntentBean bean1 = new IntentBean(new GalleryMainActivity(), "Gallery1图片展示");
        IntentBean bean2 = new IntentBean(new com.jason.dailyproject.gallery2.MainActivity(), "Gallery2图片展示");
        IntentBean bean3 = new IntentBean(new DaySignActivity(), "仿万年历图片轮播，viewpager图片加载后向右滑动");
        intentBeanList.add(bean1);
        intentBeanList.add(bean2);
        intentBeanList.add(bean3);
    }
}
