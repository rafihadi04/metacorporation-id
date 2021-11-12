package id.metacorporation.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProgramAPIBuilder{
    companion object{
        private var retrofit : Retrofit? = null
        private const val BASE_URL: String = "https://metacorporation.id/"
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