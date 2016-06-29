package com.example.samsung.linben;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class ContinuarCadastroActivity extends AppCompatActivity {
    private Spinner estado;
    private Spinner cidade;
    private Button btn_voltar;
    private Button btn_concluir;
    private Usuario usuario;

    CadastroActivity cad = new CadastroActivity();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continuar_cadastro);

        this.usuario = new Usuario();

        cad.nome = (EditText) findViewById(R.id.nome);
        cad.email = (EditText) findViewById(R.id.email);
        cad.senha = (EditText) findViewById(R.id.t_senha);
        cad.sexo = (Spinner) findViewById(R.id.sexo);
        cad.sangue = (Spinner) findViewById(R.id.sangue);
        cad.dataNascimento = (Button) findViewById(R.id.data);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                this.usuario.setId(bundle.getInt("id"));
                cad.nome.setText(bundle.getString("nome"));
                //cad.sangue.setAdapter(bundle.getString(""));
                //genero
                //data
                cad.email.setText(bundle.getString("email"));
                cad.senha.setText(bundle.getString("senha"));
                //estado
                //cidade
            }
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.estado,
                android.R.layout.simple_spinner_item);
        estado = (Spinner) findViewById(R.id.estado);
        estado.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.cidade,
                android.R.layout.simple_spinner_item);
        cidade = (Spinner) findViewById(R.id.cidade);
        cidade.setAdapter(adapter1);

        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_concluir = (Button) findViewById(R.id.concluir);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(ContinuarCadastroActivity.this, CadastroActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );


        btn_concluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                                              usuario.setNome(cad.nome.getText().toString());
                                             // usuario.setTipo_sanguineo(cad.sangue.toString());
                                             // usuario.setGenero(cad.sexo.toString());
                                             // usuario.setData_nascimento(cad.dataNascimento.getText().toString());
                                              usuario.setEmail(cad.email.getText().toString());
                                              usuario.setSenha(cad.senha.getText().toString());
                                           //   usuario.setEstado(estado.toString());
                                            //  usuario.setCidade(cidade.toString());
                                              usuario.salvar();

                                              Toast.makeText(ContinuarCadastroActivity.this, usuario.get_mensagem(), Toast.LENGTH_LONG).show();
                                              if (usuario.is_status())
                                                  finish();
                                          }
                                      }
        );



    }





 }
