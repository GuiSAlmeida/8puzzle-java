package br.ies.aps.jogooito.controle;

import br.ies.aps.jogooito.modelo.Tabuleiro;

public class TabuleiroControle {
	private Tabuleiro tabuleiro;

	public TabuleiroControle(Tabuleiro tabuleiro) {
		this.setTabuleiro(tabuleiro);
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void moverPraCima() {
		tabuleiro.getPonteiro().moverParaCima();
		tabuleiro.setPonteiro(tabuleiro.getPonteiro().getCampoDeCima());
	}

	public void moverPraBaixo() {
		tabuleiro.getPonteiro().moverParaBaixo();
		tabuleiro.setPonteiro(tabuleiro.getPonteiro().getCampoDeBaixo());
	}

	public void moverPraEsquerda() {
		tabuleiro.getPonteiro().moverParaEsquerda();
		tabuleiro.setPonteiro(tabuleiro.getPonteiro().getCampoDaEsquerda());
	}

	public void moverPraDireita() {
		tabuleiro.getPonteiro().moverParaDireita();
		tabuleiro.setPonteiro(tabuleiro.getPonteiro().getCampoDaDireita());
	}
}
