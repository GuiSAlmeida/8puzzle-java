package br.ies.aps.jogooito.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class testeTabuleiro {
	private Tabuleiro tabuleiro;
	@Before
	public void configuracao() {
		tabuleiro = new Tabuleiro();
	}

	@Test
	public void testarPosicaoDoPonteiro() {
		assertEquals(0, tabuleiro.getPonteiro().getNumero());		
	}
	
	
}
