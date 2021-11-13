package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.*
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import id.metacorporation.R
import id.metacorporation.adapter.ProgramAdapter
import id.metacorporation.adapter.VODAdappter
import id.metacorporation.models.ProgramModel
import id.metacorporation.repository.DataRepository
import id.metacorporation.usecase.MainActivityUseCase


@Suppress("LocalVariableName")
class TvFragment(private val dataRepository: DataRepository) : Fragment() {
    private lateinit var rvProgramTv :RecyclerView
    //private lateinit var rvPresenterTv :RecyclerView
    private lateinit var viewFragment: View
    private lateinit var youTubePlayerView :YouTubePlayerView
    ///*EXPERIMENTAL*/private lateinit var youtubeView :YouTubeView
    private lateinit var navbar: ChipNavigationBar
    private lateinit var livechat: WebView
    private lateinit var livechatTitle :TextView
    private lateinit var liveChatTitleLayout :LinearLayout
    private lateinit var scrollView :NestedScrollView
    private lateinit var lastState :PlayerConstants.PlayerState
    private lateinit var toolbar :RelativeLayout
    private var youtubePlayer :YouTubePlayer? = null
    private lateinit var namaProgramTvOnAir:TextView
    private lateinit var textTVRadio :TextView
    private var isFullscreen :Boolean = false
    private var callback: OnBackPressedCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(this.javaClass.simpleName,"onCreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.d(this.javaClass.simpleName,"onCreateView()")

        viewFragment = inflater.inflate(R.layout.fragment_tv_radio, container, false)

        youTubePlayerView = viewFragment.findViewById(R.id.youtubeTv)

        /*rvPresenterTv = viewFragment.findViewById(R.id.rv_presenter_tv)*/
        rvProgramTv = viewFragment.findViewById(R.id.rv_our_programtv)

        livechat = viewFragment.findViewById(R.id.livechatWebview)
        livechatTitle = viewFragment.findViewById(R.id.liveChatButton)
        liveChatTitleLayout = viewFragment.findViewById(R.id.liveChatTitleLayout)
        textTVRadio = viewFragment.findViewById(R.id.textTVRADIO)

        navbar = requireActivity().findViewById(R.id.bottomNav)
        toolbar = viewFragment.findViewById(R.id.toolbar)
        scrollView = viewFragment.findViewById(R.id.scrollViewTvRadio)
        namaProgramTvOnAir =viewFragment.findViewById(R.id.namaProgramTvOnAir)
        namaProgramTvOnAir.text = getString(R.string.meta_tv_live_name)

        /*livechat.post{
            mOriginalHeight=livechat.height
        }*/

        navbar.visibility = savedInstanceState?.getInt("NavBar") ?: View.VISIBLE
        isFullscreen = savedInstanceState?.getBoolean("isFullscreen") ?: false

        youTubePlayerView.post{
            setLiveChatListener()
            val linkTV = dataRepository.getLinkTV()
            if (!linkTV.isNullOrEmpty()){
                setyoutubeLink(linkTV)
                liveChatInit()
                showProgram(dataRepository.getProgramTv()/*, dataRepository.getAnnouncer()*/)
            }else {
                replayLayout(dataRepository.getProgramTv())
            }
        }
        liveChatInit()

        //EXPERIMENTAL
        //youtubeView = viewFragment.findViewById(R.id.youtubeView)
        /*youtubeView.post{
            youtubeView.webChromeClient = WebChromeClient()
            @SuppressLint("SetJavaScriptEnabled")
            youtubeView.settings.javaScriptEnabled = true
            youtubeView.loadUrl("https://youtube.com/embed/M7lc1UVf-VE")
        }*/
        showProgram(dataRepository.getProgramTv()/*, dataRepository.getPresenter()*/)
        /*Thread({
            Log.d(this.javaClass.simpleName,Thread.currentThread().name)

        },"GetProgramTV").start()*/

        networkError(dataRepository.onErrorNetwork)
        return viewFragment
    }

