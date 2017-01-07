package com.example.estuardo.proyectoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estuardo.conexion.wsAlgoritmo;

public class Menu extends AppCompatActivity implements View.OnClickListener
{

    private String usuario;
    private TextView lTituloMenu;
    private Button bHistorial;
    private Button bOperacion;
    private Button bModificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.usuario = getIntent().getStringExtra("Username").toString();

        this.bHistorial = (Button) findViewById(R.id.btnHistorial);
        this.bOperacion = (Button) findViewById(R.id.btnFuncion);
        this.bModificacion = (Button) findViewById(R.id.btnModificacion);
        this.lTituloMenu = (TextView) findViewById(R.id.lblMenuTitulo);
        this.lTituloMenu.setText(this.usuario);

        this.bHistorial.setOnClickListener(this);
        this.bOperacion.setOnClickListener(this);
        this.bModificacion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent actividad;
        switch (v.getId())
        {
            case R.id.btnHistorial:
                new CargarHistorial().execute(this.usuario);
                break;
            case R.id.btnFuncion:
                actividad = new Intent(getApplicationContext(), Funcion.class);
                actividad.putExtra("Username", this.usuario);
                startActivity(actividad);
                break;
            case R.id.btnModificacion:
                actividad = new Intent(getApplicationContext(), Modificacion.class);
                actividad.putExtra("Username", this.usuario);
                startActivity(actividad);
                break;
        }
    }

    private class CargarHistorial extends AsyncTask<String, Void, String>
    {
        private boolean estado;
        public CargarHistorial () {this.estado = false;}

        @Override
        protected String doInBackground(String... params)
        {
            String retorno = new wsAlgoritmo().ObtenerHistorial(params[0].toString());
            if (!retorno.equals("."))
                this.estado = true;
            return retorno;
        }

        @Override
        protected void onPostExecute(String aVoid) {

            if(this.estado == false)
                Toast.makeText(getBaseContext(), "No se han encontrado resultados", Toast.LENGTH_LONG).show();
            else
            {
                Intent intent = new Intent(getApplicationContext(), Historial.class);
                intent.putExtra("listaHistorial", aVoid.toString());
                intent.putExtra("Username", usuario);
                startActivity(intent);
            }

        }
    }
}
