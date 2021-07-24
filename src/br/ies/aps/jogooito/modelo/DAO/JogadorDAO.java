package br.ies.aps.jogooito.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ies.aps.jogooito.modelo.Jogador;

public class JogadorDAO {
	private Integer idJogador;

	private String nome;
	private Integer jogadas;
	private Boolean ganhador;

	public JogadorDAO(Jogador jogador) {
		this.nome = jogador.getJogadorNome();
		this.jogadas = jogador.getJogadas();
		this.ganhador = jogador.getGanhador();
	}

	public void incluirBanco(Integer idTabuleiro) throws SQLException {
		Connection conexao;
		String sql;
		ResultSet resultado;

		try {
			conexao = FabricaConexao.getConexao();
			sql = "INSERT INTO jogador (nome, jogadas, ganhador, id_tabuleiro) VALUES (?,?,?,?) RETURNING id;";
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setInt(2, jogadas);
			statement.setBoolean(3, ganhador);
			statement.setInt(4, idTabuleiro);
			statement.execute();

			resultado = statement.getResultSet();

			resultado.next();
			idJogador = resultado.getInt("id");

			resultado.close();
			statement.close();
			conexao.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizaBanco(Integer idJogador) throws SQLException {
		Connection conexao;
		String sql;
		PreparedStatement statement;
		
		try {
			conexao = FabricaConexao.getConexao();
			sql = "UPDATE jogador SET jogadas = ?, ganhador = ? WHERE id = ?;";

			statement = conexao.prepareStatement(sql);

			statement.setInt(1, jogadas);
			statement.setBoolean(2, ganhador);
			statement.setInt(3, idJogador);

			statement.execute();
			
			statement.close();
			conexao.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer getIdJogador() {
		return idJogador;
	}
}
