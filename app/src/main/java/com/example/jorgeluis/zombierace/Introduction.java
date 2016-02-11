package com.example.jorgeluis.zombierace;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Introduction extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mediaPlayer= MediaPlayer.create(this, R.raw.song);
        mediaPlayer.start();
    }

    protected void onPause() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText meditText=(EditText)findViewById(R.id.editText);
        Bundle bundle = new Bundle();
        String value= meditText.getText().toString();
        bundle.putString("key", value);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
