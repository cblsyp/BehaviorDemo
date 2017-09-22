package com.example.administrator.behaviordemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.behaviordemo.R;
import com.example.administrator.behaviordemo.utils.StatusBarUtils;

/**
 * Created by Administrator on 2017/9/12.
 * <p>
 * 这个主题是StatusTheme
 * android.os.Build.VERSION.SDK_INT  下面的demo必须在4.4以上  必须判断SDK的版本  否则会出错
 */

public class StausBarBiewActivity extends AppCompatActivity {
    public static final String TAG = StausBarBiewActivity.class.getSimpleName();
    private Button hide, show;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_bar_layout);
        context=this;
        hide = (Button) findViewById(R.id.hide);
        show = (Button) findViewById(R.id.show);


        //  如果此时不做任何处理 那么toolbar 的内容会延伸到状态栏 并且
        //下面这两行代码的处理表示toolbar 的内容应用到ActionBar中  所以status中的
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getWindow().getDecorView();
               StatusBarUtils.hideSystemUI(view);

//                toolbar.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
//                    @Override
//                    public void onSystemUiVisibilityChange(int visibility) {
//                        toolbar.setPadding(toolbar.getPaddingLeft(),0,toolbar.getPaddingRight(),toolbar.getPaddingBottom());
//                    }
//                });
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getWindow().getDecorView();
                StatusBarUtils.showSystemUI(view);
//                toolbar.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
//                    @Override
//                    public void onSystemUiVisibilityChange(int visibility) {
//                        Log.e(TAG,"getPaddingLeft:"+toolbar.getPaddingLeft()+"\n"+"paddingTop:"+toolbar.getPaddingTop()+"\n");
//                        toolbar.setPadding(toolbar.getPaddingLeft(),StatusBarUtils.getStatusbarHeight(StausBarBiewActivity.this),toolbar.getPaddingRight(),toolbar.getPaddingBottom());
//                    }
//                });
            }
        });
    }
}
