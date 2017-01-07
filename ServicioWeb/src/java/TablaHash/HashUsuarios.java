package TablaHash;

import java.io.IOException;


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
        this.InicializarTabla();
    }

    public boolean Insertar(Usuario nuevo) {
        int contIntentos = 0;
        int clave = this.funcionHash(nuevo.getUsername());

        while (contIntentos < 5) {
            clave = this.exploracion(clave, (int) Math.pow(contIntentos, 2));

            if (this.hashUsuario[clave] == null || this.hashUsuario[clave].isEstado() == false) {
                this.hashUsuario[clave] = nuevo;
                this.contadorDatos++;
                this.RevisionFactor();
                return true;
            }

            contIntentos++;
        }

        return false;
    }

    public Usuario Buscar(String username) {
        int contIntentos = 0;
        int clave = this.funcionHash(username);

        while (contIntentos < 5) {
            clave = this.exploracion(clave, (int) Math.pow(contIntentos, 2));
            Usuario aux = this.hashUsuario[clave];

            if (aux == null) {
                return null;
            }

            if (aux.getUsername().equals(username)) {
                return aux;
            }

            contIntentos++;
        }

        return null;
    }

    public boolean Eliminar(String username) {
        if (this.Buscar(username) != null) {
            this.Buscar(username).setEstado(false);
            this.contadorDatos--;
            return true;
        }

        return false;
    }

    private void ReHash() {
        int longitudAnterior = this.longitud;
        this.longitud = this.nuevaLongitud(longitud);

        Usuario anteriorTabla[] = this.hashUsuario;
        this.hashUsuario = new Usuario[this.longitud];
        this.InicializarTabla();

        for (int i = 0; i < longitudAnterior; i++) {
            Usuario temp = anteriorTabla[i];
            if (temp != null && temp.isEstado() == true)
                this.Insertar(temp);
        }
    }

//:::::::::::::::::::::::::::::::: METODOS CLAVE :::::::::::::::::::::::::::::::    
    
    private int funcionHash(String username) {
        String numID = this.codigoIngreso(username);

        String num1 = "";
        String num2 = "";

        for (int i = 0; i < numID.length() / 2; i++) {
            num1 += numID.charAt(i);
            num2 += numID.charAt(9 - i);
        }

        int clave = Integer.parseInt(num1) - Integer.parseInt(num2);

        return clave % this.longitud;
    }

    private String codigoIngreso(String username) {
        int suma = 0;
        for (int x = 0; x < username.length(); x++) {
            suma += username.codePointAt(x);
        }

        String texto = suma + "";
        int longitud = texto.length();

        if (longitud < 10) {
            while (longitud < 10) {
                texto += "0";
                longitud++;
            }
        }

        return texto;
    }

    private int exploracion(int posicion, int agregado) {
        int nuevaPosicion = posicion + agregado;

        if (nuevaPosicion >= this.longitud) {
            while (nuevaPosicion >= this.longitud) {
                nuevaPosicion = nuevaPosicion - this.longitud;
            }
        }

        return nuevaPosicion;
    }

//:::::::::::::::::::::::::::::::: METODOS REHASH :::::::::::::::::::::::::::::::
    
    private void RevisionFactor() {
        double conta = this.contadorDatos;
        double longi = this.longitud;

        double factor = conta / longi;
        if (factor >= 0.75) 
        {
            System.out.println("Supera el porcentaje");
            this.ReHash();
        }
    }

    private boolean esPrimo(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int nuevaLongitud(int num) {
        int numero = num + 1;

        while (!this.esPrimo(numero)) {
            numero++;
        }

        return numero;
    }

    private void InicializarTabla() {
        this.hashUsuario = new Usuario[this.longitud];
        
        System.out.println("Inicializacion datos: ");
        for (int i = 0; i < this.longitud; i++) {
            System.out.print(i + " | ");
            this.hashUsuario[i] = null;
        }
        System.out.println("");

        this.contadorDatos = 0;
    }

//:::::::::::::::::::::::::::::::: METODOS GRAFICADO :::::::::::::::::::::::::::::::
    
    public String GraficarTabla()
    {
        String retorno = "   nodesep=.05;\n";
             retorno += "   rankdir=LR;\n";
             retorno += "   node [shape=record,width=.1,height=.1];\n\n";
             
             retorno += "   nodoTabla [label = \""; 
        
        for (int i = 0; i < this.longitud; i++)
        {
            retorno += "<f"+ i +"> " ;
            if (this.hashUsuario[i] != null/* && this.hashUsuario[i].isEstado() == true*/)
                retorno += "Nombre: " + this.hashUsuario[i].getUsername() + 
                      "\\n Correo: " + this.hashUsuario[i].getCorreo() +
                  "\\n Contraseña: " + this.hashUsuario[i].getPassword() +
                       "\\n Clave: " + this.funcionHash(this.hashUsuario[i].getUsername()) +
                      "\\n Estado: " + this.hashUsuario[i].isEstado();
            
            if (i < (this.longitud - 1))
                retorno += " |";
        }
        
        retorno += "\", height=2.5];\n\n";
        
        
        for (int i = 0; i < this.longitud; i++)
        {
            if (this.hashUsuario[i] != null)
            {
                if (!this.hashUsuario[i].getHistorial().listaVacia()) {
                    retorno += "   nodoTabla:f" + i + " -> " + this.hashUsuario[i].getHistorial().nodoPrimero()+"\n";
                    retorno += this.hashUsuario[i].getHistorial().textoGrafica();
                }
                
            }
        }
        
        
        
        return retorno;
    }
//
}
