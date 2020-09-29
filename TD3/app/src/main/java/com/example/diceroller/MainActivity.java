package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button roll = (Button) findViewById(R.id.roll_button);
        final TextView roll_TextView = (TextView) findViewById(R.id.TextView_Roll);
        final TextView roll_TextView2 = (TextView) findViewById(R.id.TextView_Roll2);

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roll_TextView.setText(Random());
                roll_TextView2.setText(Random());
            }
        });
    }

    public String Random(){
        int roll=0;
        int min = 1;
        int max = 6;

        Random r = new Random();
        roll = r.nextInt(max-min+1)+min;
        String res = String.valueOf(roll);
        return res;

    }

}