package com.example.samsung.linben;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Raquel on 28/06/2016.
 */
public class Usuario extends _Default {

    private int id;
    private String nome;
    private String tipo_sanguineo;
    private String genero;
    private String data_nascimento;
    private String email;
    private String senha;
   // private String estado;
    //private String cidade;


    public Usuario(){
        super();
        this.id = -1;
        this.nome = "";
        this.tipo_sanguineo = "";
        this.genero = "";
        this.data_nascimento = "";
        this.email = "";
        this.senha = "";
       // this.estado = "";
       // this.cidade = "";
    }

    public ArrayList<Usuario> getLista(){
        DB db = new DB();
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            ResultSet resultSet = db.select("SELECT * FROM usuario");
            if (resultSet != null){
                while (resultSet.next()){
                    Usuario obj = new Usuario();
                    obj.setId(resultSet.getInt("id"));
                    obj.setNome(resultSet.getString("nome"));
                    obj.setTipo_sanguineo(resultSet.getString("tipo_sanguineo"));
                    //obj.setGenero(resultSet.getString("genero"));
                    //obj.setData_nascimento(resultSet.getString("data_nascimento"));
                    obj.setEmail(resultSet.getString("email"));
                    obj.setSenha(resultSet.getString("senha"));
                    //obj.setEstado(resultSet.getString("estado"));
                    //obj.setCidade(resultSet.getString("cidade"));
                    lista.add(obj);
                    obj = null;
                }

            }
        }catch (Exception ex){
            this._mensagem = ex.getMessage();
            this._status = false;
        }
        return lista;
    }


    public  void salvar(){
        String comando = "";
        if (this.getId() == -1){
            comando = String.format("INSERT INTO usuario (nome, email, senha, tipo_sanguineo) VALUES ('%s', '%s', '%s', '%s'); ",
                    this.getNome(), this.getEmail(), this.getSenha(), this.getTipo_sanguineo());
        }else{
            comando = String.format("UPDATE usuario SET nome = '%s', email = '%s', senha = '%s', tipo_sanguineo = '%s' WHERE id = %d;",
                    this.getNome(), this.getEmail(), this.getSenha(), this.getTipo_sanguineo(), this.getId());
        }
        DB db = new DB();
        db.execute(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }

    public void apagar (){
        String comando = String.format("DELETE FROM usuario WHERE id = %d;", this.getId());
        DB db = new DB();
        db.execute(comando);
        this._mensagem = db._mensagem;
        this._status = db._status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

   /* public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

  /*  public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }*/
}
