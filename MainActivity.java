package com.example.myapplication;

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
import com.aldebaran.qi.sdk.object.conversation.Say;
import com.aldebaran.qi.sdk.object.holder.AutonomousAbilitiesType;
import com.aldebaran.qi.sdk.object.holder.Holder;

import android.widget.ImageView;





public class MainActivity extends AppCompatActivity {


    AppCompatButton btnbeginer,btncomplex,btnadvanced;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        btnbeginer=findViewById(R.id.btnbeginner);
        btncomplex=findViewById(R.id.btncomplex);
        btnadvanced=findViewById(R.id.btnadvanced);


        btnbeginer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, beginnersmovesActivity.class);
                startActivity(intent);

            }
        });
        btncomplex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, complexmovesActivity.class);
                startActivity(intent);

            }
        });
        btnadvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, AdvancemovesActivity.class);
                startActivity(intent);

            }
        });
    }

}






//
//public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {
//
//    private QiContext qiContext;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // Register the RobotLifecycleCallbacks to this Activity.
//        QiSDK.register(this, this);
//        Log.i("TAG","Run action started with success.");
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        // Unregister the RobotLifecycleCallbacks for this Activity.
//        QiSDK.unregister(this, this);
//        super.onDestroy();
//    }
//
//    @Override
//    public void onRobotFocusGained(QiContext qiContext) {
//        // The robot focus is gained.
//        this.qiContext = qiContext;
//        Log.i("TAG","Run action started with success.");
//        // Create a new say action.
//        Say say = SayBuilder.with(qiContext) // Create the builder with the context.
//                .withText("Hello human!") // Set the text to say.
//                .build(); // Build the say action.
//        Log.i("TAG", "Build action started with success.");
//        say.run();
//        Log.i("TAG", "Say action finished with success.");
//
////        runAction();
//    }
//
//
//    @Override
//    public void onRobotFocusLost() {
//        // The robot focus is lost.
//    }
//
//    @Override
//    public void onRobotFocusRefused(String reason) {
//        // The robot focus is refused.
//    }
//
//    private void runAction() {
//        Log.i("TAG","Inside run action started with success.");
//        try {
//            // Build an action synchronously.
//            Say say = SayBuilder.with(qiContext) // Create a builder with the QiContext.
//                    .withText("Hello!") // Specify the action parameters.
//                    .build();
//            Log.i("TAG", "Build action finished with success.");
////            Animate animate = AnimationBuilder.with(qiContext)
////                    .withResources(R.raw.my_animation)
////                    .build();
//            // Run the action synchronously and get the result.
//            say.run();
//            // Act on success.
//            Log.i(TAG, "Say action finished with success.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void holdAbilities(QiContext qiContext) {
//        // Build the holder for the abilities.
//        Holder holder = HolderBuilder.with(qiContext)
//                .withAutonomousAbilities(
//                        AutonomousAbilitiesType.BACKGROUND_MOVEMENT,
//                        AutonomousAbilitiesType.BASIC_AWARENESS,
//                        AutonomousAbilitiesType.AUTONOMOUS_BLINKING
//                )
//                .build();
//
//        // Hold the abilities asynchronously.
//        Future<Void> holdFuture = holder.async().hold();
//    }
//}