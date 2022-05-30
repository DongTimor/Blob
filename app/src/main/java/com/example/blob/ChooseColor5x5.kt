package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

var fview4 : View? = null

lateinit var ic1 : ImageView
lateinit var ic2 : ImageView
lateinit var ic3 : ImageView
lateinit var ic4 : ImageView
lateinit var ic5 : ImageView
lateinit var ic6 : ImageView
lateinit var ic7 : ImageView
lateinit var ic8 : ImageView
lateinit var ic9 : ImageView
lateinit var ic10 : ImageView
lateinit var ic11 : ImageView
lateinit var ic12 : ImageView
lateinit var ic13 : ImageView
lateinit var ic14 : ImageView
lateinit var ic15 : ImageView
lateinit var ic16 : ImageView
lateinit var ic17 : ImageView
lateinit var ic18 : ImageView
lateinit var ic19 : ImageView
lateinit var ic20 : ImageView
lateinit var ic21 : ImageView
lateinit var ic22 : ImageView
lateinit var ic23 : ImageView
lateinit var ic24 : ImageView
lateinit var ic25 : ImageView
lateinit var text3 : TextView
lateinit var list3 : ArrayList<ImageView>


class ChooseColor5x5 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fview4 = inflater.inflate(R.layout.choose5x5, container, false)
        ic1 = fview4!!.findViewById(R.id.color_item_5x5_1)
        ic2 = fview4!!.findViewById(R.id.color_item_5x5_2)
        ic3 = fview4!!.findViewById(R.id.color_item_5x5_3)
        ic4 = fview4!!.findViewById(R.id.color_item_5x5_4)
        ic5 = fview4!!.findViewById(R.id.color_item_5x5_5)
        ic6 = fview4!!.findViewById(R.id.color_item_5x5_6)
        ic7 = fview4!!.findViewById(R.id.color_item_5x5_7)
        ic8 = fview4!!.findViewById(R.id.color_item_5x5_8)
        ic9 = fview4!!.findViewById(R.id.color_item_5x5_9)
        ic10 = fview4!!.findViewById(R.id.color_item_5x5_10)
        ic11 = fview4!!.findViewById(R.id.color_item_5x5_11)
        ic12 = fview4!!.findViewById(R.id.color_item_5x5_12)
        ic13 = fview4!!.findViewById(R.id.color_item_5x5_13)
        ic14 = fview4!!.findViewById(R.id.color_item_5x5_14)
        ic15 = fview4!!.findViewById(R.id.color_item_5x5_15)
        ic16 = fview4!!.findViewById(R.id.color_item_5x5_16)
        ic17 = fview4!!.findViewById(R.id.color_item_5x5_17)
        ic18 = fview4!!.findViewById(R.id.color_item_5x5_18)
        ic19 = fview4!!.findViewById(R.id.color_item_5x5_19)
        ic20 = fview4!!.findViewById(R.id.color_item_5x5_20)
        ic21 = fview4!!.findViewById(R.id.color_item_5x5_21)
        ic22 = fview4!!.findViewById(R.id.color_item_5x5_22)
        ic23 = fview4!!.findViewById(R.id.color_item_5x5_23)
        ic24 = fview4!!.findViewById(R.id.color_item_5x5_24)
        ic25 = fview4!!.findViewById(R.id.color_item_5x5_25)

        list3 = ArrayList()
        list3.add(ic1);list3.add(ic2);list3.add(ic3);list3.add(ic4);list3.add(ic5);
        list3.add(ic6);list3.add(ic7);list3.add(ic8);list3.add(ic9);list3.add(ic10);
        list3.add(ic11);list3.add(ic12);list3.add(ic13);list3.add(ic14);list3.add(ic15);
        list3.add(ic16);list3.add(ic17);list3.add(ic18);list3.add(ic19);list3.add(ic20);
        list3.add(ic21);list3.add(ic22);list3.add(ic23);list3.add(ic24);list3.add(ic25);

        // //  blue->brown->green->orange->purple->pink->red->yellow
        var loop = 1

        while (loop != 0) {


            RandomColor()
            var colorColection = arrayOf<Int>(blue, brown, green, orange, purple, pink, red, yellow)
            var max = 0
            for (i in 0..7) {
                if (max < colorColection.get(i)) {
                    max = colorColection.get(i)
                    setmost(i + 1)
                    loop = 0
                } else {
                    if (max == colorColection.get(i)) {
                        loop++
                    }
                }

            }


        }



        return fview4
    }

    fun RandomColor() {
        blue = 0
        brown = 0
        green = 0
        orange = 0
        purple = 0
        pink = 0
        red = 0
        yellow = 0
        //  blue->brown->green->orange->purple->pink->red->yellow
        for (t in list3) {
            val random = Random()
            val rd = random.nextInt(8)
            when (rd) {
                0 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.blue))
                    blue++
                }

                1 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.brown))
                    brown++
                }

                2 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.green))
                    green++
                }

                3 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.orange))
                    orange++
                }

                4 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.purple))
                    purple++
                }

                5 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.pink))
                    pink++
                }

                6 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.red))
                    red++
                }

                7 -> {
                    t.setImageDrawable(resources.getDrawable(R.drawable.yellow))
                    yellow++
                }


            }


        }
    }

    fun setmost(i: Int) {
        mostcolor = i
    }

    fun getnum(): Int {
        return mostcolor
    }
}


