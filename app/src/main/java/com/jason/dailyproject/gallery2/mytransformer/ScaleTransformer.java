package com.jason.dailyproject.gallery2.mytransformer;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * 创建日期: 2017/9/22 on 下午9:32
 * 描述:  透明+Image可缩放的ViewPager切换动画效果
 * 作者: Jason  jianbo311@163.com
 */
public class ScaleTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.70f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {
            page.setAlpha(MIN_ALPHA);
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        } else if (position <= 1) { // [-1,1]
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            if (position < 0) {
                float scaleX = 1 + 0.3f * position;
                Log.d("google_lenve_fb", "transformPage: scaleX:" + scaleX);
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            } else {
                float scaleX = 1 - 0.3f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            }
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
    }

}
