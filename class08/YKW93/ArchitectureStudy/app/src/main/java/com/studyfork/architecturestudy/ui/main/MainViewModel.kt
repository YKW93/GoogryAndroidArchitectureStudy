package com.studyfork.architecturestudy.ui.main

import androidx.lifecycle.MutableLiveData
import com.studyfork.architecturestudy.R
import com.studyfork.architecturestudy.base.BaseViewModel
import com.studyfork.architecturestudy.common.ResourceProvider
import com.studyfork.architecturestudy.data.model.MovieResponse
import com.studyfork.architecturestudy.data.repository.MovieRepository

class MainViewModel(
    private val movieRepository: MovieRepository,
    private val resourceProvider: ResourceProvider
) : BaseViewModel() {

    val movieDataList: MutableLiveData<List<MovieResponse.Item>> = MutableLiveData()
    val searchText: MutableLiveData<String> = MutableLiveData()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val hidesKeyboard: MutableLiveData<Boolean> = MutableLiveData()

    private fun requestMovieData() {
        val query: String? = searchText.value

        if (query.isNullOrEmpty()) {
            showToast(resourceProvider.getString(R.string.empty_query_notice))
            return
        } else {
            movieRepository.getMovieList(query, {
                isLoading.value = it
            }, {
                if (it.total != 0) {
                    movieDataList.value = it.items
                } else {
                    showToast(resourceProvider.getString(R.string.empty_data_notice))
                }
            }, {
                it.printStackTrace()
            }).addDisposable()
        }
    }

    fun loadMovieData() {
        hidesKeyboard.value = true
        requestMovieData()
    }

    fun showKeyboard() {
        hidesKeyboard.value = false
    }
}
