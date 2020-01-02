package clases;

public class Usuario {

    private String nombre;
    private String apellido;
    private String carne;
    private String password;

    public Usuario(String name, String lsname, String carne, String pass) {
        this.nombre=name;
        this.apellido=lsname;
        this.carne=carne;
        this.password=pass;
    }
    
    void setNombre(String name){this.nombre=name;}
    void setApellido(String A){this.apellido=A;}
    void setCarne(String C){this.carne=C;}
    void setPassword(String P){this.password=P;}
    
    String getNombre(){return this.nombre;}
    String getApellido(){return this.apellido;}
    String getCarne(){return this.carne;}
    String getPassword(){return this.password;}
       
}
