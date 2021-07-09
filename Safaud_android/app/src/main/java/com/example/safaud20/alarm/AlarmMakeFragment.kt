package com.example.safaud20.alarm

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.safaud20.MainActivity
import com.example.safaud20.R
import com.example.safaud20.navigation.AlarmFragment
import kotlinx.android.synthetic.main.fragment_alarm_make.*
import java.util.*

class AlarmMakeFragment : Fragment() {

//
//    val db = Room.databaseBuilder(
//        this.activity!!, AlarmDatebase::class.java,"database-name"
//    ).build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_alarm_make, container, false)

        timePicker1?.setIs24HourView(false)
        //시간설정하기, 없으면 디폴트
        val sharedPreferences: SharedPreferences = this.activity!!.getSharedPreferences("daily alarm", Context.MODE_PRIVATE)

        val millis: Long = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().timeInMillis)

        val nextNotifyTime: Calendar = GregorianCalendar()
        nextNotifyTime.timeInMillis = millis

        // 이전 설정값으로 TimePicker 초기화
        val currentTime = nextNotifyTime.time
        val HourFormat = SimpleDateFormat("kk", Locale.getDefault())
        val MinuteFormat = SimpleDateFormat("mm", Locale.getDefault())
        val pre_hour = HourFormat.format(currentTime).toInt()
        val pre_minute = MinuteFormat.format(currentTime).toInt()
        timePicker1?.setHour(pre_hour);
        timePicker1?.setMinute(pre_minute);

        val Button1 = view?.findViewById<Button>(R.id.button1)
        Button1?.setOnClickListener {
            var hour: Int
            var hour_24: Int
            var minute: Int
            var am_pm: String? = null
            hour_24 = timePicker1.getHour()
            minute = timePicker1.getMinute()
            if (hour_24 > 12) {
                am_pm = "PM"
                hour = hour_24 - 12
            } else {
                hour = hour_24
                am_pm = "AM"
            }
            // 현재 지정된 시간으로 알람 시간 설정

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar[Calendar.HOUR_OF_DAY] = hour_24
            calendar[Calendar.MINUTE] = minute
            calendar[Calendar.SECOND] = 0

            // 이미 지난 시간을 지정했다면 다음날 같은 시간으로 설정

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }

            val currentDateTime = calendar.getTime();

            val date_text = SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(currentDateTime);

            val date_input_text = SimpleDateFormat("a hh시 mm분", Locale.getDefault()).format(currentDateTime)


            Toast.makeText(
                activity!!.applicationContext,
                date_text + "으로 알람이 설정되었습니다!",
                Toast.LENGTH_LONG
            ).show();
            var main_activity = activity as MainActivity
            main_activity.setAlarm("default")
            main_activity.value1 = date_input_text.toString()

            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY,date_input_text)
        }

        return view
    }
    companion object{
        const val EXTRA_REPLY = "com.example.android.timelistsql.REPLY"
    }
}




