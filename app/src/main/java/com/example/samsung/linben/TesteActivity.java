package com.example.samsung.linben;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * Created by Raquel on 23/06/2016.
 */
public class TesteActivity extends Activity {


        // criar objetos para orientação
        Button EXECUTAR;
        EditText ValorBusca;
        ListView Lista;
        Connection connect;
        SimpleAdapter AD;
        // fim dos objetos - Até o momento
        //
        //   Utilize o CTRL+O para importar as bibliotecas que faltarem.
        //
        //--------------------------

        private void declarar()
        {
            EXECUTAR = (Button) findViewById(R.id.bnt_buscar);
            ValorBusca = (EditText) findViewById(R.id.txt_buscar);  // é txt_buscar mais é EditText
            Lista = (ListView) findViewById(R.id.list_output);
        }


        private void inicializar ()
        {
            declarar();   // chamamos a declaração
            ValorBusca.setText("SELECT * FROM USUARIO");  //estarei setando um valor para agilizar...
            connect = CONN("linbenadm", "linben**123", "linbendatabase", "177.42.176.199");
        }

        // IMPORTANTE! - Metodo/função para conexão com o Banco de dados.

        @SuppressLint("NewApi")
        private Connection CONN(String _user, String _pass, String _DB, String _server)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection conn = null;
            String ConnURL = null;
            try {

                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                ConnURL = "jdbc:jtds:sqlserver://" + _server + ";" + "databaseName=" + _DB + ";user=" + _user + ";password=" + _pass + ";";
                conn = DriverManager.getConnection(ConnURL);
            } catch (SQLException se) {
                Log.e("ERRO",se.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e("ERRO",e.getMessage());
            } catch (Exception e) {
                Log.e("ERRO",e.getMessage());
            }

            return conn;
        }



        public void QuerySQL(String COMANDOSQL){
            ResultSet rs;
            try {

                Statement statement = connect.createStatement();
                rs = statement.executeQuery(COMANDOSQL);
                // Configurando nosso SimpleAdapter

                List<Map<String, String>> data = null;
                data = new ArrayList<Map<String,String>>();

                while(rs.next()){           // percorrer nosso ResultSet em todos os registro, enquanto existir um prox.
                    Map<String, String> datanum = new HashMap<String, String>();
                    datanum.put("A", rs.getString("nome"));
                    datanum.put("B", rs.getString("estado"));
                    data.add(datanum);

                }
                String[] from = {"A","B"};
                int[] views = {R.id.txt_titulo,R.id.txt_conteudo}; // vamos criar um modelo para as linhas do Adapter
                AD = new SimpleAdapter(this, data, R.layout.activity_modelo, from, views);
                Lista.setAdapter(AD);
            } catch (Exception e) {
                Log.e("ERRO",e.getMessage());
            }

        }


        // PRONTO, bora produzir?


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_teste);

            inicializar();

            EXECUTAR.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    QuerySQL(ValorBusca.getText().toString());

                }
            });



        }



    }


