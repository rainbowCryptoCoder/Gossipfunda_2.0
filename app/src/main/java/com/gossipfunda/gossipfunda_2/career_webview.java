package com.gossipfunda.gossipfunda_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class career_webview extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;
    ProgressBar progressBar;
    private AdView mAdView;
    //InterstitialAd mInterstitialAd;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_webview);


        webView = findViewById(R.id.career_webview);
        webView.setWebViewClient(new WebViewClient());
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //webSettings.setBuiltInZoomControls(true);
        webView.loadUrl("https://gossipfunda.com/career/");

        //MobAd
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        //InterstitialAd
        //prepare the interstitial ad
        interstitialAd = new InterstitialAd(career_webview.this);
        //insert the Ad unit ID
        interstitialAd.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitialAd.loadAd(adRequest);
        //interstitialAd.loadAd(new adRequest().Builder().build());
        //prepare an Interstitial Ad listener
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                //call displayInterstitial() function
                //displayInterstitial();
                if (interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
            }
        });

        progressBar = (ProgressBar) findViewById(R.id.progressBar_career);
        progressBar.setMax(100);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}