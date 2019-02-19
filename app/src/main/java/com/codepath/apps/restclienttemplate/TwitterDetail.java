package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.AsyncHttpClient;

import org.parceler.Parcels;

public class TwitterDetail extends AppCompatActivity {

    public ImageView ivProfileImage;
    public TextView tvScreenName;
    public TextView tvBody;
    public TextView tvTimeStamp;
    Tweet tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_twitter_logo_whiteonimage);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvScreenName = findViewById(R.id.tvScreenName);
        tvBody = findViewById(R.id.tvBody);
        tvTimeStamp = findViewById(R.id.tvTimeStamp);

        // Get the parceler results
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        // Set the variables
        tvScreenName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());
        tvTimeStamp.setText(tweet.getRelativeTimeAgo(tweet.getCreateAt()));
        Glide.with(this).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);

    }

}
