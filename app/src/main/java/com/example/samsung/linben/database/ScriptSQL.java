package com.example.samsung.linben.database;

/**
 * Created by Raquel on 01/07/2016.
 */
public class ScriptSQL {

    public static String getCreateUsuario(){

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE usuario(");
        sqlBuilder.append("id integer NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("nome VARCHAR(40),");
        sqlBuilder.append("email VARCHAR(20),");
        sqlBuilder.append("senha VARCHAR(10) ,");
        sqlBuilder.append("tipo_sanguineo VARCHAR(3),");
        sqlBuilder.append("genero VARCHAR(10),");
        sqlBuilder.append("data_nascimento DATE ");
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }


}
