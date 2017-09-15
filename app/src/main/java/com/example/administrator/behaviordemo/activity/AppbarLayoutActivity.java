package com.example.administrator.behaviordemo.activity;

import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.android.debug.hv.ViewServer;
import com.example.administrator.behaviordemo.R;
import com.example.administrator.behaviordemo.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/9/11.
 * 有疑问
 */

public class AppbarLayoutActivity extends AppCompatActivity {

    private static final String TAG = AppbarLayoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_layout);
        ViewServer.get(this).addWindow(this);


/*
* 确实可以为满屏幕  这个是可以实现的  测试通过  其实这就是单元测试*/
        //   StatusBarUtils.setFullScreen(this);

        initView();

//        testStatusbar();


    }

    private void testStatusbar() {
        Window window = getWindow();
        ViewGroup view = (ViewGroup) window.getDecorView();
        int count = view.getChildCount();  // 1
        boolean isStatus = view.getChildAt(count - 1) instanceof FrameLayout;  //false

        String classname = view.getChildAt(count - 1).getClass().getSimpleName();  //LinearLayout  是一个线性布局 为什么

        Log.e(TAG, "DecorView  count:" + count + "\n" + isStatus + "\n" + classname);

    }

    private void initView() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.appbar_layout_toolbar);
/*
* 如果没有设置其他的代码  那么手机的状态栏是没有被覆盖的  也就是说没有满屏  满屏的状态  需要区手机的版本来设计
* 分界线是手机的
* */
        // testwindow();  if do this fuction()  .so the button is above the contentview ,because 系统的window 的层级是最高的

        StatusBarUtils.setTranslucentImageHeader(this,0,toolbar);
        toolbar.setTitleTextColor(Color.TRANSPARENT);
        toolbar.inflateMenu(R.menu.setting_menu);

        final AppBarLayout appBarLayout= (AppBarLayout) findViewById(R.id.appbar);

        final CollapsingToolbarLayout coordinatorLayout= (CollapsingToolbarLayout) findViewById(R.id.collapse_layout);
        //如果你想要toolbar的标题有效的话 那么此时这个应该这样设置
        coordinatorLayout.setTitle("");
        coordinatorLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        coordinatorLayout.setExpandedTitleColor(Color.TRANSPARENT);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e(TAG,"appbarrheight:"+appBarLayout.getHeight()+"getTotalScollRange:"+appBarLayout.getTotalScrollRange()+"offset:"+verticalOffset);
                if (Math.abs(verticalOffset)>=appBarLayout.getTotalScrollRange()){
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    coordinatorLayout.setTitle("子veiw的=高度正在改变");
                }else{
                    coordinatorLayout.setTitle("");
                }
            }
        });

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }
}
