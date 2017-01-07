package Historial;

/**
 *
 * @author Estuardo
 */
public class Recorrido {
    
    private Recorrido siguiente;
    private Recorrido anterior;
    
    private int tiempo;
    private int posicion;
    private String origen;
    private String destino;
    private String grafo;
    
    public Recorrido(String grafo, String ori, String des)
    {
        this.grafo = grafo;
        this.origen = ori;
        this.destino = des;
        
        this.siguiente = null;
        this.anterior = null;
        this.tiempo = 0;
    }
    
    
    public String toString(String user, int pos, boolean tipo) 
    {
        String retorno = "nodo" + pos + user;
        
        if (tipo) {
            retorno += " [label = \"";
            retorno += "  Origen: " + this.origen + " Destino: " + this.destino + "\\n" + "Tiempo: " + this.tiempo;
            retorno += "\"];\n";
            
            return retorno;
        }
        
        return retorno;
    }

    @Override
    public String toString() {
        return posicion + ","+ origen + "," + destino + "," + tiempo;
    }
    

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo += tiempo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    

    public Recorrido getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Recorrido siguiente) {
        this.siguiente = siguiente;
    }

    public Recorrido getAnterior() {
        return anterior;
    }

    public void setAnterior(Recorrido anterior) {
        this.anterior = anterior;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getGrafo() {
        return grafo;
    }

    public void setGrafo(String imagen) {
        this.grafo = imagen;
    }
    
}
