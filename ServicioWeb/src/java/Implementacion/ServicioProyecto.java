/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "RegistroUsuario")
    public boolean RegistroUsuario(@WebParam(name = "username") String username,
                                   @WebParam(name = "password") String password,
                                   @WebParam(name = "correo") String correo)
    {
        return false;
    }

    @WebMethod(operationName = "IngresoUsuario")
    public boolean IngresoUsuario(@WebParam(name = "username") String username,
                                   @WebParam(name = "password") String password,
                                   @WebParam(name = "correo") String correo)
    {
        return false;
    }


}
