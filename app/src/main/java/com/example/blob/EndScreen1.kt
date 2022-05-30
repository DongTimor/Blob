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
import com.example.blob.databinding.ColorChooseMainActivityBinding

lateinit var bindingEnd : ActivityEndScreen1Binding
lateinit var listText : ArrayList<TextView>

class EndScreen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_end_screen1)
        listText = ArrayList()

        bindingEnd = ActivityEndScreen1Binding.inflate(layoutInflater)
        setContentView(bindingEnd.root)

        bindingEnd.rounds2.setText(rounds.toString())
        bindingEnd.corrects2.setText(corrects.toString())
        bindingEnd.highestcombo2.setText(comboPenalty.toString())
        bindingEnd.finalscrore2.setText(finalScore.toString())
        when{
            finalScore <=1000->{bindingEnd.rank2.setText("F")}
            finalScore >1000 && finalScore <=2000->{bindingEnd.rank2.setText("D")}
            finalScore >2000 && finalScore<= 4000->{bindingEnd.rank2.setText("C")}
            finalScore >4000 && finalScore <=6000->{bindingEnd.rank2.setText("B")}
            finalScore >6000 && finalScore <=8000->{bindingEnd.rank2.setText("A")}
            finalScore >=10000->{bindingEnd.rank2.setText("S")}
        }


        listText.add(bindingEnd.rounds2);listText.add(bindingEnd.corrects2);listText.add(bindingEnd.highestcombo2);listText.add(bindingEnd.finalscrore2)

        setViewAndChildrenEnabled(bindingEnd.end1layout,false)
        bindingEnd.nextFrame.isEnabled = true

        bindingEnd.nextFrame.setOnClickListener{
            bindingEnd.nextFrame.isVisible = false


            bindingEnd.rounds.isVisible = false
            bindingEnd.corrects.isVisible = false
            bindingEnd.highestcombo.isVisible = false
            bindingEnd.finalscrore.isVisible = false
            bindingEnd.rank.isVisible = false


            for(t in listText){
                t.isVisible = true
                setEASEanimation(t)

            }
            Handler().postDelayed({ bindingEnd.rank2.isVisible=true;setTurnDownAnim(bindingEnd.rank2);setViewAndChildrenEnabled(bindingEnd.end1layout,true)},2000)

        }

        bindingEnd.homeFlex.setOnClickListener{
           val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        bindingEnd.retryFlex.setOnClickListener{
            val intent = Intent(this,ColorChooseMainActivity::class.java)
            startActivity(intent)
            finish()
        }
        var i = 1
        for(i in 1..4){
            var rs = 0
            lateinit var text : TextView
            when(i){
                1 -> {rs = rounds;text = bindingEnd.rounds;}//Integer.parseInt(chooseColorBinding.round.toString())
                2 -> {rs = corrects;text = bindingEnd.corrects}
                3 -> {rs = comboPenalty;text = bindingEnd.highestcombo}
                4 -> {rs = finalScore;text = bindingEnd.finalscrore}
            }
            Handler().postDelayed({setCounterAnimation(text,rs)},(i*1600).toLong())
        }

        Handler().postDelayed({ when{
            finalScore <=1000->{bindingEnd.rank.setText("F");setTurnDownAnim(bindingEnd.rank)}
            finalScore >1000 && finalScore <=2000->{bindingEnd.rank.setText("D");setTurnDownAnim(bindingEnd.rank)}
            finalScore >2000 && finalScore<= 4000->{bindingEnd.rank.setText("C");setTurnDownAnim(bindingEnd.rank)}
            finalScore >4000 && finalScore <=6000->{bindingEnd.rank.setText("B");setTurnDownAnim(bindingEnd.rank)}
            finalScore >6000 && finalScore <=8000->{bindingEnd.rank.setText("A");setTurnDownAnim(bindingEnd.rank)}
            finalScore >=10000->{bindingEnd.rank2.setText("S");setTurnDownAnim(bindingEnd.rank)}
        }
            bindingEnd.nextFrame.isVisible = false
            setViewAndChildrenEnabled(bindingEnd.end1layout,true)

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