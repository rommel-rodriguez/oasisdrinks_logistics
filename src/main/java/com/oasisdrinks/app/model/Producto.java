package com.oasisdrinks.app.model;

public abstract class Producto {
    private int codProducto;
    private String nomProducto;
    protected int cantProducto;
    protected double precioVenta;
    private int diasCaducidad;
    private Receta receta;
    
    public Producto() {     }
    public Producto(int codProducto, String nomProducto, int cantProducto, double precioVenta, int diasCaducidad, Receta receta) {
        this.codProducto = codProducto;
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.precioVenta = precioVenta;
        this.diasCaducidad = diasCaducidad;
        this.receta = receta;
    }
    public Producto(int cantProducto, double precioVenta) {
        this.cantProducto = cantProducto;
        this.precioVenta = precioVenta;
    }
    
    public Receta getReceta(){return receta;}
    public void setReceta(Receta receta){this.receta = receta;}

    public int getCodProducto() {return codProducto;}
    public void setCodProducto(int codProducto) {this.codProducto = codProducto;}

    public String getNomProducto() {return nomProducto;}
    public void setNomProducto(String nomProducto) {this.nomProducto = nomProducto;}

    public int getCantProducto() {return cantProducto;}
    public void setCantProducto(int cantProducto) {this.cantProducto = cantProducto;}

    public double getPrecioVenta() {return precioVenta;}
    public void setPrecioVenta(double precioVenta) {this.precioVenta = precioVenta;}

    public int getDiasCaducidad() {return diasCaducidad;}
    public void setDiasCaducidad(int diasCaducidad) {this.diasCaducidad = diasCaducidad;}
    
    public void ValoresCosto(int c,double v){
        cantProducto=c;
        precioVenta=v;
    }
    
    @Override
    public String toString(){
        return "\nCódigo de producto   : "+codProducto+
               "\nNombre de producto   : "+nomProducto+
               "\nCantidad de producto : "+cantProducto+
               "\nPrecio de venta      : "+precioVenta+
               "\nDías de Caducidad    : "+diasCaducidad;
                }
}
