package com.haohao.framwork.haoframwork.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserBean.class}, version = 1, exportSchema = false)
public abstract class StrokeDataBase extends RoomDatabase {
    private static final String DB_NAME = "UserDatabase.db";
    private static volatile StrokeDataBase instance;

    public static synchronized StrokeDataBase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static StrokeDataBase create(final Context context) {
        return Room.databaseBuilder(
                        context,
                        StrokeDataBase.class,
                        DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }


    public abstract UserDao getUserDao();


}
