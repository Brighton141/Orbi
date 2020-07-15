package com.malingi.orbicoin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.orbicoin.R;
import com.google.android.material.tabs.TabItem;
import com.malingi.orbicoin.Database.DatabaseHelper;
import com.malingi.orbicoin.chat_activities.Chat_mainActivity;
import com.malingi.orbicoin.dash_activities.AccountsActivity;
import com.malingi.orbicoin.dash_activities.CreditActivity;
import com.malingi.orbicoin.dash_activities.DepositsActivity;
import com.malingi.orbicoin.dash_activities.PaymentActivity;
import com.malingi.orbicoin.dash_activities.TransferActivity;
import com.malingi.orbicoin.dash_activities.WithdrawActivity;
import com.malingi.orbicoin.nav_activities.ProfileActivity;
import com.malingi.orbicoin.nav_activities.Transaction;


public class DashboardActivity extends Activity {
    DatabaseHelper myDb;
    ImageView imageView, imageView1, imageView2, imageView3, imageView4,
            imageView5, imageView6, imageView7, imageView8, imageView9, imageView10;
    TextView member;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageView = findViewById(R.id.accounts);
        imageView1 = findViewById(R.id.deposits);
        imageView2 = findViewById(R.id.withdraw);
        imageView3 = findViewById(R.id.credit);
        imageView4 = findViewById(R.id.sendMoney);
        imageView5 = findViewById(R.id.makePayments);

        imageView6 = findViewById(R.id.navHome);
        imageView7 = findViewById(R.id.navExpenses);
        imageView8 = findViewById(R.id.navWallet);
        imageView9 = findViewById(R.id.navProfile);
        imageView10 = findViewById(R.id.navChat);


        myDb = new DatabaseHelper(this);
        final TextView  member = findViewById(R.id.userName);
        String user = myDb.getuser_name();
        member.setText(user);

        OnClickListener onClickListener = v -> startActivity(new Intent(getApplicationContext(), AccountsActivity.class));
        imageView.setOnClickListener(onClickListener);
        imageView1.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DepositsActivity.class)));
        imageView2.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), WithdrawActivity.class)));
        imageView3.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), CreditActivity.class)));
        imageView4.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), TransferActivity.class)));
        imageView5.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PaymentActivity.class)));
        imageView6.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DashboardActivity.class)));
        imageView7.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Transaction.class)));
        imageView8.setOnClickListener(onClickListener);
        imageView9.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ProfileActivity.class)));
        imageView10.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Chat_mainActivity.class)));
        

    }
}
