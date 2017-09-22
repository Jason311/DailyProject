package com.jason.dailyproject.gallery2.mytransformer;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * 创建日期: 2017/9/22 on 下午8:23
 * 描述:  自定义PageTransformer练习   一个透明的ViewPager切换动画效果
 * 作者: Jason  jianbo311@163.com
 */
public class AlphaTransformer implements ViewPager.PageTransformer {

    private float MINALPHA = 0.5f;

    /**
     * position取值特点：
     * 假设页面从0～1，则：
     * 第一个页面position变化为[0,-1]
     * 第二个页面position变化为[1,0]
     *
     * @param page
     * @param position
     */
    @Override
    public void transformPage(View page, float position) {

        Log.e("page & position-->", page.toString() + "---->" + position);

        if (position < -1 || position > 1) {
            page.setAlpha(MINALPHA);
        } else {
            //不透明->半透明
            if (position < 0) { //[0,-1]
                page.setAlpha(MINALPHA + (1 + position) * (1 - MINALPHA));
            } else {   // [1,0]
                page.setAlpha(MINALPHA + (1 - position) * (1 - MINALPHA));
            }
        }
    }
}
