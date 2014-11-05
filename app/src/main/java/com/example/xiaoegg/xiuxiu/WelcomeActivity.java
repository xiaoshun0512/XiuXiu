package com.example.xiaoegg.xiuxiu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * Created by xiaoegg on 14-11-5.
 */
public class WelcomeActivity extends Activity {
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        setContentView(R.layout.welcome_tmp);
        ImageView imageView = (ImageView) findViewById(R.id.Launch);
        imageView.setImageResource(R.drawable.ic_launch);
        handler.postDelayed(new LaunchRunnerable(this),2000l);
    }

    public void jump(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



    public class LaunchRunnerable implements Runnable{
        final WeakReference<WelcomeActivity> activityRef;
        private LaunchRunnerable(WelcomeActivity activity) {
            this.activityRef = new WeakReference<WelcomeActivity>(activity);
        }

        @Override
        public void run() {
            WelcomeActivity activity = activityRef.get();
            activity.jump();

        }
    }
}
