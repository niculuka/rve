package com.example.rve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class RadioActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    LinearLayout home, player, radio, settings;
    TextView veb, vec, ves, zu, impulse, sport;
    String radioVeb = "Vocea Evangheliei Bucuresti";
    String radioVec = "Vocea Evangheliei Cluj";
    String radioVes = "Vocea Evangheliei Sibiu";
    String radioZu = "Radio Zu";
    String radioImpulse = "Radio Impuls";
    String radioSport = "Radio Sport";

    String loading = ".......";
    String playing =  " (now playing)";
    boolean prepared = false;
    boolean started = false;
    boolean preparedZu = false;
    boolean startedZu = false;
    MediaPlayer mediaPlayer;
    String vebUrl = "https://streamer.radio.co/sb94ce6fe2/listen";
    String vecUrl = "https://s23.myradiostream.com/:18366/listen.mp3";
    String vesUrl = "https://c13.radioboss.fm:18286/stream";
    String zuUrl = "https://live7digi.antenaplay.ro/radiozu/radiozu-48000.m3u8";
    String impulseUrl = "https://stream.radio-impuls.ro/stream2";
    String sportUrl = "https://livesptfm.com/SPTFM/Live/chunklist_w991511764.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        drawerLayout = findViewById(R.id.drawerLayout);
        // -----------------------------------------
        home = findViewById(R.id.menuHome);
        player = findViewById(R.id.menuPlayer);
        radio = findViewById(R.id.menuRadio);
        settings = findViewById(R.id.menuSettings);
        // -----------------------------------------
        veb = findViewById(R.id.vebId);
        vec = findViewById(R.id.vecId);
        ves = findViewById(R.id.vesId);
        zu = findViewById(R.id.zuId);
        impulse = findViewById(R.id.impulseId);
        sport = findViewById(R.id.sportId);

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

        veb.setText(radioVeb);
        vec.setText(radioVec);
        ves.setText(radioVes);
        impulse.setText(radioImpulse);
        zu.setText(radioZu);
        sport.setText(radioSport);

//        mediaPlayer = new MediaPlayer();
//        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        new PlayTask().execute(impulseUrl, zuUrl);
    }

    public static void changeActivity(Activity activity, Class nextActivity) {
        Intent intent = new Intent(activity, nextActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    // R A D I O ===================================================================================
    public void vebOnClick(View view) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(vebUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void vecOnClick(View view) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(vecUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void vesOnClick(View view) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(vesUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void zuOnClick(View view) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(zuUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void impulseOnClick(View view) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(impulseUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sportOnClick(View view) {
        if (mediaPlayer != null) mediaPlayer.release();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(sportUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopOnClick(View view) {
        mediaPlayer.release();
    }


//    private class PlayTask extends AsyncTask<String, Void, Boolean> {
//        @Override
//        protected Boolean doInBackground(String... strings) {
//            try {
//                mediaPlayer.setDataSource(strings[0]);
//                mediaPlayer.prepare();
//                prepared = true;
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            return prepared;
//        }
//
//        @Override
//        protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
//            impulse.setEnabled(true);
//            impulse.setText(radioImpulse);
//            started = false;
//        }
//    }

}