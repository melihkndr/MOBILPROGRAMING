package com.example.dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    private Context context;
    private ArrayList<MenuItem> menuItems;

    public MenuAdapter(Context context, ArrayList<MenuItem> menuItems) {
        super(context, 0, menuItems);
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.menu_item_layout, parent, false);
        }

        MenuItem currentItem = menuItems.get(position);

        ImageView imageView = convertView.findViewById(R.id.menuItemImage);
        TextView nameText = convertView.findViewById(R.id.menuItemName);
        TextView priceText = convertView.findViewById(R.id.menuItemPrice);

        imageView.setImageResource(currentItem.getImageResource());
        nameText.setText(currentItem.getName());
        priceText.setText(String.format("%.2f ₺", currentItem.getPrice()));

        return convertView;
    }
} 