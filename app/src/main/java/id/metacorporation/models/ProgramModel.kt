package id.metacorporation.models

class ProgramModel (
    var namaProgram: String = "",
    var resource: Int = 0,
    var urlImage :String = "",
    var urlTeaser :String? = null,
    var deskripsiProgram :String = "",
    var urlBannerImage :String? = null,
    var resourceBanner: Int = 0,
    var jam :String = "18:00",
    var kruJobdesk :ArrayList<JobdeskModel> = arrayListOf(),
    var pengisiAcara :ArrayList<JobdeskModel> = arrayListOf(),
    val jadwal :String = "NULL",
    val rating :String = "NULL",
    val jenisProgram :String = "NULL",
    val detilPembawaAcara :String = "NULL",
    val fotoPembawaAcara :Int = 0,
)