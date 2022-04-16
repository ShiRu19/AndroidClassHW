package com.example.a107ab0008_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDonutOrder(View view) {
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    public void showIcecreamOrder(View view) {
        Intent intent = new Intent(this, IcecreamActivity.class);
        startActivity(intent);
    }

    public void showFroyoOrder(View view) {
        Intent intent = new Intent(this, FroyoActivity.class);
        startActivity(intent);
    }
}