package com.example.blob

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.blob.databinding.ActivityMemHomeBinding

var time2 = 45
var tilesCount2 = 4
var custom2 = false

class Mem_home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mem_home)
        lateinit var binding: ActivityMemHomeBinding
        binding = ActivityMemHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.memPlay.setOnClickListener{
            mainsound.stop()
            var intent = Intent(this,ColorMemorizeMain::class.java )

            startActivity(intent)
            overridePendingTransition(R.anim.zoom,R.anim.static_animation)
        }


        binding.memCustom.setOnClickListener{

            tapsound.start()
            binding.customsubtractiontime.isVisible = false
            binding.customsubtractiontiles.isVisible = false
            binding.customplustiles.isVisible = false
            binding.customplustime.isVisible = false
            binding.Custom.isVisible = true
            binding.memCustom.isEnabled = false
            binding.memPlay.isEnabled = false
            binding.backpick4.isEnabled = false

        }

        binding.customsubtractiontime.setOnClickListener {
            tapsound.start()
            if( Integer.parseInt(binding.customboardtime.text.toString()) >= 35){
                binding.customboardtime.setText((Integer.parseInt(binding.customboardtime.text.toString())-5).toString())
            }else{
                binding.customboardtime.setText("30")
            }

        }

        binding.customsubtractiontime.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(view: View?): Boolean {
                binding.choosetime.isVisible = true
                setViewAndChildrenEnabled(binding.Custom,false)
                return true
            }
        })

        binding.customplustime.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(view: View?): Boolean {
                binding.choosetime.isVisible = true
                setViewAndChildrenEnabled(binding.Custom,false)
                return true
            }
        })

        binding.customplustime.setOnClickListener {
            tapsound.start()
            if( Integer.parseInt(binding.customboardtime.text.toString()) <= 115){
                binding.customboardtime.setText((Integer.parseInt(binding.customboardtime.text.toString())+5).toString())
            }else{
                binding.customboardtime.setText("120")
            }

        }

        binding.timeboardok.setOnClickListener {
            tapsound.start()
            binding.choosetime.isVisible = false

            setViewAndChildrenEnabled(binding.Custom,true)
            if(Integer.parseInt(binding.edittime.text.toString()) > 120 || Integer.parseInt(binding.edittime.text.toString()) < 0){
                time2 = 120
                binding.customboardtime.setText("120")
            }else{
                time2 = Integer.parseInt(binding.edittime.text.toString())
                binding.customboardtime.setText(binding.edittime.text)
            }


        }
        binding.customsubtractiontiles.setOnClickListener {
            tapsound.start()
            when(tilesCount2){
                4->{
                    tilesCount2--
                    binding.customboartiles4.isVisible = false
                }
                3->{
                    tilesCount2--
                    binding.customboartiles3.isVisible = false
                }
                2->{
                    tilesCount2--
                    binding.customboartiles2.isVisible = false
                }



            }
        }

        binding.customplustiles.setOnClickListener {
            tapsound.start()
            when(tilesCount2){
                1->{
                    tilesCount2++
                    binding.customboartiles2.isVisible = true
                }
                2->{
                    tilesCount2++
                    binding.customboartiles3.isVisible = true
                }
                3->{
                    tilesCount2++
                    binding.customboartiles4.isVisible = true
                }



            }
        }

        binding.customdefault.setOnClickListener {
            tapsound.start()
            binding.customdefault.setImageDrawable(resources.getDrawable(R.drawable.default_yes))
            binding.customcustom.setImageDrawable(resources.getDrawable(R.drawable.custom_no))
            custom2 = false

            binding.customboardtime.setText("45")
            tilesCount2 = 4

            binding.customboartiles2.isVisible = true
            binding.customboartiles3.isVisible = true
            binding.customboartiles4.isVisible = true
            binding.customsubtractiontime.isVisible = false
            binding.customsubtractiontiles.isVisible = false
            binding.customplustiles.isVisible = false
            binding.customplustime.isVisible = false


        }

        binding.customboartok.setOnClickListener {
            binding.Custom.isVisible = false
            time2 = Integer.parseInt(binding.customboardtime.text.toString())
            binding.memCustom.isEnabled = true
            binding.memPlay.isEnabled = true
            binding.backpick4.isEnabled = true
        }

        binding.customcustom.setOnClickListener {
            tapsound.start()
            binding.customdefault.setImageDrawable(resources.getDrawable(R.drawable.default_no))
            binding.customcustom.setImageDrawable(resources.getDrawable(R.drawable.custom_yes))
            custom2 = true

            binding.customsubtractiontime.isVisible = true
            binding.customsubtractiontiles.isVisible = true
            binding.customplustiles.isVisible = true
            binding.customplustime.isVisible = true
        }

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
}