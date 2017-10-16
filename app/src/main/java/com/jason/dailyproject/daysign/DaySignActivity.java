package com.jason.dailyproject.daysign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jason.dailyproject.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 创建日期: 2017/10/16 on 下午10:01
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class DaySignActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLayout;
    private List<DaySignImgBean> beanList = new ArrayList<>();
    private ArrayList<View> mpViews;
    private MyVPAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_sign);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mLayout = (LinearLayout) findViewById(R.id.daysign_layout);

        //初始化
        initData();

        mViewPager.setOffscreenPageLimit(3);
        int pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.5f / 5.0f);
        ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        mViewPager.setLayoutParams(lp);
        mLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });
//        实现Viewpager的翻页动态缩放的效果
        mViewPager.setPageTransformer(true, new GallyPageTransformer());
    }

    private void initData() {
        mpViews = new ArrayList<View>();
        beanList.add(new DaySignImgBean("https://img3.doubanio.com/view/note/large/public/p9614520.jpg", "2016-7", "http://dwz.cn/6FqWL0"));
        beanList.add(new DaySignImgBean("https://img1.doubanio.com/view/note/large/public/p9614519.jpg", "2016-6", "http://dwz.cn/6FqWFw"));
        beanList.add(new DaySignImgBean("https://img1.doubanio.com/view/note/large/public/p9614517.jpg", "2016-5", "http://dwz.cn/6FqWoR"));
        beanList.add(new DaySignImgBean("https://img3.doubanio.com/view/note/large/public/p9614515.jpg", "2016-4", "http://dwz.cn/6FqW8X"));
        beanList.add(new DaySignImgBean("https://img3.doubanio.com/view/note/large/public/p9614512.jpg", "2016-3", "http://dwz.cn/6FqV1Y"));
        beanList.add(new DaySignImgBean("https://img3.doubanio.com/view/note/large/public/p9614511.jpg", "2016-2", "http://dwz.cn/6FqU8A"));
        beanList.add(new DaySignImgBean("https://img1.doubanio.com/view/note/large/public/p9614509.jpg", "2016-1", "http://dwz.cn/6FqThj"));
        for (int i = 0; i < beanList.size(); i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.item_daysign_vp, null);
            mpViews.add(v);
        }

        mAdapter = new MyVPAdapter(this, mpViews, beanList);
        mViewPager.setAdapter(mAdapter);
        final int currentPosition = beanList.size() - 1;
        mViewPager.setCurrentItem(currentPosition);
        addEvent(0);
        mAdapter.notifyDataSetChanged();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addEvent(currentPosition - position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addEvent(final int position) {
        final DaySignImgBean imgBean = beanList.get(position);
        View view = mpViews.get(position);
        FrameLayout itemLayout = (FrameLayout) view.findViewById(R.id.daysign_item_layout);
        Button shareBtn = (Button) view.findViewById(R.id.daysign_share_btn);
        Button downloadBtn = (Button) view.findViewById(R.id.daysign_download_btn);
        ImageView daysignIv = (ImageView) view.findViewById(R.id.daysign_iv);

        itemLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //图片详情
                if (TextUtils.isEmpty(imgBean.getDetailsUrl())) {
                    return;
                }
                Intent intent = new Intent(DaySignActivity.this, WebViewActivity.class);
                intent.putExtra("url", imgBean.getDetailsUrl());
                startActivity(intent);
            }
        });

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下载图片
                Toast.makeText(DaySignActivity.this, "下载" + imgBean.getShowDate() + "图片",
                        Toast.LENGTH_LONG).show();
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //分享图片
                Toast.makeText(DaySignActivity.this, "分享" + imgBean.getShowDate() + "图片",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
