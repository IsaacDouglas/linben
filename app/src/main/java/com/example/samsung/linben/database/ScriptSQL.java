package com.example.samsung.linben.database;

/**
 * Created by Raquel on 01/07/2016.
 */
public class ScriptSQL {

    public static String getCreateUsuario(){

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE usuario(");
        sqlBuilder.append("id integer PRIMARY KEY Autoincrement,");
        sqlBuilder.append("nome VARCHAR(40) NOT NULL,");
        sqlBuilder.append("email VARCHAR(20) NOT NULL,");
        sqlBuilder.append("senha VARCHAR(10) NOT NULL,");
        sqlBuilder.append("tipo_sanguineo VARCHAR(3) NOT NULL,");
        sqlBuilder.append("genero VARCHAR(10) NOT NULL,");
        sqlBuilder.append("data_nascimento DATE NOT NULL");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }


}
