package registro;

public class Matricula {
    private double monto;
    private int cantCursos;
    private int cantHoras;

    public Matricula() {
    }

    public Matricula(double monto, int cantCursos, int cantHoras) {
        this.monto = monto;
        this.cantCursos = cantCursos;
        this.cantHoras = cantHoras;
    }
    
    public double calcularMonto(double monto){
        monto=cantCursos*cantHoras;
        return monto;
    }
}
