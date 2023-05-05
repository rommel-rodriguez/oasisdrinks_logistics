package com.oasisdrinks.app.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ModelTest {
    
    @Test
    void testSKUItem() {
        SKUItem item = new SKUItem("ABC123", "Test Item", 10.0);
        assertEquals("ABC123", item.getCodigoItem());
        assertEquals("Test Item", item.getNombre());
        assertEquals(10.0, item.getPrecioCosto());
        
        item.setCodigoItem("DEF456");
        item.setNombre("Another Item");
        item.setPrecioCosto(20.0);
        assertEquals("DEF456", item.getCodigoItem());
        assertEquals("Another Item", item.getNombre());
        assertEquals(20.0, item.getPrecioCosto());
    }
    
    @Test
    void testProducto() {
        Producto producto = new Producto("ABC123", "Test Product", 10.0, 15.0, "Test NomProducto", 5, 7);
        assertEquals("ABC123", producto.getCodigoItem());
        assertEquals("Test Product", producto.getNombre());
        assertEquals(10.0, producto.getPrecioCosto());
        assertEquals(15.0, producto.getPrecioVenta());
        assertEquals("Test NomProducto", producto.getNomProducto());
        assertEquals(5, producto.getCantProducto());
        assertEquals(7, producto.getDiasCaducidad());
        
        producto.setCodigoItem("DEF456");
        producto.setNombre("Another Product");
        producto.setPrecioCosto(20.0);
        producto.setPrecioVenta(25.0);
        producto.setNomProducto("Another NomProducto");
        producto.setCantProducto(10);
        producto.setDiasCaducidad(14);
        assertEquals("DEF456", producto.getCodigoItem());
        assertEquals("Another Product", producto.getNombre());
        assertEquals(20.0, producto.getPrecioCosto());
        assertEquals(25.0, producto.getPrecioVenta());
        assertEquals("Another NomProducto", producto.getNomProducto());
        assertEquals(10, producto.getCantProducto());
        assertEquals(14, producto.getDiasCaducidad());
    }
    
    @Test
    void testInsumo() {
        Insumo insumo = new Insumo("ABC123", "Test Insumo", 10.0, "Test NomInsumo", 5, "kg");
        assertEquals("ABC123", insumo.getCodigoItem());
        assertEquals("Test Insumo", insumo.getNombre());
        assertEquals(10.0, insumo.getPrecioCosto());
        assertEquals("Test NomInsumo", insumo.getNomInsumo());
        assertEquals(5, insumo.getCantInsumo());
        assertEquals("kg", insumo.getUnidadCompra());
        
        insumo.setCodigoItem("DEF456");
        insumo.setNombre("Another Insumo");
        insumo.setPrecioCosto(20.0);
        insumo.setNomInsumo("Another NomInsumo");
        insumo.setCantInsumo(10);
        insumo.setUnidadCompra("l");
        assertEquals("DEF456", insumo.getCodigoItem());
        assertEquals("Another Insumo", insumo.getNombre());
        assertEquals(20.0, insumo.getPrecioCosto());
        assertEquals("Another NomInsumo", insumo.getNomInsumo());
        assertEquals(10, insumo.getCantInsumo());
        assertEquals("l", insumo.getUnidadCompra());
    }
}
   
