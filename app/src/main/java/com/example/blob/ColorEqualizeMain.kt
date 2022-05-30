package com.example.blob

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.blob.databinding.ActivityColorEqualizeMainBinding
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

lateinit var scale1 : Fragment
lateinit var scale2 : Fragment
lateinit var scale3 : Fragment
var equalizelist: ArrayList<ImageView> = ArrayList()
var equalizelist2 : ArrayList<Drawable> = ArrayList()
private var butlist: ArrayList<ImageView> = ArrayList()
var Random_color_list: ArrayList<Drawable> = ArrayList()

var equal_comboBonus = 0;
var equal_Penalty = 0
var equal_result = false
var equal_ratio = 0
var equal_corrects = 0
var equal_rounds = 0
var equal_finalScore = 0
var result_ans = 0





private lateinit var binding2: ActivityColorEqualizeMainBinding

var result : Int = 0



var arr1 = arrayOf<Int>(1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,   3,0,0,   2,1)
var arr2 = arrayOf<Int>(1,1,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,   1,0,0,   2,2)
var arr3 = arrayOf<Int>(1,0,0,2,0,0,3,0,0,2,0,0,0,0,0,0,0,0,   1,3,0,   3,3)
var arr4 = arrayOf<Int>(1,0,0,2,2,0,2,0,0,3,0,0,0,0,0,0,0,0,   1,1,0,   3,1)
var arr5 = arrayOf<Int>(1,0,0,2,2,2,1,0,0,2,2,3,0,0,0,0,0,0,   3,3,0,   3,1)
var arr6 = arrayOf<Int>(1,1,0,2,2,0,1,2,0,3,0,0,0,0,0,0,0,0,   1,2,0,   3,3)
var arr7 = arrayOf<Int>(1,1,0,1,2,0,0,2,0,3,0,0,0,0,0,0,0,0,   2,2,0,   3,3)
var arr8 = arrayOf<Int>(1,0,0,2,0,0,2,0,0,3,0,0,1,2,3,0,4,4,   1,1,1,   4,4)
var arr9 = arrayOf<Int>(1,0,0,2,0,0,2,3,0,3,3,0,2,0,0,4,4,0,   3,3,3,   4,1)
var arr10 = arrayOf<Int>(1,0,0,2,0,0,2,2,0,3,0,0,1,3,0,3,4,0,  1,2,1,   4,3)

//var arr1 = arrayOf<Int>(1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,   3,0,0,   2,1)
//var arr2 = arrayOf<Int>(1,1,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,   1,0,0,   2,2)
//var arr3 = arrayOf<Int>(1,0,0,2,0,0,3,0,0,2,0,0,0,0,0,0,0,0,   1,3,0,   3,3)
//var arr4 = arrayOf<Int>(1,0,0,2,2,0,2,0,0,3,0,0,0,0,0,0,0,0,   1,1,0,   3,4)
//var arr5 = arrayOf<Int>(1,0,0,2,2,2,1,0,0,2,2,3,0,0,0,0,0,0,   3,3,0,   3,5)
//var arr6 = arrayOf<Int>(1,1,0,2,2,0,1,2,0,3,0,0,0,0,0,0,0,0,   1,2,0,   3,6)
//var arr7 = arrayOf<Int>(1,1,0,1,2,0,0,2,0,3,0,0,0,0,0,0,0,0,   2,2,0,   3,7)
//var arr8 = arrayOf<Int>(1,0,0,2,0,0,2,0,0,3,0,0,1,2,3,0,4,4,   1,1,1,   4,8)
//var arr9 = arrayOf<Int>(1,0,0,2,0,0,2,3,0,3,3,0,2,0,0,4,4,0,   3,3,3,   4,9)
//var arr10 = arrayOf<Int>(1,0,0,2,0,0,2,2,0,3,0,0,1,3,0,3,4,0,  1,2,1,   4,10)






class ColorEqualizeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_equalize_main)


        binding2 = ActivityColorEqualizeMainBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        butlist.add(binding2.but1);butlist.add(binding2.but2);butlist.add(binding2.but3);butlist.add(binding2.but4)



        equal_corrects = 0; equal_Penalty = 0

        setViewAndChildrenEnabled(binding2.EqualMain, false)

        val animStart2: Animation = AnimationUtils.loadAnimation(this, R.anim.endflash)
        startsound.start()
        binding2.whitebg.startAnimation(animStart2)

        Handler().postDelayed({
            binding2.equalready.isVisible = false

        }, 3000)

        Handler().postDelayed({
            binding2.equalreadygo.isVisible = false

        }, 3600)

        Handler().postDelayed({
            memorizesound.start()
            memorizesound.isLooping

        }, 3900)

        Handler().postDelayed({
            setViewAndChildrenEnabled(binding2.EqualMain, true)
            TimeRun(time2 + 1)

        }, 4000)




        Handler().postDelayed({
            equal_rounds = Integer.parseInt(binding2.memround.text.toString())
            equal_finalScore = Integer.parseInt(binding2.memScore.text.toString())
            var intent = Intent(this, EndScreen2::class.java)
            startActivity(intent)
            finish()
        }, (time2 + 8) * 1000.toLong())







        var previous = 100
        var rd = Random().nextInt(10)
        while(rd == previous){
            rd = Random().nextInt(10)
        }
        previous = rd
        when(rd){

            0->Start_now(arr1)
            1->Start_now(arr2)
            2->Start_now(arr3)
            3->Start_now(arr4)
            4->Start_now(arr5)
            5->Start_now(arr6)
            6->Start_now(arr7)
            7->Start_now(arr8)
            8->Start_now(arr9)
            9->Start_now(arr10)


        }

        binding2.but1.setOnClickListener{

            refresh()
            rd = Random().nextInt(10)
            while(rd == previous){
                rd = Random().nextInt(10)
            }
            previous = rd
            Toast.makeText(this,rd.toString(),Toast.LENGTH_SHORT).show()
            when(rd){
                0->Logic_but(binding2.but1,arr1)
                1->Logic_but(binding2.but1,arr2)
                2->Logic_but(binding2.but1,arr3)
                3->Logic_but(binding2.but1,arr4)
                4->Logic_but(binding2.but1,arr5)
                5->Logic_but(binding2.but1,arr6)
                6->Logic_but(binding2.but1,arr7)
                7->Logic_but(binding2.but1,arr8)
                8->Logic_but(binding2.but1,arr9)
                9->Logic_but(binding2.but1,arr10)


            }
        }

        binding2.but2.setOnClickListener{
            refresh()
            rd = Random().nextInt(10)
            while(rd == previous){
                rd = Random().nextInt(10)
            }
            previous = rd
            Toast.makeText(this,rd.toString(),Toast.LENGTH_SHORT).show()

            when(rd){
                0->Logic_but(binding2.but2,arr1)
                1->Logic_but(binding2.but2,arr2)
                2->Logic_but(binding2.but2,arr3)
                3->Logic_but(binding2.but2,arr4)
                4->Logic_but(binding2.but2,arr5)
                5->Logic_but(binding2.but2,arr6)
                6->Logic_but(binding2.but2,arr7)
                7->Logic_but(binding2.but2,arr8)
                8->Logic_but(binding2.but2,arr9)
                9->Logic_but(binding2.but2,arr10)


            }
        }

        binding2.but3.setOnClickListener{
            refresh()
            rd = Random().nextInt(10)
            while(rd == previous){
                rd = Random().nextInt(10)
            }
            previous = rd
            Toast.makeText(this,rd.toString(),Toast.LENGTH_SHORT).show()

            when(rd){
                0->Logic_but(binding2.but3,arr1)
                1->Logic_but(binding2.but3,arr2)
                2->Logic_but(binding2.but3,arr3)
                3->Logic_but(binding2.but3,arr4)
                4->Logic_but(binding2.but3,arr5)
                5->Logic_but(binding2.but3,arr6)
                6->Logic_but(binding2.but3,arr7)
                7->Logic_but(binding2.but3,arr8)
                8->Logic_but(binding2.but3,arr9)
                9->Logic_but(binding2.but3,arr10)


            }
        }

        binding2.but4.setOnClickListener{
            refresh()
            rd = Random().nextInt(10)
            while(rd == previous){
                rd = Random().nextInt(10)
            }
            previous = rd
            Toast.makeText(this,rd.toString(),Toast.LENGTH_SHORT).show()

            when(rd){
                0->Logic_but(binding2.but4,arr1)
                1->Logic_but(binding2.but4,arr2)
                2->Logic_but(binding2.but4,arr3)
                3->Logic_but(binding2.but4,arr4)
                4->Logic_but(binding2.but4,arr5)
                5->Logic_but(binding2.but4,arr6)
                6->Logic_but(binding2.but4,arr7)
                7->Logic_but(binding2.but4,arr8)
                8->Logic_but(binding2.but4,arr9)
                9->Logic_but(binding2.but4,arr10)


            }
        }





    }

    private fun Result_Color(but : ImageView, arr: Array<Int>){


             if(Integer.parseInt(but.getTag().toString())== result_ans) {
                equal_result = true
                binding2.equalcorrect.isVisible = true
                Caculatingmemcombo2()
                binding2.equalcorrect.isVisible = true
                correctsound.start()
                setViewAndChildrenEnabled(binding2.EqualMain, false)
                Handler().postDelayed({

                    binding2.equalcorrect.isVisible = false
                   
                }, 400)
                binding2.memScore.setText((Integer.parseInt(binding2.memScore.text.toString()) + 200 + mem_ratio).toString())
                mem_corrects++
//                countClick = 0
               

               

                Handler().postDelayed({
                    setViewAndChildrenEnabled(binding2.EqualMain, true)

                    binding2.memround.setText((Integer.parseInt(binding2.memround.text.toString()) + 1).toString())
                    when (equal_comboBonus) {
                        0, 1, 2, 3 -> {
                            binding2.memcombo2.setText(""); binding2.streak.isVisible =  false; binding2.streak2.isVisible = false
                        }
                        4 -> {
                            binding2.memcombo2.setText("Streak x 1.2");setEASEanimation(
                                binding2.memcombo2
                            )
                        }
                        6 -> {
                            binding2.memcombo2.setText("Streak x 1.4"); binding2.memcombo2.setTextColor(
                                Color.parseColor("#FF7B07")
                            );setEASEanimation(binding2.memcombo2)
                        }
                        8 -> {
                            binding2.memcombo2.setText("Streak x 1.6"); binding2.memcombo2.setTextColor(
                                Color.parseColor("#FF5607")
                            );setEASEanimation(binding2.memcombo2)
                        }
                        10 -> {
                            binding2.memcombo2.setText("Streak x 2"); binding2.memcombo2.setTextColor(
                                Color.parseColor("#FF3907")
                            );setEASEanimation(binding2.memcombo2)
                        }
                        15 -> {
                            binding2.memcombo2.setText("Streak x 4"); binding2.memcombo2.setTextColor(
                                Color.parseColor("#971EAC")
                            );setEASEanimation(binding2.memcombo2); binding2.streak.isVisible =
                                true; binding2.streak2.isVisible = true
                        }

                    }
                }, 450)
            }
         else {
         equal_result = false


                 countClick = 0
            binding2.equalincorrect.isVisible = true
            Handler().postDelayed({}, 200)
            Caculatingmemcombo2()
            binding2.equalincorrect.isVisible = true
            incorrectsound.start()
            setViewAndChildrenEnabled(binding2.EqualMain, false)
            Handler().postDelayed({

                binding2.equalincorrect.isVisible = false
               
            }, 400)
            binding2.memScore.setText(
                (Integer.parseInt(binding2.memScore.text.toString()) * 0.8).toInt()
                    .toString()
            )
            
            


            Handler().postDelayed({
                setViewAndChildrenEnabled(binding2.EqualMain, true)

                binding2.memround.setText((Integer.parseInt(binding2.memround.text.toString()) + 1).toString())
                when (equal_comboBonus) {
                    0, 1, 2, 3 -> {
                        binding2.memcombo2.setText(""); binding2.streak.isVisible =
                            false; binding2.streak2.isVisible = false
                    }
                    4 -> {
                        binding2.memcombo2.setText("Streak x 1.2");setEASEanimation(
                            binding2.memcombo2
                        )
                    }
                    6 -> {
                        binding2.memcombo2.setText("Streak x 1.4"); binding2.memcombo2.setTextColor(
                            Color.parseColor("#FF7B07")
                        );setEASEanimation(binding2.memcombo2)
                    }
                    8 -> {
                        binding2.memcombo2.setText("Streak x 1.6"); binding2.memcombo2.setTextColor(
                            Color.parseColor("#FF5607")
                        );setEASEanimation(binding2.memcombo2)
                    }
                    10 -> {
                        binding2.memcombo2.setText("Streak x 2"); binding2.memcombo2.setTextColor(
                            Color.parseColor("#FF3907")
                        );setEASEanimation(binding2.memcombo2)
                    }
                    15 -> {
                        binding2.memcombo2.setText("Streak x 4"); binding2.memcombo2.setTextColor(
                            Color.parseColor("#971EAC")
                        );setEASEanimation(binding2.memcombo2); binding2.streak.isVisible =
                            true; binding2.streak2.isVisible = true
                    }

                }
            }, 450)


        }
    }


    private fun Logic_but(but : ImageView, arr : Array<Int>){

        Random_Color(arr)
        Logic_Sort(arr)
        Handler().postDelayed({ Logic_Soft2(arr) }, 400)
        Handler().postDelayed({ Logic_Soft3() }, 410)
        Result_Color(but,arr)
        Handler().postDelayed({result_ans = arr[22]
        },460)

    }

    private fun Start_now( arr : Array<Int>){
        result_ans = arr[22]
        Random_Color(arr)
        Logic_Sort(arr)
        Handler().postDelayed({ Logic_Soft2(arr) }, 400)
        Handler().postDelayed({ Logic_Soft3() }, 410)

    }

    private fun Logic_Soft3() {
        var x = 0
        try{
            for(i in butlist){
                i.setImageDrawable(equalizelist2.get(x))
                x++
            }
        }catch (e : Exception){

        }


    }

    fun Caculatingmemcombo2() {


        if (equal_result == true) {
            equal_comboBonus++
            if (equal_comboBonus > equal_Penalty) {
                equal_Penalty = equal_comboBonus
            }


        } else {

            equal_comboBonus = 0


        }



        if (equal_comboBonus >= 0) {
            when (equal_comboBonus) {
                0, 1, 2, 3 -> equal_ratio = 0
                4, 5 -> equal_ratio = 40
                6, 7 -> equal_ratio = 80
                8, 9 -> equal_ratio = 120
                10, 11, 12, 13, 14 -> equal_ratio = 200
                else -> equal_ratio = 600
            }
        }

    }

    private fun Logic_Sort(arr: Array<Int>) {

        when (arr[18]) {
            0 -> binding2.scaleBox1.isVisible = false
            1 -> {
                binding2.scaleBox11.isVisible = true
                binding2.scaleBox12.isVisible = false
                binding2.scaleBox13.isVisible = false

                equalizelist.add(binding2.mini1);equalizelist.add(binding2.mini2);equalizelist.add(
                    binding2.mini3
                );
                equalizelist.add(binding2.mini4);equalizelist.add(binding2.mini5);equalizelist.add(
                    binding2.mini6
                );


            }
            2 -> {
                binding2.scaleBox11.isVisible = false
                binding2.scaleBox12.isVisible = true
                binding2.scaleBox13.isVisible = false

                equalizelist.add(binding2.mini12a);equalizelist.add(binding2.mini22a);equalizelist.add(
                    binding2.mini32a
                );
                equalizelist.add(binding2.mini42a);equalizelist.add(binding2.mini52a);equalizelist.add(
                    binding2.mini62a
                );
            }
            3 -> {
                binding2.scaleBox11.isVisible = false
                binding2.scaleBox12.isVisible = false
                binding2.scaleBox13.isVisible = true

                equalizelist.add(binding2.mini13a);equalizelist.add(binding2.mini23);equalizelist.add(
                    binding2.mini33
                );
                equalizelist.add(binding2.mini43);equalizelist.add(binding2.mini53);equalizelist.add(
                    binding2.mini63
                );
            }
        }

        Handler().postDelayed({
            when (arr[19]) {
                0 -> binding2.scaleBox2.isVisible = false
                1 -> {
                    binding2.scaleBox21.isVisible = true
                    binding2.scaleBox22.isVisible = false
                    binding2.scaleBox23.isVisible = false

                    equalizelist.add(binding2.mini7);equalizelist.add(binding2.mini8);equalizelist.add(
                        binding2.mini9
                    );
                    equalizelist.add(binding2.mini10);equalizelist.add(binding2.mini11);equalizelist.add(
                        binding2.mini12
                    );
                }
                2 -> {
                    binding2.scaleBox21.isVisible = false
                    binding2.scaleBox22.isVisible = true
                    binding2.scaleBox23.isVisible = false

                    equalizelist.add(binding2.mini72);equalizelist.add(binding2.mini82);equalizelist.add(
                        binding2.mini92
                    );
                    equalizelist.add(binding2.mini102);equalizelist.add(binding2.mini112);equalizelist.add(
                        binding2.mini122
                    );
                }
                3 -> {
                    binding2.scaleBox21.isVisible = false
                    binding2.scaleBox22.isVisible = false
                    binding2.scaleBox23.isVisible = true

                    equalizelist.add(binding2.mini73);equalizelist.add(binding2.mini83);equalizelist.add(
                        binding2.mini93
                    );
                    equalizelist.add(binding2.mini103);equalizelist.add(binding2.mini113);equalizelist.add(
                        binding2.mini123
                    );
                }
            }
        }, 100)


        Handler().postDelayed({
            when (arr[20]) {
                0 -> binding2.scaleBox3.isVisible = false
                1 -> {
                    binding2.scaleBox31.isVisible = true
                    binding2.scaleBox32.isVisible = false
                    binding2.scaleBox33.isVisible = false

                    equalizelist.add(binding2.mini13);equalizelist.add(binding2.mini14);equalizelist.add(
                        binding2.mini15
                    );
                    equalizelist.add(binding2.mini16);equalizelist.add(binding2.mini17);equalizelist.add(
                        binding2.mini18
                    );
                }
                2 -> {
                    binding2.scaleBox31.isVisible = false
                    binding2.scaleBox32.isVisible = true
                    binding2.scaleBox33.isVisible = false

                    equalizelist.add(binding2.mini132);equalizelist.add(binding2.mini142);equalizelist.add(
                        binding2.mini152
                    );
                    equalizelist.add(binding2.mini162);equalizelist.add(binding2.mini172);equalizelist.add(
                        binding2.mini182
                    );
                }
                3 -> {
                    binding2.scaleBox31.isVisible = false
                    binding2.scaleBox32.isVisible = false
                    binding2.scaleBox33.isVisible = true

                    equalizelist.add(binding2.mini133);equalizelist.add(binding2.mini143);equalizelist.add(
                        binding2.mini153
                    );
                    equalizelist.add(binding2.mini163);equalizelist.add(binding2.mini173);equalizelist.add(
                        binding2.mini183
                    );
                }
            }
        }, 100)


    }

    private fun Random_Color(arr: Array<Int>) {

        var list : ArrayList<Int> = ArrayList()


        while(list.size<arr[21]) {
            var ran = Random().nextInt(8)
            try {
                if(list.contains(ran)==false){
                    list.add(ran)
                }
            } catch (e: Exception) {
                Log.e("Loi", e.toString())
            }
        }

        when(arr[21]){
            2-> {
                butlist[3].isVisible = false
                butlist[2].isVisible = false
            }
            3-> {
                butlist[3].isVisible = false
            }
        }

        for(i in list){
            Log.e("Loi", i.toString())

            when (i) {
                        0 -> {
                           equalizelist2.add(resources.getDrawable(R.drawable.blue3))
                            Random_color_list.add(resources.getDrawable(R.drawable.blue_mini))

                        }

                        1 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.brown3))
                            Random_color_list.add(resources.getDrawable(R.drawable.brown_mini))

                        }

                        2 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.green3))
                            Random_color_list.add(resources.getDrawable(R.drawable.green_mini))

                        }

                        3 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.orange3))
                            Random_color_list.add(resources.getDrawable(R.drawable.orange_mini))

                        }

                        4 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.purple3))
                            Random_color_list.add(resources.getDrawable(R.drawable.purple_mini))

                        }

                        5 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.pink3))
                            Random_color_list.add(resources.getDrawable(R.drawable.pink_mini))

                        }

                        6 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.red3))
                            Random_color_list.add(resources.getDrawable(R.drawable.red_mini))

                        }

                        7 -> {
                            equalizelist2.add(resources.getDrawable(R.drawable.yellow3))
                            Random_color_list.add(resources.getDrawable(R.drawable.equa_yellow))

                        }


                    }
            }
