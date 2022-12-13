package com.example.walmart_intent

import java.io.Serializable

data class User(var username: String,
                var password: String,
                var firstName: String,
                var lastName: String) : Serializable
