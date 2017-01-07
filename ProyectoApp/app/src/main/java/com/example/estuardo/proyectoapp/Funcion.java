package com.example.estuardo.proyectoapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.estuardo.conexion.wsAlgoritmo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Funcion extends AppCompatActivity implements View.OnClickListener
{
    private  String usuario;
    private ImageView imagen;
    private EditText tOrigen, tDestino;
    private Button bAlgoritmo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcion);
        this.usuario = getIntent().getStringExtra("Username").toString();

        this.tOrigen = (EditText) findViewById(R.id.txtOrigen);
        this.tDestino = (EditText) findViewById(R.id.txtDestino);
        this.bAlgoritmo = (Button) findViewById(R.id.btnAnalizar);
        this.imagen = (ImageView) findViewById(R.id.imgFuncion);

        this.bAlgoritmo.setOnClickListener(this);
        new DescargarImagen().execute(imagen);
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btnAnalizar:
                String param1 = this.tOrigen.getText().toString();
                String param2 = this.tDestino.getText().toString();
                new IniciarAlgoritmo(this.usuario).execute(param1, param2);
                break;
        }
    }

    private class DescargarImagen extends AsyncTask<ImageView, Void, Bitmap>
    {
        ImageView imagen;
        Bitmap bitmap;

        @Override
        protected Bitmap doInBackground(ImageView... params) {

            imagen = params[0];
            try
            {
                String ruta = new wsAlgoritmo().GraficarGrafo();
                URL imagenUrl = new URL(ruta);
                HttpURLConnection conn = (HttpURLConnection) imagenUrl.openConnection();
                conn.connect();
                this.bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            this.imagen.setImageBitmap(bitmap);
            super.onPostExecute(bitmap);
        }
    }

    private class IniciarAlgoritmo extends AsyncTask<String, Void, String> {
        private Boolean estado;
        private String usario;

        public IniciarAlgoritmo(String user) {
            this.estado = false;
            this.usario = user;
        }

        @Override
        protected String doInBackground(String... params) {

            String retorno = new wsAlgoritmo().RutasMinimas(params[0].toString(), params[1].toString());
            if (!retorno.equals(""))
                estado = true;

            return retorno;
        }

        @Override
        protected void onPostExecute(String aVoid) {

            if(this.estado == false)
                Toast.makeText(getBaseContext(), "No se han encontrado resultados", Toast.LENGTH_LONG).show();
            else
            {
                Intent intent = new Intent(getApplicationContext(), ListaOpciones.class);
                intent.putExtra("listaOpciones", aVoid.toString());
                intent.putExtra("Username", this.usario);
                startActivity(intent);
            }
        }
    }

 }

