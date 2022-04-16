package com.example.a107ab0008_hw7_2;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeContentAdapter extends RecyclerView.Adapter<RecipeContentAdapter.RecipeViewHolder> {
    private final LinkedList<String> recipe;
    private LayoutInflater mInflater;
    private int image_index;

    public RecipeContentAdapter(Context context, LinkedList<String> recipe, int image_index) {
        mInflater = LayoutInflater.from(context);
        this.recipe = recipe;
        this.image_index = image_index;
    }

    @NonNull
    @Override
    public RecipeContentAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipe_detail, parent, false);
        return new RecipeContentAdapter.RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeContentAdapter.RecipeViewHolder holder, int position) {
        holder.imageItemView.setImageResource(image_index);
        holder.recipeContentItemView.setText(recipe.get(position));
    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeContentItemView;
        public final ImageView imageItemView;
        final RecipeContentAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeContentAdapter adapter) {
            super(itemView);
            recipeContentItemView = itemView.findViewById(R.id.recipes_content_2);
            imageItemView = itemView.findViewById(R.id.recipe_picture);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
