package br.ies.aps.jogooito.modelo.DAO;

import java.sql.SQLException;

import org.junit.Test;

import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.DAO.JogadorDAO;

public class TesteJogadorDAO {

	@Test
	public void testarNovoJogadorDAO() throws SQLException {
		Jogador jogador = new Jogador("Gui");

		JogadorDAO jogadorDAO = new JogadorDAO(jogador);
		jogadorDAO.incluirBanco(8);
	}
}
