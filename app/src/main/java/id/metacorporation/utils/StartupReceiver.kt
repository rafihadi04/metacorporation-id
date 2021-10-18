package id.metacorporation.utils

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.metacorporation.R

class StartupReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action.equals(Intent.ACTION_BOOT_COMPLETED)){
            Log.d(this.javaClass.simpleName, "onReceive()")
            showNotification(context)
            Toast.makeText(context,"MetaCorporation Running on Background",Toast.LENGTH_SHORT).show()
        }
    }

    private fun showNotification(context: Context){

        val notificationBuilder = NotificationCompat.Builder(context, "Program")
            .setSmallIcon(R.drawable.ic_white_fix)
            .setContentTitle("Aplikasi Berjalan di Background")
            //.setContentIntent(intent)
            .setContentText("Ketuk untuk memberhentikan")
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
}