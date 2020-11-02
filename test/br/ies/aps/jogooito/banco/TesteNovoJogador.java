package br.ies.aps.jogooito.banco;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class TesteNovoJogador {
	private Connection connection;

	@Before
	public void configurarConexao() throws SQLException {
		connection = FabricaConexao.getConexao();
	}

	@SuppressWarnings("unused")
	@Test
	public void testarNovoJogador() throws SQLException {
		NovoJogador jogador = new NovoJogador("Guilherme", 100, true, 2);

		connection.close();
	}
}
