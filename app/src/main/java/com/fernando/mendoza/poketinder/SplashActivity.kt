package com.fernando.mendoza.poketinder

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.fernando.mendoza.poketinder.databinding.ActivitySplashBinding
import com.rommansabbir.animationx.Attention
import com.rommansabbir.animationx.animationXAttention


class SplashActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imvLogo.animationXAttention(Attention.ATTENTION_SHAKE)
    }

    private fun runPostDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            goMainActivity()
        }, 3000)
    }

    private fun goMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}