package com.example.walmart_intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccount : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_create_account)

        btnCreateAcc.setOnClickListener{

         var registeredUser = User(textEmailAddress.text.toString(),
             textPassword.text.toString(), textFirstName.text.toString(),
             textLastName.text.toString())

            Toast.makeText(this, "Account has been created successfully!",
                Toast.LENGTH_LONG).show()

            Intent(this, MainActivity::class.java).also{
                it.putExtra("regUser", registeredUser)
                startActivity(it)
            }

        }
    }
}