package com.example.thugwtsapp;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderHelper extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SliderHelper(Context context) {
        this.context = context;
    }

    private int images[] = {R.drawable.loudspeaker_announcement,
            R.drawable.search_cartoon, R.drawable.send_icon};
    private int text[] = {R.string.slide_txt_one,
            R.string.slider_txt_two, R.string.slider_txt_three};

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.onboarding_custom_layout,container,false);

        ImageView imageView=view.findViewById(R.id.onboarding_imageView);
        TextView textView=view.findViewById(R.id.slider_footer_txt);

        imageView.setImageResource(images[position]);
        textView.setText(text[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
