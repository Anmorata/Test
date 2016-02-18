package com.example.gmukhigulashvili.test;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmukhigulashvili.test.R;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        TextView MainText = (TextView) findViewById(R.id.splash_screen_text);

        Typeface Roboto_Light = Typeface.createFromAsset(getAssets(),"Roboto-Light.ttf");

        MainText.setTypeface(Roboto_Light);


        final ImageView imageView = (android.widget.ImageView) findViewById(R.id.splash_image);
        final Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.splash_rotate);

        imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                Intent intent = new Intent(SplashScreen.this,Login.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
