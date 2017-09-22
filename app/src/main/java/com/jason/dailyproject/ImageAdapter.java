package com.jason.dailyproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/*
     * Function   :    ImageAdapter类，继承自BaseAdapter
     * Author     :    博客园-依旧淡然
     */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;        //上下文对象
    private int[] mImageResourceIds;

    //构造方法
    public ImageAdapter(Context context, int[] mImageResourceIds) {
        this.mContext = context;
        this.mImageResourceIds = mImageResourceIds;
    }

    //获取图片的个数
    public int getCount() {
        return mImageResourceIds.length;
    }

    //获取图片在库中的位置
    public Object getItem(int position) {
        return mImageResourceIds[position];
    }

    //获取图片在库中的位置
    public long getItemId(int position) {
        return position;
    }

    //获取适配器中指定位置的视图对象
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mImageResourceIds[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(120, 120));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

}