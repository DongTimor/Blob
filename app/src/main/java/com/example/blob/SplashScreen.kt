package com.example.blob

import android.content.ClipData
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash2)

        val image : ImageView = findViewById(R.id.cenydong)
        val animStart : Animation = AnimationUtils.loadAnimation(this, R.anim.startanimation)
        val animStart2 : Animation = AnimationUtils.loadAnimation(this, R.anim.startanimation2)

        //Animation start
       image.startAnimation(animStart)
    Handler().postDelayed({ image.startAnimation(animStart2)},2000)




        //Next to mainActivity
        Handler().postDelayed({
            var intent = Intent(this,MainMenu::class.java )
            startActivity(intent)
            overridePendingTransition(R.anim.zoom,R.anim.static_animation)
            finish()
        },2800)

    }

}