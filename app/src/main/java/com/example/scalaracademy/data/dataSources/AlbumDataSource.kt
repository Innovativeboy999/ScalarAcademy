package com.example.scalaracademy.data.dataSources

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.data.models.albummodels.AlbumResponseItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class AlbumDataSource(private val apiService: ScalarInterface, private val compositeDisposable : CompositeDisposable) {
    private val _downloadedMutableLiveDataUsersResponse = MutableLiveData<List<AlbumResponseItem>>()
    val liveDataAlbumList : LiveData<List<AlbumResponseItem>>
        get() = _downloadedMutableLiveDataUsersResponse

    fun fetchAlbums(id : Int)
    {
        try {
            compositeDisposable.add(apiService.getAlbumList(id)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.e("AlbumList DataSource", "fetchUsers: success  ")
                        _downloadedMutableLiveDataUsersResponse.postValue(it)

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