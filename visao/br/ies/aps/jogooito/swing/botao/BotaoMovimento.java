package br.ies.aps.jogooito.swing.botao;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import br.ies.aps.jogooito.controle.TabuleiroControle;
import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.swing.ControleTabuleiro;
import br.ies.aps.jogooito.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public abstract class BotaoMovimento extends JButton implements ActionListener {
	private Tabuleiro tabuleiro;
	private Jogador jogador;
	private TabuleiroControle tabuleiroControle;
	private TelaTabuleiro telaTabuleiro;
	private ControleTabuleiro controleTabuleiro;

	public BotaoMovimento(String posicao, Tabuleiro tabuleiro, TelaTabuleiro telaTabuleiro,
			ControleTabuleiro controleTabuleiro, Jogador jogador) {
		setText(posicao);
		addActionListener(this);
		setTabuleiro(tabuleiro);
		setJogador(jogador);
		setTabuleiroControle(new TabuleiroControle(tabuleiro));
		setTelaTabuleiro(telaTabuleiro);
		setControleTabuleiro(controleTabuleiro);
	}

	public abstract void alteraEstadoTabuleiro() throws SQLException;

	public TabuleiroControle getTabuleiroControle() {
		return tabuleiroControle;
	}

	public void setTabuleiroControle(TabuleiroControle controle) {
		this.tabuleiroControle = controle;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public TelaTabuleiro getTelaTabuleiro() {
		return telaTabuleiro;
	}

	public void setTelaTabuleiro(TelaTabuleiro telaTabuleiro) {
		this.telaTabuleiro = telaTabuleiro;
	}

	public ControleTabuleiro getControleTabuleiro() {
		return controleTabuleiro;
	}

	public void setControleTabuleiro(ControleTabuleiro controleTabuleiro) {
		this.controleTabuleiro = controleTabuleiro;
	}
}
