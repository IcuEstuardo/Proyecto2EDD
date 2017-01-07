package com.example.estuardo.proyectoapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estuardo.conexion.wsAlgoritmo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DatosRecorrido extends AppCompatActivity implements View.OnClickListener
{
    private String ruta;
    private String usuario;
    private int idGrafica;
    private int contador;
    private String [] vertices;

    private ImageView imagen;
    private TextView lOrigen;
    private TextView lDestino;
    private EditText tTiempo;
    private Button bAvanzar;
    private Button bComenzar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_recorrido);

        //////////////////////////////////////////////////////////////////////////////
        this.usuario = getIntent().getStringExtra("Username");
        this.idGrafica = Integer.parseInt(getIntent().getStringExtra("idGrafica"));
        this.ruta = getIntent().getStringExtra("Ruta");
        this.vertices = this.ruta.split("->");
        this.contador = 0;
        //////////////////////////////////////////////////////////////////////////////

        this.imagen = (ImageView) findViewById(R.id.imgRecorrido);
        this.lOrigen = (TextView) findViewById(R.id.lblOrigen);
        this.lDestino = (TextView) findViewById(R.id.lblDestino);
        this.bAvanzar = (Button) findViewById(R.id.btnAvanzar);
        this.bComenzar = (Button) findViewById(R.id.btnComenzar);
        this.tTiempo = (EditText) findViewById(R.id.txtTiempo);

        this.bAvanzar.setEnabled(false);
        this.bAvanzar.setOnClickListener(this);
        this.bComenzar.setOnClickListener(this);

        new DescargarImagen1(this.idGrafica).execute(imagen);
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btnAvanzar:
                this.EnviarTiempo(tTiempo.getText().toString());
                break;
            case R.id.btnComenzar:
                new CrearHistorial().execute(this.usuario, vertices[0], vertices[vertices.length-1], this.idGrafica+"");
                break;
        }
    }

    public void EnviarTiempo(String texto)
    {
        if (!texto.isEmpty() && texto.matches("[0-9]*"))
        {
            if (this.contador < (this.vertices.length - 1))
            {
                new AgregarTiempo().execute(this.vertices[this.contador],this.vertices[this.contador +1], this.usuario, texto);
                new DescargarImagen2(vertices[contador], vertices[contador+1]).execute(imagen);
                lOrigen.setText("Inicio: " + vertices[contador]);
                lDestino.setText("Fin: " + vertices[contador+1]);
            }
            else
                bAvanzar.setEnabled(false);
        }
        else
            Toast.makeText(getBaseContext(), "No ha ingresado un valor", Toast.LENGTH_SHORT).show();
    }

    private class AgregarTiempo extends AsyncTask<String, Void, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params)
        {
            return new wsAlgoritmo().AgregarTiempo(params[0], params[1], params[2], Integer.parseInt(params[3]));
        }

        @Override
        protected void onPostExecute(Boolean bitmap) {
            if (bitmap == true)
                contador++;
        }
    }

    private class DescargarImagen1 extends AsyncTask<ImageView, Void, Bitmap>
    {
        ImageView imagen;
        Bitmap bitmap;
        int direccion;

        public  DescargarImagen1(int dir)
        {
            this.direccion = dir;
        }

        @Override
        protected Bitmap doInBackground(ImageView... params) {

            imagen = params[0];
            try
            {
                String ruta = new wsAlgoritmo().GraficarRuta(direccion);
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

    private class DescargarImagen2 extends AsyncTask<ImageView, Void, Bitmap>
    {
        ImageView imagen;
        Bitmap bitmap;

        String pos1, pos2;

        public  DescargarImagen2(String p1, String p2)
        {
            this.pos1 = p1;
            this.pos2 = p2;
        }

        @Override
        protected Bitmap doInBackground(ImageView... params) {

            imagen = params[0];
            try
            {
                String ruta = new wsAlgoritmo().GraficarEstado(pos1,pos2);
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

    private class CrearHistorial extends AsyncTask<String, Void, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params)
        {
            return new wsAlgoritmo().CrearHistorial(params[0], params[1], params[2], Integer.parseInt(params[3]));
        }

        @Override
        protected void onPostExecute(Boolean bitmap) {
            if (bitmap == true)
            {
                bComenzar.setEnabled(false);
                bAvanzar.setEnabled(true);
                new DescargarImagen2(vertices[contador], vertices[contador+1]).execute(imagen);
                lOrigen.setText("Inicio: " + vertices[contador]);
                lDestino.setText("Fin: " + vertices[contador+1]);
            }
        }
    }

}
