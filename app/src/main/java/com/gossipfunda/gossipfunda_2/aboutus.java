package com.gossipfunda.gossipfunda_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
    }

    public void about_web(View view) {
        Intent intent = new Intent(aboutus.this, aboutus_webview.class);
        startActivity(intent);
    }
}