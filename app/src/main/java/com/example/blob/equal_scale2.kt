package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

var equalview2 : View? = null

lateinit var block7 : ImageView
lateinit var block8 : ImageView
lateinit var block9 : ImageView
lateinit var block10: ImageView
lateinit var block11 : ImageView
lateinit var block12: ImageView


class equal_scale2 : Fragment() {





    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        equalizelist.clear()



        equalview2 = inflater.inflate(R.layout.equal_scale2, container, false)

        block7 = equalview2!!.findViewById(R.id.mini7)
        block8 = equalview2!!.findViewById(R.id.mini8)
        block9 = equalview2!!.findViewById(R.id.mini9)
        block10 = equalview2!!.findViewById(R.id.mini10)
        block11 = equalview2!!.findViewById(R.id.mini11)
        block12 = equalview2!!.findViewById(R.id.mini12)

        equalizelist.add(block7);equalizelist.add(block8);equalizelist.add(block9);
        equalizelist.add(block10);equalizelist.add(block11);equalizelist.add(block12);

        // //  blue->brown->green->orange->purple->pink->red->yellow




        return equalview2
    }


}