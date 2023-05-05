package registro;
public class Curso {
    private String nombre;
    private String turno;
    private int cantHoras;
    private int cantCreditos;
    private String modalidad;

    public Curso() {
    }

    public Curso(String nombre, String turno, int cantHoras, int cantCreditos, String modalidad) {
        this.nombre = nombre;
        this.turno = turno;
        this.cantHoras = cantHoras;
        this.cantCreditos = cantCreditos;
        this.modalidad = modalidad;
    }

    public void verBoleta(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Turno: "+turno);
        System.out.println("Horas: "+cantHoras);
        System.out.println("Creditos: "+cantCreditos);
        System.out.println("modalidad: "+modalidad);
    }
}
