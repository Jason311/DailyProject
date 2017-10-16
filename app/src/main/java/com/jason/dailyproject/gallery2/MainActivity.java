package com.jason.dailyproject.gallery2;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jason.dailyproject.R;
import com.jason.dailyproject.gallery2.adapter.MyViewPagerAdapter;
import com.jason.dailyproject.gallery2.adapter.MyVpAdapter;
import com.jason.dailyproject.gallery2.mytransformer.GallyPageTransformer;
import com.jason.dailyproject.gallery2.mytransformer.ScaleTransformer2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout ll_main;
    private List<ImageView> imageViews;
    private int pagerWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        setAdapter1();
//        setAdapter2();
//        setAdapter3();

    }

    private void initData() {
        imageViews = new ArrayList<>();
        ImageView first = new ImageView(MainActivity.this);
        ImageView second = new ImageView(MainActivity.this);
        ImageView third = new ImageView(MainActivity.this);
        ImageView fourth = new ImageView(MainActivity.this);
        ImageView fifth = new ImageView(MainActivity.this);

//        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.d, MainActivity.this));
//        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.f, MainActivity.this));
//        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.pic4, MainActivity.this));
//        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.pic5, MainActivity.this));
//        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.pic6, MainActivity.this));

        first.setImageResource(R.mipmap.d);
        second.setImageResource(R.mipmap.f);
        third.setImageResource(R.mipmap.pic4);
        fourth.setImageResource(R.mipmap.pic5);
        fifth.setImageResource(R.mipmap.pic6);

        imageViews.add(first);
        imageViews.add(second);
        imageViews.add(third);
        imageViews.add(fourth);
        imageViews.add(fifth);
    }

    /**
     * clipChildren 是否限制子控件在该容器所在的范围内，
     * clipChildren属性配合layout_gravity属性，可以用来设置多余部分的显示位置
     */
    private void setAdapter1() {
        setContentView(R.layout.activity_gallery2_vp1);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        ll_main = (LinearLayout) findViewById(R.id.activity_main);

        pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp = mViewPager.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        } else {
            lp.width = pagerWidth;
        }
        mViewPager.setLayoutParams(lp);

        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setPageMargin(-50);
        ll_main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mViewPager.dispatchTouchEvent(motionEvent);
            }
        });

        /**
         * 3种样式的PageTransformer
         */
//        ViewPager.PageTransformer transformer1 = new AlphaTransformer();
//        ViewPager.PageTransformer transformer2 = new ScaleTransformer();
        ViewPager.PageTransformer transformer3 = new GallyPageTransformer();

        mViewPager.setPageTransformer(true, transformer3);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(imageViews);
        mViewPager.setAdapter(adapter);
    }


    /**
     * clipToPadding  是否允许ViewGroup在ViewGroup的padding中进行绘制，
     * 默认情况下该属性的值为true，即不允许在ViewGroup的padding中进行绘制
     */
    private void setAdapter2() {
        setContentView(R.layout.activity_gallery2_vp2);
        mViewPager = (ViewPager) findViewById(R.id.viewpager2);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(imageViews);
        mViewPager.setAdapter(adapter);
        mViewPager.setPageMargin(20);

    }

    private void setAdapter3() {
        setContentView(R.layout.activity_gallery2_vp3);
        mViewPager = (ViewPager) findViewById(R.id.viewpager3);

        MyVpAdapter adapter = new MyVpAdapter(this, imageViews);
        mViewPager.setAdapter(adapter);
        mViewPager.setPageMargin(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        48, getResources().getDisplayMetrics()));
        mViewPager.setPageTransformer(false, new ScaleTransformer2(this));
    }
}