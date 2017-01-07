package com.example.estuardo.proyectoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.estuardo.conexion.wsConexion;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private EditText tIuser, tIpass;
    private EditText tRuser, tRpass, tRemai;
    private Button bIngreso, bRegistro;
    private ProgressBar bProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bProgreso = (ProgressBar) findViewById(R.id.progressBar);

        this.bIngreso = (Button) findViewById(R.id.btnIngreso);
        this.bRegistro = (Button) findViewById(R.id.btnRegistro);
        this.tIuser = (EditText) findViewById(R.id.txtIusername);
        this.tIpass = (EditText) findViewById(R.id.txtIpassword);
        this.tRuser = (EditText) findViewById(R.id.txtRusername);
        this.tRpass = (EditText) findViewById(R.id.txtRpassword);
        this.tRemai = (EditText) findViewById(R.id.txtRemail);

        this.bIngreso.setOnClickListener(this);
        this.bRegistro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btnIngreso:
                String param1 = this.tIuser.getText().toString();
                String param2 = this.tIpass.getText().toString();
                new LogearUsuario(param1).execute(param2);
                break;
            case R.id.btnRegistro:
                String parm1 = this.tRuser.getText().toString();
                String parm2 = this.tRpass.getText().toString();
                String parm3 = this.tRemai.getText().toString();
                new AgregarUsuarios().execute(parm1, parm2, parm3);
                break;
        }
    }


    private class AgregarUsuarios extends AsyncTask<String, Integer, String>
    {
        @Override
        protected String doInBackground(String... params) {
            return new wsConexion().RegistrarUsuario(params[0].toString(), params[1].toString(), params[2].toString());
        }

        @Override
        protected void onPostExecute(String aVoid) {
            Toast.makeText(getBaseContext(), aVoid.toString(), Toast.LENGTH_LONG).show();
            tRuser.setText("");
            tRpass.setText("");
            tRemai.setText("");
        }
    }

    private class LogearUsuario extends AsyncTask<String, Void, Boolean>
    {
        private boolean estado;
        private String user;

        public LogearUsuario(String user)
        {
            this.estado = false;
            this.user = user;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String respuesta = new wsConexion().IngresoUsuario(user);

            try {
                if (!respuesta.equals(""))
                {
                    String datos[] = respuesta.split(",");
                    if (datos[1].equals(params[0]))
                        this.estado = true;
                }

            }catch (Exception e)
            {
            }

            return estado;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            String mensaje;
            if (this.estado == true)
            {
                mensaje = "Usuario y Contrasea correctos";
                Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                intent.putExtra("Username",this.user);
                startActivity(intent);
            }
            else
            {
                mensaje = "Usuario y Contrasea incorrectos";
                Toast.makeText(getBaseContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        }
    }

}
