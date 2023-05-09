/*
 * BD_Conector: Se encarga de abrir y cerrar la base de datos
 */
package bbdd;

import java.sql.*;


public class BD_Conector {
	private String base;
	private String usuario;
	private String pass;
	private String url;
	protected Connection c;
	
	
	
	public BD_Conector(String bbdd){		
		base= bbdd;
		usuario = "root";
		pass = "password";
		url="jdbc:mysql://localhost/"+base;
	}
	
	public void abrir(){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver"); 
			System.out.println("Correcto el driver");

		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
			System.out.println("No funciona el driver");
		}
		try{
		 	c = DriverManager.getConnection(url,usuario,pass);
		 	System.out.println("Correcto la conexion");
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
	
	}	
	

	public void cerrar(){
		try{
			c.close();
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}
	
}
