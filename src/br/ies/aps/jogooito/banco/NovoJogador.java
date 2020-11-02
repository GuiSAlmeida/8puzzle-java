package br.ies.aps.jogooito.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NovoJogador {
	private String sql;
	private Connection conexao;
	
	public NovoJogador(String nome, Integer jogadas, Boolean vencedor, Integer id_tabuleiro) throws SQLException {
		conexao = FabricaConexao.getConexao();
		sql = "INSERT INTO jogador (nome, jogadas, ganhador, id_tabuleiro) VALUES (?,?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, nome);
		statement.setInt(2, jogadas);
		statement.setBoolean(3, vencedor);
		statement.setInt(4, id_tabuleiro);
		statement.execute();
		statement.close();
		conexao.close();
	}	
}
