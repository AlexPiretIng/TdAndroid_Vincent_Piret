package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle(getLocalClassName());

        Button ok_Btn = (Button)findViewById(R.id.ok_button);
        TextView login_Text = (TextView)findViewById(R.id.login_name);

        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();

        login_Text.setText(login);

        ok_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailsActivity.this, NewsActivity.class);
        startActivity(intent);
    }
}