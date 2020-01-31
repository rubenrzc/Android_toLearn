package com.example.tolearn.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * @Author Andoni
 * This class take care of SQLite
 */
public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbUser";
    private static final String USER_TABLE = "userTable";
    private static final int DATABASE_VERSION = 1;
    private LocalUser localUser = null;
    private SQLiteDatabase sqLiteDatabase = getWritableDatabase();

    public ConexionSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * it creats the USER_TABLE
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + USER_TABLE +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT NOT NULL" +
                ", pwd TEXT NOT NULL, remember NUMBER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    /**
     * This method takes care of insert or update
     * the LocalUser on the USER_TABLE
     * @param user LocalUser type object
     */
    public void insertUser(LocalUser user) {
        if(findUser()==null) {
            sqLiteDatabase.insert(USER_TABLE, null, user.insertValues());
        } else {
            sqLiteDatabase.update(USER_TABLE,user.insertValues(),"_id = 1",null);
        }

    }

    /**
     * LocalUser getter method
     * @return LocalUser object
     */
    public LocalUser getUser() {
        return findUser();
    }

    /**
     * This method return the last
     * user on the device
     * @return LocalUser object
     */
    public LocalUser findUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        LocalUser user = null;

        Cursor cursor = db.query(USER_TABLE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            user = new LocalUser(cursor.getString(cursor.getColumnIndex("username")), cursor.getString(cursor.getColumnIndex("pwd")), cursor.getInt(cursor.getColumnIndex("remember")));
        }
        return user;
    }

    /**
     * This method change the
     * user.remember to 0
     */
    public void changeToNoRemember(){
        LocalUser user = null;
        user = findUser();
        if (user!=null) {
            if(user.getRemember()==1){
                user.setRemember(0);
                sqLiteDatabase.update(USER_TABLE,user.insertValues(),"_id = 1",null);
            }
        }
    }


}