//        try{
//            for(i in 1..4){
//                Log.e("Sssssssssssssss",list2.get(i-1).toString())
//            }
//        }catch (e :Exception){
//            Log.e("Sssssssssssssss",e.toString())
//        }


        }
    //green : f1a4b85
    //brown : f12ddda
    //purple : b3d120b
    //orange : 40238e8






    private fun Logic_Soft2(arr: Array<Int>){
        var count = 0
        for(block in equalizelist){
           when(arr[count]){

               0->block.setImageResource(R.color.mem)
               1->block.setImageDrawable(Random_color_list.get(0))
               2->block.setImageDrawable(Random_color_list.get(1))
               3->block.setImageDrawable(Random_color_list.get(2))
               4->block.setImageDrawable(Random_color_list.get(3))

           }
            count++
        }

    }


    fun setEASEanimation(text: TextView) {


        val anim2: Animation = AnimationUtils.loadAnimation(this, R.anim.ease1)
        val anim3: Animation = AnimationUtils.loadAnimation(this, R.anim.ease2)


        text.startAnimation(anim2)
        Handler().postDelayed({ text.startAnimation(anim3) }, 150)
    }

    fun TimeRun(time: Int) {

        var timene = time * 1000
        binding2.memtimer.setText(time.toString())

        val timer: CountDownTimer = object : CountDownTimer(timene.toLong(), 1000) {
            override fun onTick(l: Long) {
                binding2.memtimer.setText((Integer.parseInt(binding2.memtimer.text.toString()) - 1).toString())
            }

            override fun onFinish() {

                memorizesound.stop()
                overtimesound.start()
                binding2.equalovertime.isVisible = true
                setViewAndChildrenEnabled(binding2.EqualMain, false)


            }
        }
        timer.start()
    }

private fun refresh(){
    binding2.scaleBox1.isVisible = true
    binding2.scaleBox2.isVisible = true
    binding2.scaleBox3.isVisible = true

    binding2.scaleBox11.isVisible = false
    binding2.scaleBox12.isVisible = false
    binding2.scaleBox13.isVisible = false
    binding2.scaleBox21.isVisible = false
    binding2.scaleBox22.isVisible = false
    binding2.scaleBox23.isVisible = false
    binding2.scaleBox31.isVisible = false
    binding2.scaleBox32.isVisible = false
    binding2.scaleBox33.isVisible = false

    for(i in equalizelist){
        i.isVisible = true
    }

    equalizelist.clear()
    equalizelist2.clear()
    Random_color_list.clear()

    for(o in butlist){
        o.isVisible = true
    }


}

fun setViewAndChildrenEnabled(view: View, enabled: Boolean) {
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





