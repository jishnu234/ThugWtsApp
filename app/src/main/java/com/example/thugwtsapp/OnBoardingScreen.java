package com.example.thugwtsapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class OnBoardingScreen extends AppCompatActivity {

    private ViewPager viewPager;
    private Button skip;
    private Button next;
    private Button start;
    private LinearLayout doted_layout;
    private TextView dots[];
    private int currentPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        viewPager=findViewById(R.id.viewpager);
        skip=findViewById(R.id.onBoarding_btn_skip);
        start=findViewById(R.id.onBoarding_btn_start);
        next=findViewById(R.id.onBoarding_btn_nxt);
        doted_layout=findViewById(R.id.onBoarding_dot_layout);


        start.setVisibility(View.GONE);

        SliderHelper helper=new SliderHelper(this);
        viewPager.setAdapter(helper);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(currentPosition+1);
            }
        });

        viewPager.addOnPageChangeListener(pageChangeListener);

        addDots(0);

    }

    private void addDots(int position) {

        dots=new TextView[3];

        doted_layout.removeAllViews();

        for(int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            doted_layout.addView(dots[i]);
        }

        if(dots.length>0)
        {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }



    }


    ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {

            currentPosition=position;
            addDots(position);
            if(position==0)
            {
                start.setVisibility(View.GONE);
            }
            else if(position==1)
            {
                start.setVisibility(View.GONE);
            }
            else
            {
                start.setVisibility(View.VISIBLE);
                Animation animation= AnimationUtils.loadAnimation(OnBoardingScreen.this,R.anim.bottom_anim);
                start.setAnimation(animation);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
