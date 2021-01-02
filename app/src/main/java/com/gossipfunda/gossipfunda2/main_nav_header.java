//package com.gossipfunda.gossipfunda2;
//
//import androidx.annotation.NonNull;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import com.bumptech.glide.Glide;
//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.material.navigation.NavigationView;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.UserInfo;
//
//public class main_nav_header extends AppCompatActivity {
//
//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;
//    private Toolbar mToolbar;
//
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//    ImageView ivImage;
//    private TextView tvName;
//    private NavigationView mNavigationView;
//
//    private String name;
//    private Uri photoUrl;
//    private ImageView mPic;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_nav_header);
//
//        //mToolbar = findViewById(R.id.nav_action);
//        setSupportActionBar(mToolbar);
//        mDrawerLayout = findViewById(R.id.drawer_Layout);
//        ivImage = findViewById(R.id.iv_image);
//        tvName = findViewById(R.id.tv_name);
//
//        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = firebaseAuth -> {
//            if(firebaseAuth.getCurrentUser() == null) {
//                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        tvName = mNavigationView.getHeaderView(0).findViewById(R.id.tv_name);
//        mPic = mNavigationView.getHeaderView(0).findViewById(R.id.iv_image);
//        getCurrentinfo();
//
//        mNavigationView = findViewById(R.id.nav_view);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(mToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void getCurrentinfo() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            for (UserInfo profile : user.getProviderData()) {
//                // Id of the provider (ex: google.com)
//                String providerId = profile.getProviderId();
//
//                // UID specific to the provider
//                String uid = profile.getUid();
//
//                // Name, email address, and profile photo Url
//                name = profile.getDisplayName();
//                photoUrl = profile.getPhotoUrl();
//                tvName.setText(name);
//
//                GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
//                Glide.with(this).load(googleSignInAccount.getPhotoUrl()).into(ivImage);
//            }
//        }
//    }
//}