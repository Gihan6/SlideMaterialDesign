package com.alokda.slide;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SlideAdapter(Context context) {
        this.context = context;
    }

    //List of images
    public int[] images = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};

    //List of title
    public String[] titles = {"COSMONAUT", "SATELLITE", "GALAXY", "ROCKET"};

    //List of Descriptions
    public String descriptions[] = {"Description 1", "Description 2", "Description 3", "Description 4"};

    //List of background
    public int[] colors = {Color.rgb(55, 55, 55),
            Color.rgb(239, 49, 89),
            Color.rgb(110, 55, 55),
            Color.rgb(1, 188, 212)};

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide, container, false);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.linear);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
        TextView title = (TextView) view.findViewById(R.id.tv_title);
        TextView desc = (TextView) view.findViewById(R.id.tv_desc);

        layout.setBackgroundColor(colors[position]);
        imageView.setImageResource(images[position]);
        title.setText(titles[position]);
        desc.setText(descriptions[position]);
        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return (view == (LinearLayout) object);
    }
}
