package com.example.samsung.linben.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Raquel on 09/06/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "Usuario.db";
    private static final String TABLE_NAME = "usuario_table";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "NOME";
    private static final String COL_3 = "DATA_NASCIMENTO";
    private static final String COL_4 = "EMAIL";
    private static final String COL_5 = "SENHA";


    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + TABLE_NAME +" (ID INTERGER PRIMARY KEY AUTOINCREMENT, NOME TEXT, DATA_NASCIMENTO DATE, EMAIL TEXT, SENHA TEXT)");

                //"estado TEXT, cidade TEXT");

               // "tipo_sanguíneo CHECK (tipo IN ('A+', 'A-’, 'B+', 'B-’, 'O+', 'O-’, 'AB+', 'AB-’)), genero CHECK (tipo IN ('Feminino', 'Masculino'))");

        /*db.execSQL("CREATE TABLE gotinha (id NUMBER PRIMARY KEY);");

        db.execSQL("CREATE TABLE usuario_tem_amizade (id_usuario NUMBER PRIMARY KEY," + "id_amigo NUMBER PRIMARY KEY," + "FOREIGN KEY(id_usuario) REFERENCES usuario(id)," +
                "FOREIGN KEY(id_amigo) REFERENCES usuario(id));");

        db.execSQL("CREATE TABLE doador (id NUMBER PRIMARY KEY," + "id_gotinha NUMBER," + "FOREIGN KEY(id_gotinha) REFERENCES gotinha(id)," +
                "FOREIGN KEY(id) REFERENCES usuario(id));");

        db.execSQL("CREATE TABLE receptor (id NUMBER PRIMARY KEY," + "FOREIGN KEY(id) REFERENCES usuario(id));");

        db.execSQL("CREATE TABLE causa (id NUMBER PRIMARY KEY);");

        db.execSQL("CREATE TABLE apoiar (id_doador NUMBER PRIMARY KEY," + "id_causa NUMBER PRIMARY KEY," + "FOREIGN KEY(id_doador) REFERENCES doador(id)," +
                "FOREIGN KEY(id_causa) REFERENCES causa(id));");

        db.execSQL("CREATE TABLE doar (id_doador NUMBER PRIMARY KEY," + "id_causa NUMBER PRIMARY KEY," + "horario DATE," + "FOREIGN KEY(id_doador) REFERENCES doador(id)," +
                "FOREIGN KEY(id_causa) REFERENCES causa(id));");

        db.execSQL("CREATE TABLE criar (id_receptor NUMBER PRIMARY KEY," + "id_causa NUMBER PRIMARY KEY," + "descricao TEXT, hemocentro TEXT" + "FOREIGN KEY(id_receptor) REFERENCES receptor(id)," +
                "FOREIGN KEY(id_causa) REFERENCES causa(id));");

        db.execSQL("CREATE TABLE acao (id NUMBER PRIMARY KEY," + "id_quem_agiu NUMBER, id_sofreu_acao NUMBER" + "horario DATE, tipo TEXT" + "FOREIGN KEY(id_quem_agiu) REFERENCES usuario(id)," +
                "FOREIGN KEY(id_sofreu_acao) REFERENCES usuario(id));");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}


