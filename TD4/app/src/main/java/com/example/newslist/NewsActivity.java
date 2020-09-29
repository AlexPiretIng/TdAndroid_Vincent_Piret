package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setTitle(getLocalClassName());

        Button logout_Btn = (Button)findViewById(R.id.Logout_button);
        Button detail_btn = (Button)findViewById(R.id.details_button);

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
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}