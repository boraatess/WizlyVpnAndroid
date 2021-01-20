package com.application.android.wizlyVpn.vpn.Activities;

import android.content.Intent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.application.android.wizlyVpn.vpn.R;

public class SplashScreen extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        coordinatorLayout = findViewById(R.id.cordi);

        if (!Utility.isOnline(getApplicationContext())) {

            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Check internet connection", Snackbar.LENGTH_LONG);
            snackbar.show();

        } else {
            startActivity(new Intent(this, IntroActivity.class));
            finish();
        }

    }
}
