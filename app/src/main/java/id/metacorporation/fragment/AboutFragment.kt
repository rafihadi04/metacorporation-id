package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import id.metacorporation.MainActivity
import id.metacorporation.R
import id.metacorporation.adapter.SponsorMedpartAdapter
import id.metacorporation.enum.NotificationID
import id.metacorporation.usecase.MainActivityUseCase
import id.metacorporation.utils.ProgramNotificationReceiver
import java.lang.Exception

class AboutFragment : Fragment() {

    private lateinit var ivInstagram: ImageView
    private lateinit var ivTiktok: ImageView
    private lateinit var ivTwitter: ImageView
    private lateinit var ivLinkedin: ImageView
    private lateinit var rvSponsor: RecyclerView
    private lateinit var rvMedpart: RecyclerView

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

        /*val intent = Intent(requireContext(),MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(requireContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT)*/

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
        ivInstagram = view.findViewById(R.id.iv_instagram)
        ivLinkedin = view.findViewById(R.id.iv_linkedin)
        ivTiktok = view.findViewById(R.id.iv_tiktok)
        ivTwitter = view.findViewById(R.id.iv_twitter)
        rvSponsor = view.findViewById(R.id.rvSponsor)
        rvMedpart = view.findViewById(R.id.rvMedpart)
        setImageListener()
        sponsor()
    }

    private fun setImageListener() {
        val link = arrayListOf(
            getString(R.string.link_instagram),
            getString(R.string.link_linkedin),
            getString(R.string.link_tiktok),
            getString(R.string.link_twitter)
        )
        arrayListOf(ivInstagram,ivLinkedin,ivTiktok,ivTwitter).withIndex().forEach { image->
            image.value.setOnClickListener{
                try{
                    startActivity(
                        Intent(Intent.ACTION_VIEW)
                            .setData(Uri.parse(link[image.index]))
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    )
                }catch(e:Exception){
                    (requireActivity() as MainActivityUseCase).onError("Something went wrong! Pls open it manually ${link[image.index]}")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        (requireActivity() as MainActivityUseCase).whiteNavBar()
    }

    private fun sponsor(){
        rvSponsor.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(
            R.drawable.sponsor_audiogood,
            R.drawable.sponsor_koi5,
            R.drawable.sponsor_kotakht,
            R.drawable.sponsor_lensajogja,
            R.drawable.sponsor_logonafigrass,
            R.drawable.sponsor_logoplant,
            R.drawable.sponsor_sumberabadifurniture,
            R.drawable.sponsor_thegrandcabinhotel,
            R.drawable.sponsor_wavoice
        ))
        rvMedpart.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(
            R.drawable.medpart_gold_xl_bem,
            R.drawable.medpart_gold_xl_crastfm,
            R.drawable.medpart_gold_xl_familavoice,
            R.drawable.medpart_gold_xl_fastfm,
            R.drawable.medpart_gold_xl_fomstmm,
            R.drawable.medpart_gold_xl_mdcstmm,
            R.drawable.medpart_gold_xl_unytechtv,
            R.drawable.medpart_silver_l_akindotv,
            R.drawable.medpart_silver_l_jbradio,
            R.drawable.medpart_silver_l_jogjafamiliyradio,
            R.drawable.medpart_silver_l_kommikstmm,
            R.drawable.medpart_silver_l_raigedhek,
            R.drawable.medpart_silver_l_swaragama,
            R.drawable.medpart_silver_l_usbfstmm,
            R.drawable.medpart_silver_l_volleyballmmtc,
            R.drawable.medpart_silver_l_wargagigs,
            R.drawable.medpart_bronze_m_gradiosta,
            R.drawable.medpart_bronze_m_istakalisa,
            R.drawable.medpart_bronze_m_jogjainfoku,
            R.drawable.medpart_bronze_m_jogjapunyaacara,
            R.drawable.medpart_bronze_m_magenta,
            R.drawable.medpart_bronze_m_mmtcbasketball,
            R.drawable.medpart_bronze_m_mmtcradio,
            R.drawable.medpart_bronze_m_mnctrijayafm,
            R.drawable.medpart_bronze_m_mqfm,
            R.drawable.medpart_bronze_m_pamityang2an_black,
            R.drawable.medpart_bronze_m_pmkk,
            R.drawable.medpart_bronze_m_rasida,
            R.drawable.medpart_bronze_m_retjobuntung,
            R.drawable.medpart_bronze_m_rockstarmagz_bgwhite,
            R.drawable.medpart_bronze_m_sakafm,
            R.drawable.medpart_allyoucanart,
        ))
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