package com.example.samsung.linben;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.samsung.linben.database.DBHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Raquel on 15/06/2016.
 */
public class ListUsersActivity extends ListActivity {

    private DBHelper helper;
    private Button btn_voltar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = new DBHelper(this);

        btn_voltar = (Button) findViewById(R.id.voltar);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_listusers, listarUsuario()));
        ListView listView;
        listView = (ListView)findViewById(R.id.listView_users);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              listarUsuario();
                                              Intent i = new Intent(ListUsersActivity.this, LoginActivity.class);
                                              startActivity(i);
                                          }
                                      }
        );


    }

    public ArrayList<String> listarUsuario(){
        ArrayList<String> myArray = new ArrayList<String>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cur = db.rawQuery("select nome from usuario", null);
        cur.moveToFirst();
        while(cur.isAfterLast()==false){
            myArray.add(cur.getString(cur.getColumnIndex("nome")));
            cur.moveToNext();
        }

        return myArray;
    }

  /*  public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

                return super.onCreateOptionsMenu(menu);
    }
*/
   /* public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.listView_users:
                startActivity(new Intent(ListUsersActivity.this, LoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
*/

}