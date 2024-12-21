package com.example.logintablayout

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        }

        // Ambil username dari Intent
        val username = intent.getStringExtra("USERNAME")
        val nim = intent.getStringExtra("NIM")

        // Set welcome message
        findViewById<TextView>(R.id.tvWelcome).text = "Welcome back, $username!"

        // Button untuk Profile
        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            // Arahkan ke ProfileActivity saat icon Profile diklik
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USERNAME", username) // Kirim username ke ProfileActivity
            intent.putExtra("NIM", nim) // Kirim NIM ke ProfileActivity
            startActivity(intent)
        }

        // Button untuk Logout
        val btnLogout = findViewById<ImageButton>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // Logout user dan kembali ke Login
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
