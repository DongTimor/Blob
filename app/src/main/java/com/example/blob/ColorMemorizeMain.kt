package com.example.blob

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.blob.databinding.ActivityColorMemorizeMainBinding
import java.util.*
import kotlin.collections.ArrayList


private lateinit var mem3x3: Mem3x3
private lateinit var mem4x4: Mem4x4
private lateinit var mem5x5: Mem5x5
private lateinit var mem6x6: Mem6x6

private lateinit var memorizeMainBinding: ActivityColorMemorizeMainBinding
var sizeMem: Int = 0
var arrayMem: IntArray = IntArray(8)
var mem3list: ArrayList<ImageView> = ArrayList()
var mem3list2: ArrayList<pl.droidsonroids.gif.GifImageView> = ArrayList()
var mem_memcomboBonus = 0;
var mem_memcomboPenalty = 0
var mem_result = false
var mem_ratio = 0
var mem_corrects = 0
var mem_mem_rounfs = 0
var mem_finalScore = 0
var countClick = 0
var mem_fragnumber = 0

class ColorMemorizeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_memorize_main)
        setFitAndTransparentBackgmem_rounf()

        memorizeMainBinding = ActivityColorMemorizeMainBinding.inflate(layoutInflater)
        setContentView(memorizeMainBinding.root)

        mem_corrects = 0; mem_memcomboPenalty = 0

        setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, false)



        val animStart2: Animation = AnimationUtils.loadAnimation(this, R.anim.endflash)
        startsound.start()
        memorizeMainBinding.whitebg.startAnimation(animStart2)

        Handler().postDelayed({
            memorizeMainBinding.memstartready.isVisible = false

        }, 3000)

        Handler().postDelayed({
            memorizeMainBinding.memstartreadygo.isVisible = false

        }, 3600)

        Handler().postDelayed({
            memorizesound.start()
            memorizesound.isLooping

        }, 3900)

        Handler().postDelayed({
            memorizeMainBinding.ready.isEnabled = true
            TimeRun(time2 + 1)

        }, 4000)




        Handler().postDelayed({

            mem_mem_rounfs = Integer.parseInt(memorizeMainBinding.memround.text.toString())
            mem_finalScore = Integer.parseInt(memorizeMainBinding.memScore.text.toString())
            var intent = Intent(this, EndScreen2::class.java)
            startActivity(intent)
            finish()
        }, (time2 + 8) * 1000.toLong())





        CallFragment1()
        Handler().postDelayed({
            Toast.makeText(this, sizeMem.toString(), Toast.LENGTH_SHORT).show()
        }, 100)



        memorizeMainBinding.red.setOnClickListener {
            LogicButton(memorizeMainBinding.red, mem3list.get(arrayMem.get(countClick)), 0)

        }

        memorizeMainBinding.yellow.setOnClickListener {
            LogicButton(memorizeMainBinding.yellow, mem3list.get(arrayMem.get(countClick)), 1)


        }

        memorizeMainBinding.green.setOnClickListener {
            LogicButton(memorizeMainBinding.green, mem3list.get(arrayMem.get(countClick)), 2)


        }

        memorizeMainBinding.pink.setOnClickListener {
            LogicButton(memorizeMainBinding.pink, mem3list.get(arrayMem.get(countClick)), 3)


        }

        memorizeMainBinding.orange.setOnClickListener {
            LogicButton(memorizeMainBinding.orange, mem3list.get(arrayMem.get(countClick)), 4)


        }

        memorizeMainBinding.brown.setOnClickListener {
            LogicButton(memorizeMainBinding.brown, mem3list.get(arrayMem.get(countClick)), 5)


        }

        memorizeMainBinding.blue.setOnClickListener {
            LogicButton(memorizeMainBinding.blue, mem3list.get(arrayMem.get(countClick)), 6)


        }

        memorizeMainBinding.purple.setOnClickListener {
            LogicButton(memorizeMainBinding.purple, mem3list.get(arrayMem.get(countClick)), 7)


        }

        memorizeMainBinding.ready.setOnClickListener {
            FlipBlock(mem3list, mem3list2)
            setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, true)

        }


        /*val random = Random()
        val rd = random.nextInt(tilesCount)

        when(rd){
            0->{ CallFragment1()
                mem_fragnumber = 1}
            1->{ CallFragment2()
                mem_fragnumber = 2}
            /*2->{ CallFragment3()
                mem_fragnumber = 3}
            3->{ CallFragment4()
                mem_fragnumber = 4}*/
        }*/
    }

    private fun setFitAndTransparentBackgmem_rounf() {
        val w: Window = window
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            w.setDecorFitsSystemWindows(false)
//        } else w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
//        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGmem_mem_rounfs)
//        w.statusBarColor = ContextCompat.getColor(this, R.color.white)
        w.navigationBarColor = ContextCompat.getColor(this, R.color.white)
    }

    fun CallFragment1() {
        val fragman = supportFragmentManager
        val tran = fragman.beginTransaction()
        mem3x3 = Mem3x3()
        tran.replace(R.id.colormemorizefragcontent, mem3x3)
        tran.commit()

    }

    fun CallFragment2() {
        val fragman2 = supportFragmentManager
        val tran = fragman2.beginTransaction()
        mem4x4 = Mem4x4()
        tran.replace(R.id.colormemorizefragcontent, mem4x4)
        tran.commit()
    }


    fun CallFragment3() {
        val fragman3 = supportFragmentManager
        val tran = fragman3.beginTransaction()
        mem5x5 = Mem5x5()
        tran.replace(R.id.colormemorizefragcontent, mem5x5)
        tran.commit()
    }

    fun CallFragment4() {
        val fragman4 = supportFragmentManager
        val tran = fragman4.beginTransaction()
        mem6x6 = Mem6x6()
        tran.replace(R.id.colormemorizefragcontent, mem6x6)
        tran.commit()
    }

    fun TimeRun(time: Int) {

        var timene = time * 1000
        memorizeMainBinding.memtimer.setText(time.toString())

        val timer: CountDownTimer = object : CountDownTimer(timene.toLong(), 1000) {
            override fun onTick(l: Long) {
                memorizeMainBinding.memtimer.setText((Integer.parseInt(memorizeMainBinding.memtimer.text.toString()) - 1).toString())
            }

            override fun onFinish() {

                memorizesound.stop()
                overtimesound.start()
                memorizeMainBinding.memovertime.isVisible = true
                setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, false)


            }
        }
        timer.start()
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

    fun Caculatingmemcombo() {


        if (mem_result == true) {
            mem_memcomboBonus++
            if (mem_memcomboBonus > mem_memcomboPenalty) {
                mem_memcomboPenalty = mem_memcomboBonus
            }


        } else {

            mem_memcomboBonus = 0


        }



        if (mem_memcomboBonus >= 0) {
            when (mem_memcomboBonus) {
                0, 1, 2, 3 -> mem_ratio = 0
                4, 5 -> mem_ratio = 40
                6, 7 -> mem_ratio = 80
                8, 9 -> mem_ratio = 120
                10, 11, 12, 13, 14 -> mem_ratio = 200
                else -> mem_ratio = 600
            }
        }

    }

    fun FlipBlock(list: List<ImageView>, list2: List<pl.droidsonroids.gif.GifImageView>) {
        memorizeMainBinding.ready.isVisible = false
        val anim: Animation = AnimationUtils.loadAnimation(this, R.anim.flip)
        val anim2: Animation = AnimationUtils.loadAnimation(this, R.anim.flip2)
        Handler().postDelayed({
            for (o in 0..sizeMem - 1) {

                list.get(arrayMem.get(o)).startAnimation(anim)

                Handler().postDelayed({
                    list.get(arrayMem.get(o))
                        .setImageDrawable(resources.getDrawable(R.drawable.black))
                    list.get(arrayMem.get(o)).startAnimation(anim2)
                }, 50)
                Handler().postDelayed({ list2.get(arrayMem.get(0)).isVisible = true }, 100)
            }
        }, 300)
    }

    fun setEASEanimation(text: TextView) {


        val anim2: Animation = AnimationUtils.loadAnimation(this, R.anim.ease1)
        val anim3: Animation = AnimationUtils.loadAnimation(this, R.anim.ease2)


        text.startAnimation(anim2)
        Handler().postDelayed({ text.startAnimation(anim3) }, 150)
    }

    fun LogicButton(button: TextView, block: ImageView, numtag: Int) {
        button.setBackgroundDrawable(resources.getDrawable(R.drawable.select_bottom))
        Handler().postDelayed({ button.setBackgroundColor(Color.TRANSPARENT) }, 250)
        when (button.id) {
            memorizeMainBinding.red.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.red))

            }
            memorizeMainBinding.yellow.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.yellow))

            }
            memorizeMainBinding.green.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.green))

            }
            memorizeMainBinding.pink.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.pink))

            }
            memorizeMainBinding.orange.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.orange))

            }
            memorizeMainBinding.brown.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.brown))

            }
            memorizeMainBinding.blue.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.blue))

            }
            memorizeMainBinding.purple.id -> {
                block.setImageDrawable(resources.getDrawable(R.drawable.purple))

            }
        }

        if (mem3list.get(arrayMem.get(countClick)).getTag() == numtag) {

            mem3list2.get(arrayMem.get(countClick))
                .setImageDrawable(resources.getDrawable(R.drawable.white))
            countClick++
            if (countClick < sizeMem) {
                mem3list2.get(arrayMem.get(countClick)).isVisible = true
            } else {
                mem_result = true
                memorizeMainBinding.memcorrect.isVisible = true
                Handler().postDelayed({}, 200)
                Caculatingmemcombo()
                memorizeMainBinding.memcorrect.isVisible = true
                correctsound.start()
                setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, false)
                Handler().postDelayed({

                    memorizeMainBinding.memcorrect.isVisible = false
                    memorizeMainBinding.ready.isVisible = true
                }, 400)
                memorizeMainBinding.memScore.setText((Integer.parseInt(memorizeMainBinding.memScore.text.toString()) + 200 + mem_ratio).toString())
                mem_corrects++
                countClick = 0
                val random = Random()
                val rd = random.nextInt(tilesCount2)

                when (rd) {
                    0 -> {
                        CallFragment1()
                        mem_fragnumber = 1
                    }
                    1 -> {
                        CallFragment2()
                        mem_fragnumber = 2
                    }
                    2 -> {
                        CallFragment3()
                        mem_fragnumber = 3
                    }
                    3 -> {
                        CallFragment4()
                        mem_fragnumber = 4
                    }
                }
                setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, false)
                memorizeMainBinding.ready.isEnabled = true

                Handler().postDelayed({
                    memorizeMainBinding.memround.setText((Integer.parseInt(memorizeMainBinding.memround.text.toString()) + 1).toString())
                    when (mem_memcomboBonus) {
                        0, 1, 2, 3 -> {
                            memorizeMainBinding.memcombo.setText(""); memorizeMainBinding.Streak1.isVisible =
                                false; memorizeMainBinding.Streak2.isVisible = false
                        }
                        4 -> {
                            memorizeMainBinding.memcombo.setText("Streak x 1.2");setEASEanimation(
                                memorizeMainBinding.memcombo
                            )
                        }
                        6 -> {
                            memorizeMainBinding.memcombo.setText("Streak x 1.4"); memorizeMainBinding.memcombo.setTextColor(
                                Color.parseColor("#FF7B07")
                            );setEASEanimation(memorizeMainBinding.memcombo)
                        }
                        8 -> {
                            memorizeMainBinding.memcombo.setText("Streak x 1.6"); memorizeMainBinding.memcombo.setTextColor(
                                Color.parseColor("#FF5607")
                            );setEASEanimation(memorizeMainBinding.memcombo)
                        }
                        10 -> {
                            memorizeMainBinding.memcombo.setText("Streak x 2"); memorizeMainBinding.memcombo.setTextColor(
                                Color.parseColor("#FF3907")
                            );setEASEanimation(memorizeMainBinding.memcombo)
                        }
                        15 -> {
                            memorizeMainBinding.memcombo.setText("Streak x 4"); memorizeMainBinding.memcombo.setTextColor(
                                Color.parseColor("#971EAC")
                            );setEASEanimation(memorizeMainBinding.memcombo); memorizeMainBinding.Streak1.isVisible =
                                true; memorizeMainBinding.Streak2.isVisible = true
                        }

                    }
                }, 450)
            }
        } else {
            mem_result = false
            countClick = 0
            memorizeMainBinding.memincorrect.isVisible = true
            Handler().postDelayed({}, 200)
            Caculatingmemcombo()
            memorizeMainBinding.memincorrect.isVisible = true
            incorrectsound.start()
            setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, false)
            Handler().postDelayed({

                memorizeMainBinding.memincorrect.isVisible = false
                memorizeMainBinding.ready.isVisible = true
            }, 400)
            memorizeMainBinding.memScore.setText(
                (Integer.parseInt(memorizeMainBinding.memScore.text.toString()) * 0.8).toInt()
                    .toString()
            )
            val random = Random()
            val rd = random.nextInt(tilesCount2)
            when (rd) {
                0 -> {
                    CallFragment1()
                    mem_fragnumber = 1
                }
                1 -> {
                    CallFragment2()
                    mem_fragnumber = 2
                }
                2 -> {
                    CallFragment3()
                    mem_fragnumber = 3
                }
                3 -> {
                    CallFragment4()
                    mem_fragnumber = 4
                }
            }
            setViewAndChildrenEnabled(memorizeMainBinding.memorizeMainLayout, false)
            memorizeMainBinding.ready.isEnabled = true

            Handler().postDelayed({
                memorizeMainBinding.memround.setText((Integer.parseInt(memorizeMainBinding.memround.text.toString()) + 1).toString())
                when (mem_memcomboBonus) {
                    0, 1, 2, 3 -> {
                        memorizeMainBinding.memcombo.setText(""); memorizeMainBinding.Streak1.isVisible =
                            false; memorizeMainBinding.Streak2.isVisible = false
                    }
                    4 -> {
                        memorizeMainBinding.memcombo.setText("Streak x 1.2");setEASEanimation(
                            memorizeMainBinding.memcombo
                        )
                    }
                    6 -> {
                        memorizeMainBinding.memcombo.setText("Streak x 1.4"); memorizeMainBinding.memcombo.setTextColor(
                            Color.parseColor("#FF7B07")
                        );setEASEanimation(memorizeMainBinding.memcombo)
                    }
                    8 -> {
                        memorizeMainBinding.memcombo.setText("Streak x 1.6"); memorizeMainBinding.memcombo.setTextColor(
                            Color.parseColor("#FF5607")
                        );setEASEanimation(memorizeMainBinding.memcombo)
                    }
                    10 -> {
                        memorizeMainBinding.memcombo.setText("Streak x 2"); memorizeMainBinding.memcombo.setTextColor(
                            Color.parseColor("#FF3907")
                        );setEASEanimation(memorizeMainBinding.memcombo)
                    }
                    15 -> {
                        memorizeMainBinding.memcombo.setText("Streak x 4"); memorizeMainBinding.memcombo.setTextColor(
                            Color.parseColor("#971EAC")
                        );setEASEanimation(memorizeMainBinding.memcombo); memorizeMainBinding.Streak1.isVisible =
                            true; memorizeMainBinding.Streak2.isVisible = true
                    }

                }
            }, 450)


        }


    }
}