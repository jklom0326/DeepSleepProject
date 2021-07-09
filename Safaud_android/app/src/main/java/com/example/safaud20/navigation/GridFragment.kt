package com.example.safaud20.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.safaud20.MainActivity
import com.example.safaud20.R


class GridFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_grid,container,false)

        val button1 = view.findViewById<Button>(R.id.KESS)


        button1?.setOnClickListener(){
            val mainActivity = activity as MainActivity
            mainActivity.sleepTest( "KESS")
        }
        return view


    }

}