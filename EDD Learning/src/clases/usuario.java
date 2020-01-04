package clases;

public class usuario {

    private String nombre;
    private String apellido;
    private String carne;
    private String password;

    usuario(String name, String lsname, String carne, String pass) {
        this.nombre=name;
        this.apellido=lsname;
        this.carne=carne;
        this.password=pass;
    }
    
    public void setNombre(String name){this.nombre=name;}
    public void setApellido(String A){this.apellido=A;}
    public void setCarne(String C){this.carne=C;}
    public void setPassword(String P){this.password=P;}
    
    public String getNombre(){return this.nombre;}
    public String getApellido(){return this.apellido;}
    public String getCarne(){return this.carne;}
    public String getPassword(){return this.password;}
       
}