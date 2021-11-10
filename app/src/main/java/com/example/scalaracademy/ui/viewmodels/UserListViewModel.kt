package com.example.scalaracademy.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.scalaracademy.data.api.ScalarInterface
import com.example.scalaracademy.data.dataSources.UsersDataSource
import com.example.scalaracademy.data.models.usermodels.UserResponseItem
import io.reactivex.disposables.CompositeDisposable

class UserListViewModel(application: Application) : AndroidViewModel(application)
{
    private val compositeDisposable= CompositeDisposable()
    private lateinit var usersDataSource : UsersDataSource

    fun fetchUsersList(apiService: ScalarInterface) : LiveData<List<UserResponseItem>>
    {
        usersDataSource = UsersDataSource(apiService , compositeDisposable)
        usersDataSource.fetchUsers()
        return usersDataSource.liveDataUserList
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}