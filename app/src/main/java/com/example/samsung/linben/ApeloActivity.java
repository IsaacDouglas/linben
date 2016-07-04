package com.example.samsung.linben;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.samsung.linben.database.DataBase;
import com.example.samsung.linben.entidades.Causa;

/**
 * Created by Raquel on 12/05/2016.
 */
public class ApeloActivity extends Activity {
    private Spinner estado;
    private Spinner cidade;
    private Spinner hemocentro;
    private EditText descricao;

    private DataBase database;
    private SQLiteDatabase dbActions;

    private Button btn_voltar;
    private Button btn_continuar;

    private static final int CAPTURAR_VIDEO = 2;

    public void capturarVideo(View v){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 240);
        startActivityForResult(intent, CAPTURAR_VIDEO);
    }
    private Uri uri;

    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_apelo);
        super.onCreate(savedInstanceState);
        btn_voltar = (Button) findViewById(R.id.voltarseta);
        btn_continuar = (Button) findViewById(R.id.concluir);


        descricao = (EditText) findViewById(R.id.descricao);
        cidade = (Spinner) findViewById(R.id.cidade);
        estado = (Spinner) findViewById(R.id.estado);
        hemocentro = (Spinner) findViewById(R.id.hemocentro);

        try {
            database = new DataBase(this);
            dbActions = database.getWritableDatabase();

        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco!" + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

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


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
                this, R.array.hemocentro,
                android.R.layout.simple_spinner_item);
        hemocentro = (Spinner) findViewById(R.id.hemocentro);
        hemocentro.setAdapter(adapter3);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(ApeloActivity.this, MenuActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );


        btn_continuar.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {

                                                 inserir();
                                                 Toast.makeText(ApeloActivity.this, "Novo apelo cadastrado", Toast.LENGTH_LONG).show();
                                                 Intent i = new Intent(ApeloActivity.this, LoginActivity.class);
                                                 startActivity(i);
                                                 }
                                             }



        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            String msg = "Vídeo gravado em " + data.getDataString();
            mostrarMensagem(msg);
            uri = data.getData();
            adicionarNaGaleria();
        } else {
            mostrarMensagem("Vídeo não gravado");
        }
    }
    public void visualizarVideo(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "video/mp4");
        startActivity(intent);
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    private void mostrarMensagem(String msg){
        Toast.makeText(this, msg,Toast.LENGTH_LONG).show();
    }


    private void inserir() {
        try {
            Causa causa = new Causa();
            causa.setDescricao(descricao.getText().toString());
            causa.setCidade(cidade.getSelectedItem().toString());
            causa.setEstado(estado.getSelectedItem().toString());
            causa.setHemocentro(hemocentro.getSelectedItem().toString());

            database.insertCausa(causa);

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao inserir os dados! " + ex.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();

        }
    }


}
