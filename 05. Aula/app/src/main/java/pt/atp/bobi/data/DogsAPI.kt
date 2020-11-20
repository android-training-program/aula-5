package pt.atp.bobi.data

import pt.atp.bobi.data.model.Breed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DogsAPI {

    @Headers("x-api-key: $API_KEY")
    @GET(BREEDS)
    fun getBreedsList(): Call<List<Breed>>
}