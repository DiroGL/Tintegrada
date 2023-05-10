package conexionSQL;
import java.sql.*;
public class ConexionBD {
	
	private final String base;
	private final String usuario;
	private final String pass;
	private String url;
	protected Connection c;
	
	/*Instancia de la conexion al iniciar el programa*/
	public ConexionBD(String bbdd) {

		base= bbdd;
		usuario = "root";
		pass = "accesodatos";
		url = "jdbc:mysql://localhost:8080/"+base;
		
	}
	
	public Connection abrirConexion(){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
                        Class.forName("com.mysql.cj.jdbc.Driver"); 
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		try{
		 	c = DriverManager.getConnection(url,usuario,pass);
			System.out.println("Conexión exitosa con la BBDD");
			return c;

		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
			return null;
		}
	
	}	
	

		
	
	public void cerrarConexion(){
		try{
			c.close();
			System.out.println("Se ha cerrado la conexión con la BBDD");

		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			
		}
	}
	
	
	

}
