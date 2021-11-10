package com.example.scalaracademy.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.data.dataSources.PhotoDataSource
import com.example.scalaracademy.data.models.photosDataSource.PhotoResponseItem
import io.reactivex.disposables.CompositeDisposable

class PhotoViewModel (application: Application) : AndroidViewModel(application) {

    private val compositeDisposable= CompositeDisposable()
    private lateinit var photoDataSource : PhotoDataSource

    fun fetchUsersList(apiService: ScalarInterface, id :Int ) : LiveData<List<PhotoResponseItem>>
    {
        photoDataSource = PhotoDataSource(apiService , compositeDisposable)
        photoDataSource.fetchAlbums(id)
        return photoDataSource.liveDataPhotoList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}