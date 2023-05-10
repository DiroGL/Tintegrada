package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterfazBDImpl implements InterfazBD {

	private Connection conexion;

	public InterfazBDImpl(Connection conexion) {
		this.conexion = conexion;
	}

	@Override
	public void crearRegistro() {
		
		try {
			// Preparar una sentencia SQL para la inserción
			String sql = "INSERT INTO tabla (columna1, columna2, columna3) VALUES (?, ?, ?)";
			PreparedStatement statement = conexion.prepareStatement(sql);

			// Establecer los valores de los parámetros en la sentencia
			statement.setString(1, "valor1");
			statement.setString(2, "valor2");
			statement.setString(3, "valor3");

			// Ejecutar la sentencia de inserción
			statement.executeUpdate();

			// Cerrar el statement
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void leerRegistro() {
	
		try {

			String sql = "SELECT * FROM tabla WHERE columna = ?";
			PreparedStatement statement = conexion.prepareStatement(sql);

			statement.setString(1, "valor");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String columna1 = resultSet.getString("columna1");
				String columna2 = resultSet.getString("columna2");
				String columna3 = resultSet.getString("columna3");

				System.out.println("columna1: " + columna1);
				System.out.println("columna2: " + columna2);
				System.out.println("columna3: " + columna3);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actualizarRegistro() {
		
		try {
			String sql = "UPDATE tabla SET columna1 = ?, columna2 = ? WHERE columna3 = ?";
			PreparedStatement statement = conexion.prepareStatement(sql);

			statement.setString(1, "nuevoValor1");
			statement.setString(2, "nuevoValor2");
			statement.setString(3, "valor3");

			statement.executeUpdate();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarRegistro() {
		
		try {

			String sql = "DELETE FROM tabla WHERE columna = ?";
			PreparedStatement statement = conexion.prepareStatement(sql);

			statement.setString(1, "valor");

			statement.executeUpdate();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}