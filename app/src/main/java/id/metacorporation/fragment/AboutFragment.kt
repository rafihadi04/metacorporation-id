package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.metacorporation.R
import id.metacorporation.adapter.SponsorMedpartAdapter
import id.metacorporation.repository.models.CreditModel
import id.metacorporation.models.JobdeskModel
import id.metacorporation.models.SponsorModel
import id.metacorporation.repository.DataRepository
import id.metacorporation.repository.models.Kru
import id.metacorporation.usecase.MainActivityUseCase
import java.lang.Exception

class AboutFragment(private val dataRepository: DataRepository) : Fragment() {

    private lateinit var ivInstagram: ImageView
    private lateinit var ivTiktok: ImageView
    private lateinit var ivTwitter: ImageView
    private lateinit var ivLinkedin: ImageView
    private lateinit var ivInstagram2: ImageView
    private lateinit var ivTiktok2: ImageView
    private lateinit var ivTwitter2: ImageView
    private lateinit var ivLinkedin2: ImageView
    private lateinit var rvSponsorS: RecyclerView
    private lateinit var rvSponsor: RecyclerView
    private lateinit var rvSponsorL: RecyclerView
    private lateinit var rvSponsorXL: RecyclerView
    private lateinit var rvMedpart: RecyclerView
    private lateinit var rvMedpartL: RecyclerView
    private lateinit var rvMedpartXL: RecyclerView
    private lateinit var rvMedpartS: RecyclerView
    private lateinit var credits :Button

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
        ivInstagram2 = view.findViewById(R.id.iv_instagram2)
        ivLinkedin2 = view.findViewById(R.id.iv_linkedin2)
        ivTiktok2 = view.findViewById(R.id.iv_tiktok2)
        ivTwitter2 = view.findViewById(R.id.iv_twitter2)
        rvSponsorS = view.findViewById(R.id.rvSponsorS)
        rvSponsor = view.findViewById(R.id.rvSponsor)
        rvSponsorL = view.findViewById(R.id.rvSponsorL)
        rvSponsorXL = view.findViewById(R.id.rvSponsorXL)
        rvMedpart = view.findViewById(R.id.rvMedpart)
        rvMedpartS = view.findViewById(R.id.rvMedpartS)
        rvMedpartL = view.findViewById(R.id.rvMedpartL)
        rvMedpartXL = view.findViewById(R.id.rvMedpartXL)
        credits = view.findViewById(R.id.credits)
        setImageListener()
        setCredits()
        sponsor()
    }

    private fun setCredits() {
        credits.setOnClickListener {
            if(dataRepository.credits != null){
                val bottomSheetDialog = BottomSheetDialog(requireContext())
                bottomSheetDialog.setContentView(R.layout.credit_title)



                bottomSheetDialog.show()
                val nested = bottomSheetDialog.findViewById<LinearLayout>(R.id.layoutCredit)
                /*val animation = AnimationUtils.loadAnimation(requireContext(),R.anim.down_from_up)
                nested?.startAnimation(animation)*/
                bottomSheetDialog.behavior.state=BottomSheetBehavior.STATE_EXPANDED
                bottomSheetDialog.behavior.skipCollapsed = true
                val rvCredit = bottomSheetDialog.findViewById<RecyclerView>(R.id.rvCredit)!!
                /*rvCredit.adapter = */creditList(
                    //requireContext(),
                    bottomSheetDialog,
                    dataRepository.credits!!

                )
            }else{
                (requireActivity() as MainActivityUseCase).onError("Server tidak dapat dihubungi. Silahkan periksa jaringan Anda atau Silahkan Buka Ulang Aplikasi!")
                dataRepository.pullCredits()
            }
        }
    }

    private fun creditList(
        bottomSheetDialog: BottomSheetDialog,
        arrayListOf: ArrayList<CreditModel>
    ) {
        arrayListOf.forEach {
            val layout = LayoutInflater.from(context).inflate(R.layout.credit_title_layout,null)
            val divisi : TextView = layout.findViewById(R.id.divisi)

            divisi.text = it.namaDivisi.uppercase()

            (layout as LinearLayout).addView(jobdeskInit(it.kru))

            val nested = bottomSheetDialog.findViewById<LinearLayout>(R.id.layoutCredit)

            nested?.addView(layout)
        }

    }

    @SuppressLint("InflateParams")
    private fun jobdeskInit(kru: List<Kru>):LinearLayout {

        val layoutHorizontal = LayoutInflater.from(context).inflate(R.layout.credit_title_jobdesk,null) as LinearLayout
        //layoutHorizontal.layoutParams = LinearLayout.LayoutParams(LinearLayout)
        val layoutVerticalKiri = layoutHorizontal.findViewById<LinearLayout>(R.id.kiri)
        /*LinearLayout(context)
    layoutVerticalKiri.orientation=LinearLayout.VERTICAL*/
        val layoutVerticalKanan = layoutHorizontal.findViewById<LinearLayout>(R.id.kanan)
        /*LinearLayout(context)
    layoutVerticalKanan.orientation=LinearLayout.VERTICAL*/
        val tvKiri = layoutHorizontal.findViewById<TextView>(R.id.tvKiri)
        val tvKanan = layoutHorizontal.findViewById<TextView>(R.id.tvKanan)

        kru.forEach {

            val tvJobNama = TextView(context)
            val tvNama = TextView(context)
            tvJobNama.text = it.jobdesk
            tvNama.text = it.nama

            tvJobNama.typeface = tvKiri.typeface
            tvJobNama.setTextColor(tvKiri.textColors)
            tvJobNama.layoutParams = tvKiri.layoutParams
            tvJobNama.textAlignment = tvJobNama.textAlignment
            tvJobNama.fontVariationSettings = tvKiri.fontVariationSettings

            tvNama.typeface = tvKanan.typeface
            tvNama.setTextColor(tvKanan.textColors)
            tvNama.layoutParams = tvKanan.layoutParams
            tvNama.fontVariationSettings = tvKanan.fontVariationSettings

            layoutVerticalKiri.addView(
                tvJobNama
            )

            layoutVerticalKanan.addView(
                tvNama
            )
        }

        /*layoutHorizontal.addView(layoutVerticalKiri)
        layoutHorizontal.addView(layoutVerticalKanan)*/


        return layoutHorizontal

    }

    private fun setImageListener() {
        val link = arrayListOf(
            getString(R.string.link_instagram),
            getString(R.string.link_linkedin),
            getString(R.string.link_tiktok),
            getString(R.string.link_twitter),
            getString(R.string.link_instagram),
            getString(R.string.link_linkedin),
            getString(R.string.link_tiktok),
            getString(R.string.link_twitter)
        )
        arrayListOf(ivInstagram,ivLinkedin,ivTiktok,ivTwitter,ivInstagram2,ivLinkedin2,ivTiktok2,ivTwitter2).withIndex().forEach { image->
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

        rvMedpartXL.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(

            SponsorModel(R.drawable.medpart_gold_xl_fastfm_150px,SponsorModel.Companion.Size.XL),
            SponsorModel(R.drawable.medpart_gold_xl_unytechtv_150px,SponsorModel.Companion.Size.XL),
            SponsorModel(R.drawable.medpart_gold_xl_mdcstmm_150px,SponsorModel.Companion.Size.XL),
            SponsorModel(R.drawable.medpart_gold_xl_fomstmm_150px,SponsorModel.Companion.Size.XL),
            SponsorModel(R.drawable.medpart_gold_xl_crastfm_150px,SponsorModel.Companion.Size.XL),
            SponsorModel(R.drawable.medpart_gold_xl_familavoice_150px,SponsorModel.Companion.Size.XL),
        ))

        rvMedpartL.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(
            SponsorModel(R.drawable.medpart_silver_l_akindotv_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_jbradio_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_jogjafamiliyradio_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_kommikstmm_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_raigedhek_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_swaragama_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_usbfstmm_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_volleyballmmtc_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_pbstmm_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_alinea_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_wargagigs_150px,SponsorModel.Companion.Size.L),
            SponsorModel(R.drawable.medpart_silver_l_radioq_150px,SponsorModel.Companion.Size.L),
        ))

        rvSponsor.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(
            SponsorModel(R.drawable.sponsor_audiogood_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_koi5_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_kotakht_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_lensajogja_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_logonafigrass_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_logoplant_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_sumberabadifurniture_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_thegrandcabinhotel_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.sponsor_wavoice_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.fixinema,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.rf_production,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.blue_production,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.everyprint_smol,SponsorModel.Companion.Size.M),
        ))

        rvSponsorXL.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(
            SponsorModel(R.drawable.potma_mmtc_smol,SponsorModel.Companion.Size.XL),
            SponsorModel(R.drawable.logo_bri,SponsorModel.Companion.Size.XL),
        ))

        rvMedpart.adapter=SponsorMedpartAdapter(requireContext(), arrayListOf(
            SponsorModel(R.drawable.medpart_gold_xl_bem_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_gradiosta_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_istakalisa_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_jogjainfoku_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_jogjapunyaacara_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_magenta_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_mmtcbasketball_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_mmtcradio_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_mnctrijayafm_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_mqfm_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_pamityang2an_black_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_pmkk_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_rasida_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_retjobuntung_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_rockstarmagz_bgwhite_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_sakafm_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_allyoucanart_black_150px,SponsorModel.Companion.Size.M),
            SponsorModel(R.drawable.medpart_bronze_m_kolonigigs_150px,SponsorModel.Companion.Size.M),
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