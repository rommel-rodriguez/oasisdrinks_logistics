package dao;

import conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import registro.Horarios;

public class DaoHorarioImpl implements DaoHorario {

    private final Conexion conexion;
    private String mensaje;

    public DaoHorarioImpl() {
        this.conexion = null;
    }

    @Override
    public List<Horarios> HorariosSel() {

        List<Horarios> lista = null;

        try ( Connection cn = conexion.conn) {
            StringBuilder sql = new StringBuilder();
            sql.append("Select")
                    .append("item")
                    .append("curso")
                    .append("Lunes")
                    .append("Martes")
                    .append("Miercoles")
                    .append("Jueves")
                    .append("Viernes")
                    .append("Sabado");
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Horarios tabla = new Horarios();
                tabla.setItem(rs.getInt(1));
                tabla.setCurso(rs.getString(2));
                tabla.setLunes(rs.getString(3));
                tabla.setMartes(rs.getString(4));
                tabla.setMiercoles(rs.getString(5));
                tabla.setJueves(rs.getString(6));
                tabla.setViernes(rs.getString(7));
                tabla.setSabado(rs.getString(8));
                lista.add(tabla);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;

        /*DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM CursosMatriculados";
        try {

            Statement stmt = con.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            //int a= Integer.parseInt(miResultSet.getString(1));
            modelo.setColumnIdentifiers(new Object[]{"item", "curso",
                "lunes","martes", "miercoles", "jueves", "viernes", "sabado"});
            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("seccion"), rs.getString("curso"),
                    rs.getString("lunes"), rs.getString("martes"),
                    rs.getString("miercoles"), rs.getString("jueves"), rs.getString("viernes"), rs.getString("sabado")
                });

                tabla1.setModel(modelo);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se conecto");
        }*/
    }

    @Override
    public Horarios HorariosGet(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String HorariosIns(Horarios Horarios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String HorariosUpd(Horarios Horarios) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String HorariosDel(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

}
