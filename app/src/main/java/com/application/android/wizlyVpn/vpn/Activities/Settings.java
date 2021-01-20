package com.application.android.wizlyVpn.vpn.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.application.android.wizlyVpn.vpn.R;
import com.onesignal.OneSignal;
import com.pixplicity.easyprefs.library.Prefs;

public class Settings extends AppCompatActivity {

    private Switch connectstart, tvnotif;
    private TextView aboutUs;
    private SharedPreferences connec_mode, open_start, notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarold);
        toolbar.setTitle("Settings");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        connectstart = findViewById(R.id.switch_connect_start);
        tvnotif = findViewById(R.id.switch_notific);
        aboutUs = findViewById(R.id.tv_aboutus);

        connec_mode = getSharedPreferences("cmode", MODE_PRIVATE);
        open_start = getSharedPreferences("start", MODE_PRIVATE);
        notification = getSharedPreferences("notifi", MODE_PRIVATE);

        checkSwitch();

        connectstart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Prefs.putString("connectStart", "on");
                } else {
                    //do stuff when Switch if OFF
                    Prefs.putString("connectStart", "off");
                }
            }
        });
        tvnotif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Prefs.putString("noti", "on");
                    OneSignal.setSubscription(true);
                } else {
                    //do stuff when Switch if OFF
                    OneSignal.setSubscription(false);
                    Prefs.putString("noti", "off");
                }
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AboutUs.class));
            }
        });
    }

    protected void checkSwitch() {
        String s1 = Prefs.getString("connectStart", null);
        if (s1 != null) {
            if (s1.equals("on")) {
                connectstart.setChecked(true);
            } else {
                connectstart.setChecked(false);
            }
        }
        String s2 = Prefs.getString("noti", null);
        if (s2 != null) {
            if (s2.equals("on")) {
                tvnotif.setChecked(true);

            } else {
                tvnotif.setChecked(false);
            }
        }
    }

}
