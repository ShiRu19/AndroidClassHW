package com.example.a107ab0008_hw7_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mRecipeList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    private String total_recipes;
    private int pictureIndex[] = {R.drawable.recipe_1, R.drawable.recipe_2, R.drawable.recipe_3};
    private int contentIndex[] = {R.string.recipe_1, R.string.recipe_2, R.string.recipe_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_recipes = getString(R.string.total_recipe);
        for (String retval: total_recipes.split("#")) {
            mRecipeList.addLast(retval);
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecipeListAdapter(this, mRecipeList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Turn to SecondActivity
    public void textOnClicked(int mPosition) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("RecipeDetailIndex", contentIndex[mPosition]);
        intent.putExtra("RecipePictureIndex", pictureIndex[mPosition]);
        startActivity(intent);
    }
}