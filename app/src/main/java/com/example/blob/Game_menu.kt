package com.example.blob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blob.databinding.ActivityGameMenuBinding


class Game_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_menu)

        lateinit var binding: ActivityGameMenuBinding
        binding = ActivityGameMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Flexchoose.setOnClickListener {
            var intent = Intent(this, Flex_home::class.java)
            tapsound.start()
            startActivity(intent)
            overridePendingTransition(R.anim.zoom, R.anim.static_animation)
        }

        binding.Memchoose.setOnClickListener {
            tapsound.start()
            var intent = Intent(this, Mem_home::class.java)

            startActivity(intent)
            overridePendingTransition(R.anim.zoom, R.anim.static_animation)
        }

        binding.backpick.setOnClickListener {
            tapsound.start()
            onBackPressed()
        }

        binding.Equachoose.setOnClickListener {
            tapsound.start()
            var intent = Intent(this, Equal_choose::class.java)

            startActivity(intent)
            overridePendingTransition(R.anim.zoom, R.anim.static_animation)
        }


    }
}