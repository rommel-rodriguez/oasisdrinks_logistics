package registro;

public class TablaMatricula {

    Integer item;
    String Cursos;
    Integer Creditos;
    Integer ciclo;
    Integer nIncripcion;
    String Tipo;
    Integer Seccion;
    String accion;
    Integer capac;

    public TablaMatricula() {
    }

    public TablaMatricula(Integer item, String Cursos, Integer Creditos, Integer ciclo, Integer nIncripcion, String Tipo, Integer Seccion, String accion, Integer capac) {
        this.item = item;
        this.Cursos = Cursos;
        this.Creditos = Creditos;
        this.ciclo = ciclo;
        this.nIncripcion = nIncripcion;
        this.Tipo = Tipo;
        this.Seccion = Seccion;
        this.accion = accion;
        this.capac = capac;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getCursos() {
        return Cursos;
    }

    public void setCursos(String Cursos) {
        this.Cursos = Cursos;
    }

    public Integer getCreditos() {
        return Creditos;
    }

    public void setCreditos(Integer Creditos) {
        this.Creditos = Creditos;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getnIncripcion() {
        return nIncripcion;
    }

    public void setnIncripcion(Integer nIncripcion) {
        this.nIncripcion = nIncripcion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Integer getSeccion() {
        return Seccion;
    }

    public void setSeccion(Integer Seccion) {
        this.Seccion = Seccion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Integer getCapac() {
        return capac;
    }

    public void setCapac(Integer capac) {
        this.capac = capac;
    }

}
