package com.example.estuardo.proyectoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estuardo.conexion.wsAlgoritmo;

import java.util.ArrayList;
import java.util.List;

public class ListaOpciones extends AppCompatActivity
{
    private String usuario;
    private ListView lista;
    private ArrayList<Lista_entrada> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_opciones);

        this.usuario = getIntent().getStringExtra("Username");
        String entrada = getIntent().getStringExtra("listaOpciones");
        this.LLenarLista(entrada);

        lista = (ListView) findViewById(R.id.ListView_listado);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo());

                }
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);

                String texto = (elegido.get_Identificador() - 1) + "";
                String ruta = elegido.get_textoDebajo()+"";
                String user = elegido.get_Usuario() + "";

                Intent intent = new Intent(getApplicationContext(), DatosRecorrido.class);
                intent.putExtra("idGrafica", texto);
                intent.putExtra("Username", user);
                intent.putExtra("Ruta", ruta);

                startActivity(intent);
            }
        });

    }

    private void LLenarLista(String entrada)
    {
        datos = new ArrayList<Lista_entrada>();
        String lineas [] = entrada.split("\n");

        for (int i = 0; i < lineas.length; i++)
        {
            datos.add(new Lista_entrada("Recorrido #" + (i+1) , lineas[i], this.usuario, (i+1)));
        }
    }
}
