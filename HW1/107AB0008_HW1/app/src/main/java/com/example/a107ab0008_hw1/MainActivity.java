package com.example.a107ab0008_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String Tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(Tag, "This is Verbose");
        Log.d(Tag, "This is Debug");
        Log.i(Tag, "This is Information");
        Log.w(Tag, "This is Warn");
        Log.e(Tag, "This is Error");
    }
}