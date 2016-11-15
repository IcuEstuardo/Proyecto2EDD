package TablaHash;

/**
 *
 * @author Estuardo
 */
public class HashUsuarios {
    
    private Usuario hashUsuario[];
    private int longitud;
    private int contadorDatos;
    
    public HashUsuarios()
    {
        this.longitud = 7;
        this.hashUsuario = new Usuario[this.longitud];
        
        this.InicializarTabla();
    }
    
    public boolean Insertar(Usuario nuevo)
    {
        int contIntentos = 0;
        int clave = this.funcionHash(nuevo.getUsername());
        
        while (contIntentos < 5) 
        {
            clave = this.exploracion(clave, (int) Math.pow(contIntentos, 2));
            
            if (this.hashUsuario[clave] == null)
            {
                this.hashUsuario[clave] = nuevo;
                this.contadorDatos++;
                this.RevisionFactor();
                return true;
            }
                
            contIntentos++;
        }
        
        return false;
    }
    
    public Usuario Buscar(String username)
    {
        int contIntentos = 0;
        int clave = this.funcionHash(username);
        
        while (contIntentos < 5) 
        {
            clave = this.exploracion(clave, (int) Math.pow(contIntentos, 2));
            Usuario aux = this.hashUsuario[clave];
            
            if (aux == null)
                return null;
            
            if (aux.getUsername().equals(username))
                return aux;
            
            contIntentos++;
        }
        
        return null;
    }
    
    private void  ReHash()
    {
        int longitudAnterior = this.longitud;
        this.longitud = this.nuevaLongitud(longitud);
        
        Usuario anteriorTabla[] = this.hashUsuario;
        this.hashUsuario = new Usuario[this.longitud];
        this.InicializarTabla();
        
        for (int i = 0; i < longitudAnterior; i++) 
        {
            this.Insertar(anteriorTabla[i]);
        }
    }
    
//:::::::::::::::::::::::::::::::: METODOS CLAVE :::::::::::::::::::::::::::::::    
    
    private int funcionHash(String username)
    {
        String numID = this.codigoIngreso(username);
        
        String num1 = "";
        String num2 = "";
        
        for (int i = 0; i < numID.length()/2; i++)
        {
            num1 += numID.charAt(i);
            num2 += numID.charAt(9 - i);
        }
        
        int clave = Integer.parseInt(num1) - Integer.parseInt(num2);
        
        return clave%this.longitud;
    }
    
    private String codigoIngreso(String username)
    {
        int suma = 0;
        for (int x=0; x < username.length(); x++)
            suma += username.codePointAt(x);
        
        String texto = suma + "";
        int longitud = texto.length();
        
        if (longitud < 10)
            while(longitud < 10)
            {
                texto += "0";
                longitud++;
            }
        
        return texto;
    }
    
    private int exploracion(int posicion, int agregado)
    {
        int nuevaPosicion = posicion + agregado;
        
        if (nuevaPosicion >= this.longitud) 
            while(nuevaPosicion >= this.longitud)
                nuevaPosicion = nuevaPosicion - this.longitud;
            
        return nuevaPosicion;
    }
    
//:::::::::::::::::::::::::::::::: METODOS REHASH :::::::::::::::::::::::::::::::
    
    private void RevisionFactor()
    {
        double conta = this.contadorDatos;
        double longi = this.longitud;
        
        double factor = conta/longi;
        if (factor >= 0.75)
            this.ReHash();
    }
    
    private boolean esPrimo(int num)
    {
        for (int i = 2; i < num; i++) 
            if (num % i == 0)
                return false;
        
        return true;
    }
    
    private int nuevaLongitud(int num)
    {
        int numero = num + 1;
        
        while(!this.esPrimo(numero))
            numero++;
        
        return numero;
    }

    private void InicializarTabla()
    {
        for (int i = 0; i < this.longitud; i++)
            this.hashUsuario[i] = null;    
        
        this.contadorDatos = 0;
    }
    
}
