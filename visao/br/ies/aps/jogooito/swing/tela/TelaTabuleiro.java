package br.ies.aps.jogooito.swing.tela;

import java.awt.GridLayout;

import javax.swing.JPanel;

import br.ies.aps.jogooito.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaTabuleiro extends JPanel {
	private CampoTela campoCimaEsquerda;
	private CampoTela campoCimaMeio;
	private CampoTela campoCimaDireita;
	private CampoTela campoMeioEsquerda;
	private CampoTela campoMeio;
	private CampoTela campoMeioDireita;
	private CampoTela campoBaixoEsquerda;
	private CampoTela campoBaixoMeio;
	private CampoTela campoBaixoDireita;

	public TelaTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(3, 3));

		campoCimaEsquerda = new CampoTela(tabuleiro.getCampoCimaEsquerda());
		add(campoCimaEsquerda.getCampoTela());

		campoCimaMeio = new CampoTela(tabuleiro.getCampoCimaMeio());
		add(campoCimaMeio.getCampoTela());

		campoCimaDireita = new CampoTela(tabuleiro.getCampoCimaDireita());
		add(campoCimaDireita.getCampoTela());

		campoMeioEsquerda = new CampoTela(tabuleiro.getCampoMeioEsquerda());
		add(campoMeioEsquerda.getCampoTela());

		campoMeio = new CampoTela(tabuleiro.getCampoMeio());
		add(campoMeio.getCampoTela());

		campoMeioDireita = new CampoTela(tabuleiro.getCampoMeioDireita());
		add(campoMeioDireita.getCampoTela());

		campoBaixoEsquerda = new CampoTela(tabuleiro.getCampoBaixoEsquerda());
		add(campoBaixoEsquerda.getCampoTela());

		campoBaixoMeio = new CampoTela(tabuleiro.getCampoBaixoMeio());
		add(campoBaixoMeio.getCampoTela());

		campoBaixoDireita = new CampoTela(tabuleiro.getCampoBaixoDireita());
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
