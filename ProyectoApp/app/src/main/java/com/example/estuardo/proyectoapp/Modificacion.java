package com.example.estuardo.proyectoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estuardo.conexion.wsConexion;

import org.w3c.dom.Text;

public class Modificacion extends AppCompatActivity implements View.OnClickListener
{

    private String usuario;
    private Button bModificar;
    private EditText tCorreo;
    private EditText tPassword;
    private TextView lUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificacion);

        this.usuario = getIntent().getStringExtra("Username").toString();

        this.bModificar = (Button) findViewById(R.id.btnModificar);
        this.tCorreo = (EditText) findViewById(R.id.txtMCorreo);
        this.tPassword = (EditText) findViewById(R.id.txtMPassword);
        this.lUsuario = (TextView) findViewById(R.id.lblMUsername);

        this.lUsuario.setText(this.usuario);

        this.bModificar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent actividad;
        switch (v.getId())
        {
            case R.id.btnModificar:
                String param1 = this.tPassword.getText().toString();
                String param2 = this.tCorreo.getText().toString();
                new ModificarUsuarios().execute(this.usuario, param1, param2);
                break;
        }
    }

    private class ModificarUsuarios extends AsyncTask<String, Integer, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params) {
            return new wsConexion().ModificarUsuario(params[0].toString(), params[1].toString(), params[2].toString(), "");
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            String mensaje = "";
            if(aVoid == true)
                mensaje = "No se ha podido modificar";
            else
                mensaje = "Dato modificado";

            Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG).show();
            tPassword.setText("");
            tCorreo.setText("");
        }
    }

}
