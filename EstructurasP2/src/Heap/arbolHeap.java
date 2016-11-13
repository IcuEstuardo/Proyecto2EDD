package Heap;

import java.util.ArrayList;

/**
 *
 * @author estuardo
 */
public class arbolHeap {

    private ArrayList<nodoHeap> Cola;
    private nodoHeap Raiz;

    public arbolHeap()
    {
        this.Raiz = null;
        this.Cola = null;
    }

    
    public void Insercion(String nom, int id)
    {
        if (this.Cola == null)
            this.Cola = new ArrayList<>();
        
        
        this.Cola.add(new nodoHeap(nom, id));
        
        int posicion = this.Cola.size() - 1;
        this.EstructuraArbol(this.Cola.get(posicion), posicion);
        
        this.OrdenarInsercion(posicion);
    }
    
    private void OrdenarInsercion(int posicion)
    {
        int posHActual = posicion;
        int posPActual = this.PosicionPadre(posicion);
        
        while(posPActual >= 0)
        {
            if (this.Cola.get(posPActual).getDistancia() > this.Cola.get(posHActual).getDistancia())
                this.IntercambiarDatos(this.Cola.get(posPActual), this.Cola.get(posHActual));
            else
                break;
            
            posHActual = posPActual;
            posPActual = this.PosicionPadre(posHActual);
        }
    }
    
    
    
    public nodoHeap Eliminacion()
    {
        if (this.Cola.size() > 0) {
            nodoHeap ultimo = this.Cola.get(this.Cola.size() -1);
            nodoHeap primero = this.Cola.get(0);

            nodoHeap retorno = new nodoHeap(primero.getNombre(), primero.getDistancia());

            primero.setNombre(ultimo.getNombre());
            primero.setDistancia(ultimo.getDistancia());

            this.EstructuraArbol(null, this.Cola.size() -1);
            this.Cola.remove(this.Cola.size() -1);
            
            this.OrdenarEliminacion(0);
            return retorno;
        }
        
        return null;
    }
    
    private void OrdenarEliminacion(int posicion)
    {
        int posActual = posicion;
        int posHI = this.PosicionHijo(1, posActual);
        int posHD = this.PosicionHijo(2, posActual);
        
        while(posHI != -1)
        {   
            if (posHD != -1 && this.Cola.get(posHD).getDistancia() < this.Cola.get(posHI).getDistancia())
            {
                if (this.Cola.get(posHD).getDistancia() < this.Cola.get(posActual).getDistancia())
                {
                    this.IntercambiarDatos(this.Cola.get(posActual), this.Cola.get(posHD));
                    posActual = posHD;
                }
                else
                    break;
            }
            
            else if (this.Cola.get(posHI).getDistancia() < this.Cola.get(posActual).getDistancia())
            {
                this.IntercambiarDatos(this.Cola.get(posActual), this.Cola.get(posHI));
                posActual = posHI;
            }
            else
                break;
            
            posHI = this.PosicionHijo(1, posActual);
            posHD = this.PosicionHijo(2, posActual);
        }
    }
    
    
    
    private void IntercambiarDatos(nodoHeap padre, nodoHeap hijo)
    {
        String tempNom = hijo.getNombre();
        int tempDis = hijo.getDistancia();
        
        hijo.setNombre(padre.getNombre());
        hijo.setDistancia(padre.getDistancia());
        
        padre.setNombre(tempNom);
        padre.setDistancia(tempDis);
    }
    
    private void EstructuraArbol(nodoHeap nodo, int posicion)
    {
        if (this.PosicionPadre(posicion) != -1) {
            
            if ((posicion % 2) == 0) 
                this.Cola.get(this.PosicionPadre(posicion)).setNdDerecha(nodo);
            else
                this.Cola.get(this.PosicionPadre(posicion)).setNdIzquierda(nodo);
        }
        else
            this.Raiz = nodo;
    }
    

    
    
    private int PosicionPadre(int posHijo)
    {
        if (posHijo != 0)
            return (posHijo - 1)/2;
        
        return -1;
    }
    
    private int PosicionHijo(int tipo, int posPadre)
    {
        if (((2 * posPadre) + tipo) < this.Cola.size())
            return (2 * posPadre) + tipo;
            
        return -1;
    }
    
    
    public void RecorrerArbol(nodoHeap raiz)
    {
        if (raiz != null) {
            
            System.out.println(raiz.getNombre() + " | " + raiz.getDistancia());
            this.RecorrerArbol(raiz.getNdIzquierda());
            this.RecorrerArbol(raiz.getNdDerecha());
        }
    }
    

    public void RecorrerLista()
    {
        this.Cola.forEach((item) -> {
            System.out.println(item.getNombre() + " | " + item.getDistancia());
        });
        
        System.out.println("\n");
        this.RecorrerArbol(Raiz);
    }
}
