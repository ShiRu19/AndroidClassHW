package com.example.a107ab0008_hw7_2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private final LinkedList<String> recipe;
    private LayoutInflater mInflater;
    private MainActivity mainActivity;

    public RecipeListAdapter(Context context,LinkedList<String> recipe) {
        mInflater = LayoutInflater.from(context);
        mainActivity = (MainActivity) context;
        this.recipe = recipe;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_list, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        String recipe_split[] = recipe.get(position).split(":");

        holder.recipeTitleItemView.setText(recipe_split[0]);
        holder.recipeContentItemView.setText(recipe_split[1]);
    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeTitleItemView;
        public final TextView recipeContentItemView;
        final RecipeListAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleItemView = itemView.findViewById(R.id.recipes_title);
            recipeContentItemView = itemView.findViewById(R.id.recipes_content);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            Log.d("-------PP", String.valueOf(mPosition));
            mainActivity.textOnClicked(mPosition);
            /*
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = recipe.get(mPosition);
            // Change the word in the mWordList.
            recipe.set(mPosition, "Clicked! "+ element);
            // Notify the adapter that the data has changed so it can update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
            */
        }
    }
}
