package com.example.dev;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private GridView gridView;
    private TextView categoryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dbHelper = new DatabaseHelper(this);
        gridView = findViewById(R.id.menuGridView);
        categoryTitle = findViewById(R.id.categoryTitle);

        String kategori = getIntent().getStringExtra("kategori");
        categoryTitle.setText(kategori);
        loadMenuItems(kategori);
    }

    private void loadMenuItems(String category) {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        Cursor cursor = dbHelper.getMenuItemsByCategory(category);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRICE));
            int imageResource = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGE));
            
            menuItems.add(new MenuItem(name, price, imageResource));
        }
        cursor.close();

        MenuAdapter adapter = new MenuAdapter(this, menuItems);
        gridView.setAdapter(adapter);
    }
} 