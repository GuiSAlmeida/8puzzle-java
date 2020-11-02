package br.ies.aps.jogooito.banco;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class TesteConexao {

	@Test
	public void testarConexao() throws SQLException {
		Connection connection = FabricaConexao.getConexao();
		connection.close();
	}
}
