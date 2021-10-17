package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import id.metacorporation.MainActivity
import id.metacorporation.R
import id.metacorporation.enum.NotificationID
import id.metacorporation.utils.ProgramNotificationReceiver

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val intent = Intent(requireContext(),MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        /*view.findViewById<Button>(R.id.bt_sponsor).setOnClickListener{
            //showNotification("Sponsor", "sponsor bla bla bla desc")
            scheduleNotification("Program TV 1","Program telah dimulai, silahkan ketuk untuk melihat!",R.drawable.ic_tv,pendingIntent)
        }

        view.findViewById<Button>(R.id.bt_mediapartner).setOnClickListener {
            //showNotification("Media Partner", "blablablabla",R.drawable.ic_radio)
            scheduleNotification(
                "Program Radio 1",
                "Program Radio telah dimulai, silahkan ketuk untuk melihat!",
                R.drawable.ic_radio,
                pendingIntent
            )
        }*/
    }

    override fun onResume() {
        super.onResume()
        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
    /*fun showNotification(title:String,contentText:String, icon:Int=R.drawable.ic_tv){
        Log.d("Notification","show $title, $contentText")
        val notificationBuilder = NotificationCompat.Builder(requireContext(), "Program")
            .setSmallIcon(icon)
            .setContentTitle(title)
            .setContentText(contentText)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        with(NotificationManagerCompat.from(requireContext())){
            notify(9092,notificationBuilder.build())
        }
        //NotificationManagerCompat.from(this).notify(NotificationID.PROGRAM.ordinal,notificationBuilder.build())
    }*/

    /*fun scheduleNotification(
        title: String,
        contentText: String,
        icon: Int = R.drawable.ic_tv,
        _intent: PendingIntent,
    ){
        val notificationIntent = Intent(requireContext() , ProgramNotificationReceiver::class.java)
        notificationIntent
            .putExtra(NotificationID.TITLE, title)
            .putExtra(NotificationID.IMAGE, icon)
            .putExtra(NotificationID.MESSAGE,contentText)
            .putExtra(NotificationID.INTENT, _intent)
        val pendingIntent = PendingIntent.getBroadcast(requireContext(),0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT)
        val futureInMillis = SystemClock.elapsedRealtime() + 100000
        val alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent)
    }*/


}