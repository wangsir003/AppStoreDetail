package com.example.wangsir.appstoredetail.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wangsir.appstoredetail.utils.ScreenUtil;

import java.util.List;

/**
 * Created by WangSir on 2017/11/21.
 */

public class CustomIndicator extends ViewGroup {
    private int widthMeasureSpec;
    private int heightMeasureSpec;

    public CustomIndicator(Context context) {
        this(context, null);
    }

    public CustomIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CustomIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }

    /*@Override
    public void addView(View child) {
        super.addView(child);
    }*/

    //默认执行，计算view的宽高,在onDraw()之前
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.widthMeasureSpec = widthMeasureSpec;
        this.heightMeasureSpec = heightMeasureSpec;
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        //设置宽高
        setMeasuredDimension(width, height);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    //根据xml的设定获取宽度
    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST) {
            //如果是wrap_content,则默认设置未全名的宽度
        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY) {

        }
        Log.i("这个控件的宽度----------", "specMode=" + specMode + " specSize=" + specSize);

        return specSize;
    }

    //根据xml的设定获取高度
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST) {
            //如果为wrap_content
            specSize = 150;
        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY) {

        }
        Log.i("这个控件的高度----------", "specMode:" + specMode + " specSize:" + specSize);

        return specSize;
    }


    public void setListData(Context context, CustomIndicator mIndicator, List<String> datas, MarginLayoutParams layoutParams) {
        for (int i = 0; i < datas.size(); i++) {
            TextView textView = new TextView(context);
            textView.setText(datas.get(i));
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(18f);
           /* LayoutParams layoutParams = new ActionBar.LayoutParams(60,120);
            textView.setLayoutParams(layoutParams);*/
            int width = textView.getMeasuredWidth();
            int height = textView.getMeasuredHeight();
            Log.e("textView_x", String.valueOf(width));
            Log.e("textView_y", String.valueOf(height));
            textView.layout(0, 150, 60, 90);
            mIndicator.addView(textView,layoutParams);

           /* ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = 150;
            layoutParams.height = 150;
*//*

            mIndicator.addView(textView);
//                textView.requestLayout();
        }
    }*/
        }
    }
}
