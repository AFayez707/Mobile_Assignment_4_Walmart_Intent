package com.example.walmart_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shop.*

class Shop : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        val intent = intent

        welcomeLabel.text = intent.getStringExtra("flname")

        tv.setOnClickListener(){
            Toast.makeText(this, "You have Choose Electronic Category", Toast.LENGTH_LONG).show()
        }

        jacket.setOnClickListener() {
            Toast.makeText(this, "You have Choose Clothing Category", Toast.LENGTH_LONG).show()
        }

        beauty.setOnClickListener(){
            Toast.makeText(this, "You have Choose Beauty Category", Toast.LENGTH_LONG).show()
        }

        pasta.setOnClickListener(){
            Toast.makeText(this, "You have Choose Food Category", Toast.LENGTH_LONG).show()
        }


    }
}