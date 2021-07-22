package br.ies.aps.jogooito.view.swing.botao;

import java.awt.event.ActionEvent;

import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.view.swing.tela.TelaControle;
import br.ies.aps.jogooito.view.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public class BotaoMovimentoDireita extends BotaoMovimento {

	public BotaoMovimentoDireita(String posicao, Tabuleiro tabuleiro, 
		TelaTabuleiro telaTabuleiro, TelaControle controleTabuleiro, Jogador jogador) {
		super(posicao, tabuleiro, telaTabuleiro, controleTabuleiro, jogador);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		alteraEstadoTabuleiro();
	}

	@Override
	public void alteraEstadoTabuleiro() {
		this.getTabuleiroControle().moverPraDireita();
		this.getTelaTabuleiro().atualizarTelaTabuleiro(this.getTabuleiro());
		Integer jogadas = this.getJogador().getJogadas();
		this.getJogador().setJogadas(jogadas + 1);
	};
}
