package com.example.dev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    ListView listv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listv1 = findViewById(R.id.listv1);
        
        String[] baslik = {"Sıcak İçecekler", "Soğuk İçecekler", "Tatlılar", "Yemekler"};
        int[] resim = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

        CategoryAdapter adapter = new CategoryAdapter(this, baslik, resim);
        listv1.setAdapter(adapter);

        listv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("kategori", baslik[position]);
                startActivity(intent);
            }
        });
    }
}