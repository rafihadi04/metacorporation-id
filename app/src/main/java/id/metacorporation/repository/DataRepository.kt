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
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
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
                    namaProgram = "lensa Bulletin",
                    resource = R.drawable.ic_launcher_background,
                    urlBannerImage = "https://images.pexels.com/photos/7078048/pexels-photo-7078048.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260",
                    urlTeaser = "pOWuBM2RNmI",
                    deskripsiProgram = "Menghadirkan berita dengan berbagai format penyajian, live report atau laporan langsung, dan dialog yang berisi informasi secara menyeluruh dari beberapa daerah di Indonesia. Dibagi kedalam tiga segmentasi, yaitu segmen berita umum, dialog, dan rubrik.",
                    rating= "17+ | News Bulletin",
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
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
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
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
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
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
                    jadwal = "Rabu, 17 Okt 2021 Pukul 16.00 WIB",
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