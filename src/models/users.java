package models;

import java.util.Date;

/**
 *
 */
public class users {
    private int id;
    private String user;
    private String password;
    private String nombre;
    private String email;
    private int tipo;
    private Date created_at;
    private int status;
    private String type_user;

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    private static users instance;
   
    /*
    public Usuario(int idusuario, String usuario, String nombreapellido, String identificacion, String idtipous ){
        this.IDUsuario = idusuario;
        this.Usuario = usuario;
        this.NombreApellidos = nombreapellido;
        this.Identificacion = identificacion;
        this.IdTipoUsuario = idtipous;
    }*/
    
    public users(){
        
    }
    
   
    public static users getInstance() {
        if (instance == null)
            instance = new users();
        return instance;
    }
}