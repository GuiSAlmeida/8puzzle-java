package br.ies.aps.jogooito.swing.botao;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import br.ies.aps.jogooito.banco.JogadorDAO;
import br.ies.aps.jogooito.banco.TabuleiroDAO;
import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.swing.tela.TelaControle;
import br.ies.aps.jogooito.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public class BotaoMovimentoDireita extends BotaoMovimento {

	public BotaoMovimentoDireita(String posicao, Tabuleiro tabuleiro, TelaTabuleiro telaTabuleiro,
			TelaControle controleTabuleiro, Jogador jogador) {
		super(posicao, tabuleiro, telaTabuleiro, controleTabuleiro, jogador);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			alteraEstadoTabuleiro();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alteraEstadoTabuleiro() throws SQLException {
		this.getTabuleiroControle().moverPraDireita();
		this.getTelaTabuleiro().atualizarTelaTabuleiro(this.getTabuleiro());
		Integer jogadas = this.getJogador().getJogadas();
		this.getJogador().setJogadas(jogadas + 1);
		
		TabuleiroDAO tabuleiroDAO = new TabuleiroDAO(this.getTabuleiro());
		tabuleiroDAO.atualizaBanco(this.getTabuleiro().getIdTabuleiro());
		
		JogadorDAO jogadorDAO = new JogadorDAO(this.getJogador());
		jogadorDAO.atualizaBanco(this.getJogador().getIdJogador());
	};

}
