package com.example.scalaracademy.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.data.dataSources.AlbumDataSource
import com.example.scalaracademy.data.models.albummodels.AlbumResponseItem
import io.reactivex.disposables.CompositeDisposable

class AlbumListViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable= CompositeDisposable()
    private lateinit var albumsDataSource : AlbumDataSource

    fun fetchUsersList(apiService: ScalarInterface , id :Int ) : LiveData<List<AlbumResponseItem>>
    {
        albumsDataSource = AlbumDataSource(apiService , compositeDisposable)
        albumsDataSource.fetchAlbums(id)
        return albumsDataSource.liveDataAlbumList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}