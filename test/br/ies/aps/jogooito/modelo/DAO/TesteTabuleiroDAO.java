package br.ies.aps.jogooito.modelo.DAO;

import java.sql.SQLException;

import org.junit.Test;

import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.modelo.DAO.TabuleiroDAO;

public class TesteTabuleiroDAO {

	@Test
	public void testarNovotabuleiro() throws SQLException {
		TabuleiroDAO tabuleiroDAO = new TabuleiroDAO(new Tabuleiro());
		tabuleiroDAO.inclirBanco();
		System.out.println(tabuleiroDAO.getIdTtabuleiro());
	}
}
