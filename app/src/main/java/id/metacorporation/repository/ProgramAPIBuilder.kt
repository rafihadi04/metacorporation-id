package id.metacorporation.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProgramAPIBuilder{
    companion object{
        private var retrofit : Retrofit? = null
        private const val BASE_URL: String = "https://api.jsonstorage.net/v1/json/"
        fun getProgramAPI() : Retrofit {
            if(retrofit==null){
                retrofit= Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}