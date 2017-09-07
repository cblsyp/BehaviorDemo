package com.example.administrator.behaviordemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2017/9/7.
 */

public class EasyBehaviorActivity extends Activity {
    private static final String TAG = EasyBehaviorActivity.class.getSimpleName();
    private int btx;
    private int bty;
    private Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.behavior_layout);

        button=(Button) findViewById(R.id.button1);

        Log.e(TAG,"视图坐标系中的X/Y坐标"+button.getX()+"\n"+button.getY());
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX()-v.getWidth()/2);
                        v.setY(event.getRawY()-v.getHeight()/2);

                        break;

                    case MotionEvent.ACTION_DOWN:
                        Log.e(TAG,"ACTION_DOWN相对于父视图而言两个左边缘的距离和上边缘的距离:"+button.getX()+"\n"+button.getY());
                        Log.e(TAG,"ACTION_DOWNgetLeft()  and getTop()"+button.getLeft()+"\n"+button.getRight());

                        Log.e(TAG,"getx()"+button.getX());


                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG,"ACTION_UP相对于父视图而言两个左边缘的距离和上边缘的距离:"+button.getX()+"\n"+button.getY());
                        Log.e(TAG,"ACTION_UPgetLeft()  and getTop()"+button.getLeft()+"\n"+button.getRight());

                        break;
                }
                return false;
            }
        });
    }

/*
*  Log.e(TAG,"view 的宽度,用getWidth()获取"+button.getWidth());
   Log.e(TAG,"view 的高度,用getHeight()获取"+button.getHeight())
   这个是得到view的长度和宽度  单位:像素
* */

/*
* Log.e(TAG,"MotionEvent ACTION_DOWN点击事件的坐标:X/Y坐标"+event.getX()+event.getY());
*
* 是指点击事件相对于Button的视图系
* */

/*
* Log.e(TAG,"getElevation()这个值是不会变得:"+button.getElevation()); 这个API二十一以上   对sdk的版本有要求
*
* 其中getLeft() getTop()  getBottom() getRight()  getElevation()  这几个数值是不会变得 这五个值代表的是view 的初始位置
* 这个不同于view.getX()  view.getY()  这个是会变化的 我们
* * */
}
