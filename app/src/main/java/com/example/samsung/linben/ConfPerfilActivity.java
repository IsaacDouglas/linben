package com.example.samsung.linben;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


/**
 * Created by Samsung on 28/05/2016.
 */
public class ConfPerfilActivity extends Activity {
    private Spinner estado;
    private Spinner cidade;
   // private RelativeLayout rl;
   // private FragmentActivity fa;
    private Button btn_voltar;
    private Button btn_concluir;

    private static final int REQUEST_CAMERA = 1;
    private static final int SELECT_FILE = 2;
    private Button btn_foto;
    private String userChoosenTask;
    private ImageView imageView;
    private String IDusuario = "1";


    private File profileDir;

    private void cameraIntent(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent.createChooser(intent, "Selecione a imagem"), SELECT_FILE);
    }

    private void escolheFoto(){
        final CharSequence[] itens = {"Usar câmera", "Ir para galeria", "Cancelar"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ConfPerfilActivity.this);
        builder.setTitle("Adicionar foto");
        builder.setItems(itens, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean resultado = Utility.checkPermission(ConfPerfilActivity.this);
                if(itens[item].equals("Usar câmera")){
                    userChoosenTask = "Usar câmera";
                    if(resultado){
                        cameraIntent();
                    }
                } else if(itens[item].equals("Ir para galeria")){
                    userChoosenTask = "Ir para galeria";
                    if(resultado){
                        galleryIntent();
                    }
                } else if(itens[item].equals("Cancelar")){
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(resultCode == Activity.RESULT_OK){
            if(requestCode ==  SELECT_FILE){
                try {
                    onSelectFromGalleryResult(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if(requestCode == REQUEST_CAMERA){
                try {
                    onCaptureImageResult(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) throws IOException {
        if(data != null){
            Uri uri = data.getData();
            String src = getRealPathFromURI(uri);
            File source = new File(src);
            String filename = IDusuario + ".jpg";
            File destination = new File(profileDir.getPath() + "/" + filename);
            Log.d("AQUI", "" + source);
            Log.d("AQUI", "" + destination);
            copy(source, destination);
            btn_foto.setBackground(Drawable.createFromPath(String.valueOf(new File(profileDir.getPath() + "/1.jpg"))));

        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    private void onCaptureImageResult(Intent data) throws IOException {
        imageView = (ImageView) findViewById(R.id.imageView);
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try{
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        //picture_path = saveToInternalStorage(thumbnail);
        //imageView.setImageBitmap(thumbnail);
    }

    private void copy(File source, File destination) throws IOException {

        FileChannel in = new FileInputStream(source).getChannel();
        FileChannel out = new FileOutputStream(destination).getChannel();

        try {
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }


    protected void onCreate(Bundle savedInstanceState){

    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // fa = (FragmentActivity) super.getActivity();
       // rl = (RelativeLayout) inflater.inflate(R.layout.activity_confgperfil, container, false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confgperfil);

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // aqui cria o diretório onde salva as imagens de perfil
        profileDir = cw.getDir("profilePics", Context.MODE_PRIVATE);

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

        btn_foto = (Button) findViewById(R.id.camera);
        if (new File(profileDir.getPath() + "/1.jpg") != null){
            btn_foto.setBackground(Drawable.createFromPath(String.valueOf(new File(profileDir.getPath() + "/1.jpg"))));
        }

        btn_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                escolheFoto();
            }
        });


        btn_voltar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(ConfPerfilActivity.this, MenuActivity.class);
                                            startActivity(i);
                                        }
                                    }
        );


        btn_concluir.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent i = new Intent(ConfPerfilActivity.this, MenuActivity.class);
                                           startActivity(i);
                                       }
                                   }
        );
        //return rl;
    }
}
