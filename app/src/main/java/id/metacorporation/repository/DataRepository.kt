package id.metacorporation.repository

import id.metacorporation.R
import id.metacorporation.enum.SosmedType
import id.metacorporation.enum.TopProgramType
import id.metacorporation.models.JobdeskModel
import id.metacorporation.models.Posts
import id.metacorporation.models.PresenterModel
import id.metacorporation.models.ProgramModel
import retrofit2.Callback
import retrofit2.Retrofit
import kotlin.collections.ArrayList

class DataRepository {

    private val newsAPI: NewsAPI = NewsAPIBuilder.getNewsAPI().create(NewsAPI::class.java)

    fun getNews(callback: Callback<ArrayList<Posts>>){
        val call = newsAPI.getPosts()
        call.enqueue(callback)
    }

    /**
     * Mengambil data seluruh Program TV
     * */
    fun getProgramTv() :ArrayList<ProgramModel>{

        val data = arrayListOf<ProgramModel>()

        data.addAll(
            arrayListOf(
                //CONTOH DATA PER PROGRAM
                //SUPERBLOOM
                ProgramModel(
                    namaProgram = "Superbloom",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Penggambaran dari rasa cemas, tenang, dan berani yang merupakan tahapan dari proses terpuruk hingga bangkit sebagai experience dari tema healing dan growth yang akan dibawakan.",
                    rating= "17+ | Music Show",
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
                    jenisProgram = "Music Show",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Annisa Aulia Rahma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Produser",
                            namaKru = "Gustiani Arianti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 2
                ProgramModel(
                    namaProgram = "Superbloom",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Penggambaran dari rasa cemas, tenang, dan berani yang merupakan tahapan dari proses terpuruk hingga bangkit sebagai experience dari tema healing dan growth yang akan dibawakan.",
                    rating= "17+ | Music Show",
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
                    jenisProgram = "Music Show",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Annisa Aulia Rahma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Produser",
                            namaKru = "Gustiani Arianti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Produser",
                            namaKru = "Annisa Aulia Rahma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 3
                ProgramModel(
                    "Program TV 3",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/9812491/pexels-photo-9812491.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program TV 4",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/4972986/pexels-photo-4972986.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program TV 5",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/6202036/pexels-photo-6202036.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
            )
        )

        return data
    }

    /**
     * Mengambil data seluruh Program Radio
     * */
    fun getProgramRadio() :ArrayList<ProgramModel>{

        val data = arrayListOf<ProgramModel>()

        data.addAll(
            arrayListOf(
                ProgramModel(
                    namaProgram = "RADIO 1",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Penggambaran dari rasa cemas, tenang, dan berani yang merupakan tahapan dari proses terpuruk hingga bangkit sebagai experience dari tema healing dan growth yang akan dibawakan.",
                    rating= "17+ | Music Show",
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
                    jenisProgram = "Music Show",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Annisa Aulia Rahma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Produser",
                            namaKru = "Gustiani Arianti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                ProgramModel(
                    "Program Radio 2",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/9811744/pexels-photo-9811744.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program Radio 3",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/9789896/pexels-photo-9789896.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program Radio 4",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/9816125/pexels-photo-9816125.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program Radio 5",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/9807089/pexels-photo-9807089.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
            )
        )

        return data
    }

    /**
     * Untuk mengambil data Top Program
     * */
    fun getTopProgram(tipe : TopProgramType) :ArrayList<ProgramModel>{

        val data = arrayListOf<ProgramModel>()

        /**
         * Tolong ini nanti diganti sesuai topProgram
         * */
        val topRadio = listOf<Int>(0,1,2,3,4)
        val topTV = listOf<Int>(0,1,2,3,4)

        /**
         * Untuk tipe radio
         * */
        if(tipe == TopProgramType.RADIO){
            getProgramRadio().withIndex().forEach{
                if(topRadio.contains(it.index)) data.add(it.value)
            }
        }else{
            getProgramTv().withIndex().forEach{
                if(topTV.contains(it.index)) data.add(it.value)
            }
        }

        return data
    }

    /**
     * Fungsi untuk mengambil data presenter
     */
    fun getPresenter() :ArrayList<PresenterModel>{

        val data = arrayListOf<PresenterModel>()

        data.addAll(
            arrayOf(
                PresenterModel("Bujang 1","bujanglapok", SosmedType.INSTAGRAM,
                    "lorem ipsum dolor sit amet blabalbal", "",
                    R.drawable.ic_launcher_background
                ),
                PresenterModel("Bujang 2","bujanglapok2", SosmedType.FACEBOOK,
                    "lorem ipsum dolor sit amet blabalbal", "",
                    R.drawable.ic_launcher_background
                ),
                PresenterModel("Bujang 3","bujanglapok3", SosmedType.TWITTER,
                    "lorem ipsum dolor sit amet blabalbal", "",
                    R.drawable.ic_launcher_background
                )
            )
        )

        return data
    }

    fun getAnnouncer() :ArrayList<PresenterModel>{

        val data = arrayListOf<PresenterModel>()

        data.addAll(
            arrayOf(
                PresenterModel("Pengangguran 1","pengangguran", SosmedType.INSTAGRAM,
                    "lorem ipsum dolor sit amet blabalbal", "",
                    R.drawable.ic_launcher_background
                ),
                PresenterModel("Pengangguran 2","pengangguran2", SosmedType.FACEBOOK,
                    "lorem ipsum dolor sit amet blabalbal", "",
                    R.drawable.ic_launcher_background
                ),
                PresenterModel("Pengangguran 3","pengangguran3", SosmedType.TWITTER,
                    "lorem ipsum dolor sit amet blabalbal", "",
                    R.drawable.ic_launcher_background
                )
            )
        )

        return data
    }


    fun getBanner() :ArrayList<ProgramModel>{

        val data = arrayListOf<ProgramModel>()

        val featuredProgramRadio = listOf(2,1,3)
        val featuredProgramTV = listOf(0,1,3)

        getProgramRadio().withIndex().forEach{
            if(featuredProgramRadio.contains(it.index)) data.add(it.value)
        }

        getProgramTv().withIndex().forEach {
            if(featuredProgramTV.contains(it.index)) data.add(it.value)
        }

        data.shuffle()

        return data

    }
}