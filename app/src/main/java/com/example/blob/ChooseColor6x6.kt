package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.*

var fview5 : View? = null

lateinit var icon1 : ImageView
lateinit var icon2 : ImageView
lateinit var icon3 : ImageView
lateinit var icon4 : ImageView
lateinit var icon5 : ImageView
lateinit var icon6 : ImageView
lateinit var icon7 : ImageView
lateinit var icon8 : ImageView
lateinit var icon9 : ImageView
lateinit var icon10 : ImageView
lateinit var icon11 : ImageView
lateinit var icon12 : ImageView
lateinit var icon13 : ImageView
lateinit var icon14 : ImageView
lateinit var icon15 : ImageView
lateinit var icon16 : ImageView
lateinit var icon17 : ImageView
lateinit var icon18 : ImageView
lateinit var icon19 : ImageView
lateinit var icon20 : ImageView
lateinit var icon21 : ImageView
lateinit var icon22 : ImageView
lateinit var icon23 : ImageView
lateinit var icon24 : ImageView
lateinit var icon25 : ImageView
lateinit var icon26 : ImageView
lateinit var icon27 : ImageView
lateinit var icon28 : ImageView
lateinit var icon29 : ImageView
lateinit var icon30 : ImageView
lateinit var icon31 : ImageView
lateinit var icon32 : ImageView
lateinit var icon33 : ImageView
lateinit var icon34 : ImageView
lateinit var icon35 : ImageView
lateinit var icon36 : ImageView
lateinit var text4 : TextView

lateinit var list4 : ArrayList<ImageView>



class ChooseColor6x6 : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         fview5 = inflater.inflate(R.layout.choose6x6,container,false)

        icon1 = fview5!!.findViewById(R.id.item_6x6_1)
        icon2 = fview5!!.findViewById(R.id.item_6x6_2)
        icon3 = fview5!!.findViewById(R.id.item_6x6_3)
        icon4 = fview5!!.findViewById(R.id.item_6x6_4)
        icon5 = fview5!!.findViewById(R.id.item_6x6_5)
        icon6 = fview5!!.findViewById(R.id.item_6x6_6)
        icon7 = fview5!!.findViewById(R.id.item_6x6_7)
        icon8 = fview5!!.findViewById(R.id.item_6x6_8)
        icon9 = fview5!!.findViewById(R.id.item_6x6_9)
        icon10 = fview5!!.findViewById(R.id.item_6x6_10)
        icon11 = fview5!!.findViewById(R.id.item_6x6_11)
        icon12 = fview5!!.findViewById(R.id.item_6x6_12)
        icon13 = fview5!!.findViewById(R.id.item_6x6_13)
        icon14 = fview5!!.findViewById(R.id.item_6x6_14)
        icon15 = fview5!!.findViewById(R.id.item_6x6_15)
        icon16 = fview5!!.findViewById(R.id.item_6x6_16)
        icon17 = fview5!!.findViewById(R.id.item_6x6_17)
        icon18 = fview5!!.findViewById(R.id.item_6x6_18)
        icon19 = fview5!!.findViewById(R.id.item_6x6_19)
        icon20 = fview5!!.findViewById(R.id.item_6x6_20)
        icon21 = fview5!!.findViewById(R.id.item_6x6_21)
        icon22 = fview5!!.findViewById(R.id.item_6x6_22)
        icon23 = fview5!!.findViewById(R.id.item_6x6_23)
        icon24 = fview5!!.findViewById(R.id.item_6x6_24)
        icon25 = fview5!!.findViewById(R.id.item_6x6_25)
        icon26 = fview5!!.findViewById(R.id.item_6x6_26)
        icon27 = fview5!!.findViewById(R.id.item_6x6_27)
        icon28 = fview5!!.findViewById(R.id.item_6x6_28)
        icon29 = fview5!!.findViewById(R.id.item_6x6_29)
        icon30 = fview5!!.findViewById(R.id.item_6x6_30)
        icon31 = fview5!!.findViewById(R.id.item_6x6_31)
        icon32 = fview5!!.findViewById(R.id.item_6x6_32)
        icon33 = fview5!!.findViewById(R.id.item_6x6_33)
        icon34 = fview5!!.findViewById(R.id.item_6x6_34)
        icon35 = fview5!!.findViewById(R.id.item_6x6_35)
        icon36 = fview5!!.findViewById(R.id.item_6x6_)

        list4 = ArrayList()
        list4.add(icon1);list4.add(icon2);list4.add(icon3);list4.add(icon4);list4.add(icon5);list4.add(icon6);
        list4.add(icon7);list4.add(icon8);list4.add(icon9);list4.add(icon10);list4.add(icon11);list4.add(icon12);
        list4.add(icon13);list4.add(icon14);list4.add(icon15);list4.add(icon16);list4.add(icon17);list4.add(icon18);
        list4.add(icon19);list4.add(icon20);list4.add(icon21);list4.add(icon22);list4.add(icon23);list4.add(icon24);
        list4.add(icon25);list4.add(icon26);list4.add(icon27);list4.add(icon28);list4.add(icon29);list4.add(icon30);
        list4.add(icon31);list4.add(icon32);list4.add(icon33);list4.add(icon34);list4.add(icon35);list4.add(icon36);


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



        return fview5
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
        for (t in list4) {
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


