package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

lateinit var i1 : ImageView
lateinit var i2 : ImageView
lateinit var i3 : ImageView
lateinit var i4 : ImageView
lateinit var i5 : ImageView
lateinit var i6 : ImageView
lateinit var i7 : ImageView
lateinit var i8 : ImageView
lateinit var i9 : ImageView
lateinit var i10 : ImageView
lateinit var i11 : ImageView
lateinit var i12: ImageView
lateinit var i13 : ImageView
lateinit var i14 : ImageView
lateinit var i15 : ImageView
lateinit var i16 : ImageView


lateinit var list2 : ArrayList<ImageView>







var fview3 : View? = null

class ChooseColor4x4 : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         fview3 = inflater.inflate(R.layout.choose4x4,container,false)
        i1 = fview3!!.findViewById(R.id.item_4x4_1)
        i2 = fview3!!.findViewById(R.id.item_4x4_2)
        i3 = fview3!!.findViewById(R.id.item_4x4_3)
        i4 = fview3!!.findViewById(R.id.item_4x4_4)
        i5 = fview3!!.findViewById(R.id.item_4x4_5)
        i6 = fview3!!.findViewById(R.id.item_4x4_6)
        i7 = fview3!!.findViewById(R.id.item_4x4_7)
        i8 = fview3!!.findViewById(R.id.item_4x4_8)
        i9 = fview3!!.findViewById(R.id.item_4x4_9)
        i10 = fview3!!.findViewById(R.id.item_4x4_10)
        i11 = fview3!!.findViewById(R.id.item_4x4_11)
        i12 = fview3!!.findViewById(R.id.item_4x4_12)
        i13 = fview3!!.findViewById(R.id.item_4x4_13)
        i14 = fview3!!.findViewById(R.id.item_4x4_14)
        i15 = fview3!!.findViewById(R.id.item_4x4_15)
        i16 = fview3!!.findViewById(R.id.item_4x4_16)

        list2  = ArrayList()
        list2.add(i1);list2.add(i2);list2.add(i3);list2.add(i4)
        list2.add(i5);list2.add(i6);list2.add(i7);list2.add(i8)
        list2.add(i9);list2.add(i10);list2.add(i11);list2.add(i12)
        list2.add(i13);list2.add(i14);list2.add(i15);list2.add(i16)

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



        return fview3
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
        for (t in list2) {
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

    fun setmost(i : Int){
        mostcolor = i
    }

    fun getnum(): Int {
        return mostcolor
    }


}