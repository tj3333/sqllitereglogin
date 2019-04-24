package com.example.santoshyadav.sqllitereglogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.santoshyadav.sqllitereglogin.QuizHome;
import com.example.santoshyadav.sqllitereglogin.R;

public class QuizHome2Actvity extends AppCompatActivity {

    String selected_item="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home2_actvity);

        Intent intent=getIntent();
        final String selected_item_=intent.getStringExtra("quiz1ans");

        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radio_group);
        Button button=(Button)findViewById(R.id.btnSubmitOne);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("TAG", "onCheckedChanged: "+checkedId);
                switch (checkedId){
                    case R.id.radio1:
                        selected_item="1";
                        break;
                    case R.id.radio2:
                        selected_item="2";
                        break;
                    case R.id.radio3:
                        selected_item="3";
                        break;
                    case R.id.radio4:
                        selected_item="4";
                        break;

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuizHome2Actvity.this,QuizHome3Activity.class);
                intent.putExtra("quiz2ans",selected_item+","+selected_item_);
                startActivity(intent);
                finish();
            }
        });
    }
}
