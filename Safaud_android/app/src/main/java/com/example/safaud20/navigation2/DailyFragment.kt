package com.example.safaud20.navigation2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.safaud20.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class DailyFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_daily,container,false)
        setOn()
        return view
    }

    private fun setOn(){
        val chart = view?.findViewById<BarChart>(R.id.chart)
        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(1f, 3f));
        entries.add(BarEntry(1f, 8f));
        entries.add(BarEntry(2f, 6f));
        entries.add(BarEntry(3f, 5f));
        entries.add(BarEntry(5f, 7f));
        entries.add(BarEntry(6f, 6f));
        entries.add(BarEntry(7f, 10f));
        entries.add(BarEntry(8f, 2f));
        entries.add(BarEntry(9f, 3f));
        entries.add(BarEntry(10f, 6f))
        val barData = BarDataSet(entries, "BarDataSet")
//        val barData = BarDataSet()
        val data = BarData(barData)

        if (chart != null) {
            chart.setData(data)
        }
        if (chart != null) {
            chart.setFitBars(true)
        } // make the x-axis fit exactly all bars
        if (chart != null) {
            chart.invalidate()
        } // refresh

        val xAxis : XAxis = chart!!.xAxis

        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM // x축 위치 아래
            textSize = 10f
            setDrawGridLines(false)
            granularity = 1f
            axisMinimum = 2f
//            isGranularityEnabled = true

        }
        chart.apply {
            axisRight.isEnabled = false
            legend.apply {
                textSize = 15f
                verticalAlignment = Legend.LegendVerticalAlignment.TOP          //수직조정 > 위
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER   //수평조정 > 중앙
                orientation = Legend.LegendOrientation.HORIZONTAL               //차트정렬 > 수평
                setDrawInside(false)
            }
        }
    }
}