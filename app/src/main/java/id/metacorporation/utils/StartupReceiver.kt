package id.metacorporation.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.metacorporation.MainActivity
import id.metacorporation.R
import id.metacorporation.enum.NotificationID
import id.metacorporation.repository.DataRepository
import java.text.SimpleDateFormat
import java.util.*

class StartupReceiver:BroadcastReceiver() {
    private var requestCode: Int = 0
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action.equals(Intent.ACTION_BOOT_COMPLETED)){
            Log.d(this.javaClass.simpleName, "onReceive()")
            showNotification(context)
            setUpAlarm(context)
            Toast.makeText(context,"MetaCorporation Running on Background",Toast.LENGTH_SHORT).show()
        }
    }

    private fun showNotification(context: Context){

        val notificationBuilder = NotificationCompat.Builder(context, "Program")
            .setSmallIcon(R.drawable.ic_white_fix)
            .setContentTitle("Setelan Notifikasi Dinyalakan")
            //.setContentIntent(intent)
            .setContentText("Anda akan mendapatkan notifikasi ketika program telah dimulai")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationBuilder.color = Color.argb(100,185,13, 39)
        }

        with(NotificationManagerCompat.from(context)){
            notify(9092,notificationBuilder.build())
        }
        //NotificationManagerCompat.from(this).notify(NotificationID.PROGRAM.ordinal,notificationBuilder.build())
    }

    private fun setUpAlarm(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,0,intent,0)
        val formatTanggal = SimpleDateFormat("EEEE, dd MMM yyyy 'Pukul' kk.mm z", Locale("id","ID"))
        val dataRepository = DataRepository()
        val allProg = dataRepository.getProgramTv()+dataRepository.getProgramRadio()
        allProg.forEach{
            Log.d("ALARMSET", it.namaProgram)
            scheduleNotification(context, "${it.namaProgram} akan segera dimulai", "Tekan untuk melihat Program",R.drawable.ic_white_fix,pendingIntent,formatTanggal.parse(it.jadwal).time)
        }
        //scheduleNotification(context, "akan segera dimulai", "Tekan untuk melihat Program",R.drawable.ic_white_fix,pendingIntent,formatTanggal.parse("Sabtu, 06 Nov 2021 Pukul 04.38 WIB").time)
    }

    private fun scheduleNotification(
        context: Context,
        title: String,
        contentText: String,
        icon: Int = R.drawable.ic_tv,
        _intent: PendingIntent? = null,
        timeMillis :Long
    ){
        val notificationIntent = Intent(context , ProgramNotificationReceiver::class.java)
        notificationIntent
            .putExtra(NotificationID.TITLE, title)
            .putExtra(NotificationID.IMAGE, icon)
            .putExtra(NotificationID.MESSAGE,contentText)
        if (_intent!=null) notificationIntent.putExtra(NotificationID.INTENT, _intent)
        val pendingIntent = PendingIntent.getBroadcast(context,requestCode,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //alarmManager.set(AlarmManager.RTC_WAKEUP, timeMillis, pendingIntent)
        alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,timeMillis,pendingIntent)
        requestCode++
    //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,timeMillis,AlarmManager.INTERVAL_DAY,pendingIntent)
    }
}