    private fun networkError(posisi :Boolean){
        if(posisi){
            val dialog = layoutInflater.inflate(R.layout.on_network_error,null)
            dialog.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT).also {
                it.setMargins(requireActivity().resources.getDimension(R.dimen._10sdp).toInt())
            }
            (scrollView.getChildAt(0) as RelativeLayout).addView(
                dialog,
                RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT).also {
                    it.alignWithParent=true
                    it.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
                    it.bottomMargin=requireActivity().resources.getDimension(R.dimen._50sdp).toInt()
                    it.marginStart=requireActivity().resources.getDimension(R.dimen._10sdp).toInt()
                    it.marginEnd=requireActivity().resources.getDimension(R.dimen._10sdp).toInt()
                }
            )
        }
    }

    private fun replayLayout(programRadio: ArrayList<ProgramModel>) {
        youTubePlayerView.visibility = View.GONE
        liveChatTitleLayout.visibility = View.GONE
        textTVRadio.visibility = View.GONE
        namaProgramTvOnAir.visibility = View.GONE
        /*.text = "Replay Program Radio".uppercase()
        namaProgramTvOnAir.setTextColor(requireContext().getColor(R.color.pallet_yellow))*/
        //rvProgramRadio.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvProgramTv.layoutManager = GridLayoutManager(context,2,
            LinearLayoutManager.VERTICAL,false)
        rvProgramTv.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT).also {
            it.gravity = Gravity.CENTER
        }
        rvProgramTv.adapter = VODAdappter(requireContext(),programRadio)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setLiveChatListener() {
        livechatTitle.setOnClickListener {
            if(livechat.visibility==View.GONE){
                livechat.visibility=View.VISIBLE
            }else{
                livechat.visibility=View.GONE
            }
        }
        livechat.setOnTouchListener { _, _ ->
            scrollView.requestDisallowInterceptTouchEvent(true)
            false
        }

    }

    /**
     * Mengatur Layout untuk Live Chat
     * */
    /*private fun setLiveChatListener() {

        val _hideAnimation = object:  Animation(){
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                super.applyTransformation(interpolatedTime, t)
                livechat.layoutParams.height = (mOriginalHeight*(interpolatedTime-1)).toInt()
                //Log.d("hideAnimation",livechat.layoutParams.height.toString())
            }
        }

        val _showAnimation = object:  Animation(){
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                super.applyTransformation(interpolatedTime, t)
                livechat.layoutParams.height = -(mOriginalHeight*(interpolatedTime)).toInt()
                //Log.d("showAnimation",livechat.layoutParams.height.toString())
            }
        }

        _hideAnimation.duration = 1000
        _showAnimation.duration = 1000

        livechatTitle.setOnClickListener{
            //it.clearAnimation()
            livechat.clearAnimation()
            if(isShrink){
                livechat.startAnimation(_showAnimation)
            }else{
                livechat.startAnimation(_hideAnimation)
            }

            isShrink = !isShrink

        }
    }*/

    /**
     * Fungsi ini dipanggil setiap kali fragment tampil kembali
     * */
    override fun onResume() {
        Log.d(this.javaClass.simpleName,"onResume()")
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        if (this.youtubePlayer != null) {
            this.youtubePlayer!!.play()
        }
        (requireActivity() as MainActivityUseCase).blackNavBar()
    }

    /**
     * Fungsi ini dipanggil setiap kali fragment ditinggalkan
     * */
    override fun onPause() {
        Log.d(this.javaClass.simpleName,"onPause()")
        super.onPause()
        youtubePlayer?.pause()
    }

    /**
     * Fungsi untuk menampilkan Program TV
     * */
    private fun showProgram(dataProgram: ArrayList<ProgramModel>/* dataPresenter: ArrayList<PresenterModel>*/) {
        rvProgramTv.adapter = ProgramAdapter(
            context,
            programList = dataProgram
        )
        /*rvPresenterTv.adapter = PresenterAdapter(
            context,
            presenterList = dataPresenter,
        )*/

    }

    /*fun showProgramTV(dataProgram: ArrayList<ProgramModel>){
        rvProgramTv.adapter = ProgramAdapter(
            context,
            programList = dataProgram
        )
    }

    fun showPresenter(dataPresenter: ArrayList<PresenterModel>){

    }*/


    /**
     * Fungsi untuk menyiapkan layout Youtube
     * */
    private fun setyoutubeLink(url :String){
        lifecycle.addObserver(youTubePlayerView)

        setYoutubeListener(url)
        setYoutubeFullScreenListener()

        youTubePlayerView.enableBackgroundPlayback(false)
        if(requireActivity().requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE ) youTubePlayerView.enterFullScreen()

    }

    /**
     * Fungsi untuk menyiapkan url Youtube
     * */
    private fun setYoutubeListener(url: String) {
        youTubePlayerView.initialize(
            object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youtubePlayer = youTubePlayer
                    youTubePlayer.cueVideo(
                        url, 0f
                    )
                    //super.onReady(youTubePlayer)
                }

                override fun onStateChange(
                    youTubePlayer: YouTubePlayer,
                    state: PlayerConstants.PlayerState
                ) {
                    super.onStateChange(youTubePlayer, state)
                    when(state){
                        PlayerConstants.PlayerState.PLAYING -> {}
                        PlayerConstants.PlayerState.PAUSED -> {}
                        PlayerConstants.PlayerState.UNSTARTED -> {}
                        else -> true
                    }
                    lastState = state
                    Log.d(this@TvFragment.javaClass.simpleName, "state changed: ${state.name}")
                }
            },handleNetworkEvents = true
        )
    }

    /**
     * Fungsi untuk mengatur apa yang harus dilakukan ketika layar penuh ditekan
     * */
    private fun setYoutubeFullScreenListener() {
        youTubePlayerView.addFullScreenListener(
            object : YouTubePlayerFullScreenListener {

                override fun onYouTubePlayerEnterFullScreen() {
                    enterFullScreen()
                    //requireActivity().window.addFlags(Gravity.LEFT)
                    /*youTubePlayerView.setOnFocusChangeListener { v, hasFocus ->
                        if (hasFocus) {
                            hideNavBar()
                            requireActivity().isImmersive =false
                        }

                    }*/
                }

                override fun onYouTubePlayerExitFullScreen() {
                    //requireActivity().window.addFlags(Gravity.BOTTOM)
                    exitFullScreen()
                }

            }
        )
    }

    fun enterFullScreen(){

        if (callback==null){
            setOnBackFullScreen()
        }else{
            callback!!.isEnabled=true
        }

        toolbar.visibility=View.GONE

        val decorView = requireActivity().window.decorView
        hideNavBar(decorView)
        if(resources.configuration.orientation != ORIENTATION_LANDSCAPE){
            Log.d("FullScreen","force landscape")
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
            if(Settings.System.getInt(requireActivity().contentResolver, Settings.System.ACCELEROMETER_ROTATION)==1){
                Handler(Looper.getMainLooper()).postDelayed({ requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED }, 2000)
            }
        }

    }

    private fun setOnBackFullScreen() {
        callback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (youTubePlayerView.isFullScreen()) (
                            youTubePlayerView.exitFullScreen()
                            )/*else{
                            remove()
                            requireActivity().onBackPressed()
                        }*/
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback!!
        )
    }

    @SuppressLint("SourceLockedOrientationActivity")
    fun exitFullScreen(){
        //removeOnBackFullScreen()
        callback!!.isEnabled=false
        toolbar.visibility=View.VISIBLE
        val decorView = requireActivity().window.decorView
        showNavBar(decorView)
        if(resources.configuration.orientation != ORIENTATION_PORTRAIT){
            Log.d("FullScreen","force portrait")
            requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            if(Settings.System.getInt(requireActivity().contentResolver, Settings.System.ACCELEROMETER_ROTATION)==1){
                Handler(Looper.getMainLooper()).postDelayed({ requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED }, 2000)
            }
        //resources.configuration.orientation = ORIENTATION_PORTRAIT
        }
    }


    /**
     * Fungsi untuk menghilangkan Navigasi Bar
     * */
    private fun hideNavBar(decorView: View) {
        navbar.visibility=View.GONE
        //requireActivity().requestWindowFeature(Window.FEATURE_NO_TITLE)
        @SuppressWarnings("deprecation")
        decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                )
        //requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

    }

    /**
     * Fungsi untuk memunculkan Navigasi Bar
     * */
    private fun showNavBar(decorView: View){
        navbar.visibility=View.VISIBLE
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        //requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
    }

    /**
     * Dipanggil setiap fragment diattach pada viewPager
     * */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("onAttached", "successfully")
    }

    /**
     * Dipanggil setiap ada configurasi UI berubah
     * */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(newConfig.orientation == ORIENTATION_LANDSCAPE ){
            youTubePlayerView.enterFullScreen()
        }else if(newConfig.orientation == ORIENTATION_PORTRAIT){
            youTubePlayerView.exitFullScreen()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun liveChatInit(){
        livechat.loadUrl(getString(R.string.link_chat_tv))
        livechat.settings.javaScriptEnabled=true
        livechat.webViewClient=WebViewClient()
        livechat.webChromeClient=WebChromeClient()
    }

    /*private fun mediaPlayerNotification(){
        val notificationBuilder = NotificationCompat.Builder(requireContext(),"Player")
            .setSmallIcon(R.drawable.ic_white_fix)
            .setContentTitle("Aplikasi Berjalan di Background")
            //.setContentIntent(intent)
            .setContentText("Ketuk untuk memberhentikan")
            .setStyle(Notification.MediaStyle().setMediaSession())
            .setPriority(androidx.core.app.NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationBuilder.color = Color.argb(100,185,13, 39)
        }

        with(NotificationManagerCompat.from(requireContext())){
            notify(9092,notificationBuilder.build())
        }
    }*/


}