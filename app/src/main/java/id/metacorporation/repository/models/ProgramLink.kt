package id.metacorporation.repository.models


import com.google.gson.annotations.SerializedName

data class ProgramLink(
    @SerializedName("linkYT")
    val linkYT: String,
    @SerializedName("Media")
    val media: String,
    @SerializedName("Program")
    val program: String?
)