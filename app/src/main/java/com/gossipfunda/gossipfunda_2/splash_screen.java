package com.gossipfunda.gossipfunda_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash_screen extends AppCompatActivity {

    //variable
    Animation topAnim, bottomAnim;
    ImageView image;
    ImageView image2;
    Intent intent;
    private static int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.text_animation);

        //hooks
        image = findViewById(R.id.gossipfunda_logo);
        image2 = findViewById(R.id.gossipfunda_text);

        image.setAnimation(topAnim);
        image2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent = new Intent(splash_screen.this, sign_in_page.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}