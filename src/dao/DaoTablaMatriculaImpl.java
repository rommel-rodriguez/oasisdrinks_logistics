package dao;

import conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import registro.TablaMatricula;

public class DaoTablaMatriculaImpl implements Dao {

    private final Conexion conexion;
    private String mensaje;

    public DaoTablaMatriculaImpl() {
        this.conexion = null;
    }
    
    @Override
    public List<TablaMatricula> TablaMatriculaSel() {
        List<TablaMatricula > lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("Select")
                .append("item")
                .append("curso")
                .append("creditos")
                .append("ciclo")
                .append("nInscritos")
                .append("tipo")
                .append("seccion")
                .append("accion")
                .append("capacidad")
                .append("from Cursos");
        try (Connection cn = conexion.conn){
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {                
                TablaMatricula tabla = new TablaMatricula();
                tabla.setItem(rs.getInt(1));
                tabla.setCursos(rs.getString(2));
                tabla.setCreditos(rs.getInt(3));
                tabla.setCiclo(rs.getInt(4));
                tabla.setnIncripcion(rs.getInt(5));
                tabla.setTipo(rs.getString(6));
                tabla.setSeccion(rs.getInt(7));
                tabla.setAccion(rs.getString(8));
                tabla.setCapac(rs.getInt(9));
                lista.add(tabla);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return lista;
    }

    @Override
    public TablaMatricula TablaMatriculaGet(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String TablaMatriculaIns(TablaMatricula TablaMatricula) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String TablaMatriculaUpd(TablaMatricula TablaMatricula) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String TablaMatriculaDel(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getMessage() {
        return mensaje;
    }

}
