package ejercicios;

import java.sql.*;

public class Ejercicio_03_02_01 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demodb";
        String usuario = "demodb";
        String contrasena = "demodb";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); Statement acceso = conexion.createStatement(); ResultSet resultado_acceso = acceso.executeQuery("select deptno, dname from DEPT")){
            while(resultado_acceso.next()){
                int numero_departamento = resultado_acceso.getInt("deptno");
                String nombre_departamento = resultado_acceso.getString("dname");
                System.out.println("Número: " + numero_departamento + ". Nombre: " + nombre_departamento);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}