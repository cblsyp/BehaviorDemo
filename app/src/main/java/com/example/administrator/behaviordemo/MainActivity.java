package com.example.administrator.behaviordemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.behaviordemo.activity.AppbarLayoutActivity;
import com.example.administrator.behaviordemo.activity.EasyBehaviorActivity;
import com.example.administrator.behaviordemo.activity.JanshuActivity;
import com.example.administrator.behaviordemo.activity.StausBarBiewActivity;
import com.example.administrator.behaviordemo.activity.ToolBarActivity;
import com.example.administrator.behaviordemo.activity.WindowActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.behavior_layout);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4,R.id.button5,R.id.button6,R.id.button7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent=new Intent(this, WindowActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1=new Intent(this, ToolBarActivity.class);
                startActivity(intent1);
                break;
            case R.id.button3:
                Intent intent3=new Intent(this, StausBarBiewActivity.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4=new Intent(this, AppbarLayoutActivity.class);
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5=new Intent(this, JanshuActivity.class);
                startActivity(intent5);
                break;
            case R.id.button6:
                Intent intent6=new Intent(this, EasyBehaviorActivity.class);
                startActivity(intent6);
                break;
            case R.id.button7:
                Intent intent7=new Intent(this, AppbarLayoutActivity.class);
                startActivity(intent7);
                break;
        }
    }
}
