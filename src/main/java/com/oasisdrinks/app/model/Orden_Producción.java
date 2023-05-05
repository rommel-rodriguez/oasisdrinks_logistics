
package com.oasisdrinks.app.model;

import java.util.Date;
import java.util.List;

public class Orden_Producción {
    private String idOrden;
    private Date fecha;


    public Orden_Producción(String idOrden, Date fecha) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        
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

  
}

