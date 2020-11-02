package br.ies.aps.jogooito.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NovoTabuleiro {
	private String sql;
	private Connection conexao;
	private Integer idTabuleiro;

	public NovoTabuleiro(Integer campo1, Integer campo2, Integer campo3, 
						Integer campo4, Integer campo5, Integer campo6, 
						Integer campo7, Integer campo8, Integer campo9) throws SQLException {
		
		conexao = FabricaConexao.getConexao();
		sql = "INSERT INTO tabuleiro (campo_cima_esquerda, campo_cima_meio, campo_cima_direita,\n"
				+ "campo_meio_esquerda, campo_meio_meio, campo_meio_direita,\n"
				+ "campo_baixo_esquerda, campo_baixo_meio, campo_baixo_direita)"
				+ "VALUES (?,?,?,?,?,?,?,?,?) RETURNING id;";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setInt(1, campo1);
		statement.setInt(2, campo2);
		statement.setInt(3, campo3);
		statement.setInt(4, campo4);
		statement.setInt(5, campo5);
		statement.setInt(6, campo6);
		statement.setInt(7, campo7);
		statement.setInt(8, campo8);
		statement.setInt(9, campo9);
		
		statement.execute();
		ResultSet resultado = statement.getResultSet();
		
		resultado.next();
		idTabuleiro = resultado.getInt("id");
		
		resultado.close();
		statement.close();
		conexao.close();
	}

	public Integer getIdTtabuleiro() {
		return idTabuleiro;
	}
}
