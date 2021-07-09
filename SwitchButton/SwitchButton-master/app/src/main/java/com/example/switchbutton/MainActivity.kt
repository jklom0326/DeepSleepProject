package com.example.switchbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import lib.kingja.switchbutton.SwitchMultiButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var score1:Int = 0
        var score2:Int = 0
        val highly = "매우 많이"
        val pretty = "상당히"
        val little = "적음"
        val absol = "전혀"
        var total :Int = 0

        val mSwitchMultiButton = findViewById(R.id.switchMultiButton) as SwitchMultiButton
        mSwitchMultiButton.setText(absol,little,pretty,highly).setOnSwitchListener { position, tabText ->
            when{
                mSwitchMultiButton.selectedTab == 0 -> score1 += 4
                mSwitchMultiButton.selectedTab == 1 -> score1 += 3
                mSwitchMultiButton.selectedTab == 2 -> score1 += 2
                mSwitchMultiButton.selectedTab == 3 -> score1 += 1
            }
        }

        val mSwitchMultiButton2 = findViewById(R.id.switchMultiButton2) as SwitchMultiButton
        mSwitchMultiButton2.setText(absol,little,pretty,highly).setOnSwitchListener { position, tabText ->
            when{
                mSwitchMultiButton2.selectedTab == 0 -> score2 += 4
                mSwitchMultiButton2.selectedTab == 1 -> score2 += 3
                mSwitchMultiButton2.selectedTab == 2 -> score2 += 2
                mSwitchMultiButton2.selectedTab == 3 -> score2 += 1
            }
        }

        val button1 = button
        button1.setOnClickListener(){
            total = score1 + score2
            textView.text =total.toString()
            score1 =0
            score2 =0
            total = 0
        }
    }

}