package com.alokda.slide;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    SlideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter=new SlideAdapter(this);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
    }
}
