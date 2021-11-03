package id.metacorporation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import id.metacorporation.adapter.BannerAdapter
import id.metacorporation.R
import id.metacorporation.adapter.JadwalAdapter
import id.metacorporation.adapter.NewsAdapter
import id.metacorporation.adapter.SpinnerAdapter
import id.metacorporation.enum.TopProgramType
import id.metacorporation.models.Posts
import id.metacorporation.models.ProgramModel
import id.metacorporation.repository.DataRepository
import id.metacorporation.usecase.MainActivityUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment(val dataRepository: DataRepository) : Fragment() {
    lateinit var viewFragment :View
    lateinit var rvTopProgramTv :RecyclerView
    lateinit var rvTopProgramRadio :RecyclerView
    lateinit var slider :SliderView
    lateinit var newsSlider :SliderView
    lateinit var btStreamTV :MaterialButton
    lateinit var btStreamRadio :MaterialButton
    private lateinit var spinner :Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewFragment = inflater.inflate(R.layout.fragment_home, container, false)

        rvTopProgramTv = viewFragment.findViewById(R.id.rv_jadwal_programtv)
        rvTopProgramRadio = viewFragment.findViewById(R.id.rv_jadwal_programradio)
        slider = viewFragment.findViewById(R.id.banner_program)
        newsSlider = viewFragment.findViewById(R.id.bannerBerita)

        spinner = viewFragment.findViewById(R.id.spinner)
        setSpinnerList()

        @SuppressLint("SourceLockedOrientationActivity")
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        /*Thread({
            Log.d(this.javaClass.simpleName,Thread.currentThread().name)
            //
        },"ShowTopProgram").start()*/
        /*val programRadio = dataRepository.getTopProgram(TopProgramType.RADIO)
        val programTv = dataRepository.getTopProgram(TopProgramType.TV)*/

        btStreamTV = viewFragment.findViewById(R.id.btStreamTV)
        btStreamRadio = viewFragment.findViewById(R.id.btStreamRadio)

        setButtonListener()
        //showJadwalProgram(programRadio,programTv)
        showBanner(context, dataRepository.getBanner())
        //showBannerBerita()
        dataRepository.getNews(
            object: Callback<ArrayList<Posts>>{
                override fun onResponse(
                    call: Call<ArrayList<Posts>>,
                    response: Response<ArrayList<Posts>>
                ) {
                    showBannerBerita(ArrayList(response.body()!!.subList(0,4)))
                }

                override fun onFailure(call: Call<ArrayList<Posts>>, t: Throwable) {
                    Log.e(this.javaClass.simpleName,t.toString())
                    (activity as MainActivityUseCase).onError("Periksa kembali koneksi kamu!")
                }

            }
        )

        /*Thread({
            Log.d(this.javaClass.simpleName,Thread.currentThread().name)
        },"ShowBanner").start()*/

        return viewFragment
    }

    private fun showBannerBerita(body: ArrayList<Posts>) {
        newsSlider.setSliderAdapter(
            NewsAdapter(requireContext(),body)
        )
        newsSlider.setIndicatorAnimation(IndicatorAnimationType.COLOR)
        newsSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        newsSlider.scrollTimeInSec = 5
        newsSlider.startAutoCycle()
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
        (requireActivity() as MainActivityUseCase).whiteNavBar()
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

    private fun setSpinnerList(){
        spinner.adapter = SpinnerAdapter(
            requireActivity(),
            R.layout.spinner_jadwal_layout,
            arrayListOf(
                "Senin, 12 Okt 21",
                "Selaja, 13 Okt 21"
            )
        )
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                showJadwalProgram(
                    ArrayList(dataRepository.getTopProgram(TopProgramType.RADIO).shuffled()),
                    ArrayList(dataRepository.getTopProgram(TopProgramType.TV).shuffled())
                )
                //Toast.makeText(requireContext(),position.toString(),Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?){
                //Nothing Happens ;)
            }

        }

        /*SpinnerAdapter(
            requireContext(),
            R.layout.spinner_jadwal_layout,
            arrayListOf(
                "Senin, 12 Okt 21",
                "Selaja, 13 Okt 21"
            )
        )*/
    }

}