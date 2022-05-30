package com.example.blob

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import java.util.*

var equalview3 : View? = null

lateinit var block13 : ImageView
lateinit var block14 : ImageView
lateinit var block15 : ImageView
lateinit var block16 : ImageView
lateinit var block17 : ImageView
lateinit var block18 : ImageView


class equal_scale3 : Fragment() {





    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        equalizelist.clear()



        equalview3 = inflater.inflate(R.layout.equal_scale3, container, false)

        block13 = equalview3!!.findViewById(R.id.mini13)
        block14 = equalview3!!.findViewById(R.id.mini14)
        block15 = equalview3!!.findViewById(R.id.mini15)
        block16 = equalview3!!.findViewById(R.id.mini16)
        block17 = equalview3!!.findViewById(R.id.mini17)
        block18 = equalview3!!.findViewById(R.id.mini18)

        equalizelist.add(block13);equalizelist.add(block14);equalizelist.add(block15);
        equalizelist.add(block16);equalizelist.add(block17);equalizelist.add(block18);

        // //  blue->brown->green->orange->purple->pink->red->yellow




        return equalview3
    }


}