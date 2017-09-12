package com.example.administrator.behaviordemo.activity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.administrator.behaviordemo.R;
import com.example.administrator.behaviordemo.StatusBarUtils;

/**
 * Created by Administrator on 2017/9/11.
 */

public class AppbarLayoutActivity extends AppCompatActivity {

    private static final String TAG = AppbarLayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_layout);


/*
* 确实可以为满屏幕  这个是可以实现的  测试通过  其实这就是单元测试*/
     //   StatusBarUtils.setFullScreen(this);

        initView();

        testStatusbar();
    }

    private void testStatusbar() {
        Window window=getWindow();
        ViewGroup  view= (ViewGroup) window.getDecorView();
         int  count=view.getChildCount();
        Log.e(TAG,"DecorView  count:"+count);
    }

    private void initView() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_layout_toolbar);
/*
* 如果没有设置其他的代码  那么手机的状态栏是没有被覆盖的  也就是说没有满屏  满屏的状态  需要区手机的版本来设计
* 分界线是手机的
* */
       // testwindow();  if do this fuction()  .so the button is above the contentview ,because the

    }

    private void testwindow() {

        Button button = new Button(this);
        button.setText("floating button");

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSLUCENT);
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;

        params.gravity = Gravity.CENTER;

        WindowManager windowManager = getWindowManager();
        windowManager.addView(button, params);
    }
}
