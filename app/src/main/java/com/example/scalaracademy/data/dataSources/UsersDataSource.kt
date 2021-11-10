package com.example.scalaracademy.data.dataSources

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.data.models.usermodels.UserResponseItem
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


class UsersDataSource(private val apiService:ScalarInterface , private val compositeDisposable : CompositeDisposable) {
    private val _downloadedMutableLiveDataUsersResponse = MutableLiveData<List<UserResponseItem>>()
    val liveDataUserList : LiveData<List<UserResponseItem>>
    get() = _downloadedMutableLiveDataUsersResponse

    fun fetchUsers()
    {
        try {
            compositeDisposable.add(apiService.getUsersList()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        Log.e("UserList DataSource", "fetchUsers: success  ")
                        _downloadedMutableLiveDataUsersResponse.postValue(it)

                    },{
                        Log.e("UserList DataSource", "fetchUsers: Throwable  "+it.message )
                    }
                ))
        }catch (e:Exception)
        {
            Log.e("UserList DataSource", "fetchUsers: "+e.message )
        }
    }
}