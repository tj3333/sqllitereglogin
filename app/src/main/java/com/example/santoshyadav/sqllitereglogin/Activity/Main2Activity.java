package com.example.santoshyadav.sqllitereglogin.Activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.santoshyadav.sqllitereglogin.R;

public class Main2Activity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        String selected_item_=intent.getStringExtra("quiz5ans");

        Log.d("TAG", "onCreate:============================= "+selected_item_);

        textView=(TextView)findViewById(R.id.place_name_quiz);


        //please learn this and add questions ,options


        if (selected_item_.equals("4,4,4,4,4")){
            textView.setText("Lonavala");
        }
        else if (selected_item_.equals("1,2,3,4,1")){
            textView.setText("Matheran");
        }
        else if (selected_item_.equals("1,2,1,2,1") || selected_item_.equals("2,2,2,2,2")){
            textView.setText("Lohagad");
        }
        else if (selected_item_.equals("4,3,4,3,4") || selected_item_.equals("1,1,1,1,1")){
            textView.setText("Raireshwar");
        }
        else if (selected_item_.equals("1,3,1,2,4")){
            textView.setText("Rajmachi");
        }
        else if (selected_item_.equals("4,3,2,1,2") || selected_item_.equals("3,3,3,3,3")){
            textView.setText("Sanjay Gandhi National park");
        }
        else {
            textView.setText("Lonavala");
        }

        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(textView,View.ALPHA,0f,1f);
        objectAnimator.setDuration(5000);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(objectAnimator);
        animatorSet.start();



    }
}
