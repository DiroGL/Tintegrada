package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexionSQL.ConexionBD;
import entitiesBBDD.Compañias;

public class CompaniaDAO{
	 private ConexionBD conexionBD;
	public CompaniaDAO() {
    	//New Pull
    	conexionBD = new ConexionBD("tintegrador");    }

    public boolean agregarCompania(Compañias compania) { 
        try {
            String query = "INSERT INTO companias (coberturas,formaPago,Ncom,telcom) VALUES (?, ?, ?,?)";
          
            
            
            
            PreparedStatement statement = conexionBD.abrirConexion().prepareStatement(query);
            statement.setString(1, compania.getCoberturas());
            statement.setString(2, compania.getFormaPago());
            statement.setString(3, compania.getNcom());
            statement.setString(4, compania.getTelcom());

            int rowsInserted = statement.executeUpdate();
            statement.close();
 
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Compañias> obtenerCompanias() {
        List<Compañias> companias = new ArrayList<>();

        try {
            String query = "SELECT * FROM compañias";
            PreparedStatement statement = conexionBD.abrirConexion().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String coberturas = resultSet.getString("coberturas");
                String formaPago = resultSet.getString("formaPago");
                String Ncom = resultSet.getString("Ncom");
                String telcom = resultSet.getString("telcom");

                Compañias compania = new Compañias(coberturas,formaPago,Ncom,telcom);
                companias.add(compania);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companias;
    }

    public boolean actualizarCompania(String nombreAnterior, Compañias companiaNueva) {
        try {
            String query = "UPDATE companias SET Coberturas=?, FormaPago=?, NCom=?,TelCom=? WHERE nombre=?";
            PreparedStatement statement = conexionBD.abrirConexion().prepareStatement(query);
            statement.setString(1, companiaNueva.getCoberturas());
            statement.setString(2, companiaNueva.getFormaPago());
            statement.setString(3, companiaNueva.getNcom());
            statement.setString(4, companiaNueva.getTelcom());

            statement.setString(5, nombreAnterior);

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public List<Compañias> buscarCompanias(String filtro) {
        List<Compañias> companias = new ArrayList<>();

        try {
            String query = "SELECT * FROM companias WHERE nombre LIKE ?";
            PreparedStatement statement = conexionBD.abrirConexion().prepareStatement(query);
            statement.setString(1, "%" + filtro + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	 String coberturas = resultSet.getString("coberturas");
                 String formaPago = resultSet.getString("formaPago");
                 String Ncom = resultSet.getString("Ncom");
                 String telcom = resultSet.getString("telcom");

                 Compañias compania = new Compañias(coberturas,formaPago,Ncom,telcom);
                 companias.add(compania);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return companias;
    }
    public boolean eliminarCompania(String nombre) {
        try {
            String query = "DELETE FROM compañias WHERE nombre=?";
            PreparedStatement statement = conexionBD.abrirConexion().prepareStatement(query);
            statement.setString(1, nombre);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
}

