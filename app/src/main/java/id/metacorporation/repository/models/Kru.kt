package id.metacorporation.repository.models


import com.google.gson.annotations.SerializedName

data class Kru(
    @SerializedName("jobdesk")
    val jobdesk: String,
    @SerializedName("nama")
    val nama: String
)