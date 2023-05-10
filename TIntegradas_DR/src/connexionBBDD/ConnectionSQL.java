package connexionBBDD;

import java.sql.*;

public class ConnectionSQL {
	public static void main(String[] args) {

		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tintegrada","root","password");
				
				Statement sentencia = conexion.createStatement();
				String sql = "SELECT * FROM compañias";
				ResultSet result = sentencia.executeQuery(sql);
				while(result.next()) {
					
					System.out.printf("%s ,%s %s %s",result.getString(1),result.getString(2),result.getString(3),result.getString(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}
}
