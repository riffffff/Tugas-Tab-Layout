package com.example.logintablayout

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        }

        // Ambil username dan NIM dari Intent
        val username = intent.getStringExtra("USERNAME")
        val nim = intent.getStringExtra("NIM")

        // Inisialisasi TextView
        val textViewUsername = findViewById<TextView>(R.id.textViewName)
        val textViewNIM = findViewById<TextView>(R.id.textViewNIM)

        // Set data nama dan NIM
        textViewUsername.text = "Nama: $username"
        textViewNIM.text = "NIM: $nim"
    }
}
