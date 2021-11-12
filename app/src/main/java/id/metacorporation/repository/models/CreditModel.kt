package id.metacorporation.repository.models


import com.google.gson.annotations.SerializedName

data class CreditModel(
    @SerializedName("kru")
    val kru: List<Kru>,
    @SerializedName("namaDivisi")
    val namaDivisi: String
)