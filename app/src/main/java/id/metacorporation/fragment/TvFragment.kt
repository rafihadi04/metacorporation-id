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
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import id.metacorporation.R
import id.metacorporation.adapter.ProgramAdapter
import id.metacorporation.models.ProgramModel
import id.metacorporation.repository.DataRepository
import id.metacorporation.usecase.MainActivityUseCase
import kotlin.properties.Delegates


@Suppress("LocalVariableName")
class TvFragment(val dataRepository: DataRepository) : Fragment() {
    private lateinit var rvProgramTv :RecyclerView
    //private lateinit var rvPresenterTv :RecyclerView
    private lateinit var viewFragment: View
    private lateinit var youTubePlayerView :YouTubePlayerView
    ///*EXPERIMENTAL*/private lateinit var youtubeView :YouTubeView
    private lateinit var navbar: ChipNavigationBar
    private lateinit var livechat:View
    private lateinit var livechatTitle :TextView
    private var youtubePlayer :YouTubePlayer? = null
    private var mOriginalHeight by Delegates.notNull<Int>()
    private var isFullscreen :Boolean = false
    private var isShrink :Boolean = false
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

        livechat = viewFragment.findViewById(R.id.liveChatLayout)
        livechatTitle = viewFragment.findViewById(R.id.liveChatButton)

        navbar = requireActivity().findViewById(R.id.bottomNav)

        /*livechat.post{
            mOriginalHeight=livechat.height
        }*/

        navbar.visibility = savedInstanceState?.getInt("NavBar") ?: View.VISIBLE
        isFullscreen = savedInstanceState?.getBoolean("isFullscreen") ?: false

        youTubePlayerView.post{
            setLiveChatListener()
            setyoutubeLink(getString(R.string.youtube_live_tv))
        }

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

        return viewFragment
    }

    private fun setLiveChatListener() {
        livechatTitle.setOnClickListener {
            if(livechat.visibility==View.GONE){
                livechat.visibility=View.VISIBLE
            }else{
                livechat.visibility=View.GONE
            }
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
    fun showProgram(dataProgram: ArrayList<ProgramModel>,/* dataPresenter: ArrayList<PresenterModel>*/) {
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
    fun setyoutubeLink(url :String){
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
    fun hideNavBar(decorView: View) {
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


}