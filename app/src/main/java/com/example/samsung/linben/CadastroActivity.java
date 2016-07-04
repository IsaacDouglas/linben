package com.example.samsung.linben;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.samsung.linben.database.DataBase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.samsung.linben.entidades.Usuario;

/**
 * Created by Raquel on 12/05/2016.
 */
public class CadastroActivity extends AppCompatActivity {
    private int ano, mes, dia;
    Button dataNascimento;

    private Button btn_voltar;
    private Button btn_salvar;
    private Usuario usuario;
    private DataBase database;
    private SQLiteDatabase dbActions;


    private EditText nome;
    private EditText email;
    private EditText senha;
    private Spinner genero;
    private Spinner tipo_sanguineo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //verifica se a tela mandou dados para a outra
        usuario = new Usuario();


        try {
            database = new DataBase(this);
            dbActions = database.getWritableDatabase();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_salvar = (Button) findViewById(R.id.bt_salvar);

        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.t_senha);
        genero = (Spinner) findViewById(R.id.sexo);
        tipo_sanguineo = (Spinner) findViewById(R.id.sangue);

        Calendar calendar = Calendar.getInstance();
        this.ano = calendar.get(Calendar.YEAR);
        this.mes = calendar.get(Calendar.MONTH);
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);
        this.dataNascimento = (Button) findViewById(R.id.data);
        //dataNascimento.setText(dia + "/" + (mes+1) + "/" + ano);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                 this, R.array.tipo_sanguineo,
         android.R.layout.simple_spinner_item);
         tipo_sanguineo = (Spinner) findViewById(R.id.sangue);
         tipo_sanguineo.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.sexo,
                android.R.layout.simple_spinner_item);
        genero = (Spinner) findViewById(R.id.sexo);
        genero.setAdapter(adapter1);


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
                                              if (usuario != null) {
                                                  if (email.getText().length()==0 || senha.getText().length()==0 || nome.getText().length()==0) {
                                                      Toast.makeText(getApplication(), "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();
                                                  }else {
                                                      inserir();
                                                      Toast.makeText(CadastroActivity.this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                                                      Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
                                                     startActivity(i);
                                                  }
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

            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes, dia);
            Date data = calendar.getTime();


            DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);
            String dt = format.format(data);

            dataNascimento.setText(dt);
            //dataNascimento.setText(dia + "/" + (mes+1) + "/" + ano);
            usuario.setData_nascimento(data);
        }
    };



         private void inserir() {
         try {


             usuario.setNome(nome.getText().toString());
             usuario.setEmail(email.getText().toString());
             usuario.setSenha(senha.getText().toString());
             usuario.setGenero(genero.getSelectedItem().toString());
             usuario.setTipo_sanguineo(tipo_sanguineo.getSelectedItem().toString());

             database.insertUser(usuario);

         } catch (Exception ex) {

             AlertDialog.Builder dlg = new AlertDialog.Builder(this);
             dlg.setMessage("Erro ao inserir os dados! " + ex.getMessage());
             dlg.setNegativeButton("OK", null);
             dlg.show();

         }
     }


}


