package com.example.santoshyadav.sqllitereglogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.santoshyadav.sqllitereglogin.Activity.BookingActivity;
import com.example.santoshyadav.sqllitereglogin.Service.SharedPref;

@SuppressWarnings("deprecation")
public class Design extends AppCompatActivity {

    CardView best_time_view,places_on_map_view,quiz_view,shopping_view,book_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        best_time_view=(CardView)findViewById(R.id.best_time_view);
        places_on_map_view=(CardView)findViewById(R.id.places_on_map_view);
        quiz_view=(CardView)findViewById(R.id.quiz_view);
        shopping_view=(CardView)findViewById(R.id.shopping_view);
        book_view=(CardView)findViewById(R.id.book_view);

        best_time_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, Besttime.class);
                startActivity(intent);

            }
        });
        places_on_map_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, MapsActivity.class);
                startActivity(intent);
            }
        });
/*        _dbtnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, Help.class);
                startActivity(intent);
            }
        });*/
        quiz_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, QuizHome.class);
                startActivity(intent);
            }
        });
/*        _dbtnguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, Guide.class);
                startActivity(intent);
            }
        });*/
/*        _dbtnexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, Expenditure.class);
                startActivity(intent);
            }
        });*/
        shopping_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, Expenditure.class);
                startActivity(intent);
            }
        });

        book_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, BookingActivity.class);
                startActivity(intent);
            }
        });
/*        _dbtnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Design.this, Chat.class);
                startActivity(intent);
            }
        });*/


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dash_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                startActivity(new Intent(Design.this,Help.class));
                return true;
            case R.id.guide:
                startActivity(new Intent(Design.this,Guide.class));
                return true;
            case R.id.spd:
                startActivity(new Intent(Design.this, com.example.santoshyadav.sqllitereglogin.MapsShort.MapsActivity.class));
                return true;
            case R.id.logout:
                SharedPref sharedPref=new SharedPref();
                sharedPref.clearSharedPreference(Design.this);
                startActivity(new Intent(Design.this,Login.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


