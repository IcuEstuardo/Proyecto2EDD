package com.example.estuardo.proyectoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estuardo.conexion.wsConexion;


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private EditText tIuser, tIpass;
    private EditText tRuser, tRpass, tRemai;
    private Button bIngreso, bRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                this.metodoIngreso(param1, param2);
                break;
            case R.id.btnRegistro:
                String par1 = this.tRuser.getText().toString();
                String par2 = this.tRpass.getText().toString();
                String par3 = this.tRemai.getText().toString();
                this.metodoRegistro(par1, par2, par3);
                break;
        }
    }

    private void metodoIngreso(String us, String ps)
    {
        String mensaje;

        if (!us.isEmpty() && !ps.isEmpty())
        {
            String resultado = new wsConexion().IngresoUsuario(us, ps);

            if (resultado.equals(""))
                mensaje = "Usuario invalido";
            else
            {
                String [] usuario =  resultado.split(",");
                if (usuario[1].equals(ps))
                    mensaje = "Contrasena correcta";
                else
                    mensaje = "Contrasena incorrecta";
            }

            this.tIpass.setText("");
            this.tIuser.setText("");
        }
        else
            mensaje = "No ha ingresado datos";

        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();

    }

    private void metodoRegistro(String us, String ps, String em)
    {
        String mensaje;

        if (!us.isEmpty() && !ps.isEmpty() && !em.isEmpty())
        {
            mensaje = new wsConexion().RegistrarUsuario(us, ps, em);

            this.tRuser.setText("");
            this.tRpass.setText("");
            this.tRemai.setText("");

        }
        else
            mensaje = "No ha ingresado datos";

        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }
}
