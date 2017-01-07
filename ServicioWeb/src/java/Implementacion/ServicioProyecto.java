package Implementacion;


import Dijkstra.Dijkstra;
import Historial.Recorrido;
import TablaHash.HashUsuarios;
import TablaHash.Usuario;
import Utilidades.Herramientas;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Estuardo
 */
@WebService(serviceName = "ServicioProyecto")
public class ServicioProyecto {
    
    
    
    private String IP;
    private HashUsuarios tablaUsuarios;
    private Herramientas herramientas;
    private Dijkstra algoritmo;

    public ServicioProyecto()
    {
        this.IP = "192.168.137.1";
        this.tablaUsuarios = new HashUsuarios();
        this.herramientas = new Herramientas();
        this.algoritmo = new Dijkstra();
    }

    @WebMethod(operationName = "FuncionPrueba")
    public String FuncionPrueba(@WebParam(name = "nombre") String nombre,
                             @WebParam(name = "pass") String pass)
    {
        return "Recibido " + nombre + " | " + pass;
    }

    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::: SERVICIOS DE USUARIO :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    @WebMethod(operationName = "RegistroUsuario")
    public String RegistroUsuario(@WebParam(name = "username") String username,
                              @WebParam(name = "password") String password,
                              @WebParam(name = "correo") String correo)
    {

        if (this.tablaUsuarios.Buscar(username) != null)
            return "Nombre de usuario ingresado ya existe";

        if (this.tablaUsuarios.Insertar(new Usuario(username, password, correo)))
            return "Usuario Registrado!";
        else
            return "Usuario No Registrado";
    }

    @WebMethod(operationName = "BusquedaUsuario")
    public String BusquedaUsuario(@WebParam(name = "username") String username)
    {
        if (this.tablaUsuarios.Buscar(username) != null)
            return this.tablaUsuarios.Buscar(username).toString();

        return "";
    }

    @WebMethod(operationName = "EliminacionUsuario")
    public String EliminacionUsuario(@WebParam(name = "username") String username)
    {
        if (this.tablaUsuarios.Buscar(username) == null)
            return "El usuario no existe!";

        if (this.tablaUsuarios.Eliminar(username))
            return "Usuario Eliminado";
        else
            return "Usuario No Eliminado";
    }

