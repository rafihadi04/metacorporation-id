package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import id.metacorporation.adapter.BannerAdapter
import id.metacorporation.R
import id.metacorporation.adapter.JadwalAdapter
import id.metacorporation.enum.TopProgramType
import id.metacorporation.models.ProgramModel
import id.metacorporation.repository.DataRepository
import id.metacorporation.usecase.MainActivityUseCase


class HomeFragment(val dataRepository: DataRepository) : Fragment() {
    lateinit var viewFragment :View
    lateinit var rvTopProgramTv :RecyclerView
    lateinit var rvTopProgramRadio :RecyclerView
    lateinit var slider :SliderView
    lateinit var btStreamTV :MaterialButton
    lateinit var btStreamRadio :MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewFragment = inflater.inflate(R.layout.fragment_home, container, false)

        rvTopProgramTv = viewFragment.findViewById(R.id.rv_jadwal_programtv)
        rvTopProgramRadio = viewFragment.findViewById(R.id.rv_jadwal_programradio)
        slider = viewFragment.findViewById(R.id.banner_program)

        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        /*Thread({
            Log.d(this.javaClass.simpleName,Thread.currentThread().name)
            //
        },"ShowTopProgram").start()*/
        val programRadio = dataRepository.getTopProgram(TopProgramType.RADIO)
        val programTv = dataRepository.getTopProgram(TopProgramType.TV)

        btStreamTV = viewFragment.findViewById(R.id.btStreamTV)
        btStreamRadio = viewFragment.findViewById(R.id.btStreamRadio)

        setButtonListener()
        showJadwalProgram(programRadio,programTv)
        showBanner(context, dataRepository.getBanner())

        /*Thread({
            Log.d(this.javaClass.simpleName,Thread.currentThread().name)
        },"ShowBanner").start()*/

        return viewFragment
    }

    private fun setButtonListener() {
        btStreamTV.setOnClickListener {
            (requireActivity() as MainActivityUseCase).onSwitch(R.id.tv_Fragment)
        }

        btStreamRadio.setOnClickListener {
            (requireActivity() as MainActivityUseCase).onSwitch(R.id.radio_Fragment)
        }
    }

    override fun onResume() {
        super.onResume()
        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }


    fun showBanner(context: Context?, data: ArrayList<ProgramModel>) {
        slider.setSliderAdapter(
            BannerAdapter(
                context,
                data
            )
        )
        slider.setIndicatorAnimation(IndicatorAnimationType.COLOR)
        slider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        slider.scrollTimeInSec = 5
        slider.startAutoCycle()
    }

    fun showJadwalProgram(dataRadio :ArrayList<ProgramModel>, dataTV :ArrayList<ProgramModel>){
        rvTopProgramRadio.adapter = JadwalAdapter(
            context,
            dataRadio
        )

        rvTopProgramTv.adapter = JadwalAdapter(
            context,
            dataTV
        )
    }

}