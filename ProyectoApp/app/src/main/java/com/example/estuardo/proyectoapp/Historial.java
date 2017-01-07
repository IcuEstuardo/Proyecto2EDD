package com.example.estuardo.proyectoapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estuardo.conexion.wsAlgoritmo;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    private String usuario;
    private ListView lista;
    private ArrayList<Lista_entrada> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        this.usuario = getIntent().getStringExtra("Username");
        String entrada = getIntent().getStringExtra("listaHistorial");
        this.LLenarLista(entrada);

        lista = (ListView) findViewById(R.id.ListView_historial);
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

                String texto = elegido.get_Identificador() + "";
                String user = elegido.get_textoDebajo()+"";
                String daato = elegido.get_Usuario() + "";

                Intent intent = new Intent(getApplicationContext(), DatosHistoria.class);
                intent.putExtra("idHistoria", texto);
                intent.putExtra("Username", user);
                intent.putExtra("Completo", daato);

                startActivity(intent);
            }
        });

    }

    private void LLenarLista(String entrada)
    {
        datos = new ArrayList<Lista_entrada>();
        String lineas [] = entrada.split("\n");

        for (String item: lineas)
        {
            String linea [] = item.split(",");
            datos.add(new Lista_entrada("Desde: " + linea[1] + " hacia: " + linea[2], this.usuario, item, Integer.parseInt(linea[0])));
        }
    }

}
