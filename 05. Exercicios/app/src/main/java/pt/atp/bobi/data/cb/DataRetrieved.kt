package pt.atp.bobi.data.cb

import pt.atp.bobi.data.model.Breed

interface DataRetrieved {

    fun onDataFetchedSuccess(breeds: List<Breed>)

    fun onDataFetchedFailed()
}