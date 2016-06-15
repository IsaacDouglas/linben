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

    private static final String DATABASE = "mydb";

    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario(id INTEGER PRIMARY KEY," + "nome TEXT, data_nascimento DATE," +
                "email TEXT, senha TEXT," + " id_gotinha NUMBER, id_causa NUMBER, id_amigo NUMBER, estado TEXT, cidade TEXT" +
                "id_causas_apoiadas NUMBER, tipo_sanguíneo CHECK (tipo IN ('A+', 'A-’, 'B+', 'B-’, 'O+', 'O-’, 'AB+', 'AB-’)), genero CHECK (tipo IN ('Feminino', 'Masculino'))," +
                "FOREIGN KEY(id_gotinha) REFERENCES gotinha(id)," + "FOREIGN KEY(id_causa) REFERENCES causa(id)," +
                "FOREIGN KEY(id_amigo) REFERENCES usuario(id)," + "FOREIGN KEY(id_causas_apoiadas) REFERENCES causa(id));");

        db.execSQL("CREATE TABLE gotinha (id NUMBER PRIMARY KEY);");

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
                "FOREIGN KEY(id_sofreu_acao) REFERENCES usuario(id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


