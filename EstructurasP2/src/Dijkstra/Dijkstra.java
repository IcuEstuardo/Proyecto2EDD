package Dijkstra;

import Heap.arbolHeap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Isabel
 */
public class Dijkstra {

    private ArrayList<Vertice> ListaVertices;
    private arbolHeap colaPrioridad;

    public Dijkstra()
    {
        this.ListaVertices = null;
        this.colaPrioridad = null;
    }
    
    private void Inicializar()
    {
        for (Vertice item: this.ListaVertices) 
            item = new Vertice(item.getNombre(), item.getAdyacentes());
    }
    
    
    public void EncontrarRutaMinima(String nOrigen, String nDestino)
    {
        try {
            
            Vertice origen = this.BusquedaVertice(nOrigen);
            
            if (origen != null) {
                this.Inicializar();
                origen.setDistancia(0);
                
                this.colaPrioridad.Insercion(origen.getNombre(), 0);
                
                while(!this.colaPrioridad.arbolVacio())
                {
                    Vertice actual = this.BusquedaVertice(this.colaPrioridad.Eliminacion().getNombre());
                    
                    if (actual.isEstado() == true)
                        continue;
                   
                    actual.setEstado(true);
                    
                    for (Adyacente item: actual.getAdyacentes()) 
                    {
                        
                    }
                    
                    
                }
                
            }
            
        } catch (Exception e) {
        }
    }
    
    
    
    
    public void AgregarVertices(String ubi)
    {
        this.ListaVertices = new ArrayList<>();

        try {

          FileReader lectura = new FileReader(ubi);
          BufferedReader br = new BufferedReader(lectura);
          String linea;

            while (true) {

                linea = br.readLine();

                if (linea != null) {

                    String lineaTxt[] = linea.split(";|->");

                    if (this.BusquedaVertice(lineaTxt[0]) == null)
                        this.ListaVertices.add(new Vertice(lineaTxt[0]));

                    if (this.BusquedaVertice(lineaTxt[1]) == null)
                        this.ListaVertices.add(new Vertice(lineaTxt[1]));
                    
                    this.BusquedaVertice(lineaTxt[0]).agregarAdyacente(this.BusquedaVertice(lineaTxt[1]));

                }else{
                    break;
                }
            }

          br.close();
          lectura.close();

        } catch (IOException e) {
            System.out.println("Error: "+e);
        }
    }

    public void AgregarPesoAdyacentes(String ubi)
    {
        try {

          FileReader lectura = new FileReader(ubi);
          BufferedReader br = new BufferedReader(lectura);
          String linea;

            while (true) {

                linea = br.readLine();
                    
                if (linea != null) {
                    String lineaTxt[] = linea.split("->| |,|;");
                    
                    if (this.BusquedaVertice(lineaTxt[0]).BusquedaAdyacente(lineaTxt[1]) != null && lineaTxt.length > 2)
                    {
                        for (int i = 2; i < lineaTxt.length; i++) 
                        {
                            this.BusquedaVertice(lineaTxt[0]).BusquedaAdyacente(lineaTxt[1]).InsertarPeso(Integer.parseInt(lineaTxt[i]));
                        }
                    }
                    
                }else{
                    break;
                }
            }

          br.close();
          lectura.close();

        } catch (IOException e) {
            System.out.println("Error: "+e);
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::: Funciones Opcionales :::::::::::::::::::::::::::::::::::::::::::::::::::
    
    private Vertice BusquedaVertice(String nombre)
    {
        for (Vertice item: this.ListaVertices)
        {
            if (item.getNombre().equals(nombre))
                return item;
        }

        return null;
    }

    public void MostrarVertices() {
        for (Vertice nodo : this.ListaVertices) {
            nodo.MostrarAdyacentes();
        }
    }

}
