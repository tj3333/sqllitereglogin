package com.example.santoshyadav.sqllitereglogin.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.example.santoshyadav.sqllitereglogin.Components.Titanic;
import com.example.santoshyadav.sqllitereglogin.Components.TitanicTextView;
import com.example.santoshyadav.sqllitereglogin.Design;
import com.example.santoshyadav.sqllitereglogin.Login;
import com.example.santoshyadav.sqllitereglogin.R;
import com.example.santoshyadav.sqllitereglogin.Service.SharedPref;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        final TitanicTextView tv = (TitanicTextView) findViewById(R.id.splash_text);

        new Titanic().start(tv);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                SharedPref sharedPref=new SharedPref();
                int status=sharedPref.getLoginStatus(SplashActivity.this);

                if (status==1){
                    Intent mainIntent = new Intent(SplashActivity.this,Design.class);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    Intent mainIntent = new Intent(SplashActivity.this,Login.class);
                    startActivity(mainIntent);
                    finish();
                }

            }
        }, 10000);


    }
}
