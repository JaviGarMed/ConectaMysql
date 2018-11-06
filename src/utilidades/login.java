package utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
	
	private Connection conexion;
	
	private ResultSet result;
	
	private Statement stm;
	
	public boolean checkUrs(String user, String pass) {
		String sql = "Select * from eShop where usuario = "+user+" && clave = "+pass;
		conexion = Conexion.conectar("localhost:3306", "eShop", "root", "12345678");
		
		try {
			stm = conexion.prepareStatement(sql);
			result =stm.executeQuery(sql);
			if (result.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}

}
