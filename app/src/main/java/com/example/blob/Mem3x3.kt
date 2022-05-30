package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

var mem3view : View? = null

lateinit var memblock_3x3_1 : ImageView
lateinit var memblock_3x3_2 : ImageView
lateinit var memblock_3x3_3 : ImageView
lateinit var arrow_3x3_1 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_3x3_2 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_3x3_3 : pl.droidsonroids.gif.GifImageView





class Mem3x3 : Fragment() {





    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sizeMem = 0
        mem3list.clear()
        mem3list2.clear()



        mem3view = inflater.inflate(R.layout.mem3x3, container, false)

        memblock_3x3_1 = mem3view!!.findViewById(R.id.memblock3x3_1)
        memblock_3x3_2 = mem3view!!.findViewById(R.id.memblock3x3_2)
        memblock_3x3_3 = mem3view!!.findViewById(R.id.memblock3x3_3)
        arrow_3x3_1 = mem3view!!.findViewById(R.id.arrow_3x3_1)
        arrow_3x3_2 = mem3view!!.findViewById(R.id.arrow_3x3_2)
        arrow_3x3_3 = mem3view!!.findViewById(R.id.arrow_3x3_3)
        


        
        mem3list.add(memblock_3x3_1);mem3list.add(memblock_3x3_2);mem3list.add(memblock_3x3_3)
        mem3list2.add(arrow_3x3_1);mem3list2.add(arrow_3x3_2);mem3list2.add(arrow_3x3_3)

        // //  blue->brown->green->orange->purple->pink->red->yellow

        RandomColor()
        while(sizeMem==0){
            for(u in 0..2){
                var random2: Int = kotlin.random.Random.nextInt(0, 2)


                if (random2 == 0) {
                    arrayMem[sizeMem] = u
                    sizeMem++

                }

            }
        }

        arrayMem.sortDescending()



        return mem3view
    }

    fun RandomColor(){

        //  blue->brown->green->orange->purple->pink->red->yellow
        for (t in mem3list) {
            val random = Random()
            val rd = random.nextInt(8)
            when (rd) {
                0 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.red))
                    t.setTag(0)

                }

                1 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.yellow))
                    t.setTag(1)
                }

                2 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.green))
                    t.setTag(2)
                }

                3 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.pink))
                    t.setTag(3)
                }

                4 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.orange))
                    t.setTag(4)
                }

                5 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.brown))
                    t.setTag(5)
                }

                6 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.blue))
                    t.setTag(6)
                }

                7 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.purple))
                    t.setTag(7)
                }


            }



        }
    }

}