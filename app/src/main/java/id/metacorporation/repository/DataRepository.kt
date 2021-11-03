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
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
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
                            "Pengarah Acara",
                            namaKru = "Siti Amanah Nabila",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Pengarah Studio",
                            namaKru = "Veronika Laras",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Hasna Karimah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Tim Kreatif",
                            namaKru = "Brigitta Emanuella",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Tim Kreatif",
                            namaKru = "Bagas Mahendra",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "SPV artistik dan Properti",
                            namaKru = "Muhammad Farhan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Sekar Arum Ekanata W.",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Lita Sukarno",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Rakaduta Bawanurpika",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Sheva Arifiano",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "SPV Makeup dan Wardrobe",
                            namaKru = "Ardelia Ika",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Make Up dan Wardrobe",
                            namaKru = "Nadya Febbyrain",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Koordinator Talent",
                            namaKru = "Angie Ardhana Reswari",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Pengarah Teknik",
                            namaKru = "Dimas Yobel",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kamera",
                            namaKru = "Pradhika Janu",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kamera",
                            namaKru = "Dayu Rizki",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kamera",
                            namaKru = "Hafindra",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kamera",
                            namaKru = "Darwin",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kamera",
                            namaKru = "Anan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kamera",
                            namaKru = "Iman",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Mikhael Arjuna",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Michael Allvin",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Andreas Novi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Sidiq Ridwan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Dimas Yobel",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Perdana Al Hafiz",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Aziz akbari",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Fredy Andi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Desain Grafis",
                            namaKru = "Noufal Madha",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Guest Star",
                            namaKru = "Coldiac",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 2
                ProgramModel(
                    namaProgram = "Metamore Movie",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Vanka telah menyelesaikan studinya, memutuskan untuk pergi dari lingkungan yang membuatnya tertekan selama ini. Krisis jati diri dan trauma masa kecil yang ia rasakan, menjadi alasannya untuk memulai hidup baru dengan identitas baru.",
                    rating= "17+ | Drama TV",
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
                    jenisProgram = "Drama TV",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Luthfiah Ramadhani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Produser",
                            namaKru = "Dany Nasrulloh",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Sutradara",
                            namaKru = "Adinda permata",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Sutradara",
                            namaKru = "Alma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Jati Hidayati",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Art",
                            namaKru = "Tata",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Art",
                            namaKru = "Kirana Galuh",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Art",
                            namaKru = "Lucia Citra",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "MUA",
                            namaKru = "Grace",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Syamaidzar Labib Adani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "DOP",
                            namaKru = "Tafaul Fauzi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Lukas Frans Rijnhard",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Sutan Kevin Ardiansyah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 3
                ProgramModel(
                    namaProgram = "Galleria",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Galleria adalah program televisi yang memberikan hiburan dan informasi dikemas dengan fun, santai dengan gaya yang up to date.",
                    rating= "17+ | Variety Show",
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
                    jenisProgram = "Variety Show",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Producer",
                            namaKru = "Nopan Kurniawan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Producer",
                            namaKru = "Sherly Lusiana Novita",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Script Writer",
                            namaKru = "Rahel Aisyah Audre",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Chief Creative",
                            namaKru = "Ayunda Bilqish Alfiatussyifa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Dimas Adam Nugroho",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Muhammad Athalla Bagas Raya",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director ",
                            namaKru = "Deila Shofi Bhayangkara",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Floor Director",
                            namaKru = "Widura Anon Himawan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Chief Artistik",
                            namaKru = "Wildhania Ayu Safira",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik ",
                            namaKru = "Pinky Nur Azizah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Dion Elliot Prida Secondioz",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Christian Aldo",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Bintang Sektiawan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Artistik",
                            namaKru = "Nevada Indriawati",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Talent Coordinator",
                            namaKru = "Sherly Lusiana Novita",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "MUA Wardrobe",
                            namaKru = "Kezia Bernova",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "MUA Wardrobe",
                            namaKru = "Yasmin Khalisa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Unit Manager",
                            namaKru = "Adisty Fella",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Dartiana Sunarti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Chief Campers",
                            namaKru = "Ramadhan Dwi Wahono",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Campers",
                            namaKru = "Mohammad Al Faiz",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Campers",
                            namaKru = "Muhammad Andika Al Ghifari",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Chief Lighting",
                            namaKru = "Naufal Luthfi Iman",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Ariadani Dimas Yobel",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "M. Ilham Affandi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Chief Audio",
                            namaKru = "Dewi Meilisa Ashari",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Sutan Kevin Ardiansyah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Switcher",
                            namaKru = "Kurnia Sagi Prabandini",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "VMix",
                            namaKru = "Ilham Gulfiansyah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Amira Azizah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
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
                ProgramModel(
                    "Program TV 6",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/6202036/pexels-photo-6202036.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program TV 7",
                    R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/6202036/pexels-photo-6202036.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                ),
                ProgramModel(
                    "Program TV 8",
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