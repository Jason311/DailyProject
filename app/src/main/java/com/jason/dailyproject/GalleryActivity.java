package com.jason.dailyproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * 创建日期: 2017/9/21 on 下午3:50
 * 描述:
 * 作者: Jason admin
 */
public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final ImageView mImageView = (ImageView) findViewById(R.id.imageView);
        Gallery mGallery = (Gallery) findViewById(R.id.gallery);

        final int[] mImageResourceIds = new int[6];
        mImageResourceIds[0] = R.mipmap.b;
        mImageResourceIds[0] = R.mipmap.c;
        mImageResourceIds[0] = R.mipmap.d;
        mImageResourceIds[0] = R.mipmap.e;
        mImageResourceIds[0] = R.mipmap.f;
        mImageResourceIds[0] = R.mipmap.g;

        ImageAdapter adapter = new ImageAdapter(this, mImageResourceIds);
        mGallery.setAdapter(adapter);

        mGallery.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        mImageView.setBackgroundResource(mImageResourceIds[arg2]);
                    }
                });
    }
}
