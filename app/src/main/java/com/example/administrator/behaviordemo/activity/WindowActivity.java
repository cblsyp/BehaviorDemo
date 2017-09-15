package com.example.administrator.behaviordemo.activity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.android.debug.hv.ViewServer;
import com.example.administrator.behaviordemo.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/9/11.
 */

public class WindowActivity extends AppCompatActivity {
    private static final String TAG = WindowActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewServer.get(this).addWindow(this);
        caculstatusbarheigh();
        testStatusbar();
        testwindow();


        testStatusbar();
    }

    /**
     * 在两个Activity中都进行了测试说明  并且高的都是50  说明手机的状态栏的高度是一定的    该方法没有错误
     */
    private void caculstatusbarheigh() {
        int statusbarHeight= StatusBarUtils.getStatusbarHeight(this);
        Log.e(TAG,"获取到状态栏的高度:"+statusbarHeight);
    }

    /**
     *must add permission  .or the button will not be showed in the screen.
     * we didn't use the function setContent()   the feeling is so good.
     */
    private void testwindow() {

        Button button=new Button(this);
        button.setText("floating button");

        WindowManager.LayoutParams params=new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT,0,0, PixelFormat.TRANSLUCENT);
        params.flags=WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        params.type=WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;

        params.gravity= Gravity.CENTER;

        WindowManager windowManager=getWindowManager();
        windowManager.addView(button,params);   //这里添加了一个view  是添加到了哪里呢?


        testStatusbar();
    }

    /**
     * 两次的打印结果都为一 说明只有一个contentview 吗?  有点问题  没有问题 整个DecorView  下面只有一个LinearLayout
     * 如果我们不执行testwindow()这个方法  那么  状态栏是会显示出来的  因为状态栏的绘制和Activity 没有关系
     *
     * 也不再层级View 的范围之内   这个是很重要的一件事情  但是现在也不是很确定了
     *
     */
    private void testStatusbar() {
        Window window=getWindow();
        ViewGroup view= (ViewGroup) window.getDecorView();
        int  count=view.getChildCount();
        Log.e(TAG,"DecorView  count:"+count);
        Log.e(TAG,"view:"+window.getDecorView().getClass().getSimpleName());
        Log.e(TAG,"view:"+((ViewGroup) window.getDecorView()).getChildAt(0).getClass().getSimpleName());

    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }
}
