package com.example.dev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        ImageView img = findViewById(R.id.img);
        TextView titleText = findViewById(R.id.titleText);


        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.animasyon);
        img.startAnimation(rotateAnimation);


        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeIn.setDuration(2000); // 2 saniye
        titleText.startAnimation(fadeIn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent degis = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(degis);
            }
        });
    }
}