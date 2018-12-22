package com.quintus.labs.materialonboarding;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bapunu on 20-01-2018.
 */

public class SliderPagerAdapter extends PagerAdapter {
    Activity activity;
    List<WelcomeSlider> image_arraylist;
    private LayoutInflater layoutInflater;

    public SliderPagerAdapter(Activity activity, List<WelcomeSlider> image_arraylist) {
        this.activity = activity;
        this.image_arraylist = image_arraylist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item_slider, container, false);

        ImageView image = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.ls_title);
        TextView desc = view.findViewById(R.id.ls_desc);
        // Picasso.get().load(image_arraylist.get(position).getImage()).into(image);
        image.setBackgroundResource(image_arraylist.get(position).getImage());
        title.setText(image_arraylist.get(position).getTitle());
        desc.setText(image_arraylist.get(position).getDescription());


        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
