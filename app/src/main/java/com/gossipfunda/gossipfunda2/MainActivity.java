package com.gossipfunda.gossipfunda2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private Vibrator v;
    FirebaseAuth mAuth;
    FirebaseUser currentUser;
    GoogleSignInClient googleSignInClient;
    ImageView ivImage;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        ivImage = findViewById(R.id.iv_image);
        tvName = findViewById(R.id.tv_name);

        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

//        //initialize sign in client
//        GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
//        tvName.setText(googleSignInAccount.getDisplayName());
//        Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(ivImage);

//        //initialize firebase auth
//        firebaseAuth = FirebaseAuth.getInstance();
//        //initialize firebase user
//        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//        //check condition
//        if (firebaseUser != null){
//            //when firebase user is not equal to null
//            //set image on image view
//            Glide.with(MainActivity.this)
//                    .load(firebaseUser.getPhotoUrl()).into(ivImage);
//            //set name on text view
//            tvName.setText(firebaseUser.getDisplayName());
//        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        updateNavHeader();

    }

    public void Vibrate(long millisecound){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            ((Vibrator)getSystemService(VIBRATOR_SERVICE))
                    .vibrate(VibrationEffect.createOneShot(millisecound, VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else {
            ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(millisecound);
        }
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    public void search_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, search_webview.class);
        startActivity(intent);
    }

    public void home_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, home_webview.class);
        startActivity(intent);
    }

    public void android_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, android_webview.class);
        startActivity(intent);
    }

    public void apple_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, apple_webview.class);
        startActivity(intent);
    }

    public void channel_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, channel_webview.class);
        startActivity(intent);
    }

    public void sponsor_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, sponsor_webview.class);
        startActivity(intent);
    }

    public void blog_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, blog_webview.class);
        startActivity(intent);
    }

    public void contact_card(View view) {
        Vibrate(80);
        Intent intent = new Intent(this, contactus_webview.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_home:
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    break;

                case R.id.menu_electronics:
                    Intent i2 = new Intent(this, electronics_webview.class);
                    startActivity(i2);
                    break;

                case R.id.menu_ai:
                    Intent i3 = new Intent(this, ai_webview.class);
                    startActivity(i3);
                    break;

                case R.id.menu_subscribe:
                    Intent i4 = new Intent(this, subcribe_webview.class);
                    startActivity(i4);
                    break;

                case R.id.menu_career:
                    Intent i5 = new Intent(this, career_webview.class);
                    startActivity(i5);
                    break;

                case R.id.menu_aboutUs:
                    Intent i6 = new Intent(this, aboutus.class);
                    startActivity(i6);
                    break;

                case R.id.menu_privacyPolicy:
                    Intent i7 = new Intent(this, privacy_policy.class);
                    startActivity(i7);
                    break;

                case R.id.menu_rateUs:
                    Vibrate(150);
                    Uri uri = Uri.parse("https://playstore.com/store/apps/details?id=" + getApplicationContext()
                            .getPackageName());
                    Intent i8 = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        startActivity(i8);
                    }
                    catch (Exception e){
                        Toast.makeText(this, "Unable to open\n"+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.menu_logout:
                    Vibrate(150);
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplicationContext(), sign_in_page.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

    public void updateNavHeader(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUserName = headerView.findViewById(R.id.tv_name);
        TextView navUserMail = headerView.findViewById(R.id.tv_email);
        ImageView navUserPhoto = headerView.findViewById(R.id.iv_image);

        navUserName.setText(currentUser.getDisplayName());
        navUserMail.setText(currentUser.getEmail());

        Glide.with(this).load(currentUser.getPhotoUrl()).into(navUserPhoto);
    }
}