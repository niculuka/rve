package com.example.rve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    LinearLayout home, player, radio, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        drawerLayout = findViewById(R.id.drawerLayout);

        home = findViewById(R.id.menuHome);
        player = findViewById(R.id.menuPlayer);
        radio = findViewById(R.id.menuRadio);
        settings = findViewById(R.id.menuSettings);

        findViewById(R.id.menuBurger).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(SettingsActivity.this, MainActivity.class);
            }
        });

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(SettingsActivity.this, PlayerActivity.class);
            }
        });

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(SettingsActivity.this, RadioActivity.class);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                recreate();
            }
        });
    }

    public static void changeActivity(Activity activity, Class nextActivity) {
        Intent intent = new Intent(activity, nextActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }
}