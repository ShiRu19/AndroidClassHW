package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.edittext_website);
        mLocationEditText = findViewById(R.id.edittext_location);
        mShareTextEditText = findViewById(R.id.edittext_share);
    }

    public void openWebsite(View view) {
        // Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Make sure that the request resolved successfully.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // The request resolved is successfully, so start the activity.
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        // Get the location text.
        String location = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Make sure that the request resolved successfully.
        if (intent.resolveActivity(getPackageManager()) != null) {
            // The request resolved is successfully, so start the activity.
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void shareText(View view) {
        // Get the share text and define the mime type of the text to share.
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Share this text with: ")
                    .setText(txt)
                    .startChooser();


    }
}