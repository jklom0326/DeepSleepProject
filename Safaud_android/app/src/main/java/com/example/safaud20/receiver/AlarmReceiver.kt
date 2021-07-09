package com.example.safaud20.receiver

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.safaud20.MainActivity
import java.text.SimpleDateFormat
import java.util.*


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationIntent = Intent(context, MainActivity::class.java)

        notificationIntent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP
                or Intent.FLAG_ACTIVITY_SINGLE_TOP)

        val pendingI = PendingIntent.getActivity(
            context, 0,
            notificationIntent, 0
        )


        val builder: Notification.Builder = Notification.Builder(context, "default")


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "매일 알람 채널"
            val description = "매일 정해진 시간에 알람합니다."
            val importance = NotificationManager.IMPORTANCE_HIGH //소리와 알림메시지를 같이 보여줌
            val channel =
                NotificationChannel("default", channelName, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }


        builder.setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setWhen(System.currentTimeMillis())
            .setTicker("{Time to watch some cool stuff!}")
            .setContentTitle("상태바 드래그시 보이는 타이틀")
            .setContentText("상태바 드래그시 보이는 서브타이틀")
            .setContentInfo("INFO")
            .setContentIntent(pendingI)

        // 노티피케이션 동작시킴
        notificationManager.notify(1234, builder.build())
        val nextNotifyTime: Calendar = Calendar.getInstance()

        // 내일 같은 시간으로 알람시간 결정
        nextNotifyTime.add(Calendar.DATE, 1)

        //  Preference에 설정한 값 저장
        val editor =
            context.getSharedPreferences("daily alarm", MODE_PRIVATE)
                .edit()
        editor.putLong("nextNotifyTime", nextNotifyTime.getTimeInMillis())
        editor.apply()
        val currentDateTime: Date = nextNotifyTime.getTime()
        val date_text: String = SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(currentDateTime)

        Toast.makeText(
            context.applicationContext,
            "다음 알람은 " + date_text + "으로 알람이 설정되었습니다!",
            Toast.LENGTH_SHORT
        ).show()

    }
}
