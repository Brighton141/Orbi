package com.malingi.orbicoin.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orbicoin.R;
import com.malingi.orbicoin.chat_activities.Group_ChatActivity;

public class AddUserActivity extends AppCompatActivity {

    private Button setNickName;
    private EditText userNickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_login);

        userNickName = findViewById(R.id.userNickName);
        setNickName = findViewById(R.id.setNickName);


        userNickName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() > 0) {
                    setNickName.setEnabled(true);
                    Log.i(Group_ChatActivity.TAG, "onTextChanged: ABLED");
                } else {
                    Log.i(Group_ChatActivity.TAG, "onTextChanged: DISABLED");
                    setNickName.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        setNickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUserActivity.this, Group_ChatActivity.class);
                intent.putExtra("username", userNickName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
