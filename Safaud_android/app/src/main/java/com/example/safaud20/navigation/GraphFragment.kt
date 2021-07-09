package com.example.safaud20.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.safaud20.R
import com.example.safaud20.navigation2.DailyFragment
import com.example.safaud20.navigation2.MonthlyFragment
import com.example.safaud20.navigation2.WeeklyFragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_graph.*


class GraphFragment : Fragment(),BottomNavigationView.OnNavigationItemSelectedListener{
    var chart = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(activity).inflate(R.layout.fragment_graph,container,false)
        return view
        top_navigation.setOnNavigationItemSelectedListener(this)
//        button = view.findViewById(R.id.add_alram)

    }

    override fun onNavigationItemSelected(p1: MenuItem): Boolean {
        when (p1.itemId) {
            R.id.daily -> {
                var dailyFragment = DailyFragment()
                childFragmentManager.beginTransaction().replace(R.id.main_content, dailyFragment).commit()
                return true
            }

            R.id.weekly -> {
                var WeeklyFragment = WeeklyFragment()
                childFragmentManager.beginTransaction().replace(R.id.main_content, WeeklyFragment).commit()
                return true
            }

            R.id.monthly -> {
                var MonthlyFragment = MonthlyFragment()
                childFragmentManager.beginTransaction().replace(R.id.main_content, MonthlyFragment).commit()
                return true
            }

        }
        return false
    }
}


