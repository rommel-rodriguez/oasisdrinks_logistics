package registro;

//import registro.Persona;

public class Alumno extends Persona {

    private String carrera;
    private int ciclo;

    public Alumno() {
    }

    public Alumno(String carrera, int ciclo, String nombre, String apellido, String codigo, String sede) {
        super(nombre, apellido, codigo, sede);
        this.carrera = carrera;
        this.ciclo = ciclo;
    }
    
    
    
    
    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: "+getNombre());
        System.out.println("Apellido: "+getApellido());
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Sede: "+getSede());
        System.out.println("Carrera: "+carrera);
        System.out.println("Ciclo: "+ciclo);
    }
/*
    @Override
    public String toString() {
        return codigo;
    }*/

    
}
