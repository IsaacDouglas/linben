package com.example.samsung.linben;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.samsung.linben.database.DBHelper;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Raquel on 12/05/2016.
 */
public class CadastroActivity extends AppCompatActivity {
    private int ano, mes, dia;
    private Button dataNascimento;
    private DBHelper helper;

    Button btn_voltar;
    Button btn_continuar;
    Button btn_data_nascimento;
    EditText nome;
    EditText email;
    EditText senha;
    Spinner sexo;
    Spinner sangue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
//        helper = new DBHelper(this);

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_continuar = (Button) findViewById(R.id.continuar);
        btn_data_nascimento = (Button) findViewById(R.id.data);
        nome = (EditText) findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.t_senha);
        sexo = (Spinner) findViewById(R.id.sexo);
        sangue = (Spinner) findViewById(R.id.sangue);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        dataNascimento = (Button) findViewById(R.id.data);
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


        btn_continuar.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                //verificar se os campos estão vazios
                                                   if (email.getText().length()==0 || senha.getText().length()==0 || nome.getText().length()==0 || btn_data_nascimento.getText().length()==0){
                                                      Toast.makeText(getApplication(), "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show();

                                                      }else{
                                                         Intent i = new Intent(CadastroActivity.this, ContinuarCadastroActivity.class);
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






}


