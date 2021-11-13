package id.metacorporation.repository

import id.metacorporation.repository.models.CreditModel
import id.metacorporation.repository.models.ProgramLink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProgramAPI {
    @GET("febcd8af-8fb5-47b3-8a04-a5657dbfae4d")//@GET("program.json")
    fun getProgramUrl(@Query("apiKey") apiKey :String) : Call<ArrayList<ProgramLink>>
    @GET("b65578f9-a025-48db-a9af-91b455633ad1")//@GET("creditTitle.json")
    fun getCreditTitle(@Query("apiKey") apiKey :String) : Call<ArrayList<CreditModel>>
}