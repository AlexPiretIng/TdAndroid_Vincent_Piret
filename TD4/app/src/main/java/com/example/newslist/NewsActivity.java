package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        Button logout_Btn = (Button)findViewById(R.id.Logout_button);
        Button detail_btn = (Button)findViewById(R.id.details_button);
        Button google_btn = (Button)findViewById(R.id.google_button);
        TextView username = (TextView)findViewById(R.id.login_name);

        Intent intent = getIntent();
        String login;
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
            username.setText(login);
        }

        logout_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });


        google_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}