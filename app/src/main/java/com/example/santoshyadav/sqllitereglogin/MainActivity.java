package com.example.santoshyadav.sqllitereglogin;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.santoshyadav.sqllitereglogin.Service.SharedPref;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    EditText _txtfname, _txtlname, _txtpass, _txtemail, _txtphone,_txtconfpass;
    TextView _alreadyAUser;
    boolean data_inserted=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DatabaseHelper(this);

        _btnreg = (Button) findViewById(R.id.btnReg);
        _alreadyAUser = (TextView) findViewById(R.id.tvAlreadyUser);
        _txtfname = (EditText) findViewById(R.id.txtfname);
        _txtlname = (EditText) findViewById(R.id.txtlname);
        _txtpass = (EditText) findViewById(R.id.txtpass);
        _txtconfpass = (EditText) findViewById(R.id.txtconfpass);
        _txtemail = (EditText) findViewById(R.id.txtemail);
        _txtphone = (EditText) findViewById(R.id.txtphone);

        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();                  //write data in database
                String fname = _txtfname.getText().toString();
                String lname = _txtlname.getText().toString();
                String pass = _txtpass.getText().toString();
                String confpass = _txtconfpass.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();

                if(fname.isEmpty()){
                    _txtfname.setError("Enter valid first name.");
                }
                else if(lname.isEmpty()){
                    _txtlname.setError("Enter valid last name.");
                }
                else if(pass.isEmpty() || !isValidPassword(pass)){
                    _txtpass.setError("Enter valid password.");
                }
                else if(email.isEmpty() || !isValidEmail(email)){
                    _txtemail.setError("Enter valid email.");
                }
                else if(!confpass.equals(pass)) {
                    _txtemail.setError("Enter valid password.");
                }
                else if(phone.isEmpty()){
                    _txtphone.setError("Enter valid phone number.");
                }else {
                    insertData(fname, lname, pass, email, phone);
                    if (data_inserted==true){

                        SharedPref sharedPref=new SharedPref();
                        sharedPref.setLoginStatus(MainActivity.this,1);
                        sharedPref.setKeyLoginEmail(MainActivity.this,email);
                        Intent intent=new Intent(MainActivity.this,Design.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Sign up failed.", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        _alreadyAUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }

    public boolean insertData(String fname, String lname, String pass, String email, String phone){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, pass);
        contentValues.put(DatabaseHelper.COL_5, email);
        contentValues.put(DatabaseHelper.COL_6, phone);

        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        if(id==-1){
            data_inserted=false;
            return false;
        }
        else {
            data_inserted=true;
            return true;

        }

    }

    private boolean isValidEmail(String email_id) {
        Pattern pattern;
        Matcher matcher;
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(email_id);

        return matcher.matches();
    }

    private boolean isValidPassword(String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();
    }
}
