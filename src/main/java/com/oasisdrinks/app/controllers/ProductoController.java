/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.dao.ProductoDao;
import com.oasisdrinks.app.dao.RecetaDao;
import com.oasisdrinks.app.models.Bebida;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.models.MedidaService;
import com.oasisdrinks.app.models.Producto;
import com.oasisdrinks.app.models.Producto;
import com.oasisdrinks.app.models.ProductoService;
import com.oasisdrinks.app.models.ProductoService;
import com.oasisdrinks.app.models.RecetaService;
import com.oasisdrinks.app.utils.dbconnection.ConnectionFactory;
import com.oasisdrinks.app.utils.dbconnection.HikariCPConnectionPool;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.ProductoView;
import com.oasisdrinks.app.views.RecetaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class ProductoController implements ActionListener, ListSelectionListener {

    private ProductoService modelService;
    private ProductoView view;
    private ConnectionFactory conFactory;

    public ProductoController(ProductoService modelService, ProductoView view) {
        this.modelService = modelService;
        this.view = view;
        view.getBtnGuardar().addActionListener(this);
        view.getBtnNuevo().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getRefreshButton().addActionListener(this);
        view.getDetailButton().addActionListener(this);
        view.getTblDatos()
            .getSelectionModel()
            .addListSelectionListener(this);
        init();
    }

    private void init() {
        readAction();
        fillMedidasCombo();
        fillTiposCombo();
        centerTableCells();
    }

    private void centerTableCells() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        view.getTblDatos().setDefaultRenderer(Object.class, centerRenderer);
    }

    private void readAction() {
        loadDataToTable();
    }

    private void filterAction() {
        //List<Producto> productos = modelService.getAll();
        //List<Producto> filtered = new ArrayList<>();
        //String property = view.getFilterCombo().getSelectedItem().toString();

        //System.out.println("[DEBUG] Inside filter action, productos: " + productos);
        //System.out.println("[DEBUG] Inside filter action, productos size: " + productos.size());
        //System.out.println("[DEBUG] Inside filter action, property: " + property);
        //switch (property) {
        //    case "id":
        //        // TODO: Needs validation
        //        int value = Integer.parseInt( view.getFilterValue().getText() );
        //        productos.stream()
        //            .filter((producto) -> producto.getCodProducto() == value)
        //            .forEach(filtered::add);

        //        break;
        //    case "nombre":
        //        break;
        //    default:
        //        break;
        //}
        //System.out.println("[DEBUG] Filter result:\n " + filtered);
        //loadListToTable(filtered);

    }

    private void loadDataToTable(){
        List<Producto> productos = new ArrayList<>();

        productos = modelService.getAll();

        loadListToTable(productos);

    }

    private void loadListToTable(List<Producto> productos){
        DefaultTableModel tableModel = null;
        tableModel =  (DefaultTableModel) view.getTblDatos().getModel();

        tableModel.setRowCount(0);

        if (productos == null || productos.isEmpty())
            return;

        for (Producto producto: productos) {
            producto.setMargenGanancia(producto.getMargenGanancia() * 100); //TODO: Unsure about this line 
            agregarFila(producto, tableModel);
        }
    }

    private Producto getModelFromForm() {
        int cod = 0;
        String nombre = "";
        int cantidad = 0;
        String tipo = null;
        double margen = 0;
        Medida medida = null;
        int diasCaducidad;
        MedidaService medidaSrv = new MedidaService(new MedidaDao( new MySQLPool()));

        nombre = view.getTxtNombre().getText();
        tipo = view.getTiposCombo()
            .getSelectedItem()
            .toString();
        medida = medidaSrv.buscarMedidaPorAbrev(
            view.getMedidasCombo().getSelectedItem().toString()
        );
        try{
            cod = Integer.parseInt(view.getTxtCodigo().getText());
        } catch (NumberFormatException e) {
            System.out.println("[DEBUG] No code");
        }

        try{
            cantidad = Integer.parseInt(view.getTxtCantidad().getText());
            margen = Double.parseDouble(view.getTxtMargen().getText()); // margen as the user sees it is in %
            margen = margen/100;
            diasCaducidad= Integer.parseInt(view.getTxtDiasCaducidad().getText());
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] Campo invalido");
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return null;
        }

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un entero positivo.", "Error en Cantidad", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (margen <= 0 || margen >= 1) {
            JOptionPane.showMessageDialog(null, "El margen de ganancia debe estar en el rango 0 (exclusivo) a 1 (exclusivo).", "Error en Margen de Ganancia", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (diasCaducidad <= 0) {
            JOptionPane.showMessageDialog(null, "Los días de caducidad deben ser un entero positivo.", "Error en Días de Caducidad", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        Producto producto = null;
        //System.out.println("[DEBUG] Searching for producto with abrev: " + abrev);

        switch ( tipo ) {
            case "Bebida":
                System.out.println("[INFO] Product is of Bebida Type");
                producto = new Bebida();
                break;
            default:
                producto = new Bebida();
                break;
        }
        // Producto producto = new Bebida();
        producto.setCodProducto(cod);
        producto.setNomProducto(nombre);
        producto.setCantProducto(cantidad);
        producto.setTipo(modelService.getTipoProductoFromNombre(tipo));
        producto.setDiasCaducidad(diasCaducidad);
        producto.setMedida(medida);
        producto.setEstado(1);

        return producto; 
    }

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }


    // private void fillFilterCombo() {
    //     JComboBox<String> filterCombo = view.getFilterCombo();
    //     fillCombo(filterCombo, Arrays.asList("id", "nombre", "tipo"));
    // }
    
    private void emptyForm () {
        System.out.println("[DEBUG]  Nuevo button pressed");

        view.getTxtCodigo().setText("");
        view.getTxtNombre().setText("");
        view.getTxtCantidad().setText("");
        view.getTxtDiasCaducidad().setText("");
        view.getTxtMargen().setText("");
        //view.getTiposCombo().setSelectedItem(rowObjects.get(2).toString());
        //view.getMedidasCombo().setSelectedItem(rowObjects.get(3).toString());
    }

    private void agregarFila(Producto mod, DefaultTableModel tblModel){
        //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        System.out.println("[DEBUG] Trying to add tor table row producto:  " + mod);


        tblModel.addRow(modelToArray(mod));
    }

    private void fillForm(List<Object> rowObjects) {
        emptyForm();
        view.getTxtCodigo().setText(rowObjects.get(0).toString());
        view.getTxtNombre().setText(rowObjects.get(1).toString());
        view.getTxtCantidad().setText(rowObjects.get(4).toString());
        view.getTxtDiasCaducidad().setText(rowObjects.get(5).toString());
        view.getTxtMargen().setText(rowObjects.get(6).toString());

        //view.getTiposCombo().setSelectedItem(rowObjects.get(2).toString());
        view.getTiposCombo().setSelectedItem( modelService.getNombreTipoFromTipoProducto((String) rowObjects.get(2)) );
        view.getMedidasCombo().setSelectedItem(rowObjects.get(3).toString());
        
    }

    private Object[]  modelToArray (Producto mod) {

        return new Object[]{
                mod.getCodProducto(), 
                mod.getNomProducto(),
                mod.getTipo(),
                mod.getMedida().getAbrev(),
                mod.getCantProducto(),
                mod.getDiasCaducidad(),
                mod.getMargenGanancia(),
                mod.calcularCostoTotal(),
                mod.calcularPrecioDeVenta()
        };
    }

    // private Producto createProductoFromCombo(){
    //     Producto med = null;
    //     String abrev;
    //     ProductoService productoSrv = new ProductoService(new ProductoDao( new MySQLPool()));

    //     abrev = (String) view.getProductosCombo().getSelectedItem();

    //     med = productoSrv.buscarProductoPorAbrev(abrev);

    //     return med;
    // } 

    public void createAction() {
        Producto localModel = getModelFromForm();
        if (localModel == null)
            return;

        modelService.add(localModel);
        readAction();
    }

    public void updateAction() {
        Producto localModel = getModelFromForm();
        if (localModel == null)
            return;
        modelService.update(localModel);
        readAction();
    }

    public void deleteAction() {
        int codigo = 0;

        try {
            codigo = Integer.parseInt(view.getTxtCodigo().getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (codigo <= 0) {
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return;

        }

        modelService.delete(codigo);
        //readAction();
        loadDataToTable();
        //modelService.delete(id);
    }


    public void refreshView() {
        // List<Producto> productos = modelService.getAllProductos();
        // view.displayProductos(productos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if ( source == view.getBtnGuardar()) {
            createAction();
        } else if ( source ==  view.getBtnNuevo()) {
            System.out.println("[DEBUG]  Nuevo button pressed");
            emptyForm();
        } else if ( source == view.getDeleteButton() ) {
            System.out.println("[DEBUG]  Delete button pressed");
            deleteAction();
        } else if ( source ==  view.getUpdateButton()) {
            System.out.println("[DEBUG]  Update button pressed");
            updateAction();
        } else if ( source ==  view.getDetailButton()) {
            System.out.println("[DEBUG]  Details button pressed");
            showDetails();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        if (!e.getValueIsAdjusting()) {
            int selectedRow = view.getTblDatos().getSelectedRow();
            if (selectedRow >= 0) {
                int columnCount = view.getTblDatos().getColumnCount();
                List<Object> rowObjects = new ArrayList<>();

                // Assuming the desired columns are at index 0, 1, and 2
                for (int i = 0; i < columnCount; i++) {
                    Object obj = view.getTblDatos().getValueAt(selectedRow, i);
                    rowObjects.add(obj);
                }
                fillForm(rowObjects);
            }
        }
    }

    private void showDetails() {
        int codigo = 0;

        try {
            codigo = Integer.parseInt(view.getTxtCodigo().getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (codigo <= 0) {
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return;

        }

        RecetaDao recetaDao = null;
        try{
            recetaDao = new RecetaDao( new MySQLPool());
        } catch (Exception e) {
            // NOTE: I am assuming tthis will be a MySQL communications exception
            // new ErrorView("Database Conexion", "No se pudo establecer connection con la Base de Datos");
            System.out.println("[INFO] Showing details error:" + e);
            e.printStackTrace();
            return;
        }

        RecetaService recetaService = new RecetaService(recetaDao);
        RecetaView recetaView = new RecetaView();
        recetaView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        RecetaController controller = new RecetaController(recetaService, recetaView, codigo);


        recetaView.setLocationRelativeTo(null); // Center the frame
        recetaView.setVisible(true);

    }


    private void fillTiposCombo () {
        List<String> tipos = null;

        tipos = modelService.listarTipos();

        if (tipos == null) {
            JOptionPane.showMessageDialog(null, "No se pudieron conseguir los tipos!",
                           "Error Tipos", JOptionPane.ERROR_MESSAGE);
            return;
        }


        fillCombo(view.getTiposCombo(), tipos);
    }


    private void fillMedidasCombo () {

        List<Medida> meds = null;
        List<String> abrevList = new ArrayList<>();
        MedidaService medidaSrv = new MedidaService(new MedidaDao( new MySQLPool()));

        meds = medidaSrv.getAll();
        System.out.println("[INFO] Medidas listed: " + meds.toString());

        if (meds == null) {
            JOptionPane.showMessageDialog(null, "No se pudieron conseguir las medidas!",
                           "Error Medidas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        meds.forEach(medida -> abrevList.add(medida.getAbrev()));


        fillCombo(view.getMedidasCombo(), abrevList);
    }


    private void fillProductosCombo () {
    }

    //public Producto buscarProductoPorAbrev(String abrev) {
    //   return modelService.buscarProductoPorAbrev(abrev) ;
    //}
    
}
