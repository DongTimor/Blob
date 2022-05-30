package com.example.blob

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.blob.databinding.ColorChooseMainActivityBinding
import java.util.*


lateinit var chooseColorBinding : ColorChooseMainActivityBinding
var resultid  = 0
private lateinit var choose3x3 : ChooseColor3X3
private lateinit var choose4x4 : ChooseColor4x4
private lateinit var choose5x5 : ChooseColor5x5
private lateinit var choose6x6 : ChooseColor6x6


 var comboBonus = 0;  var comboPenalty = 0
 var result1 = false
 var ratio = 0
 var fragnumber = 0
 var corrects = 0
 var rounds = 0
 var finalScore = 0






class ColorChooseMainActivity : AppCompatActivity() {

    fun CaculatingCombo(){


        if(result1 == true){
            comboBonus++
            if(comboBonus> comboPenalty){comboPenalty= comboBonus}



        }else{

            comboBonus=0


        }



        if(comboBonus>=0){
            when(comboBonus){
                0,1,2, 3-> ratio = 0
                4,5-> ratio =40
                6,7-> ratio =80
                8,9-> ratio =120
                10,11,12,13,14 -> ratio =200
                else -> ratio = 600
            }
        }

    }

    fun logicButton (boo : Int){
        Handler().postDelayed({
            when(fragnumber){
                1->resultid = choose3x3.getnum()
                2->resultid = choose4x4.getnum()
                3->resultid = choose5x5.getnum()
                4->resultid = choose6x6.getnum()
            }

            },100)

        if(resultid == boo){
            result1 = true
            CaculatingCombo()
            chooseColorBinding.flexcorrect.isVisible = true
            correctsound.start()
            setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, false)
            Handler().postDelayed({setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, true)
                chooseColorBinding.flexcorrect.isVisible = false
                                  },400)
            chooseColorBinding.score.setText((Integer.parseInt(chooseColorBinding.score.text.toString())+200 + ratio).toString())
            corrects++

        }else{
            result1 = false
            CaculatingCombo()
            chooseColorBinding.flexincorrect.isVisible = true
            incorrectsound.start()
            setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, false)
            Handler().postDelayed({setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, true)
                chooseColorBinding.flexincorrect.isVisible = false
            },400)
            chooseColorBinding.score.setText((Integer.parseInt(chooseColorBinding.score.text.toString()) * 0.8).toInt().toString())
        }

        Handler().postDelayed({
            chooseColorBinding.round.setText((Integer.parseInt( chooseColorBinding.round.text.toString())+1).toString())
            when(comboBonus){
                0,1,2,3 -> {chooseColorBinding.combo.setText("");chooseColorBinding.Streak1.isVisible = false;chooseColorBinding.Streak2.isVisible = false}
                4 -> {chooseColorBinding.combo.setText("Streak x 1.2");setEASEanimation(chooseColorBinding.combo)}
                6 -> {chooseColorBinding.combo.setText("Streak x 1.4");chooseColorBinding.combo.setTextColor(Color.parseColor("#FF7B07"));setEASEanimation(chooseColorBinding.combo)}
                8 -> {chooseColorBinding.combo.setText("Streak x 1.6");chooseColorBinding.combo.setTextColor(Color.parseColor("#FF5607"));setEASEanimation(chooseColorBinding.combo)}
                10 -> {chooseColorBinding.combo.setText("Streak x 2");chooseColorBinding.combo.setTextColor(Color.parseColor("#FF3907"));setEASEanimation(chooseColorBinding.combo)}
                15 -> {chooseColorBinding.combo.setText("Streak x 4");chooseColorBinding.combo.setTextColor(Color.parseColor("#971EAC"));setEASEanimation(chooseColorBinding.combo);chooseColorBinding.Streak1.isVisible = true;chooseColorBinding.Streak2.isVisible = true}

            }
        },450)


        val random = Random()
        val rd = random.nextInt(tilesCount)

        when(rd){
            0->{ CallFragment1()
                fragnumber = 1}
            1->{ CallFragment2()
                fragnumber = 2}
            2->{ CallFragment3()
                fragnumber = 3}
            3->{ CallFragment4()
                fragnumber = 4}
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

    fun setEASEanimation(text : TextView){



        val anim2 : Animation = AnimationUtils.loadAnimation(this,R.anim.ease1)
        val anim3 : Animation = AnimationUtils.loadAnimation(this,R.anim.ease2)


        text.startAnimation(anim2)
        Handler().postDelayed({text.startAnimation(anim3)},150)
    }


    fun CallFragment1() {
        val fragman = supportFragmentManager
        val tran = fragman.beginTransaction()
        choose3x3 = ChooseColor3X3()
        tran.replace(R.id.choosecolorfragcontent1, choose3x3)
        tran.commit()

    }

    fun CallFragment2() {
        val fragman2 = supportFragmentManager
        val tran = fragman2.beginTransaction()
        choose4x4 = ChooseColor4x4()
        tran.replace(R.id.choosecolorfragcontent1, choose4x4)
        tran.commit()
    }

    fun CallFragment3() {
        val fragman3 = supportFragmentManager
        val tran = fragman3.beginTransaction()
        choose5x5 = ChooseColor5x5()
        tran.replace(R.id.choosecolorfragcontent1, choose5x5)
        tran.commit()
    }
    fun CallFragment4() {
        val fragman4 = supportFragmentManager
        val tran = fragman4.beginTransaction()
        choose6x6 = ChooseColor6x6()
        tran.replace(R.id.choosecolorfragcontent1, choose6x6)
        tran.commit()
    }

    fun TimeRun(time : Int){

        var timene = time*1000
        chooseColorBinding.clock.setText(time.toString())

        val timer: CountDownTimer = object : CountDownTimer(timene.toLong(), 1000) {
            override fun onTick(l: Long) {
                chooseColorBinding.clock.setText((Integer.parseInt(chooseColorBinding.clock.text.toString())-1).toString())
            }

            override fun onFinish() {

                flexiblesound.stop()
                overtimesound.start()
                chooseColorBinding.overtime.isVisible = true
                setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, false)



            }
        }
        timer.start()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.color_choose_main_activity)

        corrects =0 ; comboPenalty=0








        chooseColorBinding = ColorChooseMainActivityBinding.inflate(layoutInflater)
        setContentView(chooseColorBinding.root)

        setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, false)

        val image : TextView = findViewById(R.id.whitebackgrund)

        val animStart2 : Animation = AnimationUtils.loadAnimation(this, R.anim.endflash)
        startsound.start()
        image.startAnimation(animStart2)
        Handler().postDelayed({ chooseColorBinding.ready.isVisible  = false

                              },3000)

        Handler().postDelayed({   chooseColorBinding.readygo.isVisible = false

        },3600)

        Handler().postDelayed({   flexiblesound.start()
            flexiblesound.isLooping

        },3900)

        Handler().postDelayed({
            setViewAndChildrenEnabled(chooseColorBinding.flexiblelayout, true)
            TimeRun(time1+1)

        },4000)


        Handler().postDelayed({
            rounds = Integer.parseInt(chooseColorBinding.round.text.toString())
            finalScore = Integer.parseInt(chooseColorBinding.score.text.toString())
            var intent = Intent(this,EndScreen1::class.java)
                              startActivity(intent)
                              finish()},(time1+8)*1000.toLong())


        val random = Random()
        val rd = random.nextInt(tilesCount)

        when(rd){
            0->{ CallFragment1()
                fragnumber = 1}
            1->{ CallFragment2()
                fragnumber = 2}
            2->{ CallFragment3()
                fragnumber = 3}
            3->{ CallFragment4()
                fragnumber = 4}
        }

        Handler().postDelayed({
            when(fragnumber){
                1->resultid = choose3x3.getnum()
                2->resultid = choose4x4.getnum()
                3->resultid = choose5x5.getnum()
                4->resultid = choose6x6.getnum()
            }

        },100)

        //  blue->brown->green->orange->purple->pink->red->yellow

        chooseColorBinding.RedChoose.setOnClickListener{
            chooseColorBinding.textchoose.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose.isVisible = false},300)

                logicButton(7)

        }

        chooseColorBinding.blueChoose.setOnClickListener{
            chooseColorBinding.textchoose9.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose9.isVisible = false},300)

            logicButton(1)

        }

        chooseColorBinding.brownChoose.setOnClickListener{
            chooseColorBinding.textchoose6.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose6.isVisible = false},300)

            logicButton(2)

        }

        chooseColorBinding.greenChoose.setOnClickListener{
            chooseColorBinding.textchoose3.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose3.isVisible = false},300)

            logicButton(3)

        }

        chooseColorBinding.orangeChoose.setOnClickListener{
            chooseColorBinding.textchoose7.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose7.isVisible = false},300)

            logicButton(4)

        }

        chooseColorBinding.purpleChoose.setOnClickListener{
            chooseColorBinding.textchoose10.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose10.isVisible = false},300)

            logicButton(5)

        }

        chooseColorBinding.pinkChoose.setOnClickListener{
            chooseColorBinding.textchoose4.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose4.isVisible = false},300)

            logicButton(6)

        }

        chooseColorBinding.yellowChoose.setOnClickListener{
            chooseColorBinding.textchoose2.isVisible = true
            Handler().postDelayed({ chooseColorBinding.textchoose2.isVisible = false},300)

            logicButton(8)

        }




    }
}