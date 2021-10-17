package id.metacorporation.models

class ProgramModel (
    var namaProgram: String = "",
    var resource: Int = 0,
    var urlImage :String = "",
    var urlTeaser :String = "",
    var deskripsiProgram :String = "",
    var urlBannerImage :String = "",
    var jam :String = "18:00",
    var kruJobdesk :ArrayList<JobdeskModel> = arrayListOf()
) {
}