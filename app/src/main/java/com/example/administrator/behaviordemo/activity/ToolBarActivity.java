package com.example.administrator.behaviordemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.administrator.behaviordemo.R;

/**
 * Created by Administrator on 2017/9/7.
 * android 3.0之前使用的是标题栏 但是3.0之后到4.4  使用的是ActionBar   5.0之后则是推荐使用的是toolbar  这个是对actionbar的一种封装
 *
 * 一般在我们的开发中  会显示或者影藏actionbar 一般都是给activity设置主题  NoActionBar  也可以在代码中调用方法hide()  来显示和影藏actionbar  但是一般不采用这种操作 因为hide()
 * 系统默认会将ActionBar占用的空间分配给界面，此时显示的界面将会重新绘制。当然show()  也会引起界面的重新绘制
 */

public class ToolBarActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ToolBarActivity.class.getSimpleName();
    private Toolbar toolbar1, toolbar2, toolbar3, toolbar4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);
        findViewById(R.id.btn_toolbar1).setOnClickListener(this);
        findViewById(R.id.btn_toolbar2).setOnClickListener(this);
        findViewById(R.id.btn_toolbar3).setOnClickListener(this);
        findViewById(R.id.btn_toolbar4).setOnClickListener(this);
        init();
        initView();
    }

    private void init() {
        toolbar1 = (Toolbar) findViewById(R.id.tool_bar);
        toolbar2 = (Toolbar) findViewById(R.id.tool_bar2);
        toolbar3 = (Toolbar) findViewById(R.id.tool_bar3);
        toolbar4 = (Toolbar) findViewById(R.id.tool_bar4);
    }

    private void initView() {
        toolbar1.setNavigationIcon(R.drawable.ic_book_list);

        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "navigationview正在测试点击事件");
            }
        });

        toolbar1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar1.setSubtitle("副标题");

        toolbar1.setLogo(R.mipmap.ic_launcher);
//如果不加载这个  那么默认是没有加载的其图标的 如果是加载了某一个menu那么是会加载默认的图标的
        toolbar1.inflateMenu(R.menu.setting_menu);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_toolbar1) {
            toolbar1.setVisibility(View.VISIBLE);
            toolbar2.setVisibility(View.GONE);
            toolbar3.setVisibility(View.GONE);
            toolbar4.setVisibility(View.GONE);
        } else if (v.getId() == R.id.btn_toolbar2) {
            Log.e(TAG, "hha");
            toolbar1.setVisibility(View.GONE);
            toolbar2.setVisibility(View.VISIBLE);
            toolbar3.setVisibility(View.GONE);
            toolbar4.setVisibility(View.GONE);
        } else if (v.getId() == R.id.btn_toolbar3) {
            toolbar1.setVisibility(View.GONE);
            toolbar2.setVisibility(View.GONE);
            toolbar3.setVisibility(View.VISIBLE);
            toolbar4.setVisibility(View.GONE);
        } else if (v.getId() == R.id.btn_toolbar4) {
            toolbar1.setVisibility(View.GONE);
            toolbar2.setVisibility(View.GONE);
            toolbar3.setVisibility(View.GONE);
            toolbar4.setVisibility(View.VISIBLE);
        }
    }
}
