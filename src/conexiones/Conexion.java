
package conexiones;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   
    public Connection conn;

    public void conectar() {

        try {

            String dbURL = "jdbc:sqlserver://localhost\\MSSQL:1433;databaseName=ProyFinalPoo;encrypt=true;trustServerCertificate=true;"; //
            String user = "BD_Rivera";
            String pass = "u20227896";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
    