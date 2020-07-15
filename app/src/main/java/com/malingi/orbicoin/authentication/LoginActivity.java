package com.malingi.orbicoin.authentication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orbicoin.R;
import com.malingi.orbicoin.DashboardActivity;
import com.malingi.orbicoin.Database.DatabaseHelper;


public class LoginActivity extends Activity {
    Button Login;
    TextView Sign;
    EditText username, password;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);

        setContentView(R.layout.activity_login);
        myDb = new DatabaseHelper(this);

        Login = findViewById(R.id.Login);
        Sign = findViewById(R.id.Sign);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);

        Sign.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));

        Login.setOnClickListener(v -> {
            String member = username.getText().toString();
            String memberPassword = password.getText().toString();
            Boolean res = myDb.checkUser(member, memberPassword);

            if (res){
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            } else {
                Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
            }

        });
    }

}