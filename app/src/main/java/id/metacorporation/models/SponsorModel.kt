package id.metacorporation.models

class SponsorModel(
    val res: Int,
    val ukuran :Size
){
    companion object{
        enum class Size {
            S,
            M,
            L,
            XL
        }
    }
}