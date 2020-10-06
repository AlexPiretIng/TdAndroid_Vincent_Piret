package com.example.td4bis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load("https://images-ext-1.discordapp.net/external/fTyVNw3HLD9b-fMp1e_wc4f_RFkfdJcwxj_RPvM83Pk/https/homepages.cae.wisc.edu/~ece533/images/baboon.png")
                .fitCenter()
                .circleCrop()
                .transition(withCrossFade())
                .into(imageView);

    }
}