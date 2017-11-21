package com.example.wangsir.appstoredetail.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.example.wangsir.appstoredetail.R;
import com.example.wangsir.appstoredetail.view.CustomIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSir on 2017/11/21.
 */

public class TestIndicatorActivity extends AppCompatActivity {
    List<String> datas = new ArrayList<>();
    private CustomIndicator mIndicator;

    //https://www.cnblogs.com/whoislcj/p/5720202.html
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_indicator);

        mIndicator = (CustomIndicator) findViewById(R.id.custom_indicator);
//        mIndicator = (RelativeLayout) findViewById(R.id.custom_indicator);

        datas.add("详情");
        datas.add("评论");
        datas.add("推荐");
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mIndicator.setListData(this,mIndicator,datas,layoutParams);


        /*RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mIndicator.setGravity(RelativeLayout.CENTER_IN_PARENT);
        for (int i = 0; i < datas.size(); i++) {
            TextView textView = new TextView(this);
            textView.setText(datas.get(i));
            textView.setTextColor(Color.parseColor("#ff0000"));
            textView.setTextSize(18);
            textView.setId(i);
            if (i == 0){
                mIndicator.addView(textView,layoutParams);
            }else {
                LayoutParams param1 = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                param1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, i - 1);//此控件在id为1的控件的下边
                mIndicator.addView(textView,param1);
            }


        }*/
    }
}
