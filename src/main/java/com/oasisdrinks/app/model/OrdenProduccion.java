
package com.oasisdrinks.app.model;

import java.util.Date;
import java.util.List;

public class OrdenProduccion {
    private String idOrden;
    private Date fecha;
    private List<OrdenPPT> lineaOrden;

    public OrdenProduccion(String idOrden, Date fecha, List<OrdenPPT> lineaOrden) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.lineaOrden = lineaOrden;
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

    public List<OrdenPPT> getLineaOrden() {
        return lineaOrden;
    }

    public void setLineaOrden(List<OrdenPPT> lineaOrden) {
        this.lineaOrden = lineaOrden;
    }

    public void agregarLineaOrden(OrdenPPT orden) {
        this.lineaOrden.add(orden);
    }
}