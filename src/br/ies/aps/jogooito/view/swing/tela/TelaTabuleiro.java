package br.ies.aps.jogooito.view.swing.tela;

import java.awt.GridLayout;

import javax.swing.JPanel;

import br.ies.aps.jogooito.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaTabuleiro extends JPanel {
	private TelaCampo campoCimaEsquerda;
	private TelaCampo campoCimaMeio;
	private TelaCampo campoCimaDireita;
	private TelaCampo campoMeioEsquerda;
	private TelaCampo campoMeio;
	private TelaCampo campoMeioDireita;
	private TelaCampo campoBaixoEsquerda;
	private TelaCampo campoBaixoMeio;
	private TelaCampo campoBaixoDireita;

	public TelaTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(3, 3));

		campoCimaEsquerda = new TelaCampo(tabuleiro.getCampoCimaEsquerda());
		add(campoCimaEsquerda.getCampoTela());

		campoCimaMeio = new TelaCampo(tabuleiro.getCampoCimaMeio());
		add(campoCimaMeio.getCampoTela());

		campoCimaDireita = new TelaCampo(tabuleiro.getCampoCimaDireita());
		add(campoCimaDireita.getCampoTela());

		campoMeioEsquerda = new TelaCampo(tabuleiro.getCampoMeioEsquerda());
		add(campoMeioEsquerda.getCampoTela());

		campoMeio = new TelaCampo(tabuleiro.getCampoMeio());
		add(campoMeio.getCampoTela());

		campoMeioDireita = new TelaCampo(tabuleiro.getCampoMeioDireita());
		add(campoMeioDireita.getCampoTela());

		campoBaixoEsquerda = new TelaCampo(tabuleiro.getCampoBaixoEsquerda());
		add(campoBaixoEsquerda.getCampoTela());

		campoBaixoMeio = new TelaCampo(tabuleiro.getCampoBaixoMeio());
		add(campoBaixoMeio.getCampoTela());

		campoBaixoDireita = new TelaCampo(tabuleiro.getCampoBaixoDireita());
		add(campoBaixoDireita.getCampoTela());
	}

	public void atualizarTelaTabuleiro(Tabuleiro tabuleiro) {
		campoCimaEsquerda.setCampoTela(tabuleiro.getCampoCimaEsquerda());
		campoCimaMeio.setCampoTela(tabuleiro.getCampoCimaMeio());
		campoCimaDireita.setCampoTela(tabuleiro.getCampoCimaDireita());
		campoMeioEsquerda.setCampoTela(tabuleiro.getCampoMeioEsquerda());
		campoMeio.setCampoTela(tabuleiro.getCampoMeio());
		campoMeioDireita.setCampoTela(tabuleiro.getCampoMeioDireita());
		campoBaixoEsquerda.setCampoTela(tabuleiro.getCampoBaixoEsquerda());
		campoBaixoMeio.setCampoTela(tabuleiro.getCampoBaixoMeio());
		campoBaixoDireita.setCampoTela(tabuleiro.getCampoBaixoDireita());
	}
}
