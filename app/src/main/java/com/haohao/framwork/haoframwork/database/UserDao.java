package com.haohao.framwork.haoframwork.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Query("SELECT * FROM UserBean")
    Flowable<List<UserBean>> getAllList();

    @Query("SELECT * FROM UserBean where login_name =:name")
    Flowable<UserBean> getPwd(String name);

    @Insert
    void insert(UserBean... users);

    @Update
    void update(UserBean... users);

    @Delete
    void delete(UserBean... users);
}
