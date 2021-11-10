package com.example.scalaracademy.data.dataSources

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.data.models.photosDataSource.PhotoResponseItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class PhotoDataSource(private val apiService: ScalarInterface, private val compositeDisposable : CompositeDisposable) {
    private val _downloadedMutableLiveDataPhotoResponse = MutableLiveData<List<PhotoResponseItem>>()
    val liveDataPhotoList : LiveData<List<PhotoResponseItem>>
        get() = _downloadedMutableLiveDataPhotoResponse

    fun fetchAlbums(id : Int)
    {
        try {
            compositeDisposable.add(apiService.getPhotos(id)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            {
                                Log.e("AlbumList DataSource", "fetchUsers: success  ")
                                _downloadedMutableLiveDataPhotoResponse.postValue(it)

                            },{
                        Log.e("AlbumList DataSource", "fetchUsers: Throwable  "+it.message )
                    }
                    ))
        }catch (e: Exception)
        {
            Log.e("AlbumList DataSource", "fetchUsers: "+e.message )
        }
    }
}