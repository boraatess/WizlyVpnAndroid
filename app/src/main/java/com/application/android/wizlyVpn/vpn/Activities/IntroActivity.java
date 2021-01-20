package com.application.android.wizlyVpn.vpn.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.application.android.wizlyVpn.vpn.R;
import io.github.dreierf.materialintroscreen.MaterialIntroActivity;
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder;

public class IntroActivity extends MaterialIntroActivity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", true)) {
            onFinish();
        } else {
//            To familiar the user with the basic requirements of the application...
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorPrimaryDark)
                    .buttonsColor(R.color.colorPrimary)
                    .image(R.drawable.ic_048_safe)
                    .title("Easy and Secure")
                    .description("Ultimate VPN is very Secure, People wont be able to track your online activity")
                    .build());
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorPrimaryDark)
                    .buttonsColor(R.color.colorPrimary)
                    .image(R.drawable.ic_029_networking)
                    .title("Lots of  Servers")
                    .description("Choose from a lot of servers across the globe.")
                    .build());
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorPrimaryDark)
                    .buttonsColor(R.color.colorPrimary)
                    .image(R.drawable.ic_044_key)
                    .title("Start Now!! Enjoy")
                    .description("So, what are you waiting? Start and unblock the sites and apps that are blocked in your country!")
                    .build());
        }
    }

    @Override
    public void onFinish() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstTime", false);
        editor.apply();
        super.onFinish();
    }
}

