package com.jason.dailyproject.gallery2.mytransformer;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;

/**
 * 创建日期: 2017/9/22 on 下午11:43
 * 描述:
 * 作者: Jason  jianbo311@163.com
 */
public class ScaleTransformer2 implements ViewPager.PageTransformer {

    private Context context;
    private float elevation;

    public ScaleTransformer2(Context context) {
        this.context = context;
        elevation = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                20, context.getResources().getDisplayMetrics());
    }

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {

        } else {
            if (position < 0) {
                ((CardView) page).setCardElevation((1 + position) * elevation);
            } else {
                ((CardView) page).setCardElevation((1 - position) * elevation);
            }
        }
    }
}
