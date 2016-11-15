package Dijkstra;

import java.util.ArrayList;

/**
 *
 * @author Isabel
 */
public class Vertice {

    private ArrayList<Adyacente> adyacentes;
    private Vertice antecesor;
    private String nombre;
    private int distancia;
    private boolean estado;
    
    //:::::::::::::::::::::::::::::::::::::::::::::::::: CONSTRUCTORES ::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    public Vertice(String nom, ArrayList<Adyacente> ver)
    {
        this.nombre = nom;
        this.distancia = Integer.MAX_VALUE;
        this.estado = false;
        
        this.antecesor = null;
        this.adyacentes = ver;
    }
    
    public Vertice(String nom)
    {
        this.nombre = nom;
        this.distancia = Integer.MAX_VALUE;
        this.estado = false;
        
        this.antecesor = null;
        this.adyacentes = null;
    }

    //:::::::::::::::::::::::::::::::::::::::::::: OPERACIONES ADYACENTES ::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    public void agregarAdyacente(String nuevo)
    {
        if (this.adyacentes == null)
            this.adyacentes = new ArrayList<>();
        
        if (this.BusquedaAdyacente(nuevo) == null) {
            this.adyacentes.add(new Adyacente(nuevo));
        }
    }
    
    public Adyacente BusquedaAdyacente(String nombre)
    {
        for (Adyacente item: this.adyacentes)
        {
            if (item.getNodo().equals(nombre))
                return item;
        }
        
        

        return null;
    }

    public void MostrarAdyacentes() 
    {
        System.out.print(this.getNombre() + ": ");
        
        this.adyacentes.forEach((nodo) -> {
            System.out.print(nodo.getNodo() + "|" + nodo.ObtenerPeso() + " || ");
        });
        
        System.out.println("");
    }
    
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::: ENCAPSULADO :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
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

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Adyacente> getAdyacentes() {
        return adyacentes;
    }



}
