package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

var mem5view : View? = null

lateinit var memblock_5x5_1 : ImageView
lateinit var memblock_5x5_2 : ImageView
lateinit var memblock_5x5_3 : ImageView
lateinit var memblock_5x5_4 : ImageView
lateinit var memblock_5x5_5 : ImageView
lateinit var arrow_5x5_1 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_5x5_2 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_5x5_3 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_5x5_4 : pl.droidsonroids.gif.GifImageView
lateinit var arrow_5x5_5 : pl.droidsonroids.gif.GifImageView







class Mem5x5 : Fragment() {





    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sizeMem = 0
        mem3list.clear()
        mem3list2.clear()



        mem5view = inflater.inflate(R.layout.mem5x5, container, false)

        memblock_5x5_1 = mem5view!!.findViewById(R.id.memblock5x5_1)
        memblock_5x5_2 = mem5view!!.findViewById(R.id.memblock5x5_2)
        memblock_5x5_3 = mem5view!!.findViewById(R.id.memblock5x5_3)
        memblock_5x5_4 = mem5view!!.findViewById(R.id.memblock5x5_4)
        memblock_5x5_5 = mem5view!!.findViewById(R.id.memblock5x5_5)
        arrow_5x5_1 = mem5view!!.findViewById(R.id.arrow_5x5_1)
        arrow_5x5_2 = mem5view!!.findViewById(R.id.arrow_5x5_2)
        arrow_5x5_3 = mem5view!!.findViewById(R.id.arrow_5x5_3)
        arrow_5x5_4= mem5view!!.findViewById(R.id.arrow_5x5_4)
        arrow_5x5_5= mem5view!!.findViewById(R.id.arrow_5x5_5)




        mem3list.add(memblock_5x5_1);mem3list.add(memblock_5x5_2);mem3list.add(memblock_5x5_3);mem3list.add(memblock_5x5_4);mem3list.add(memblock_5x5_5)
        mem3list2.add(arrow_5x5_1);mem3list2.add(arrow_5x5_2);mem3list2.add(arrow_5x5_3);mem3list2.add(arrow_5x5_4);mem3list2.add(arrow_5x5_5)

        // //  blue->brown->green->orange->purple->pink->red->yellow

        RandomColor()
        while(sizeMem==0){
            for(u in 0..4){
                var random2: Int = kotlin.random.Random.nextInt(0, 2)


                if (random2 == 0 ) {
                    arrayMem[sizeMem] = u
                    sizeMem++

                }

            }
        }

        arrayMem.sortDescending()



        return mem5view
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