package com.example.samsung.linben;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.samsung.linben.database.DataBase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.example.samsung.linben.dominio.RepositorioUsuario;
import com.example.samsung.linben.dominio.entidades.Usuario;

/**
 * Created by Raquel on 12/05/2016.
 */
public class CadastroActivity extends AppCompatActivity {
    private int ano, mes, dia;
    Button dataNascimento;



    private Button btn_voltar;
    private Button btn_continuar;
    private Button btn_salvar;
    private Usuario usuario;
    private DataBase database;
    private SQLiteDatabase conn;
    private RepositorioUsuario repositorioUsuario;


    private EditText nome;
    private EditText email;
    private EditText senha;
    private Spinner sexo;
    private Spinner sangue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //verifica se a tela mandou dados para a outra



        try {
            database = new DataBase(this);
            conn = database.getWritableDatabase();

            repositorioUsuario = new RepositorioUsuario(conn);
        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }


        this.usuario = new Usuario();

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_continuar = (Button) findViewById(R.id.continuar);
        btn_salvar = (Button) findViewById(R.id.bt_salvar);

        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.t_senha);
        sexo = (Spinner) findViewById(R.id.sexo);
        sangue = (Spinner) findViewById(R.id.sangue);

        Calendar calendar = Calendar.getInstance();
        this.ano = calendar.get(Calendar.YEAR);
        this.mes = calendar.get(Calendar.MONTH);
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);
        this.dataNascimento = (Button) findViewById(R.id.data);
        dataNascimento.setText(dia + "/" + (mes+1) + "/" + ano);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                 this, R.array.tipo_sanguineo,
         android.R.layout.simple_spinner_item);
         sangue = (Spinner) findViewById(R.id.sangue);
         sangue.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.sexo,
                android.R.layout.simple_spinner_item);
        sexo = (Spinner) findViewById(R.id.sexo);
        sexo.setAdapter(adapter1);


        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );



        btn_salvar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              if (usuario == null){
                                                  inserir();
                                                  Toast.makeText(CadastroActivity.this, "Usuário cadastrado", Toast.LENGTH_LONG).show();
                                                  Intent i = new Intent(CadastroActivity.this,   TesteActivity.class);
                                                  startActivity(i);

                                              }



                                          }
        }


        );


    }



    public void selecionarData(View view){
        showDialog(view.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(R.id.data == id){
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {
            ano = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            dataNascimento.setText(dia + "/" + (mes+1) + "/" + ano);
        }
    };

     private void inserir(){
         try{
             usuario = new Usuario();

             usuario.setNome(nome.getText().toString());
             usuario.setEmail(email.getText().toString());
             usuario.setSenha(senha.getText().toString());
             usuario.setGenero("");
             usuario.setTipo_sanguineo("");

             Date data = new Date();
             usuario.setData_nascimento(data);

         }catch (Exception ex){

             AlertDialog.Builder dlg = new AlertDialog.Builder(this);
             dlg.setMessage("Erro ao inserir os dados!" + ex.getMessage());
             dlg.setNegativeButton("OK", null);
             dlg.show();

         }





     }





}


