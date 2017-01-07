package TablaHash;

import Historial.Historial;

/**
 *
 * @author Estuardo
 */
public class Usuario {

    private String username;
    private String password;
    private String correo;
    private String path;
    private boolean estado;
    
    private Historial historial;
    
    public Usuario(String user, String pass, String email)
    {
        this.username = user;
        this.password = pass;
        this.correo = email;
        this.path = "";
        this.estado = true;
        this.historial = new Historial(user);
    }

    @Override
    public String toString() {
        return username + "," + password + "," + correo + "," + path + "," + estado;
    }

    @Override
    public boolean equals(Object obj) {
        return this.username.equals(obj);
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPath() {
        return path;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
    
}
