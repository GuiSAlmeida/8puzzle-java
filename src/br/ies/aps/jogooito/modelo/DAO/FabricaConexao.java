package br.ies.aps.jogooito.modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static Connection getConexao() {
		try {
			final String url = "jdbc:postgresql://ec2-3-226-134-153.compute-1.amazonaws.com:5432/deig3vfprd3qk9";
			final String user = "buofjgbiejsspc";
			final String password  = "a1fcd0502de0157f9d4570a50603f9bf96995cd27b51c7a844df6f43e85ceec3";
			
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
