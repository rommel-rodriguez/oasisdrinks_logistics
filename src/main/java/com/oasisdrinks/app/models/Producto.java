package com.oasisdrinks.app.models;

public abstract class Producto {
    private int codProducto;
    private String nomProducto;
    protected int cantProducto;
    private int diasCaducidad;
    private Receta receta = null;
    private String tipo;
    private double margenGanancia = 0; // NOTE: Should be a percentage of the total cost after adding the
    private Medida medida; // NOTE: Should be a percentage of the total cost after adding the
    // packaging costs.
    
    public Producto() {  

    }

    public Producto(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, Receta receta, String tipo, double margenGanancia) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.diasCaducidad = diasCaducidad;
        this.receta = receta;
        this.tipo = tipo;
        this.margenGanancia = margenGanancia;
    }

    public Producto(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, Receta receta, double margenGanancia) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.diasCaducidad = diasCaducidad;
        this.receta = receta;
        this.margenGanancia = margenGanancia;
    }

    public Producto(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, double margenGanancia) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.diasCaducidad = diasCaducidad;
        this.margenGanancia = margenGanancia;
    }

    public Producto(String nomProducto, int cantProducto, int diasCaducidad, double margenGanancia) {
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.diasCaducidad = diasCaducidad;
        this.margenGanancia = margenGanancia;
    }





    public Producto(int codProducto, String nomProducto) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
    }

    
    public Receta getReceta(){return receta;}
    public void setReceta(Receta receta){this.receta = receta;}

    public int getCodProducto() {return codProducto;}
    public void setCodProducto(int codProducto) {this.codProducto = codProducto;}

    public String getNomProducto() {return nomProducto;}
    public void setNomProducto(String nomProducto) {this.nomProducto = nomProducto;}

    public int getCantProducto() {return cantProducto;}
    public void setCantProducto(int cantProducto) {this.cantProducto = cantProducto;}

    public int getDiasCaducidad() {return diasCaducidad;}
    public void setDiasCaducidad(int diasCaducidad) {this.diasCaducidad = diasCaducidad;}

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double calcularCostoEmpaquetado() {
        // TODO: Where do I get this from ?
        return 0;
    }

    public double calcularCostoInsumos() {
        double costo;

        costo = 0;

        if (receta == null)
            return 0;


        for ( RecetaDetalle detalle : receta.getDetalles()) {
            costo += detalle.getInsumo().getPrecioCosto();
        }

        return costo;
    }

    public double calcularCostoTotal() {
        return calcularCostoInsumos() + calcularCostoEmpaquetado();
    }

    public double calcularPrecioDeVenta() {
        return (1 + this.margenGanancia) * calcularCostoInsumos();
    }



    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    @Override
    public String toString() {
        return "Producto{" + "codProducto=" + codProducto + ", nomProducto=" + nomProducto + ", cantProducto=" + cantProducto + ", diasCaducidad=" + diasCaducidad + ", receta=" + receta + ", tipo=" + tipo + ", margenGanancia=" + margenGanancia + ", medida=" + medida + '}';
    }

    
}
