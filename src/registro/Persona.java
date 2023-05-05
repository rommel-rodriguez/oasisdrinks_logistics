package registro;

public abstract class Persona {
    protected String nombre;
    protected String apellido;
    public String codigo;
    protected String sede;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String codigo, String sede) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.sede = sede;
    }
    
    public void mostrarDatos() {
        System.out.println("Nombre: "+getNombre());
        System.out.println("Apellido: "+getApellido());
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Sede: "+getSede());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
    
}
