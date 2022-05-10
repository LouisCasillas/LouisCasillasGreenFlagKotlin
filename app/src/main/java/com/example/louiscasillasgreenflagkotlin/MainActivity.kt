package com.example.louiscasillasgreenflagkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val create_button : AppCompatButton = findViewById(R.id.create_account_button)

        create_button.setOnClickListener() {
            intent = Intent(this, InformationActivity::class.java)
            startActivity(intent)
        }
    }
}