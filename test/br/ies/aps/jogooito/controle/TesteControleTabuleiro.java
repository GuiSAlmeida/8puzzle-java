package br.ies.aps.jogooito.controle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ies.aps.jogooito.modelo.Tabuleiro;

public class TesteControleTabuleiro {
	private TabuleiroControle tabuleiroControle;
	
	@Before
	public void configuracao() {
		tabuleiroControle = new TabuleiroControle(new Tabuleiro());
	}

	@Test
	public void moverPonteiroTabuleiroParaCima() {		
		Integer posicaoAcima = tabuleiroControle.getTabuleiro().getPonteiro().getCampoDeCima().getNumero();
		tabuleiroControle.moverPraCima();		
		assertEquals(posicaoAcima, tabuleiroControle.getTabuleiro().getPonteiro().getCampoDeBaixo().getNumero());
	}
	
	@Test
	public void moverPonteiroTabuleiroParaEsquerda() {
		Integer posicaoEsquerda = tabuleiroControle.getTabuleiro().getPonteiro().getCampoDaEsquerda().getNumero();
		tabuleiroControle.moverPraEsquerda();
		assertEquals(posicaoEsquerda, tabuleiroControle.getTabuleiro().getPonteiro().getCampoDaDireita().getNumero());
	}
	
	@Test
	public void moverPonteiroTabuleiroParaDireita() {
		Integer posicaoDireita = tabuleiroControle.getTabuleiro().getPonteiro().getCampoDaDireita().getNumero();
		tabuleiroControle.moverPraDireita();
		assertEquals(posicaoDireita, tabuleiroControle.getTabuleiro().getPonteiro().getCampoDaEsquerda().getNumero());
	}

	@Test
	public void moverPonteiroTabuleiroParaBaixo() {
		Integer posicaoAbaixo = tabuleiroControle.getTabuleiro().getPonteiro().getCampoDeBaixo().getNumero();
		tabuleiroControle.moverPraBaixo();
		assertEquals(posicaoAbaixo, tabuleiroControle.getTabuleiro().getPonteiro().getCampoDeCima().getNumero());
	}
}
