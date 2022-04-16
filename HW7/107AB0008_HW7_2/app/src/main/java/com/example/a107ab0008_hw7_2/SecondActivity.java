package com.example.a107ab0008_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.LinkedList;

public class SecondActivity extends AppCompatActivity {

    private final LinkedList<String> mRecipe = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeContentAdapter mAdapter;
    private String recipe_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int recipe_index = intent.getIntExtra("RecipeDetailIndex", 0);
        int picture_index = intent.getIntExtra("RecipePictureIndex", 0);

        recipe_content = getString(recipe_index);
        mRecipe.addLast(recipe_content);

        Log.d("RecipeListSize", String.valueOf(mRecipe.size()));
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview_2);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeContentAdapter(this, mRecipe, picture_index);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}