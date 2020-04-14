package com.example.thugwtsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class LauncherScreen extends AppCompatActivity {

//    ImageView logo_image;
    RelativeLayout layout;
    Animation top_anim,bottom_anim;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.screen_launcher);


        layout=findViewById(R.id.layout);
        top_anim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        textView=findViewById(R.id.slogan);
        bottom_anim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        layout.setAnimation(top_anim);
        textView.setAnimation(bottom_anim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(LauncherScreen.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        },1000);
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
