package com.wordpress.milindkrohit.sudokusolveradvanced;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AboutUs extends AppCompatActivity {

    ImageButton rate,facebook;
    private TextView ver;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        rate = (ImageButton) findViewById(R.id.rateus);
        facebook = (ImageButton)findViewById(R.id.facebook);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "https://play.google.com/store/apps/details?id=com.wordpress.milindkrohit.sudokusolveradvanced";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));

            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "https://www.facebook.com/sudokusolveradvanced";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));

            }
        });
        String versionName = BuildConfig.VERSION_NAME;
        ver = (TextView)findViewById(R.id.appv);
        ver.setText(versionName);


    }
}
