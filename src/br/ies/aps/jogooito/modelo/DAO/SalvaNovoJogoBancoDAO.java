package br.ies.aps.jogooito.modelo.DAO;

import java.sql.SQLException;

import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.Tabuleiro;

public class SalvaNovoJogoBancoDAO {
	private Tabuleiro tabuleiro;
	private Jogador jogador;
	private TabuleiroDAO tabuleiroDAO;
	private Integer idTabuleiro;
	private JogadorDAO jogadorDAO;
	private Integer idJogador;

	public SalvaNovoJogoBancoDAO(Tabuleiro tabuleiro, Jogador jogador) {
		this.tabuleiro = tabuleiro;
		this.jogador = jogador;
	}

	public void salvar() {
		tabuleiroDAO = new TabuleiroDAO(this.tabuleiro);

		try {
			tabuleiroDAO.inclirBanco();
			idTabuleiro = tabuleiroDAO.getIdTtabuleiro();

			jogadorDAO = new JogadorDAO(this.jogador);
			jogadorDAO.incluirBanco(idTabuleiro);
			idJogador = jogadorDAO.getIdJogador();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer getIdTabuleiro() {
		return idTabuleiro;
	}
	
	public Integer getIdJogador() {
		return idJogador;
	}
}
