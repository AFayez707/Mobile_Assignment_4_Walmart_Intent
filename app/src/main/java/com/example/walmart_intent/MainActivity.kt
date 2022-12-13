package com.example.walmart_intent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val usersArrayList = ArrayList<User>()

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersArrayList.add(User("ahmed707@gmail.com", "123456", "Ahmed", "Fayez"))
        usersArrayList.add(User("test1@gmail.com", "123456", "Test", "Test"))
        usersArrayList.add(User("test2@gmail.com", "123456", "Test", "Test"))
        usersArrayList.add(User("test3@gmail.com", "123456", "Test", "Test"))
        usersArrayList.add(User("test4@gmail.com", "123456", "Test", "Test"))


        btnCreate.setOnClickListener {
            Intent(this, CreateAccount::class.java).also {
                startActivity(it)
            }
        }

        val forgetPasswordText : TextView = findViewById(R.id.txtForgot)

        forgetPasswordText.setOnClickListener {
            if (txtEmail.text.toString().isNotEmpty()) {

                var intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:")

                var sendToEmail = arrayOf(txtEmail.text.toString())

                intent.putExtra(Intent.EXTRA_EMAIL, sendToEmail);

                intent.putExtra(Intent.EXTRA_SUBJECT, "Requesting Password");

                // Note, Usually password should be stored encrypted, and reset password should generate new OTP.
                intent.putExtra(Intent.EXTRA_TEXT,
                    "Your password is: ${usersArrayList.find { it.username == txtEmail.text.toString() }?.password}");

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent);
                }

            } else {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_LONG).show()
            }
        }

        btnSignIn.setOnClickListener {
            var userEmail = txtEmail.text.toString()
            var userPassword = txtPass.text.toString()

            var loggedInUser: User? = null

            for (user in usersArrayList) {
                if ((userEmail == user.username) && (userPassword == user.password) ) {
                    loggedInUser = user
                    break
                }
            }

            if (loggedInUser == null) {
                Toast.makeText(this, "User not found!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this,"Welcome ${loggedInUser.firstName} ${loggedInUser.lastName}", Toast.LENGTH_LONG).show()

            var newPage = Intent(this, Shop::class.java)

            newPage.putExtra("flname", "Welcome ${loggedInUser.firstName} ${loggedInUser.lastName}")

            startActivity(newPage)
        }
    }

    override fun onResume() {
        super.onResume()

        val registeredUserintent = intent.getSerializableExtra("regUser") as User ?

        if (registeredUserintent != null) {
            usersArrayList.add(registeredUserintent)
        }

    }
}
