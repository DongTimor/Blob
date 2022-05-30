package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text
import java.util.*

var fview2 : View? = null
var mostcolor  = 0


lateinit var list : ArrayList<ImageView>
var blue = 0
var brown = 0
var green = 0
var orange = 0
var purple = 0
var pink = 0
var red = 0
var yellow = 0


class ChooseColor3X3 : Fragment() {
    lateinit var item1 : ImageView
    lateinit var item2 : ImageView
    lateinit var item3 : ImageView
    lateinit var item4 : ImageView
    lateinit var item5 : ImageView
    lateinit var item6 : ImageView
    lateinit var item7 : ImageView
    lateinit var item8 : ImageView
    lateinit var item9 : ImageView
    lateinit var text : TextView

    fun setmost(num: Int) {
        mostcolor = num
    }

    fun getnum(): Int {
        return mostcolor
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fview2 = inflater.inflate(R.layout.choose3x3, container, false)
        mostcolor == 5
        item1 = fview2!!.findViewById(R.id.color_item_3x3_1)
        item2 = fview2!!.findViewById(R.id.color_item_3x3_2)
        item3 = fview2!!.findViewById(R.id.color_item_3x3_3)
        item4 = fview2!!.findViewById(R.id.color_item_3x3_4)
        item5 = fview2!!.findViewById(R.id.color_item_3x3_5)
        item6 = fview2!!.findViewById(R.id.color_item_3x3_6)
        item7 = fview2!!.findViewById(R.id.color_item_3x3_7)
        item8 = fview2!!.findViewById(R.id.color_item_3x3_8)
        item9 = fview2!!.findViewById(R.id.color_item_3x3_9)


        list  = ArrayList()
        list.add(item1);list.add(item2);list.add(item3);list.add(item4);list.add(item5);list.add(
            item6
        );list.add(item7);list.add(item8);list.add(item9);


        // //  blue->brown->green->orange->purple->pink->red->yellow
        var loop = 1



        while  (loop != 0){


                RandomColor()
                var colorColection = arrayOf<Int>(blue,brown,green,orange,purple,pink,red,yellow)
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
















        return fview2
    }

    fun RandomColor(){
        blue = 0
        brown = 0
        green = 0
        orange = 0
        purple = 0
        pink = 0
        red = 0
        yellow = 0
        //  blue->brown->green->orange->purple->pink->red->yellow
        for (t in list) {
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

}