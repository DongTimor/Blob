package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

var equalview : View? = null

lateinit var block1 : ImageView
lateinit var block2 : ImageView
lateinit var block3 : ImageView
lateinit var block4 : ImageView
lateinit var block5 : ImageView
lateinit var block6 : ImageView


class equal_scale : Fragment() {





    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        equalizelist.clear()



        equalview = inflater.inflate(R.layout.equal_scale, container, false)

        block1 = equalview!!.findViewById(R.id.mini1)
        block2 = equalview!!.findViewById(R.id.mini2)
        block3 = equalview!!.findViewById(R.id.mini3)
        block4 = equalview!!.findViewById(R.id.mini6)
        block5 = equalview!!.findViewById(R.id.mini4)
        block6 = equalview!!.findViewById(R.id.mini5)

        equalizelist.add(block1);equalizelist.add(block2);equalizelist.add(block3);
        equalizelist.add(block4);equalizelist.add(block5);equalizelist.add(block6);

        // //  blue->brown->green->orange->purple->pink->red->yellow




        return equalview
    }


}