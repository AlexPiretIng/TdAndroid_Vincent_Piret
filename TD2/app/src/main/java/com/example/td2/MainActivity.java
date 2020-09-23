package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button annuler;
    private EditText entree;
    private EditText plat;
    private CheckBox fromage;
    private CheckBox fruit;
    private RadioGroup moment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repas);

        annuler = (Button) findViewById(R.id.cancel);
        entree = (EditText) findViewById(R.id.entree);
        plat = (EditText) findViewById(R.id.plat);
        fromage = (CheckBox) findViewById(R.id.fromage);
        fruit = (CheckBox) findViewById(R.id.fruit);
        moment = (RadioGroup) findViewById(R.id.moment);

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entree.setText("");
                plat.setText("");
                fromage.setChecked(false);
                fruit.setChecked(false);
                moment.clearCheck();
            }
        });
    }
}