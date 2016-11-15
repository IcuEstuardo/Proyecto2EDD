package TablaHash;

/**
 *
 * @author Estuardo
 */
public class Usuario {

    private String username;
    private String password;
    private String correo;
    private String path;
    
    public Usuario(String user, String pass, String email)
    {
        this.username = user;
        this.password = pass;
        this.correo = email;
        this.path = "";
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
    
}
