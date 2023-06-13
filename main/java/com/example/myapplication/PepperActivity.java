package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
import com.aldebaran.qi.sdk.object.humanawareness.HumanAwareness;



import android.widget.ImageView;

import android.os.Bundle;

import java.text.CollationElementIterator;
public class PepperActivity extends RobotActivity implements RobotLifecycleCallbacks {

//    AppCompatButton buttonSayHello;
    TextView textView;
    private QiContext qiContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pepper);

        QiSDK.register(this, this);
        Log.i("RoboticActivity", "Enter into RobotActivity");

//        buttonSayHello=findViewById(R.id.button_say_hello);
//        buttonSayHello.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                greet();
//            }
//        });

    }
    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        // The robot focus is gained.
        Log.i("RoboticActivity", "Robot focus gained");
        this.qiContext = qiContext;
        // Perform actions with the robot

        // Creating a Say action to make Pepper say
        Say sayGreeting = SayBuilder.with(qiContext)
                .withText("Hello, I am Pepper. Nice to meet you!")
                .build();

        // Animation action for greeting movements
        Animate greetAnimation = (Animate) AnimationBuilder.with(qiContext)
                .withResources(R.raw.clapping_b001)  //  testing with clapping animation resource
                .build();
        // Run the Say action and Animation action concurrently
        sayGreeting.run();
        greetAnimation.run();

        // Update the TextView to notify that the Say action is done.
        runOnUiThread(() -> {
            Intent intent = new Intent(PepperActivity.this, MainActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
        Log.i("RoboticActivity", "Robot focus lost");
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.
        Log.i("RoboticActivity", "Robot focus refused: " + reason);
    }

//    private void greet() {
//        if (qiContext == null) {
//            return;
//        }
//        Log.i("RoboticActivity","enter into greetings function");
//
//
//    }
}