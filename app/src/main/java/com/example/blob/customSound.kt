package com.example.blob

import android.media.AudioManager
import android.os.Bundle
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.blob.databinding.ActivityCustomBinding


lateinit var bii : ActivityCustomBinding
class customSound : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)


        bii = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(bii.root)

        val audioManager: AudioManager
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager

        val maxVolumeValue = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

        bii.buttonsound.setOnClickListener {
            audioManager.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                AudioManager.ADJUST_RAISE,
                AudioManager.FLAG_SHOW_UI
            );
        }
    }}


