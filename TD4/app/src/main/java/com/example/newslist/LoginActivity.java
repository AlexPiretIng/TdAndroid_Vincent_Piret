package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());

        final Button news_Btn = (Button) findViewById(R.id.login_button);

        news_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}