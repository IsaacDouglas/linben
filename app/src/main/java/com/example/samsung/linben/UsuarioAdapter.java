
package com.example.samsung.linben;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

/**
 * Created by Raquel on 28/06/2016.
 */
public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter (Context context, ArrayList<Usuario> lista){
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Usuario itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_lista, null);
        final View layout = convertView;

        TextView textViewNome = (TextView) convertView.findViewById(R.id.textView_nome);
        textViewNome.setText(itemPosicao.getNome());

        TextView textViewSangue = (TextView) convertView.findViewById(R.id.textView_sangue);
        textViewSangue.setText(itemPosicao.getTipo_sanguineo());

       /* TextView textViewGenero = (TextView) convertView.findViewById(R.id.textView_genero);
        textViewGenero.setText(itemPosicao.getGenero());

        TextView textViewData = (TextView) convertView.findViewById(R.id.textView_data);
        textViewData.setText(itemPosicao.getData_nascimento());*/

        TextView textViewEmail = (TextView) convertView.findViewById(R.id.textView_email);
        textViewEmail.setText(itemPosicao.getEmail());

        TextView textViewSenha = (TextView) convertView.findViewById(R.id.textView_senha);
        textViewSenha.setText(itemPosicao.getSenha());

       // TextView textViewEstado = (TextView) convertView.findViewById(R.id.textView_estado);
       // textViewEstado.setText(itemPosicao.getEstado());

        //TextView textViewCidade = (TextView) convertView.findViewById(R.id.textView_cidade);
        //textViewCidade.setText(itemPosicao.getCidade());

        Button button = (Button) convertView.findViewById(R.id.button_editar);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, CadastroActivity.class);
                intent.putExtra("nome", itemPosicao.getNome());
                intent.putExtra("tipo_sanguineo", itemPosicao.getTipo_sanguineo());
                //intent.putExtra("genero", itemPosicao.getGenero());
                //intent.putExtra("data", itemPosicao.getData_nascimento());
                intent.putExtra("email", itemPosicao.getEmail());
                intent.putExtra("senha", itemPosicao.getSenha());
             //   intent.putExtra("estado", itemPosicao.getEstado());
              //  intent.putExtra("cidade", itemPosicao.getCidade());
                context.startActivity(intent);
            }
        });

        Button buttonDeletar = (Button) convertView.findViewById(R.id.button_apagar);
        buttonDeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
             //   itemPosicao.apagar();
                if(itemPosicao._status)
                    layout.setVisibility(View.GONE);
                else
                    Toast.makeText(context, itemPosicao.get_mensagem(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
