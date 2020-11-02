package br.ies.aps.jogooito.banco;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class TesteNovoTabuleiro {
	private Connection connection;

	@Before
	public void configurarConexao() throws SQLException {
		connection = FabricaConexao.getConexao();
	}

	@Test
	public void testarNovotabuleiro() throws SQLException {
		NovoTabuleiro tabuleiroBanco = new NovoTabuleiro(1,2,3,4,5,6,7,8,0);
		System.out.println(tabuleiroBanco.getIdTtabuleiro());
		
		connection.close();
	}
}
