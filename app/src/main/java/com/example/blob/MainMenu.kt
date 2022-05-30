package com.example.blob


import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.media.MediaPlayer
import android.media.ToneGenerator.MAX_VOLUME
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.IntentCompat
import androidx.core.view.isVisible
import com.example.blob.databinding.ActivityMainMenuBinding


lateinit var binding: ActivityMainMenuBinding
lateinit var mainsound: MediaPlayer
lateinit var tapsound: MediaPlayer
lateinit var memorizesound: MediaPlayer
lateinit var backsound: MediaPlayer

lateinit var flexiblesound: MediaPlayer
lateinit var correctsound: MediaPlayer
lateinit var incorrectsound: MediaPlayer
lateinit var overtimesound: MediaPlayer
lateinit var startsound: MediaPlayer


class MainMenu : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //The mainSound start
        mainsound = MediaPlayer.create(this, R.raw.main)
        tapsound = MediaPlayer.create(this, R.raw.tap)
        flexiblesound = MediaPlayer.create(this, R.raw.flexible)
        correctsound = MediaPlayer.create(this, R.raw.corect)
        incorrectsound = MediaPlayer.create(this, R.raw.incorrect)
        overtimesound = MediaPlayer.create(this, R.raw.endtime)
        startsound = MediaPlayer.create(this, R.raw.starttime)
        memorizesound = MediaPlayer.create(this, R.raw.memorize_sound)
        backsound = MediaPlayer.create(this, R.raw.back)
        mainsound.start()
        mainsound.isLooping = true


        //The First Menu
        AfterStartApp()


        //Main Background animation

        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.flash)

        Handler().postDelayed({
            binding.backgroudtextview.isVisible = false
            binding.flashview.startAnimation(anim)
        }, 1700)

        //AfterChoose


    }

    private fun setViewAndChildrenEnabled(view: View, enabled: Boolean) {
        view.setEnabled(enabled)
        if (view is ViewGroup) {
            val viewGroup = view as ViewGroup
            for (i in 0 until viewGroup.childCount) {
                val child: View = viewGroup.getChildAt(i)
                setViewAndChildrenEnabled(child, enabled)
            }
        }
    }


    fun AfterStartApp() {
        binding.playbutton.setOnClickListener {
            AfterChoosePlay()

            tapsound.start()
            binding.select.setImageResource(R.drawable.select)
            binding.select2.setImageResource(R.color.mem)
            binding.select3.setImageResource(R.color.mem)
            binding.select4.setImageResource(R.color.mem)


            // MenuPlayMode


        }


        binding.optionbutton.setOnClickListener {
            tapsound.start()
            binding.select.setImageResource(R.color.mem)
            binding.select2.setImageResource(R.drawable.select)
            binding.select3.setImageResource(R.color.mem)
            binding.select4.setImageResource(R.color.mem)


            binding.opOk.setOnClickListener {
                binding.op.isVisible = false
                overridePendingTransition(R.anim.zoom, R.anim.static_animation)
                setViewAndChildrenEnabled(binding.buttonGrid, true)
            }
            binding.op.isVisible = true
            overridePendingTransition(R.anim.zoom, R.anim.static_animation)
            setViewAndChildrenEnabled(binding.buttonGrid, false)
            binding.BGM.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // TODO Auto-generated method stub
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // TODO Auto-generated method stub
                }

                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // TODO Auto-generated method stub
                    var volume: Float =
                        (1 - (Math.log(100.00 - progress) / Math.log(100.00))).toFloat();
                    mainsound.setVolume(volume, volume);
                    memorizesound.setVolume(volume, volume);
                    flexiblesound.setVolume(volume, volume);


                }
            });


            binding.SFX.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // TODO Auto-generated method stub
                    tapsound.start()
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // TODO Auto-generated method stub

                }

                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // TODO Auto-generated method stub
                    var volume: Float =
                        (1 - (Math.log(100.00 - progress) / Math.log(100.00))).toFloat();
                    tapsound.setVolume(volume, volume);
                    incorrectsound.setVolume(volume, volume);
                    correctsound.setVolume(volume, volume);
                    overtimesound.setVolume(volume, volume);
                    startsound.setVolume(volume, volume);


                }
            });


        }
        binding.statbutton.setOnClickListener {
            tapsound.start()
            binding.select.setImageResource(R.color.mem)
            binding.select2.setImageResource(R.color.mem)
            binding.select3.setImageResource(R.drawable.select)
            binding.select4.setImageResource(R.color.mem)
        }
        binding.quitbutton.setOnClickListener {

            binding.frame.isVisible = true
            setViewAndChildrenEnabled(binding.buttonGrid, false)
            binding.textback.setOnClickListener() {
                backsound.start()
                setViewAndChildrenEnabled(binding.buttonGrid, true)
                binding.frame.isVisible = false
            }

            binding.textquit.setOnClickListener() {

                mainsound.stop()
                this.finishAndRemoveTask()


            }
            tapsound.start()
            binding.select.setImageResource(R.color.mem)
            binding.select2.setImageResource(R.color.mem)
            binding.select3.setImageResource(R.color.mem)
            binding.select4.setImageResource(R.drawable.select)


        }
    }

    fun AfterChoosePlay() {
        //Handler().postDelayed({binding.playlayout.isVisible = true},300)

        tapsound.start()
        //setViewAndChildrenEnabled(binding.buttonGrid,false)

        //

//        binding.puzzlemodechoose.setOnClickListener {
//            tapsound.start()
        var intent = Intent(this, ColorEqualizeMain::class.java)

        startActivity(intent)
        overridePendingTransition(R.anim.zoom, R.anim.static_animation)
//        }
//
//
//        binding.testmodechoose.setOnClickListener {
//
//            binding.testmodeselect.isVisible = true
//        }
    }


}


