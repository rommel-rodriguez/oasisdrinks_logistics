package registro;

import registro.Persona;

public class Profesor extends Persona{
    private String cursoCargo;

    public Profesor() {
    }

    public Profesor(String cursoCargo, String nombre, String apellido, String codigo, String sede) {
        super(nombre, apellido, codigo, sede);
        this.cursoCargo = cursoCargo;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: "+getNombre());
        System.out.println("Apellido: "+getApellido());
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Sede: "+getSede());
        System.out.println("Carrera: "+cursoCargo);
    }
}
