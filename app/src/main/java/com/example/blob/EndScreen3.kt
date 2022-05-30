package com.example.blob

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.view.isVisible

import com.example.blob.databinding.ActivityEndScreen3Binding


lateinit var bindingEnd3 : ActivityEndScreen3Binding
lateinit var listText2 : ArrayList<TextView>

class EndScreen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_end_screen3)
        listText2 = ArrayList()

        bindingEnd3 = ActivityEndScreen3Binding.inflate(layoutInflater)
        setContentView(bindingEnd3.root)

        bindingEnd3.rounds2.setText(equal_rounds.toString())
        bindingEnd3.corrects2.setText(equal_corrects.toString())
        bindingEnd3.highestcombo2.setText(equal_Penalty.toString())
        bindingEnd3.finalscrore2.setText(equal_finalScore.toString())
        when{
            equal_finalScore <=1000->{bindingEnd3.rank2.setText("F")}
            equal_finalScore >1000 && equal_finalScore  <=2000->{bindingEnd3.rank2.setText("D")}
            equal_finalScore >2000 && equal_finalScore <= 4000->{bindingEnd3.rank2.setText("C")}
            equal_finalScore >4000 && equal_finalScore  <=6000->{bindingEnd3.rank2.setText("B")}
            equal_finalScore >6000 && equal_finalScore  <=8000->{bindingEnd3.rank2.setText("A")}
            equal_finalScore >=10000->{bindingEnd3.rank2.setText("S")}
        }


        listText2.add(bindingEnd3.rounds2);listText2.add(bindingEnd3.corrects2);listText2.add(bindingEnd3.highestcombo2);listText2.add(bindingEnd3.finalscrore2)

        setViewAndChildrenEnabled(bindingEnd3.end1layout,false)
        bindingEnd3.nextFrame.isEnabled = true

        bindingEnd3.nextFrame.setOnClickListener{
            bindingEnd3.nextFrame.isVisible = false


            bindingEnd3.rounds.isVisible = false
            bindingEnd3.corrects.isVisible = false
            bindingEnd3.highestcombo.isVisible = false
            bindingEnd3.finalscrore.isVisible = false
            bindingEnd3.rank.isVisible = false


            for(t in listText2){
                t.isVisible = true
                setEASEanimation(t)

            }
            Handler().postDelayed({ bindingEnd3.rank2.isVisible=true;setTurnDownAnim(bindingEnd3.rank2);setViewAndChildrenEnabled(bindingEnd3.end1layout,true)},2000)

        }

        bindingEnd3.homeFlex.setOnClickListener{
           val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        bindingEnd3.retryFlex.setOnClickListener{
            val intent = Intent(this,ColorEqualizeMain::class.java)
            startActivity(intent)
            finish()
        }
        var i = 1
        for(i in 1..4){
            var rs = 0
            lateinit var text : TextView
            when(i){
                1 -> {rs = equal_rounds;text = bindingEnd3.rounds;}//Integer.parseInt(chooseColorBinding.round.toString())
                2 -> {rs = equal_corrects;text = bindingEnd3.corrects}
                3 -> {rs = equal_Penalty;text = bindingEnd3.highestcombo}
                4 -> {rs = equal_finalScore;text = bindingEnd3.finalscrore}
            }
            Handler().postDelayed({setCounterAnimation(text,rs)},(i*1600).toLong())
        }

        Handler().postDelayed({ when{
            equal_finalScore <=1000->{bindingEnd3.rank.setText("F");setTurnDownAnim(bindingEnd3.rank)}
            equal_finalScore  >1000 && equal_finalScore <=2000->{bindingEnd3.rank.setText("D");setTurnDownAnim(bindingEnd3.rank)}
            equal_finalScore >2000 && equal_finalScore<= 4000->{bindingEnd3.rank.setText("C");setTurnDownAnim(bindingEnd3.rank)}
            equal_finalScore >4000 && equal_finalScore <=6000->{bindingEnd3.rank.setText("B");setTurnDownAnim(bindingEnd3.rank)}
            equal_finalScore >6000 && equal_finalScore <=8000->{bindingEnd3.rank.setText("A");setTurnDownAnim(bindingEnd3.rank)}
            equal_finalScore >=10000->{bindingEnd3.rank2.setText("S");setTurnDownAnim(bindingEnd3.rank)}
        }
            bindingEnd3.nextFrame.isVisible = false
            setViewAndChildrenEnabled(bindingEnd3.end1layout,true)

        },(5*1600).toLong())


    }

    fun setCounterAnimation(text : TextView, end : Int){
        val anim= ValueAnimator.ofInt(0,end)
        anim.duration = 1500
        anim.addUpdateListener { animation -> text.setText(animation.animatedValue.toString()) }
        anim.start()
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
    fun setTurnDownAnim(text: TextView){
        val anim : Animation = AnimationUtils.loadAnimation(this,R.anim.turndown)
        text.startAnimation(anim)
    }

}