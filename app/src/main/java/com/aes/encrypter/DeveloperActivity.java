package com.aes.encrypter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class DeveloperActivity extends AppCompatActivity {

    AppCompatButton instagram, facebook, twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Developer");

        SubsamplingScaleImageView developer = (SubsamplingScaleImageView) findViewById(R.id.developer);
        developer.setImage(ImageSource.resource(R.drawable.developer));

        instagram = findViewById(R.id.instagram);
        facebook = findViewById(R.id.facebook);
        twitter = findViewById(R.id.twitter);

        instagram.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.instagram.com/the.rupesh/");
            Intent instagram = new Intent(Intent.ACTION_VIEW, uri);
            instagram.setPackage("com.instagram.android");
            try {
                startActivity(instagram);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/the.rupesh/")));
            }
        });

        facebook.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.facebook.com/rupesh9698/");
            Intent facebook = new Intent(Intent.ACTION_VIEW, uri);
            facebook.setPackage("com.facebook.katana");
            try {
                startActivity(facebook);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rupesh9698/")));
            }
        });

        twitter.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://twitter.com/therupeshbagde");
            Intent twitter = new Intent(Intent.ACTION_VIEW, uri);
            twitter.setPackage("com.twitter.android");
            try {
                startActivity(twitter);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/therupeshbagde")));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}