package pt.atp.bobi.presentation.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import pt.atp.bobi.EXTRA_DOG_BREED
import pt.atp.bobi.EXTRA_DOG_NAME
import pt.atp.bobi.R
import pt.atp.bobi.data.DogsAPIClient
import pt.atp.bobi.data.cb.DataSearched
import pt.atp.bobi.data.model.Search

private const val TAG = "DetailsActivity"

class DetailsActivity : AppCompatActivity(), DataSearched {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setup()
    }

    private fun setup() {
        val name = intent.getStringExtra(EXTRA_DOG_NAME)
        title = name

        val breedId = intent.getStringExtra(EXTRA_DOG_BREED)
        DogsAPIClient.getBreedImage(breedId!!, this)
    }

    //region DataSearched

    override fun onDataSearchedSuccess(search: List<Search>) {
        if (search.isNotEmpty()) {
            val dog = search[0]

            Glide.with(this)
                .load(dog.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(findViewById(R.id.iv_dog))

            findViewById<TextView>(R.id.tv_name).text = dog.breed[0].name
            findViewById<TextView>(R.id.tv_temperament).text = dog.breed[0].temperament

        } else {
            Log.w(TAG, "No image found")
        }
    }

    override fun onDataSearchedFailed() {
        Log.e(TAG, "Unable to retrieve image data")
    }

    //endregion
}