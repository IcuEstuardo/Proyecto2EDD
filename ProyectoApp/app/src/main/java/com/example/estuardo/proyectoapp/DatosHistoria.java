package com.example.estuardo.proyectoapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.estuardo.conexion.wsAlgoritmo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DatosHistoria extends AppCompatActivity {

    private String usuario;
    private String  datoHistoria;
    private  int idHistoria;

    private ImageView imagen;
    private TextView ldOrigen;
    private TextView ldDestino;
    private TextView ldTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_historia);

        this.usuario = getIntent().getStringExtra("Username").toString();
        this.datoHistoria = getIntent().getStringExtra("Completo").toString();
        this.idHistoria = Integer.parseInt(getIntent().getStringExtra("idHistoria").toString());

        this.ldOrigen = (TextView) findViewById(R.id.txtValOrigen);
        this.ldDestino = (TextView) findViewById(R.id.txtValDestino);
        this.ldTiempo = (TextView) findViewById(R.id.txtValDuracion);
        this.imagen = (ImageView) findViewById(R.id.imbHistoria);

        String linea [] = this.datoHistoria.split(",");

        this.ldOrigen.setText(linea[1]);
        this.ldDestino.setText(linea[2]);
        this.ldTiempo.setText(linea[3]);

        new DescargarImagen(usuario, Integer.parseInt(linea[0])).execute(imagen);
    }

    private class DescargarImagen extends AsyncTask<ImageView, Void, Bitmap> {
        ImageView imagen;
        Bitmap bitmap;

        String usuario;
        int clave;

        public DescargarImagen(String usu, int cla)
        {
            this.usuario = usu;
            this.clave = cla;
        }

        @Override
        protected Bitmap doInBackground(ImageView... params) {

            imagen = params[0];
            try
            {
                String ruta = new wsAlgoritmo().GraficarHistoria(usuario, clave);
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

}
