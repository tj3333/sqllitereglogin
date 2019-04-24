package com.example.santoshyadav.sqllitereglogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class Adminlogin extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    Button buttonadmin;
    EditText admineditText2,admineditText3;
    TextView admintextView2;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);


        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        admintextView2=(TextView)findViewById(R.id.textView2);
        buttonadmin = (Button) findViewById(R.id.button);
        admineditText3 = (EditText) findViewById(R.id.editText3);
        admineditText2= (EditText) findViewById(R.id.editText2);

        buttonadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=admineditText2.getText().toString();
                String pass=admineditText3.getText().toString();
                if(name.equals("admin")&&pass.equals("login"))
                {

                Intent i=new Intent(Adminlogin.this, ImageList.class);
                startActivity(i);
            }
            else{
                Intent i=new Intent(Adminlogin.this,Adminlogin.class);
            }
            }
        });

    }
}
