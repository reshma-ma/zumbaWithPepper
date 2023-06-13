package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
//import android.view.View;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


import android.widget.ImageView;




public class beginnersmovesActivity extends AppCompatActivity {


    MediaPlayer player;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginnersmoves);
        Intent intent = getIntent();





    }

    public void play(View v){
        if(player==null){
            player =MediaPlayer.create(this,R.raw.zumbasong);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();


    }

    public void pause(View v){

        if(player!=null){
            player.pause();
        }

    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(player!=null){
            player.release();
            player=null;
            Toast.makeText(this, "level completed", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(beginnersmovesActivity.this, feedbackActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}










//        timerView=findViewById(R.id.timer);
//
//        long duration= TimeUnit.MINUTES.toMillis(1);
//        new CountDownTimer(duration, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                String sDuration=String.format(Locale.ENGLISH,"%02d : %02d",TimeUnit.MILLISECONDS.toMinutes(1),
//                        TimeUnit.MILLISECONDS.toSeconds(1) -
//                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(1)));
//
//                timerView.setText(sDuration);
//            }
//
//            @Override
//            public void onFinish() {
////                timerView.setText("done!");
//                timerView.setVisibility(View.GONE);
//                Toast.makeText(beginnersmovesActivity.this, "countdown timer has ended", Toast.LENGTH_SHORT).show();
//
//            }
//        }.start();







