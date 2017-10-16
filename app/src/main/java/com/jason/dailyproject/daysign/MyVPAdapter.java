package com.jason.dailyproject.daysign;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jason.dailyproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期: 2017/10/16 on 下午10:30
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class MyVPAdapter extends PagerAdapter {

    private List<DaySignImgBean> mData;
    private Context mContext;
    private ArrayList<View> mList;
    private ImageView daysignIv;

    public MyVPAdapter(Context mContext, ArrayList<View> mList, List<DaySignImgBean> mData) {
        this.mContext = mContext;
        this.mList = mList;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        // 获取要滑动的控件的数量
        return this.mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int currentPosition = mList.size() - 1;
        View view = mList.get(currentPosition - position);
        daysignIv = (ImageView) view.findViewById(R.id.daysign_iv);

        setData(currentPosition - position);
        // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，
        // 我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
        container.addView(view);
        return this.mList.get(currentPosition - position);
    }

    private void setData(int position) {
        Glide.with(mContext).load(mData.get(position).getImgUrl())
                .centerCrop()
                .dontAnimate()
                .thumbnail(0.5f)
                .placeholder(R.mipmap.b)
                .error(R.mipmap.b)
                .into(daysignIv);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(mList.size() - 1 - position));
    }
}
