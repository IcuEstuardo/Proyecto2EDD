/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enlace;

/**
 *
 * @author Estuardo
 */
public class ConexionUsuarios {

    public String busquedaUsuario(java.lang.String username) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.busquedaUsuario(username);
    }

    public String eliminacionUsuario(java.lang.String username) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.eliminacionUsuario(username);
    }
    
    
    
    

//    public boolean modificacionUsuario(java.lang.String username, java.lang.String password, java.lang.String correo, java.lang.String path) {
//        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
//        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
//        return port.modificacionUsuario(username, password, correo, path);}

    public boolean modificacionUsuario(java.lang.String username, java.lang.String password, java.lang.String correo, java.lang.String path) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.modificacionUsuario(username, password, correo, path);
    }
    

    public String registroUsuario(java.lang.String username, java.lang.String password, java.lang.String correo) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.registroUsuario(username, password, correo);
    }

    public String reporteUsuario(java.lang.String nombre) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.reporteUsuario(nombre);
    }
    
    //?????????????????????????????????????????????????????????????????????????????????????????????????
    
    
    public String subirPesos(java.lang.String texto) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.subirPesos(texto);
    }

    public String subirVertices(java.lang.String texto) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.subirVertices(texto);
    }

    public String reporteGrafo(java.lang.String nombre, boolean ruta) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.reporteGrafo(nombre, ruta);
    }

    public boolean eliminarArbol(java.lang.String posicion1, java.lang.String posicion2) {
        implementacion.ServicioProyecto_Service service = new implementacion.ServicioProyecto_Service();
        implementacion.ServicioProyecto port = service.getServicioProyectoPort();
        return port.eliminarArbol(posicion1, posicion2);
    }

    
    
}
