package br.ies.aps.jogooito.modelo;

public class Jogador {
	private String jogadorNome;
	private Boolean ganhador = false;
	private Integer idJogador;
	private Integer jogadas = 0;
	
	public Jogador(String nome) {
		setJogadorNome(nome);
	}	
	
	public String getJogadorNome() {
		return jogadorNome;
	}

	public void setJogadorNome(String jogador) {
		this.jogadorNome = jogador;
	}
	
	public Integer getJogadas() {
		return jogadas;
	}	
	
	public void setJogadas(Integer jogadas) {
		this.jogadas = jogadas;
	}	
	
	public Boolean getGanhador() {
		return ganhador;
	}	
	
	public void setGanhador(Boolean ganhador) {
		this.ganhador = ganhador;
	}	
	
	public Integer getIdJogador() {
		return idJogador;
	}	
	
	public void setIdJogador(Integer idJogador) {
		this.idJogador = idJogador;
	}
}
