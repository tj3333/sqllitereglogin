package com.example.santoshyadav.sqllitereglogin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        final TextView _button2 = (TextView) findViewById(R.id.police);
        final TextView _button3 = (TextView) findViewById(R.id.ambulance);
        final TextView _button4 = (TextView) findViewById(R.id.citizen_helpline);
        final TextView _button5 = (TextView) findViewById(R.id.health);
        final TextView _button6 = (TextView) findViewById(R.id.woman_safety);

        _button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "100";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number));

                startActivity(i);
            }
        });
        _button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number1 = "102";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number1));

                startActivity(i);
            }
        });
        _button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number2 = "103";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number2));

                startActivity(i);
            }
        });
        _button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number3 = "108";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number3));

                startActivity(i);
            }
        });
        _button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number4 = "1090";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number4));

                startActivity(i);
            }
        });
    }
}