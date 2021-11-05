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
                    jadwal = "Kamis, 18 Nov 2021 Pukul 14.15 WIB",
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
                            namaKru = "M. Farhan",
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
                    jadwal = "Rabu, 17 Nov 2021 Pukul 13.45 WIB",
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
                    jadwal = "Rabu, 17 Nov 2021 Pukul 14.30 WIB",
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
                            namaKru = "M. Athalla Bagas Raya",
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
                            namaKru = "M. Al Faiz",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Campers",
                            namaKru = "M. Andika Al Ghifari",
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
                //PROGRAM 4
                ProgramModel(
                    namaProgram = "Ruang Rasa",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Perjalanan Maria Tri Sulistyani dan Iwan Effendi menciptakan Papermoon Puppet sebagai wadah mengungkapkan segala pemikirannya. Mengangkat tema yang dekat dengan keseharian, Papermoon Puppet Theatre yakin jika teater ini menjadi jembatan mereka berkomunikasi dengan masyarakat",
                    rating= "17+ | Dokumenter",
                    jadwal = "Kamis, 18 Nov 2021 Pukul 13.30 WIB",
                    jenisProgram = "Dokumenter",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Antonius Hegarian",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Kemal Farisi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Sutradara",
                            namaKru = "Rifky Esa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Sutradara",
                            namaKru = "Nurmalita Kusumastuti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Afra Ghalda Najma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Art",
                            namaKru = "Delima",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Fahrizal Diktian",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Rudi Iswanto",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Camera Person",
                            namaKru = "Rudi Iswanto",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting ",
                            namaKru = "Helmy Agung K",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Alifia Adila H",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Early Sukma S",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Pilot Drone",
                            namaKru = "Gregorius ayuda W",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 5
                ProgramModel(
                    namaProgram = "Lensa Bulletin",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Menghadirkan berita dengan berbagai format penyajian, live report atau laporan langsung, dan dialog yang berisi informasi secara menyeluruh dari beberapa daerah di Indonesia. Dibagi kedalam tiga segmentasi, yaitu segmen berita umum, dialog, dan rubrik.",
                    rating= "17+ | News Bulletin",
                    jadwal = "Rabu, 17 Nov 2021 Pukul 13.00 WIB",
                    jenisProgram = "News Bulletin",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Koordinator Liputan",
                            namaKru = "Pramanuhara Oktaline Edisiwi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Produser",
                            namaKru = "Belanita Puspita",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Pramanuhara Oktaline Edisiwi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Annisa Nurul Hamidah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Floor Director",
                            namaKru = "Joan Murti Grace",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Presenter Utama",
                            namaKru = "Anggria Ratri Nugrah Vantiwintan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Presenter Utama",
                            namaKru = "Ilham Dika Pradana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Presenter Rubrik",
                            namaKru = "Yohanifa Ersha Aulia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter",
                            namaKru = "Syafira Puti Kinanti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Ariskha Ridhal Ikhrom",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Lenso Ramadhanovan Parhenda",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator Aximmetry",
                            namaKru = "Lenso Ramadhanovan Parhenda",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator vMix",
                            namaKru = "Ahmad Handoko",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator Resolume",
                            namaKru = "Michael Arjuna Gracia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Mixer Audio",
                            namaKru = "Michael Arjuna Gracia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Support",
                            namaKru = "Nova Mellysa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Nova Mellysa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Ariskha Ridhal Ikhrom",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Live Report",
                            namaKru = "Lukas Frans Rijnhard",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 6
                ProgramModel(
                    namaProgram = "Labirin",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Akan mengupas topik yang penting untuk diketahui masyarakat dengan riset dan pembuktian di lapangan. Pada episode kali ini, mengangkat topik mengenai “Ngeri! Godaan Eyelash Extention Ilegal!”. Dalam produksi kali ini, kami ingin mengungkap adanya terapis atau tempat pemasangan eyelash extention yang illegal dan membahayakan konsumen",
                    rating= "17+ | Investigasi",
                    jadwal = "Rabu, 17 Nov 2021 Pukul 14.00 WIB",
                    jenisProgram = "Investigasi",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Bayu Asya Isminanda",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Tifany Rizqian Nisa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Pengarah Acra",
                            namaKru = "Fathon Nurkrisna Putra",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Presenter",
                            namaKru = "Shahnaz Dinda Rindiani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kreatif",
                            namaKru = "Ahmad Miftah Kamaluddin",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter/Riset",
                            namaKru = "Suma Maulidia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter/Riset",
                            namaKru = "Yuanvika Aurellia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter/Riset",
                            namaKru = "Puri Sasmitha Benning",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Frida Agfiara",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Sandy Hananda Bakti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Camera Person",
                            namaKru = "Nova Mellysa B",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Lia April S",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Sandy Hananda Bakti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "M. Bahrul Ulum",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 7
                ProgramModel(
                    namaProgram = "ICON (Informative Conversation)",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Akan mengupas topik yang penting untuk diketahui masyarakat dengan riset dan pembuktian di lapangan. Pada episode kali ini, mengangkat topik mengenai “Ngeri! Godaan Eyelash Extention Ilegal!”. Dalam produksi kali ini, kami ingin mengungkap adanya terapis atau tempat pemasangan eyelash extention yang illegal dan membahayakan konsumen",
                    rating= "17+ | Talkshow",
                    jadwal = "Kamis, 18 Nov 2021 Pukul 13.45 WIB",
                    jenisProgram = "Talkshow",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Delabela Salsabila Early",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Audisa Luthfiyah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Pengarah Acra",
                            namaKru = "Mellinia Pranandari",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Presenter",
                            namaKru = "Aulia Noor Chairunnisa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kreatif",
                            namaKru = "Nukhfa Farhaturrahma",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter",
                            namaKru = "Fidya Milleniar",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Naura Syifa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Salsabila Laily Tabayuni",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Naura Syifa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Salsabila Laily Tabayuni",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "M. Thaariq Aziz",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Support",
                            namaKru = "Vernanda Putra",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Konita Rhamadani Puriningsih",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //PROGRAM 8
                ProgramModel(
                    namaProgram = "Meta News Journal",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Sederet konflik di tanah Papua masih terjadi hingga saat ini, hal ini membuktikan bahwa pendekatan yang dilakukan pemerintah untuk menangani konflik tersebut dinilai masih kurang tepat.",
                    rating= "17+ | Editorial",
                    jadwal = "Kamis, 18 Nov 2021 Pukul 13.00 WIB",
                    jenisProgram = "Editorial",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Eka Novia Nurbaiti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Sholekhah Tifani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program director",
                            namaKru = "Zahrah Jinan Muafa Dzabu\t",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Floor Director",
                            namaKru = "Joan Murti Grace A.W",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Ainun",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Ainun",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Presenter",
                            namaKru = "Insan Muhammad",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Oktarian Bagus Nugroho",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Yehezkiel Kristama",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Alifia Adila Hutima",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator vMix",
                            namaKru = "Yehezkiel Kristama",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Oktarian Bagus Nugroho",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Muzaki Razak",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //DUMMY
                ProgramModel(
                    namaProgram = "DUMMY",
                    jadwal = "Sabtu, 06 Nov 2021 Pukul 04.48 WIB",
                    resource = R.drawable.ic_launcher_background
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
                //Radio 1
                ProgramModel(
                    namaProgram = "Media (Meta to Pedia)",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "MEDIA mengupas berbagai fenomena yang terjadi di dekat kita. Episode kali ini berawal dari kasus mengerikan pada tahun 2020 hingga menjadi tanda tanya besar bagi di masyarakat.",
                    rating= "18+ | Feature Radio",
                    jadwal = "Senin, 15 Nov 2021 Pukul 12.50 WIB",
                    jenisProgram = "Feature Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Mafa Zulaikhah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Asisten Produser",
                            namaKru = "Intan Ramadhani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Daini Unifianto",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Crative",
                            namaKru = "Nimas Lutfiani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Farah Aulia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Coordinator Talent",
                            namaKru = "Farah Aulia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Abrar Nabil",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Yohannes Ragil",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Audio",
                            namaKru = "Galih Adam",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Visual",
                            namaKru = "Andy Wahyu",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator Recording",
                            namaKru = "Chintya Intan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //Radio 2
                ProgramModel(
                    namaProgram = "Met Up (Meta Volume Up)",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Mengundang musisi-musisi bertalenta yang akan menampilkan karya orisinil band setiap minggunya. Episode kali ini berkonsep ‘Ruang dan Ekspresi’ yakni berbicara tentang sebuah bagian dari kehidupan (slice of life) bagi seseorang untuk mengekspresikan diri melalui musik.",
                    rating= "17+ | Music Show Radio",
                    jadwal = "Selasa, 16 Nov 2021 Pukul 13.30 WIB",
                    jenisProgram = "Music Show Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Renjani Eka Sulistiyawati",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Gezza Dwivia Eryunara",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Sukma Maya Nurul Izza",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Lintang Larissya",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Floor Director",
                            namaKru = "Gezza Dwivia Eryunara",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Zhaqia Khoerunnisa Jamila",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Coordinator Talent",
                            namaKru = "Safridayu Firauz Saifana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Unit Manager",
                            namaKru = "Arifka Ari Priana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Leonardo Andhika",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator Mixer",
                            namaKru = "Leonardo Andhika",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor vMix",
                            namaKru = "Nurshafina Febriani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Runner",
                            namaKru = "Johannes Ragil",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Runner",
                            namaKru = "Yonathan Niko Aditama",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //Radio 3
                ProgramModel(
                    namaProgram = "Soulmet (Sound of Love Meta Radio)",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Program mengangkat tema percintaan ini disiarkan untuk menghibur pendengar dengan berbagai konsep yang disajikan. Serta menyampaikan informasi dan sharing santai yang dikemas singkat, ringkas dan menarik, yang akan dipandu oleh dua orang penyiar, dengan pembawaan ceria, menyenangkan dan bisa menghibur pendengar.",
                    rating= "17+ | Variety Show Radio",
                    jadwal = "Senin, 15 Nov 2021 Pukul 13.10 WIB",
                    jenisProgram = "Variety Show Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Hafni Hidayah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Esther Pradita N.",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Shafa Noor Rahmayani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Aulia Putri K.",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Sihgi Nur Baety",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Bhedari Darmastuti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Coordinator Talent",
                            namaKru = "Esther Pradita N.",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Vista Hamidah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator Mixer",
                            namaKru = "Johanes Ragil",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator vMix",
                            namaKru = "Chintya Intan Permata S",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio Playback",
                            namaKru = "Nurshafina Febriani Putri B",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Visual",
                            namaKru = "Ramadhani Asrul Ashadi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Narasumber",
                            namaKru = "Rond Bilius Weasley",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Homeband Acustic",
                            namaKru = "Lingga",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Homeband Acustic",
                            namaKru = "Ginanjar Bimantoro",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //RADIO 4
                ProgramModel(
                    namaProgram = "Madam Meta",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Menceritakan seorang gadis remaja 20 tahunan, bernama Zefa. Zefa terkenal dengan keceriaan dan keseruannya sehingga membuat Doni selalu merasa nyaman di dekatnya. Hingga suatu hari, keadaan membuat Zefa tidak bisa menceritakan keadaan pada Doni, hal itu sangat mengejutkan Doni dan membuat dirinya merasa gagal menjadi seorang teman.",
                    rating= "18+ | Drama Radio",
                    jadwal = "Selasa, 16 Nov 2021 Pukul 12.50 WIB",
                    jenisProgram = "Drama Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Nandhira Sekar Tyasmara",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Assistant Produser",
                            namaKru = "Hidayat Nur Huda",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Nova Kamalia",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Ardita Dwi Kharunnisa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Creative",
                            namaKru = "Shodiq Latif Ihyauddin",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Foley",
                            namaKru = "M. Chandra Arifianto",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Coordinator Talent",
                            namaKru = "Ainu Anggita Putri",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Unit Manager",
                            namaKru = "Saskiya Yulfani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Abdurrahman Al Tsaani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Audio",
                            namaKru = "Bayu Antosya Harsupa",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Visual",
                            namaKru = "Ilham Robi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //RADIO 5
                ProgramModel(
                    namaProgram = "Prime News",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Merupakan program Buletin Berita yang berisi informasi maupun fenomena aktual, faktual dan terpercaya yang ada di Indonesia dan Manca Negara.Di Dalam Program \"Prime News\" ini terdiri dari Prime Sport dan Prime Update",
                    rating= "18+ | News Bulletin Radio",
                    jadwal = "Senin, 15 Nov 2021 Pukul 12.00 WIB",
                    jenisProgram = "News Bulletin Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Muhammad Dzhaki Arief",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Ass Produser Umum",
                            namaKru = "Gusti Ayu Indyra Putri",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Ass Produser Olahraga",
                            namaKru = "Gusti Ayu Indyra Putri",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Ass Produser Info Aktual",
                            namaKru = "Adila Ulfa M. R",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Anindia Dwiningtyas",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penyiar Utama",
                            namaKru = "Adinda Mega Chantika",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penyiar Olahraga",
                            namaKru = "Abiyoga Cahyo Bawono",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter",
                            namaKru = "Kartika Adi Maharani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kreatif ",
                            namaKru = "Muhammad Alif Wicaksono",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Floor Director",
                            namaKru = "Muhammad Alif Wicaksono",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Allamsyah Yusuf Kurniawan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Cameramen",
                            namaKru = "Fernanda Alrasyid",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator vMix",
                            namaKru = "Allamsyah Yusuf Kurniawan",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Fernanda Alrasyid",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Mustafa Kharis",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Sefrian Swandana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //RADIO 6
                ProgramModel(
                    namaProgram = "BIAS (Bicara Apa Saja)",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Dialog yang mengulas berbagai sisi dari peristiwa yang sedang ramai diperbincangkan publik bersama narasumber dan kolaborasi bersama sederet media radio serta tak lupa interaksi bersama pendengar. \"dari Bias jadi Jelas\", menjadi goals dari Program \"Bias\"",
                    rating= "18+ | Talkshow Radio",
                    jadwal = "Selasa, 16 Nov 2021 Pukul 12.00 WIB",
                    jenisProgram = "Talkshow Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Octavian Dwi Prasetyo",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Nur Fauziah Arini Eka Putri Rahmawati",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Laily Fajriyanti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Announcer",
                            namaKru = "Nur Fauziah Arini Eka Putri Rahmawati",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Octavian Dwi Prasetyo",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter",
                            namaKru = "Laily Fajriyanti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kreatif",
                            namaKru = "Afifah Nur Sylvani",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Refangga Maulana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Galih Adam",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Camera Person",
                            namaKru = "Ikhsan Hanif",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Ikhsan Hanif",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Operator vMix",
                            namaKru = "Refangga Maulana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Visual",
                            namaKru = "Sefrian Swandana",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            " VolunteerRiset",
                            namaKru = "Mahardika Zenar Auliya",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //RADIO 7
                ProgramModel(
                    namaProgram = "Sorot Fakta",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Menguak fakta suatu peristiwa/kasus yang janggal ditengah masyarakat sehingga masyarakat dapat mengetahui kebenaran dibalik suatu peristiwa tersebut. Program Investigasi “Sorot Fakta” juga akan mendatangkan reporter untuk bercerita perjalanannya dalam menyelidiki kasus dan korban dari kejanggalan peristiwa ke studio untuk mendapatkan informasi yang valid.",
                    rating= "19+ | Investigasi Radio",
                    jadwal = "Senin, 15 Nov 2021 Pukul 12.35 WIB",
                    jenisProgram = "Investigasi Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Irvan Nur Prasetyo",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Alfi Dhamayanti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Ida Setyaningsih",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter",
                            namaKru = "Salsabila Ivaryagidea Aisya Putri",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Reporter",
                            namaKru = "Ida Setyaningsih",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kreatif",
                            namaKru = "Ferdiansyah Agung Riyadi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Printa Fitriana Suriyanto",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Salsabila Ivaryagidea Aisya Putri",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "M. Syaiful Hadi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Mustafa Kharis Syaiful Yahya",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Visual",
                            namaKru = "Yahya Nur Fahmi Fauzi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "Yonathan Niko Aditama",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
                ),
                //RADIO 8
                ProgramModel(
                    namaProgram = "Asumsi",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Mengupas isu terkini dari pandangan media \"Meta Radio\" melalui, dialog penyiar bersama pemimpin redaksi yang tentunya berdasarkan fakta dan didukung data serta mencari solusi fakta dan data dari fenomena yang terjadi. Program \"Asumsi\" juga akan membuka interaksi bersama pendengar untuk bisa bersuara terkait topik yang dibahas.",
                    rating= "18+ | Editorial Radio",
                    jadwal = "Selasa, 16 Nov 2021 Pukul 13.10 WIB",
                    jenisProgram = "Editorial Radio",
                    fotoPembawaAcara = R.drawable.ic_launcher_background,
                    detilPembawaAcara="Coldilac adalah bla bla bla?????",
                    kruJobdesk = arrayListOf(
                        //CONTOH DATA JOBDESK
                        JobdeskModel(
                            "Produser",
                            namaKru = "Septiani Media Sari",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Program Director",
                            namaKru = "Dio Rahadi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Penulis Naskah",
                            namaKru = "Dian Hastuti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Announcer",
                            namaKru = "Dian Hastuti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Riset",
                            namaKru = "Dian Hastuti",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Kreatif",
                            namaKru = "Ferdiansyah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Floor Director",
                            namaKru = "Ferdiansyah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Technical Director",
                            namaKru = "Dega Azka Riza",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Camera Person",
                            namaKru = "Dega Azka Riza",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Camera Person",
                            namaKru = "Bima Triwandha Fianarmada",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Camera Person",
                            namaKru = "Daffa Siraj Khairullah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "Dega Azka Riza",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Audio",
                            namaKru = "M.Iham Affandi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Lighting",
                            namaKru = "M.Iham Affandi",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Audio",
                            namaKru = "Bima Triwandha Fianarmada",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor Visual",
                            namaKru = "Bima Triwandha Fianarmada",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Editor",
                            namaKru = "Rakha Ananta Luvian",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                        JobdeskModel(
                            "Streamer",
                            namaKru = "Daffa Siraj Khairullah",
                            resourceImage = R.drawable.ic_launcher_background
                        ),
                    )
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