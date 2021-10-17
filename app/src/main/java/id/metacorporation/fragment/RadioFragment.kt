package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.RecyclerView
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import id.metacorporation.R
import id.metacorporation.adapter.PresenterAdapter
import id.metacorporation.adapter.ProgramAdapter
import id.metacorporation.models.PresenterModel
import id.metacorporation.models.ProgramModel
import id.metacorporation.repository.DataRepository

class RadioFragment(val dataRepository: DataRepository) : Fragment() {
    private lateinit var rvProgramRadio : RecyclerView
    private lateinit var rvPresenterRadio : RecyclerView
    private lateinit var viewFragment: View
    private lateinit var youTubePlayerView : YouTubePlayerView
    private lateinit var navbar: ChipNavigationBar
    private var youtubePlayer :YouTubePlayer? = null
    private var callback: OnBackPressedCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewFragment = inflater.inflate(R.layout.fragment_radio, container, false)

        youTubePlayerView = viewFragment.findViewById(R.id.youtubeRadio)

        rvProgramRadio = viewFragment.findViewById(R.id.rv_our_programradio)
        rvPresenterRadio = viewFragment.findViewById(R.id.rv_presenter_radio)

        navbar = requireActivity().findViewById(R.id.bottomNav)
        navbar.visibility = savedInstanceState?.getInt("NavBar") ?: View.VISIBLE

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        youTubePlayerView.post{
            setyoutubeLink(getString(R.string.youtube_live_radio))
        }
        showProgram(dataRepository.getProgramRadio(), dataRepository.getAnnouncer())

        return viewFragment
    }

    override fun onResume() {
        Log.d(this.javaClass.simpleName,"onResume()")
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        youtubePlayer?.play()

    }

    /**
     * Fungsi ini dipanggil setiap kali fragment ditinggalkan
     * */
    override fun onPause() {
        Log.d(this.javaClass.simpleName,"onPause()")
        super.onPause()
        youtubePlayer?.pause()
    }

    private fun showProgram(dataProgram :ArrayList<ProgramModel>, dataAnnouncer:ArrayList<PresenterModel>) {
        rvProgramRadio.adapter = ProgramAdapter(
            context,
            programList = dataProgram
        )
        rvPresenterRadio.adapter = PresenterAdapter(
            context,
            presenterList = dataAnnouncer,
        )
    }

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
        if(resources.configuration.orientation != Configuration.ORIENTATION_LANDSCAPE){
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
        if(resources.configuration.orientation != Configuration.ORIENTATION_PORTRAIT){
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
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            youTubePlayerView.enterFullScreen()
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            youTubePlayerView.exitFullScreen()
        }
    }


}