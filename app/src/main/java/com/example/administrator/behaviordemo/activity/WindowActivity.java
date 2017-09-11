package com.example.administrator.behaviordemo.activity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Administrator on 2017/9/11.
 */

public class WindowActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testwindow();

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
        windowManager.addView(button,params);
    }
}
