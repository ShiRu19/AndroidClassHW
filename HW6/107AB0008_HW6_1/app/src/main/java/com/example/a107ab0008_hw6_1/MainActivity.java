package com.example.a107ab0008_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean mOrder[] = {false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToastClicked(View view) {
        String message = "";
        String mOrderText[] = {getString(R.string.Chocolate_syrup),
                                getString(R.string.Sprinkles),
                                getString(R.string.Crushed_nuts),
                                getString(R.string.Cherries),
                                getString(R.string.Orio_cookie_crumbles)};

        for(int i = 0; i < 5; i++) {
            if(mOrder[i])
                message = message + " " + mOrderText[i];
        }
        if(message != "") {
            message = "Toppings: " + message;
        }
        else{
            message = "Not selected.";
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onCheckBoxClicked(View view) {
        // Is checkBox now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkBox was clicked.
        switch (view.getId()) {
            case R.id.Chocolate_syrup:
                if (checked)
                    mOrder[0] = true;
                else
                    mOrder[0] = false;
                break;
            case R.id.Sprinkles:
                if (checked)
                    mOrder[1] = true;
                else
                    mOrder[1] = false;
                break;
            case R.id.Crushed_nuts:
                if (checked)
                    mOrder[2] = true;
                else
                    mOrder[2] = false;
                break;
            case R.id.Cherries:
                if (checked)
                    mOrder[3] = true;
                else
                    mOrder[3] = false;
                break;
            case R.id.Orio_cookie_crumbles:
                if (checked)
                    mOrder[4] = true;
                else
                    mOrder[4] = false;
                break;
            default:
                break; // Do nothing
        }
    }
}