package com.example.wangsir.appstoredetail;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mTitleContainer;
    private ScrollView mScrollView;
    private ImageView mBannerBg;
    private int mBannerHeight;
    private int mBannerWidth;
    private int mTitleHeight;
    private int mTitleWidth;
    private LinearInterpolator linearInterpolator;
    private ArgbEvaluator mArgbEvaluator;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //第二个参数是想要设置的颜色
        StatusBarCompat.compat(this, Color.RED);

        mTitleContainer = (RelativeLayout) findViewById(R.id.title_container);
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mBannerBg = (ImageView) findViewById(R.id.iv_baner_bg);

        ViewTreeObserver vto1 = mTitleContainer.getViewTreeObserver();
        vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mTitleContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                mTitleHeight = mTitleContainer.getHeight();
                mTitleWidth = mTitleContainer.getWidth();
                Log.e("title_x",String.valueOf(mTitleWidth));
                Log.e("title_y",String.valueOf(mTitleHeight));

            }
        });

        //-----------------------------------------------方法三
        ViewTreeObserver vto2 = mBannerBg.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mBannerBg.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                mBannerHeight = mBannerBg.getHeight();
                mBannerWidth = mBannerBg.getWidth();
                Log.e("banner_x",String.valueOf(mBannerWidth));
                Log.e("banner_y",String.valueOf(mBannerHeight));

            }
        });



        mArgbEvaluator = new ArgbEvaluator();




        mScrollView.setOnScrollChangeListener(listener);


    }


    View.OnScrollChangeListener listener = new View.OnScrollChangeListener() {

        int subHeight = mBannerHeight - mTitleHeight;
        /**
         *
         * @param view
         * @param x         x轴坐标距离坐标点滑动的距离
         * @param y        y轴坐标距离坐标点滑动的距离
         * @param x1        x轴上滑动的距离
         * @param y1         y轴上滑动的距离
         */
        @Override
        public void onScrollChange(View view, int x, int y, int x1, int y1) {
            Log.e("y",String.valueOf(y));
                Log.e("发发呆:",String.valueOf(subHeight));
            /*if (y < subHeight && y != 0){
                float evaluate = y / subHeight * 255f;
                Log.e("发发呆:",String.valueOf(evaluate));
                mTitleContainer.setAlpha(evaluate);
            }*/



        }
    };
}
