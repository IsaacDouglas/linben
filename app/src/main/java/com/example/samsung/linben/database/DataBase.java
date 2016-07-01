package com.example.samsung.linben.database;
import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Raquel on 01/07/2016.
 */
public class DataBase extends SQLiteOpenHelper{

    public DataBase(Context context){

        super(context, "linbenDB", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScriptSQL.getCreateUsuario());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
