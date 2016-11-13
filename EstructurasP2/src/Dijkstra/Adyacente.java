package Dijkstra;

import ArbolB.arbolB;

/**
 *
 * @author Isabel
 */
public class Adyacente {
    
    private arbolB arbol;
    private Vertice nodo;
    
    public Adyacente(Vertice ady)
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

    public Vertice getNodo() {
        return nodo;
    }

    public void setNodo(Vertice nodo) {
        this.nodo = nodo;
    }
    
}
