package com.example.santoshyadav.sqllitereglogin;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.santoshyadav.sqllitereglogin.Service.SharedPref;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("deprecation")
public class Login extends AppCompatActivity {

    ActionBar actionBar;

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    Button _btnLogin;
    EditText _txtEmail, _txtPass;
    TextView _txtcreateacc;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        actionBar=getSupportActionBar();
        actionBar.hide();

        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _btnLogin = (Button) findViewById(R.id.btnLogin);
        _txtEmail = (EditText) findViewById(R.id.txtEmail);
        _txtPass = (EditText) findViewById(R.id.txtPass);
        _txtcreateacc = (TextView) findViewById(R.id.tvcreateacc);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = _txtEmail.getText().toString();
                String pass = _txtPass.getText().toString();

                if (!isValidEmail(email) || email.equals("")) {
                    _txtEmail.setError("Enter Valid Email.");
                }
                else if (_txtPass.getText().toString().length() < 8 || !isValidPassword(_txtPass.getText().toString())) {
                    _txtPass.setError("Enter Valid Password.");
                }
                else {
                    cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_5 + "=? AND " + DatabaseHelper.COL_4 + "=?", new String[]{email, pass});
                    if(cursor != null && cursor.getCount() > 0){
                        SharedPref sharedPref=new SharedPref();
                        sharedPref.setKeyLoginEmail(Login.this,email);
                        sharedPref.setLoginStatus(Login.this,1);
                        cursor.moveToNext();
                        Intent intent = new Intent(Login.this,Design.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(Login.this, "Data inserted.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Login.this, "Data not inserted.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        _txtcreateacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
