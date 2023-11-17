package com.example.rve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

public class RadioActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    LinearLayout home, player, radio, settings;
    MediaPlayer mediaPlayer;
    String veb = "https://streamer.radio.co/sb94ce6fe2/listen";
    String vec = "https://s23.myradiostream.com/:18366/listen.mp3";
    String ves = "https://c13.radioboss.fm:18286/stream";
    String zu = "https://live7digi.antenaplay.ro/radiozu/radiozu-48000.m3u8";
    String impulse = "https://stream.radio-impuls.ro/stream2";
    String sport = "https://livesptfm.com/SPTFM/Live/chunklist_w991511764.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

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
                changeActivity(RadioActivity.this, MainActivity.class);
            }
        });

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(RadioActivity.this, PlayerActivity.class);
            }
        });

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.START);
                recreate();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(RadioActivity.this, SettingsActivity.class);
            }
        });
    }

    public static void changeActivity(Activity activity, Class nextActivity) {
        Intent intent = new Intent(activity, nextActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    // R A D I O ===================================================================================
    public void zu(View view) {

        mediaPlayer = new MediaPlayer();

        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );

        try {
            mediaPlayer.setDataSource(impulse);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

//            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mediaPlayer) {
//                    stopPlayer();
//                }
//            });


        Toast.makeText(this, "PlayRadio1", Toast.LENGTH_SHORT).show();

    }

}