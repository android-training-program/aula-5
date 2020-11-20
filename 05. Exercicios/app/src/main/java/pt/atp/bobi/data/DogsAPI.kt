package pt.atp.bobi.data

import pt.atp.bobi.data.model.Breed
import pt.atp.bobi.data.model.Search
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DogsAPI {

    @Headers("x-api-key: $API_KEY")
    @GET(BREEDS)
    fun getBreedsList(): Call<List<Breed>>

    @Headers("x-api-key: $API_KEY")
    @GET(SEARCH)
    fun getBreedImage(@Query(IMAGES_INCLUDE_BREED) id: String,
                      @Query(IMAGES_BREED_ID) breedId: String): Call<List<Search>>
}