
package com.oasisdrinks.app.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class OrdenProduccion {
    private String idOrden;
    private Date fecha;
    private List<OrdenPPT> lineaOrdenes;
    
    public OrdenProduccion(String idOrden, Date fecha) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.lineaOrdenes = new ArrayList<>();
    }
    
    public String getIdOrden() {
        return idOrden;
    }
    
    public void setIdOrden(String idOrden) {
        this.idOrden = idOrden;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public List<OrdenPPT> getLineaOrdenes() {
        return lineaOrdenes;
    }
    
    public void agregarLineaOrden(OrdenPPT orden) {
        lineaOrdenes.add(orden);
    }
}
