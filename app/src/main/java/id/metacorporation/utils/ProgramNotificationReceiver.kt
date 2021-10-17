package id.metacorporation.utils

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import id.metacorporation.R
import id.metacorporation.enum.NotificationID

class ProgramNotificationReceiver: BroadcastReceiver() {

    @Suppress("LocalVariableName")
    override fun onReceive(context: Context?, intent: Intent?) {
        val title = intent!!.getStringExtra(NotificationID.TITLE)!!.toString()
        val image = intent.getIntExtra(NotificationID.IMAGE,R.drawable.ic_launcher_foreground)
        val message = intent.getStringExtra(NotificationID.MESSAGE)!!.toString()
        val _intent = intent.getParcelableExtra<PendingIntent>(NotificationID.INTENT)
        showNotification(context!!,title,message,image,_intent)
    }
    private fun showNotification(context: Context,title:String,contentText:String, icon:Int= R.drawable.ic_tv, intent: PendingIntent?){

        Log.d("Notification","show $title, $contentText")
        val notificationBuilder = NotificationCompat.Builder(context, "Program")
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentIntent(intent)
            .setContentText(contentText)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(context)){
            notify(9092,notificationBuilder.build())
        }
        //NotificationManagerCompat.from(this).notify(NotificationID.PROGRAM.ordinal,notificationBuilder.build())
    }
}