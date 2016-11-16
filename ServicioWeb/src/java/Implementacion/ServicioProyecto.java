package Implementacion;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Estuardo
 */
@WebService(serviceName = "ServicioProyecto")
public class ServicioProyecto {


    public ServicioProyecto()
    {
        System.out.println("Inicio del Servicio Web");
    }
    
        @WebMethod(operationName = "Saludo")
        public String Saludo(@WebParam(name = "parametro") String parametro)
        {
            return "Hola " + parametro;
        }

//
//    @WebMethod(operationName = "RegistroUsuario")
//    public String RegistroUsuario(@WebParam(name = "username") String username,
//                                   @WebParam(name = "password") String password,
//                                   @WebParam(name = "correo") String correo)
//    {
//
//        if (this.tablaUsuarios.Buscar(username) != null)
//            return "Nombre de usuario ingresado ya existe";
//
//        this.tablaUsuarios.Insertar(new Usuario(username, password, correo));
//        return "Usuario Registrado";
//
//    }
//
//    @WebMethod(operationName = "BusquedaUsuario")
//    public String BusquedaUsuario(@WebParam(name = "username") String username)
//    {
//        if (this.tablaUsuarios.Buscar(username) != null)
//            this.tablaUsuarios.Buscar(username).toString();
//        
//        return "";
//    }
    
    
}


