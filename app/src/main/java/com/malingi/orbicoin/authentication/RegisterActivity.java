package com.malingi.orbicoin.authentication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.orbicoin.R;
import com.malingi.orbicoin.Database.DatabaseHelper;


public class RegisterActivity extends Activity {
    EditText editText, editText1, editText2, editText3, editText4, editText5;
    Button sign_up;
    ImageView back;
    CheckBox remember;
    TextView login_text;
    DatabaseHelper myDb;
    private SQLiteDatabase sql;

    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);

        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);
        sign_up = findViewById(R.id.sign_up);
        back = findViewById(R.id.back_log);
        remember = findViewById(R.id.remember);
        login_text = findViewById(R.id.login_text);
        editText = findViewById(R.id.firstName);
        editText1 = findViewById(R.id.email);
        editText2 = findViewById(R.id.phone);
        editText3 = findViewById(R.id.password);
        editText4 = findViewById(R.id.re_password);
        editText5 = findViewById(R.id.lastName);
        AddData();

        back.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));


        login_text.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));


    }

    public void AddData() {
        sign_up.setOnClickListener(v -> {
            String firstName = editText.getText().toString();
            String lastName = editText5.getText().toString();
            String email = editText1.getText().toString();
            String phone = editText2.getText().toString();
            String password = editText3.getText().toString();
            String re_password = editText4.getText().toString();

            if(TextUtils.isEmpty(firstName)){
                Toast.makeText(RegisterActivity.this, "Please enter your First Name",
                        Toast.LENGTH_LONG).show();
                return;
            }
            if(TextUtils.isEmpty(lastName)){
                Toast.makeText(RegisterActivity.this, "Please enter your Last Name",
                        Toast.LENGTH_LONG).show();
                return;
            }
            if(TextUtils.isEmpty(email)){
                Toast.makeText(RegisterActivity.this, "Please enter your Email",
                        Toast.LENGTH_LONG).show();
                return;
            }if(TextUtils.isEmpty(phone)){
                Toast.makeText(RegisterActivity.this, "Please enter your Phone Number",
                        Toast.LENGTH_LONG).show();
                return;
            }if(TextUtils.isEmpty(password)){
                Toast.makeText(RegisterActivity.this, "Please enter your Password",
                        Toast.LENGTH_LONG).show();
                return;
            }if(TextUtils.isEmpty(re_password)){
                Toast.makeText(RegisterActivity.this, "Please Re-enter your Password",
                        Toast.LENGTH_LONG).show();
                return;
            }
            boolean isInserted = myDb.insertdata(firstName, lastName, email, phone, password, re_password);
            if (isInserted){
                Toast.makeText(RegisterActivity.this, "Data submitted",
                        Toast.LENGTH_LONG).show();
                editText.setText("");
                editText5.setText("");
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
            }
            else
                Toast.makeText(RegisterActivity.this,"Data not submitted!",
                        Toast.LENGTH_LONG).show();

        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
