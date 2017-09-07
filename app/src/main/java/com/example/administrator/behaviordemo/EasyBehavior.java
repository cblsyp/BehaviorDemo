package com.example.administrator.behaviordemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/6.
 */

public class EasyBehavior extends CoordinatorLayout.Behavior<TextView> {//这里的泛型 指的是观察者的veiw  child view

    public EasyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        //判断左边的对象是否是右边类的实例
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

//        这里是对我们的观察者对一些变化
        child.setX(dependency.getX() + dependency.getWidth());
        child.setY(dependency.getY() + dependency.getHeight());
        child.setText(child.getX()+"\n"+child.getY());
        return true;
    }
}
