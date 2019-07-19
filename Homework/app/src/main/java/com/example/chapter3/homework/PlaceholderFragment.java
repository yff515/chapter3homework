package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    public LottieAnimationView animationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView=view.findViewById(R.id.animation_view);
        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入 应该是都先通过上面放进去 然后一个淡出一个淡入 用透明度动画
                ObjectAnimator alphaAnimator=ObjectAnimator.ofFloat(animationView,"alpha",1.0f,0f);
                alphaAnimator.setRepeatCount(0);
                alphaAnimator.setInterpolator(new LinearInterpolator());
                alphaAnimator.setDuration(1000);
                alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
                alphaAnimator.start();
            }
        }, 5000);
    }
}
