package com.m.mainlib.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.m.commonlib.routepath.MainRoutePath;
import com.m.mainlib.R;
import com.ming.timingbutton_lib.TimingButton;

@Route(path = MainRoutePath.WELCOME_ACTIVITY)
public class WelcomeActivity extends AppCompatActivity {

    private ImageView mainIvWelBg;
    private TimingButton mainTbWelBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_welcome);
        //隐藏状态栏
        ImmersionBar.with(this).hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
        init();
    }

    private void init(){
        mainIvWelBg = findViewById(R.id.main_iv_wel_bg);
        mainTbWelBtn = findViewById(R.id.main_tb_wel_btn);

        mainTbWelBtn.setTimerLisenter(TimingButton.BUTTON_TIMING, 3, new TimingButton.TimerLisenter() {
            @Override
            public void clocking(int time) {
                mainTbWelBtn.setText(time+"跳过");
            }

            @Override
            public void timerOver() {
                ARouter.getInstance().build(MainRoutePath.LOGIN_ACTIVITY).navigation();
                finish();
            }

            @Override
            public void onClick(boolean timering) {

            }
        });
        mainTbWelBtn.start();
    }
}
