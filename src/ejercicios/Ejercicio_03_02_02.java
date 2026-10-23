package ejercicios;

import java.sql.*;

public class Ejercicio_03_02_02 {

    public static void main(String[] args) {
    	
    	if (args.length < 2) {
            System.out.println("No has introducido la informaci�n en los argumentos del main");
            return;
        }
    	
        String url = "jdbc:mysql://localhost:3306/demodb";
        String usuario = "demodb";
        String contrasena = "demodb";

        Integer numero_departamento = Integer.valueOf(args[1]);
        String nombre_departamento_actualizado = args[0];
        int actualizaciones = 0;

        try (Connection conexion = DriverManager.getConnection(url, usuario, contrasena); Statement acceso = conexion.createStatement()) {
        	String actualizacion = "UPDATE DEPT SET DNAME = '" + nombre_departamento_actualizado + "' WHERE DEPTNO = " + numero_departamento + ";";
        	actualizaciones = acceso.executeUpdate(actualizacion);
            System.out.println("El nombre del departmento " + numero_departamento + " ha sido actualizado.");
            System.out.println("Nuevo nombre del departamento: " + nombre_departamento_actualizado);
        } catch (SQLException e) {
        	e.printStackTrace();
        }

        System.out.println("Número de filas actualizadas: " + actualizaciones);
    }
}