    @WebMethod(operationName = "ModificacionUsuario")
    public boolean ModificacionUsuario(@WebParam(name = "username") String username,
                              @WebParam(name = "password") String password,
                              @WebParam(name = "correo") String correo,
                              @WebParam(name = "path") String path)
    {
        
        try {
            
            this.tablaUsuarios.Buscar(username).setPassword(password);
            this.tablaUsuarios.Buscar(username).setCorreo(correo);
            this.tablaUsuarios.Buscar(username).setPath(correo);
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    @WebMethod(operationName = "ReporteUsuario")
    public String ReporteUsuario(@WebParam(name = "nombre") String nombre)
    {
        String cuerpo = this.tablaUsuarios.GraficarTabla();
        String retorno = this.herramientas.graficarEstructura(cuerpo, "Reportes", nombre);
        return retorno;
    }
    
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::: MANEJO DE HISTORIAL :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    @WebMethod(operationName = "CrearHistorial")
    public boolean CrearHistorial(@WebParam(name = "username") String username,
                            @WebParam(name = "origen") String origen,
                            @WebParam(name = "destino") String destino,
                            @WebParam(name = "ubicacion") int ubicacion)
    {
        try {
            
            String grafo = this.algoritmo.getGraficas()[ubicacion];
            this.tablaUsuarios.Buscar(username).getHistorial().Insertar(new Recorrido(grafo, origen, destino));

            return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    @WebMethod(operationName = "ObtenerHistorial")
    public String ObtenerHistorial(@WebParam(name = "nombre") String username)
    {
        if (!this.tablaUsuarios.Buscar(username).getHistorial().listaVacia()) 
        {
           return this.tablaUsuarios.Buscar(username).getHistorial().toString();
        }
        
        return ".";
    }
    
    
    @WebMethod(operationName = "AgregarTiempo")
    public boolean AgregarTiempo(@WebParam(name = "posicion1") String posicion1,
                            @WebParam(name = "posicion2") String posicion2,
                            @WebParam(name = "username") String username,
                            @WebParam(name = "tiempo") int tiempo)
    {
        
        try
        {
            this.algoritmo.AgregarTiempo(posicion1, posicion2, tiempo);
            this.tablaUsuarios.Buscar(username).getHistorial().getUltimo().setTiempo(tiempo);
            
            return true;

        }catch(Exception e)
        {
            return false;
        }
        
    }
    
    
    @WebMethod(operationName = "EliminarArbol")
    public boolean EliminarArbol(@WebParam(name = "posicion1") String posicion1,
                            @WebParam(name = "posicion2") String posicion2)
    {
        try
        {
            this.algoritmo.BusquedaVertice(posicion1).BusquedaAdyacente(posicion2).setArbol(null);   
            return true;

        }catch(Exception e)
        {
            return false;
        }
        
    }
    

    //::::::::::::::::::::::::::::::::::::::::::::::::::::: SERVICIOS DE ALGORITMO :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    
    
    @WebMethod(operationName = "SubirVertices")
    public String SubirVertices(@WebParam(name = "texto") String texto)
    {
        if (this.algoritmo.AgregarVertices(texto))
            return "Los vertices han sido agregados!";
        
        return "Ha habido un error y los vertices no han sido agregados!";
    }
    
    @WebMethod(operationName = "SubirPesos")
    public String SubirPesos(@WebParam(name = "texto") String texto)
    {
        if (this.algoritmo.AgregarPesoAdyacentes(texto))
            return "Los pesos han sido agregados!";
        
        return "Ha habido un error y los pesos no han sido agregados!";
    }
    
    @WebMethod(operationName = "ReporteGrafo")
    public String ReporteGrafo(@WebParam(name = "nombre") String nombre, 
                               @WebParam(name = "ruta") boolean ruta)
    {
        String cuerpo = this.algoritmo.GraficaNormal();
        String retorno = this.herramientas.graficarEstructura(cuerpo, "Reportes", nombre);
        
        if (ruta == true)
            return retorno;
        
        return "http://" + this.IP + ":8080/ServicioWeb/Imagenes/Reportes/reporteGrafo.png";
    }
    
    @WebMethod(operationName = "GrafoRutaMinima")
    public String GrafoRutaMinima(@WebParam(name = "identificador") int identificador)
    {
        String cuerpo = this.algoritmo.getGraficas()[identificador];
        this.herramientas.graficarEstructura(cuerpo, "Reportes", "grafoResultado");
        
        return "http://" + this.IP + ":8080/ServicioWeb/Imagenes/Reportes/grafoResultado.png";
    }
    
    @WebMethod(operationName = "RutasMinimas")
    public String RutasMinimas(@WebParam(name = "posicion1") String posicion1,
                            @WebParam(name = "posicion2") String posicion2)
    {
        
        this.algoritmo.setContador(0);
        this.algoritmo.setRecorridos("");
        
        this.algoritmo.Algoritmo(posicion1, posicion2);   
        String retorno = this.algoritmo.getRecorridos();
        
        return retorno;
    }
    
    
    @WebMethod(operationName = "GraficarEstado")
    public String GraficarEstado(@WebParam(name = "posicion1") String posicion1,
                             @WebParam(name = "posicion2") String posicion2)
    {
        String cuerpo = this.algoritmo.GraficaRecorrido(posicion1, posicion2);
        String retorno = this.herramientas.graficarEstructura(cuerpo, "Reportes", "recorrido");
        
        
        return "http://" + this.IP + ":8080/ServicioWeb/Imagenes/Reportes/recorrido.png";
    }
    
    
    @WebMethod(operationName = "GraficarHistoria")
    public String GraficarHistoria(@WebParam(name = "username") String username,
                              @WebParam(name = "codigo") int codigo)
    {
        String cuerpo = this.tablaUsuarios.Buscar(username).getHistorial().Buscar(codigo).getGrafo();
        
        this.herramientas.graficarEstructura(cuerpo, "Reportes", "grafoHistoria");
        
        return "http://" + this.IP + ":8080/ServicioWeb/Imagenes/Reportes/grafoHistoria.png";
    }
    
}
