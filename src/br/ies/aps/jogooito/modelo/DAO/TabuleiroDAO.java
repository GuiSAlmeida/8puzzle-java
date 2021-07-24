package br.ies.aps.jogooito.modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.ies.aps.jogooito.modelo.Tabuleiro;

public class TabuleiroDAO {
	private Integer idTabuleiro;

	private Integer campo_cima_esquerda;
	private Integer campo_cima_meio;
	private Integer campo_cima_direita;
	private Integer campo_meio_esquerda;
	private Integer campo_meio_meio;
	private Integer campo_meio_direita;
	private Integer campo_baixo_esquerda;
	private Integer campo_baixo_meio;
	private Integer campo_baixo_direita;

	public TabuleiroDAO(Tabuleiro tabuleiro) {
		campo_cima_esquerda = tabuleiro.getCampoCimaEsquerda();
		campo_cima_meio = tabuleiro.getCampoCimaMeio();
		campo_cima_direita = tabuleiro.getCampoCimaDireita();
		campo_meio_esquerda = tabuleiro.getCampoMeioEsquerda();
		campo_meio_meio = tabuleiro.getCampoMeio();
		campo_meio_direita = tabuleiro.getCampoMeioDireita();
		campo_baixo_esquerda = tabuleiro.getCampoBaixoEsquerda();
		campo_baixo_meio = tabuleiro.getCampoBaixoMeio();
		campo_baixo_direita = tabuleiro.getCampoBaixoDireita();
	}

	public void inclirBanco() throws SQLException {
		Connection conexao;
		String sql;
		PreparedStatement statement;
		ResultSet resultado;
		
		try {
			conexao = FabricaConexao.getConexao();
			sql = "INSERT INTO tabuleiro (campo_cima_esquerda, campo_cima_meio, campo_cima_direita,\n"
					+ "campo_meio_esquerda, campo_meio_meio, campo_meio_direita,\n"
					+ "campo_baixo_esquerda, campo_baixo_meio, campo_baixo_direita)\n"
					+ "VALUES (?,?,?,?,?,?,?,?,?) RETURNING id;";

			statement = conexao.prepareStatement(sql);

			statement.setInt(1, campo_cima_esquerda);
			statement.setInt(2, campo_cima_meio);
			statement.setInt(3, campo_cima_direita);
			statement.setInt(4, campo_meio_esquerda);
			statement.setInt(5, campo_meio_meio);
			statement.setInt(6, campo_meio_direita);
			statement.setInt(7, campo_baixo_esquerda);
			statement.setInt(8, campo_baixo_meio);
			statement.setInt(9, campo_baixo_direita);

			statement.execute();
			resultado = statement.getResultSet();

			resultado.next();
			idTabuleiro = resultado.getInt("id");
			
			resultado.close();
			statement.close();
			conexao.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizaBanco(Integer idTabuleiro) throws SQLException {
		Connection conexao;
		String sql;
		PreparedStatement statement;
		
		try {
			conexao = FabricaConexao.getConexao();
			sql = "UPDATE tabuleiro SET campo_cima_esquerda = ?, campo_cima_meio = ?, campo_cima_direita = ?,\n"
					+ "campo_meio_esquerda = ?, campo_meio_meio = ?, campo_meio_direita = ?,\n"
					+ "campo_baixo_esquerda = ?, campo_baixo_meio = ?, campo_baixo_direita = ?"
					+ "WHERE id = ?;";

			statement = conexao.prepareStatement(sql);

			statement.setInt(1, campo_cima_esquerda);
			statement.setInt(2, campo_cima_meio);
			statement.setInt(3, campo_cima_direita);
			statement.setInt(4, campo_meio_esquerda);
			statement.setInt(5, campo_meio_meio);
			statement.setInt(6, campo_meio_direita);
			statement.setInt(7, campo_baixo_esquerda);
			statement.setInt(8, campo_baixo_meio);
			statement.setInt(9, campo_baixo_direita);
			statement.setInt(10, idTabuleiro);

			statement.execute();
			
			statement.close();
			conexao.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer getIdTtabuleiro() {
		return idTabuleiro;
	}
}
