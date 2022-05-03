package com.example.a107ab0008_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView battery;
    private int batteryLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        battery = (ImageView) findViewById(R.id.battery);
    }

    public void minusBattery(View view) {
        if(batteryLevel > 0) {
            batteryLevel--;
        }
        battery.setImageLevel(batteryLevel);
    }

    public void plusBattery(View view) {
        if(batteryLevel < 7) {
            batteryLevel++;
        }
        battery.setImageLevel(batteryLevel);
    }
}