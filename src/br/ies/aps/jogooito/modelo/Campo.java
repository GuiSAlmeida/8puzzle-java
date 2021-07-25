package br.ies.aps.jogooito.modelo;

public class Campo {
	private Integer numero;

	private Campo cima;
	private Campo baixo;
	private Campo esquerda;
	private Campo direita;
	
	private Tabuleiro tabuleiro;

	public Campo(Integer numero, Tabuleiro tabuleiro) {
		this.setNumero(numero);
		this.cima = this;
		this.baixo = this;
		this.esquerda = this;
		this.direita = this;		
		this.tabuleiro = tabuleiro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void trocaNumero(Campo origem, Campo destino) {
		Integer temporario = origem.getNumero();
		origem.setNumero(destino.getNumero());
		destino.setNumero(temporario);
	}

	public Campo getCampoDeCima() {
		return cima;
	}

	public void setCampoDeCima(Campo cima) {
		this.cima = cima;
	}

	public Campo getCampoDeBaixo() {
		return baixo;
	}

	public void setCampoDeBaixo(Campo baixo) {
		this.baixo = baixo;
	}

	public Campo getCampoDaEsquerda() {
		return esquerda;
	}

	public void setCampoDaEsquerda(Campo esquerda) {
		this.esquerda = esquerda;
	}

	public Campo getCampoDaDireita() {
		return direita;
	}

	public void setCampoDaDireita(Campo direita) {
		this.direita = direita;
	}

	public void moverParaCima() {
		trocaNumero(this, cima);
		this.tabuleiro.notificarObservadores(this.tabuleiro);
	}

	public void moverParaBaixo() {
		trocaNumero(this, baixo);
		this.tabuleiro.notificarObservadores(this.tabuleiro);
	}

	public void moverParaEsquerda() {
		trocaNumero(this, esquerda);
		this.tabuleiro.notificarObservadores(this.tabuleiro);
	}

	public void moverParaDireita() {
		trocaNumero(this, direita);
		this.tabuleiro.notificarObservadores(this.tabuleiro);
	}
}
