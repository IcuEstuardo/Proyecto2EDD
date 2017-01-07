package Dijkstra;

import ArbolB.arbolB;

/**
 *
 * @author Isabel
 */
public class Adyacente {
    
    private arbolB arbol;
    private String nodo;
    
    public Adyacente(String ady)
    {
        this.nodo = ady;
        this.arbol = null;
    }
    
    public Adyacente()
    {
        this.nodo = null;
        this.arbol = null;
    }
    
    public int ObtenerPeso()
    {
        if (arbol != null) {
            return arbol.PromedioRaiz();
        }
        
        return 3600;
    }

    public void InsertarPeso(int peso)
    {
        if (arbol == null)
            this.arbol = new arbolB(5);
        
        this.arbol.Insercion(peso);
    }

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public arbolB getArbol() {
        return arbol;
    }

    public void setArbol(arbolB arbol) {
        this.arbol = arbol;
    }
    
    
    
}
