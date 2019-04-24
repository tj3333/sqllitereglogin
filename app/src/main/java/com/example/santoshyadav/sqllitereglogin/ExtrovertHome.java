package com.example.santoshyadav.sqllitereglogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExtrovertHome extends AppCompatActivity {

    Button _btnQuiz, _btnQuotes;
    TextView _tvQuizMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_home);

        _btnQuiz = (Button) findViewById(R.id.btnQuiz);
        _btnQuotes = (Button) findViewById(R.id.btnQuotes);
        _tvQuizMaster = (TextView) findViewById(R.id.tvQuizMaster);


    }
}
