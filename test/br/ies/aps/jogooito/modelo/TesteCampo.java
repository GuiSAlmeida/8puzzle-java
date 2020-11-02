package br.ies.aps.jogooito.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TesteCampo {
	private Tabuleiro tabuleiro;

	private Campo campoMeio;
	private Campo campoCima;
	private Campo campoDireita;
	private Campo campoEsquerda;
	private Campo campoBaixo;

	/**
	 * Instancia campos antes dos testes.
	 */
	@Before
	public void configuracao() {
		tabuleiro = new Tabuleiro();

		campoMeio = new Campo(5, tabuleiro);
		campoCima = new Campo(1, tabuleiro);
		campoDireita = new Campo(2, tabuleiro);
		campoEsquerda = new Campo(3, tabuleiro);
		campoBaixo = new Campo(4, tabuleiro);
	}

	/**
	 * Testa craição de um campo passando valor.
	 */
	@Test
	public void CriaCampo() {
		Campo campoBaixoMeio = new Campo(8, tabuleiro);
		assertEquals(Integer.valueOf(8), campoBaixoMeio.getNumero());
	}

	/**
	 * Testa a adição de vizinhos para todos lados possiveis.
	 */
	@Test
	public void adicionaCamposVizinhos() {
		campoMeio.setCampoDeBaixo(campoBaixo);
		campoMeio.setCampoDaDireita(campoDireita);
		campoMeio.setCampoDaEsquerda(campoEsquerda);
		campoMeio.setCampoDeCima(campoCima);

		assertEquals(Integer.valueOf(1), campoMeio.getCampoDeCima().getNumero());
		assertEquals(Integer.valueOf(2), campoMeio.getCampoDaDireita().getNumero());
		assertEquals(Integer.valueOf(3), campoMeio.getCampoDaEsquerda().getNumero());
		assertEquals(Integer.valueOf(4), campoMeio.getCampoDeBaixo().getNumero());
	}

	/**
	 * Testa método mover para vizinho de cima.
	 */
	@Test
	public void moveCampoParaVizinhoDeCima() {
		campoMeio.setCampoDeCima(campoCima);
		campoMeio.moverParaCima();
		assertEquals(Integer.valueOf(1), campoMeio.getNumero());
		assertEquals(Integer.valueOf(5), campoCima.getNumero());
	}

	/**
	 * Testa método mover para vizinho da direita.
	 */
	@Test
	public void moveCampoParaVizinhoDaDireita() {
		campoMeio.setCampoDaDireita(campoDireita);
		campoMeio.moverParaDireita();
		assertEquals(Integer.valueOf(2), campoMeio.getNumero());
		assertEquals(Integer.valueOf(5), campoDireita.getNumero());
	}

	/**
	 * Testa método mover para vizinho de baixo.
	 */
	@Test
	public void moveCampoParaVizinhoDeBaixo() {
		campoMeio.setCampoDeBaixo(campoBaixo);
		campoMeio.moverParaBaixo();
		assertEquals(Integer.valueOf(4), campoMeio.getNumero());
		assertEquals(Integer.valueOf(5), campoBaixo.getNumero());
	}

	/**
	 * Testa método mover para vizinho da esquerda.
	 */
	@Test
	public void moveCampoParaVizinhoDaEsquerda() {
		campoMeio.setCampoDaEsquerda(campoEsquerda);
		campoMeio.moverParaEsquerda();
		assertEquals(Integer.valueOf(3), campoMeio.getNumero());
		assertEquals(Integer.valueOf(5), campoEsquerda.getNumero());
	}

	/**
	 * Testa método mover para parede do tabuleiro. Onde o campo não deverá se mover
	 * e permanecerá com mesmo valor.
	 */
	@Test
	public void moveCampoParaParedeTabuleiro() {
		campoDireita.moverParaDireita();
		assertEquals(Integer.valueOf(2), campoDireita.getNumero());
	}
}
