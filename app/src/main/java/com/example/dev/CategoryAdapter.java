package com.example.dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] titles;
    private final int[] images;

    public CategoryAdapter(Context context, String[] titles, int[] images) {
        super(context, R.layout.category_item_layout, titles);
        this.context = context;
        this.titles = titles;
        this.images = images;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.category_item_layout, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.categoryImage);
        TextView textView = convertView.findViewById(R.id.categoryName);

        imageView.setImageResource(images[position]);
        textView.setText(titles[position]);

        return convertView;
    }
} 