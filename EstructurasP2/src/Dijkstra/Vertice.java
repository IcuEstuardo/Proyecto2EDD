package Dijkstra;

import java.util.ArrayList;

/**
 *
 * @author Isabel
 */
public class Vertice {

    private String nombre;
    private boolean estado;

    private Vertice antecesor;
    private ArrayList<Adyacente> adyacentes;

    public Vertice(String nom)
    {
        this.nombre = nom;
        this.estado = false;

        this.antecesor = null;
        this.adyacentes = new ArrayList<>();
    }

    public void agregarAdyacente(Vertice nuevo)
    {
        if (this.BusquedaAdyacente(nuevo.getNombre()) == null) {
            this.adyacentes.add(new Adyacente(nuevo));
        }
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::: Funciones Opcionales :::::::::::::::::::::::::::::::::::::::::::::::::::
    
    public Adyacente BusquedaAdyacente(String nombre)
    {
        for (Adyacente item: this.adyacentes)
        {
            if (item.getNodo().getNombre().equals(nombre))
                return item;
        }

        return null;
    }

    public void MostrarAdyacentes() 
    {
        System.out.print(this.getNombre() + ": ");
        
        this.adyacentes.forEach((nodo) -> {
            System.out.print(nodo.getNodo().getNombre() + "|" + nodo.ObtenerPeso() + " || ");
        });
        
        System.out.println("");
    }
    
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::: Encapsulado :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Vertice getAntecesor() {
        return antecesor;
    }

    public void setAntecesor(Vertice antecesor) {
        this.antecesor = antecesor;
    }


}
