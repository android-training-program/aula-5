package pt.atp.bobi.data

import android.util.Log
import pt.atp.bobi.data.cb.DataRetrieved
import pt.atp.bobi.data.model.Breed
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pt.atp.bobi.data.cb.DataSearched
import pt.atp.bobi.data.model.Search
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "DogApi"

object DogsAPIClient {

    private val apiDog by lazy {
        setup()
    }

    fun getListOfBreeds(listener: DataRetrieved? = null) {
        apiDog.getBreedsList().enqueue(object : Callback<List<Breed>> {

            override fun onResponse(call: Call<List<Breed>>, response: Response<List<Breed>>) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "code: " + response.code())
                    return
                }

                listener?.onDataFetchedSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<List<Breed>>, t: Throwable) {
                Log.e(TAG, "Unable to get dogs breed. Error: ${t.message}")
                listener?.onDataFetchedFailed()
            }
        })
    }

    fun getBreedImage(breedId: String, listener: DataSearched) {
        apiDog.getBreedImage("1", breedId).enqueue(object : Callback<List<Search>> {

            override fun onResponse(call: Call<List<Search>>, response: Response<List<Search>>) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "code: " + response.code())
                    return
                }

                listener.onDataSearchedSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<List<Search>>, t: Throwable) {
                Log.e(TAG, "Unable to get breed image. Error: ${t.message}")
            }
        })
    }

    private fun setup(): DogsAPI {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        return retrofit.create()
    }

}