package com.example.a107ab0008_hw4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView mCountText;
    public Button mCountButton;
    public EditText mEditText;
    private int mCount = 0;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountText = findViewById(R.id.countText);
        mCountButton = findViewById(R.id.countButton);
        mEditText = findViewById(R.id.editText);
        if (savedInstanceState != null) {
            mCountText.setText(savedInstanceState.getString("countText"));
            mEditText.setText(savedInstanceState.getString("editText"));
            mCount = savedInstanceState.getInt("countNum");
        }
    }

    /*
     * Increments the number in the TextView when the COUNT button is clicked.
     *
     * @param view The view that triggered this onClick handler.
     *             Since the count always appears in the TextView,
     *             the passed in view is not used.
     */
    public void countUp(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        String num_str = mEditText.getText().toString();
        mCount = mCount + Integer.parseInt(num_str);
        mCountText.setText(Integer.toString(mCount));
    }

    /*
     * Saves the contents of countText, editText and countNum.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Save the user's current game state
        savedInstanceState.putString("countText", mCountText.getText().toString());
        savedInstanceState.putString("editText", mEditText.getText().toString());
        savedInstanceState.putInt("countNum", mCount);
    }
}