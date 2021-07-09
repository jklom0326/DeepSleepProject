package com.example.safaud20.SleepTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.safaud20.R
import lib.kingja.switchbutton.SwitchMultiButton


class ScrollingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scrolling, container, false)
    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            var score1: Int = 0

            val mSwitchMultiButton = view?.findViewById<SwitchMultiButton>(R.id.switchMultiButton1)
            mSwitchMultiButton?.setOnSwitchListener { position, tabText ->
                when {
                    mSwitchMultiButton.selectedTab == 0 -> score1 += 4
                    mSwitchMultiButton.selectedTab == 1 -> score1 += 3
                    mSwitchMultiButton.selectedTab == 2 -> score1 += 2
                    mSwitchMultiButton.selectedTab == 3 -> score1 += 1
                }

            }
        }
}