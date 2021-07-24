package br.ies.aps.jogooito.modelo.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import br.ies.aps.jogooito.modelo.DAO.FabricaConexao;

public class TesteConexao {

	@Test
	public void testarConexao() throws SQLException {
		Connection connection = FabricaConexao.getConexao();
		connection.close();
	}
}
