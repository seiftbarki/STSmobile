package com.example.stsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "abonne_db";
    public static final String TABLE_ABONNE = "abonne";
    public static final String COL_ID = "_id";
    public static final String COL_CIN = "cin";
    public static final String COL_NP = "nompren";
    public static final String COL_PHONE = "phone";
    public static final String COL_ADRESSE = "adresse";
    public static final String COL_EMAIL = "email";
    public static final String COL_LOGIN = "login";
    public static final String COL_password = "password";

    public static final String CREATE_ABONNE_TABLE = "CREATE TABLE " +
            TABLE_ABONNE + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_CIN + " TEXT NOT NULL, " +COL_NP+" TEXT NOT NULL, "+COL_PHONE+" TEXT NOT NULL, "+
            COL_ADRESSE+" TEXT NOT NULL, "+COL_EMAIL+" TEXT NOT NULL, "+COL_LOGIN+" TEXT NOT NULL, "+COL_password + " TEXT) ";
    private SQLiteDatabase db;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ABONNE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF exists " + TABLE_ABONNE);
        onCreate(db);
    }

    public SQLiteDatabase open() {
        db = this.getWritableDatabase();
        return db;
    }

    public void addStudent(abonne a) {
        open();
        ContentValues v = new ContentValues();
        v.put(COL_CIN, a.getCin());
        v.put(COL_NP, a.getNompren());
        v.put(COL_PHONE, a.getPhone());
        v.put(COL_ADRESSE, a.getAdresse());
        v.put(COL_EMAIL, a.getEmail());
        v.put(COL_LOGIN, a.getLogin());
        v.put(COL_password, a.getPassword());
        db.insert(TABLE_ABONNE, null, v);
    }

    public void updateStudent(abonne a) {
        open();
        ContentValues v = new ContentValues();
        v.put(COL_CIN, a.getCin());
        v.put(COL_NP, a.getNompren());
        v.put(COL_PHONE, a.getPhone());
        v.put(COL_ADRESSE, a.getAdresse());
        v.put(COL_EMAIL, a.getEmail());
        v.put(COL_LOGIN, a.getLogin());
        v.put(COL_password, a.getPassword());
        db.update(TABLE_ABONNE, v, COL_ID + "=?", new String[]{String.valueOf(a.getId())});
    }

    public void removeStudent(int id) {
        open();
        db.delete(TABLE_ABONNE, COL_ID + "=?", new String[]{String.valueOf(id)});
    }
    public Boolean checkusernamepassword(String login,String password){
        open();
        Cursor c=db.rawQuery("select * from TABLE_ABONNE where COL_LOGIN = ? and COL_password =?",new String[]{login,password});
        if(c.getCount()>0)
            return true;
        else
            return false;

    }


}
