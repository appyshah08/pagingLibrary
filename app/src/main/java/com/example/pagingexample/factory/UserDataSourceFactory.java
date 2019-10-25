package com.example.pagingexample.factory;




import com.example.pagingexample.datasource.UserDataSource;
import com.example.pagingexample.model.User;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class UserDataSourceFactory extends DataSource.Factory<Long, User> {

    public MutableLiveData<UserDataSource> userLiveDataSource=new MutableLiveData<>();

    @Override
    public DataSource<Long, User> create() {
        UserDataSource userDataSource = new UserDataSource();
        userLiveDataSource.postValue(userDataSource);
        return userDataSource;
    }
}
