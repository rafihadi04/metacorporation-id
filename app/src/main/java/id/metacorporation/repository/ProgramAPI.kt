package id.metacorporation.repository

import id.metacorporation.repository.models.CreditModel
import id.metacorporation.repository.models.ProgramLink
import retrofit2.Call
import retrofit2.http.GET

interface ProgramAPI {
    @GET("program.json")
    fun getProgramUrl() : Call<ArrayList<ProgramLink>>
    @GET("creditTitle.json")
    fun getCreditTitle() : Call<ArrayList<CreditModel>>
}