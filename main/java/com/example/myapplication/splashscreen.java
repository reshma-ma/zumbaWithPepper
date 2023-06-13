package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aldebaran.qi.Future;
import com.aldebaran.qi.sdk.QiContext;

import com.aldebaran.qi.sdk.QiSDK;

import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;

import com.aldebaran.qi.sdk.builder.AnimationBuilder;
import com.aldebaran.qi.sdk.builder.HolderBuilder;
import com.aldebaran.qi.sdk.builder.SayBuilder;

import com.aldebaran.qi.sdk.design.activity.RobotActivity;

import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.actuation.Animate;
import com.aldebaran.qi.sdk.object.conversation.QiChatExecutor;
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.aldebaran.qi.sdk.object.holder.AutonomousAbilitiesType;
import com.aldebaran.qi.sdk.object.holder.Holder;

import android.widget.ImageView;

import android.os.Bundle;

import java.text.CollationElementIterator;

//public class splashscreen extends RobotActivity implements RobotLifecycleCallbacks {
public class splashscreen extends AppCompatActivity {


    Animation up,down;
    QiContext qiContext;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        QiSDK.register(this, this);
        setContentView(R.layout.activity_splashscreen);
        ImageView imageView= findViewById(R.id.splashapp);
        up= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        imageView.setAnimation(up);


        TextView textView= findViewById(R.id.appname);
        down=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                makeRobotSpeak();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Intent intent =new Intent(splashscreen.this, PepperActivity.class);
                startActivity(intent);


                finish();

            }
        },6000);


    }




//    @Override
//    protected void onResume() {
//        super.onResume();
//        QiSDK.register(this, this);
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        QiSDK.unregister(this, this);
//    }

//
//    @Override
//    protected void onDestroy() {
//        QiSDK.unregister(this, this);
//        super.onDestroy();
//    }


//    @Override
//    public void onRobotFocusGained(QiContext qiContext) {
//        Log.i("TAG","Robot focus gained");
////        this.qiContext = qiContext;
//        // Create a new say action.
//        Say say = SayBuilder.with(qiContext) // Create the builder with the context.
//                .withText("Hello human!") // Set the text to say.
//                .build(); // Build the say action.
//
//        // Execute the action.
//        say.run();
//    }

//    @Override
//    public void onRobotFocusLost() {
//
//        Log.i("TAG", "Robot Focus lost");
//        // Release any resources or stop ongoing actions here
//    }
//
//    private void makeRobotSpeak() {
//        Log.i("TAG","ROBOT IS GOING TO START SPEAK");
//        if (qiContext != null) {
//            Say say = SayBuilder.with(qiContext)
//                    .withText("Hello, I am a robot.")
//                    .build();
//            say.run();
//        }
//    }

//    @Override
//    public void onRobotFocusRefused(String reason) {
//
//        Log.i("TAG", "Robot Focus refused because " + reason);
//        // The robot focus is refused.
//    }



}













