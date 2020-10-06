package com.example.newslist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        title = localClassName
        val ok_Btn = findViewById<View>(R.id.ok_button) as Button
        val login_Text = findViewById<View>(R.id.login_name) as TextView
        val app = applicationContext as NewsListApplication
        val login = app.login
        login_Text.text = login
        ok_Btn.setOnClickListener {
            val intent = Intent(this@DetailsActivity, NewsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@DetailsActivity, NewsActivity::class.java)
        startActivity(intent)
    }
}