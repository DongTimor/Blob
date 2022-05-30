package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

var mem6view : View? = null

lateinit var memblock_6x6_1 : ImageView
lateinit var memblock_6x6_2 : ImageView
lateinit var memblock_6x6_3 : ImageView
lateinit var memblock_6x6_4 : ImageView
lateinit var memblock_6x6_5 : ImageView
lateinit var memblock_6x6_6 : ImageView
lateinit var arrow_6x6_1 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_6x6_2 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_6x6_3 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_6x6_4 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_6x6_5 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_6x6_6 : pl.droidsonroids.gif.GifImageView








class Mem6x6 : Fragment() {





    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sizeMem = 0
        mem3list.clear()
        mem3list2.clear()



        mem6view = inflater.inflate(R.layout.mem6x6, container, false)

        memblock_6x6_1 = mem6view!!.findViewById(R.id.memblock6x6_1)
        memblock_6x6_2 = mem6view!!.findViewById(R.id.memblock6x6_2)
        memblock_6x6_3 = mem6view!!.findViewById(R.id.memblock6x6_3)
        memblock_6x6_4 = mem6view!!.findViewById(R.id.memblock6x6_4)
        memblock_6x6_5 = mem6view!!.findViewById(R.id.memblock6x6_5)
        memblock_6x6_6 = mem6view!!.findViewById(R.id.memblock6x6_6)
        arrow_6x6_1 = mem6view!!.findViewById(R.id.arrow_6x6_1)
        arrow_6x6_2 = mem6view!!.findViewById(R.id.arrow_6x6_2)
        arrow_6x6_3 = mem6view!!.findViewById(R.id.arrow_6x6_3)
        arrow_6x6_4= mem6view!!.findViewById(R.id.arrow_6x6_4)
        arrow_6x6_5= mem6view!!.findViewById(R.id.arrow_6x6_5)
        arrow_6x6_6= mem6view!!.findViewById(R.id.arrow_6x6_6)




        mem3list.add(memblock_6x6_1);mem3list.add(memblock_6x6_2);mem3list.add(memblock_6x6_3);mem3list.add(memblock_6x6_4);mem3list.add(memblock_6x6_5);mem3list.add(memblock_6x6_6)
        mem3list2.add(arrow_6x6_1);mem3list2.add(arrow_6x6_2);mem3list2.add(arrow_6x6_3);mem3list2.add(arrow_6x6_4);mem3list2.add(arrow_6x6_5);mem3list2.add(arrow_6x6_6)

        // //  blue->brown->green->orange->purple->pink->red->yellow

        RandomColor()
        while(sizeMem==0){
            for(u in 0..5){
                var random2: Int = kotlin.random.Random.nextInt(0, 2)


                if (random2 == 0 ) {
                    arrayMem[sizeMem] = u
                    sizeMem++

                }

            }
        }

        arrayMem.sortDescending()



        return mem6view
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