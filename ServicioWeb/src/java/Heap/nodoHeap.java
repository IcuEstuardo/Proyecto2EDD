package Heap;

/**
 *
 * @author Estuardo
 */
public class nodoHeap {
    
    private nodoHeap ndIzquierda;
    private nodoHeap ndDerecha;
    private String nombre;
    private int distancia;
    
    public nodoHeap(String nom, int dis)
    {
        this.nombre = nom;
        this.distancia = dis;
        
        this.ndDerecha = null;
        this.ndIzquierda = null;
    }

    public nodoHeap getNdIzquierda() {
        return ndIzquierda;
    }

    public void setNdIzquierda(nodoHeap ndIzquierda) {
        this.ndIzquierda = ndIzquierda;
    }

    public nodoHeap getNdDerecha() {
        return ndDerecha;
    }

    public void setNdDerecha(nodoHeap ndDerecha) {
        this.ndDerecha = ndDerecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    

    public String datosNodo(int tipo)
    {
        switch(tipo)
        {
            case 0:
                return "nodo" + this.getDistancia();
            case 1:
                return "nodo" + this.getDistancia() + " [label = \"" + this.getDistancia() + " # " +"\"];";
            default:
                return "";
        }
    }
}
