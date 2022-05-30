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
import com.example.blob.databinding.ActivityEndScreen1Binding
import com.example.blob.databinding.ActivityEndScreen2Binding
import com.example.blob.databinding.ColorChooseMainActivityBinding

lateinit var bindingEnd2 : ActivityEndScreen2Binding
lateinit var listText1 : ArrayList<TextView>

class EndScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_end_screen2)
        listText1 = ArrayList()

        bindingEnd2 = ActivityEndScreen2Binding.inflate(layoutInflater)
        setContentView(bindingEnd2.root)

        bindingEnd2.rounds2.setText(mem_mem_rounfs.toString())
        bindingEnd2.corrects2.setText(mem_corrects.toString())
        bindingEnd2.highestcombo2.setText(mem_memcomboPenalty.toString())
        bindingEnd2.finalscrore2.setText(mem_finalScore.toString())
        when{
            mem_finalScore <=1000->{bindingEnd2.rank2.setText("F")}
            mem_finalScore >1000 && mem_finalScore  <=2000->{bindingEnd2.rank2.setText("D")}
            mem_finalScore >2000 && mem_finalScore <= 4000->{bindingEnd2.rank2.setText("C")}
            mem_finalScore >4000 && mem_finalScore  <=6000->{bindingEnd2.rank2.setText("B")}
            mem_finalScore >6000 && mem_finalScore  <=8000->{bindingEnd2.rank2.setText("A")}
            mem_finalScore >=10000->{bindingEnd2.rank2.setText("S")}
        }


        listText1.add(bindingEnd2.rounds2);listText1.add(bindingEnd2.corrects2);listText1.add(bindingEnd2.highestcombo2);listText1.add(bindingEnd2.finalscrore2)

        setViewAndChildrenEnabled(bindingEnd2.end1layout,false)
        bindingEnd2.nextFrame.isEnabled = true

        bindingEnd2.nextFrame.setOnClickListener{
            bindingEnd2.nextFrame.isVisible = false


            bindingEnd2.rounds.isVisible = false
            bindingEnd2.corrects.isVisible = false
            bindingEnd2.highestcombo.isVisible = false
            bindingEnd2.finalscrore.isVisible = false
            bindingEnd2.rank.isVisible = false


            for(t in listText1){
                t.isVisible = true
                setEASEanimation(t)

            }
            Handler().postDelayed({ bindingEnd2.rank2.isVisible=true;setTurnDownAnim(bindingEnd2.rank2);setViewAndChildrenEnabled(bindingEnd2.end1layout,true)},2000)

        }

        bindingEnd2.homeFlex.setOnClickListener{
           val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        bindingEnd2.retryFlex.setOnClickListener{
            val intent = Intent(this,ColorMemorizeMain::class.java)
            startActivity(intent)
            finish()
        }
        var i = 1
        for(i in 1..4){
            var rs = 0
            lateinit var text : TextView
            when(i){
                1 -> {rs = mem_mem_rounfs;text = bindingEnd2.rounds;}//Integer.parseInt(chooseColorBinding.round.toString())
                2 -> {rs = mem_corrects;text = bindingEnd2.corrects}
                3 -> {rs = mem_memcomboPenalty;text = bindingEnd2.highestcombo}
                4 -> {rs = mem_finalScore;text = bindingEnd2.finalscrore}
            }
            Handler().postDelayed({setCounterAnimation(text,rs)},(i*1600).toLong())
        }

        Handler().postDelayed({ when{
            mem_finalScore <=1000->{bindingEnd2.rank.setText("F");setTurnDownAnim(bindingEnd2.rank)}
            mem_finalScore  >1000 && mem_finalScore <=2000->{bindingEnd2.rank.setText("D");setTurnDownAnim(bindingEnd2.rank)}
            mem_finalScore >2000 && mem_finalScore<= 4000->{bindingEnd2.rank.setText("C");setTurnDownAnim(bindingEnd2.rank)}
            mem_finalScore >4000 && mem_finalScore <=6000->{bindingEnd2.rank.setText("B");setTurnDownAnim(bindingEnd2.rank)}
            mem_finalScore >6000 && mem_finalScore <=8000->{bindingEnd2.rank.setText("A");setTurnDownAnim(bindingEnd2.rank)}
            mem_finalScore >=10000->{bindingEnd2.rank2.setText("S");setTurnDownAnim(bindingEnd2.rank)}
        }
            bindingEnd2.nextFrame.isVisible = false
            setViewAndChildrenEnabled(bindingEnd2.end1layout,true)

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