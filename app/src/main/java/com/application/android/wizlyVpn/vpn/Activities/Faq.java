package com.application.android.wizlyVpn.vpn.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.application.android.wizlyVpn.vpn.R;

public class Faq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarold);
        toolbar.setTitle("FAQ");
        setSupportActionBar(toolbar);

        /*
        *   The Questions / problems that the user probably faces during the usage of the application..
        *   The answers are available in the FAQ option...
        * */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    public void load_ad()
    {

    }

}
