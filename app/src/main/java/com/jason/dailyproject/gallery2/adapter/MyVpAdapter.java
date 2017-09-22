package com.jason.dailyproject.gallery2.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jason.dailyproject.R;

import java.util.List;

/**
 * 创建日期: 2017/9/22 on 下午11:58
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class MyVpAdapter extends PagerAdapter {

    private List<ImageView> imageViews;
    private Context context;
    private LayoutInflater inflater;

    public MyVpAdapter(Context context, List<ImageView> imageViews) {
        this.context = context;
        this.imageViews = imageViews;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageViews == null ? 0 : imageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.vp_item, container, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }
}
