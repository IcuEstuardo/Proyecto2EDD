package Historial;

/**
 *
 * @author Estuardo
 */
public class Historial {
    
    private Recorrido primero;
    private Recorrido ultimo;
    
    private String usuario;
    private int contador;
    
    public Historial(String usu)
    {
        this.usuario = usu;
        this.contador = 0;
        this.primero = null;
        this.ultimo = null;
    }
    
    
    public String nodoPrimero()
    {
        return this.primero.toString(usuario, 0, false);
    }
    
    public String textoGrafica()
    {
        String retorno1 = "";
        String retorno2 = "";
        
        int cont = 0;
        Recorrido aux = this.primero;
        while(aux != null)
        {
            retorno1 += aux.toString(usuario, cont, true);
            
            if (aux.getSiguiente() != null)
                retorno2 += aux.toString(usuario, cont, false) + " -> " + aux.getSiguiente().toString(usuario, cont + 1, false) + ";\n";
            if (aux.getAnterior() != null)
                retorno2 += aux.toString(usuario, cont, false) + " -> " + aux.getAnterior().toString(usuario, cont - 1, false) + ";\n";
            
            aux = aux.getSiguiente();
            cont++;
        }
        
        return retorno1 + "\n\n" + retorno2;
    }
    
    
    public boolean listaVacia()
    {
        return this.primero == null;
    }
    
    public void Insertar(Recorrido nuevo)
    {
        nuevo.setPosicion(contador);
        
        if (this.listaVacia()) 
        {
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else
        {
            this.ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(this.ultimo);
            this.ultimo = nuevo;
        }
        this.contador++;
    }
    
    public Recorrido Buscar(int clave)
    {
        Recorrido aux = this.primero;
        while(aux != null)
        {
            if (aux.getPosicion() == clave)
                return aux;
            
            aux = aux.getSiguiente();
        }
        
        return null;
    }

    public Recorrido getPrimero() {
        return primero;
    }

    public void setPrimero(Recorrido primero) {
        this.primero = primero;
    }

    public Recorrido getUltimo() {
        return ultimo;
    }

    public void setUltimo(Recorrido ultimo) {
        this.ultimo = ultimo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    
    @Override
    public String toString() {
        String retorno = "";
        Recorrido item = this.primero;
        while(item != null)
        {
            retorno += item.toString() + "\n";
            item = item.getSiguiente();
        }
        
        return retorno;
    }
    
    
    
}
