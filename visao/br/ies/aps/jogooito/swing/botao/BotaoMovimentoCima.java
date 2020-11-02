package br.ies.aps.jogooito.swing.botao;

import java.awt.event.ActionEvent;

import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.swing.ControleTabuleiro;
import br.ies.aps.jogooito.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public class BotaoMovimentoCima extends BotaoMovimento {

	public BotaoMovimentoCima(String posicao, Tabuleiro tabuleiro, TelaTabuleiro telaTabuleiro,
			ControleTabuleiro controleTabuleiro) {
		super(posicao, tabuleiro, telaTabuleiro, controleTabuleiro);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		alteraEstadoTabuleiro();
	}

	@Override
	public void alteraEstadoTabuleiro() {
		this.getTabuleiroControle().moverPraCima();
		this.getTelaTabuleiro().atualizarTelaTabuleiro(this.getTabuleiro());
		this.getTabuleiro().setJogadas(this.getTabuleiro().getJogadas() + 1);
//		this.getControleTabuleiro().atualizaJogadas(this.getTabuleiro().getJogadas());
	};

}
