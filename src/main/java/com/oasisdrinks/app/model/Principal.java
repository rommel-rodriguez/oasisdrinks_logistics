
package com.oasisdrinks.app.model;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Principal {
    private static int opcion = 0;
    private static String menu = "";

    public static void main(String[] args) {
        // TODO code application logic here
        final int maxItems = 5;
        int [] arrCant;
        Insumo arrInsumo;
        String cad="", resp="";
        
        /*
        do {
            MostrarMenu();
            try {
                do {
                  cad = JOptionPane.showInputDialog(resp)menu;
                  
                }
                
            }
        }
        */
        
    }
    
    public static void mostrarMenu() {
        menu="";
        menu+="*********************************************************" + "\n";
        menu+="*               REGISTRO DE RECETAS                     *" + "\n";
        menu+="*********************************************************" + "\n";
        menu+="*                  OASIS DRINK                          *" + "\n";
        menu+="1.- Crear receta" + "\n";
        menu+="2.- Mostrar receta" + "\n";
        menu+="3.- Salir" + "\n";
        menu+="Seleccione una opcion" ;
    }
    
}
