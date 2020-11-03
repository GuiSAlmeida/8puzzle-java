package br.ies.aps.jogooito.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	private Campo ponteiro;
	private Campo campoMeio;
	private Campo campoMeioDireita;
	private Campo campoMeioEsquerda;
	private Campo campoBaixoMeio;
	private Campo campoBaixoDireita;
	private Campo campoBaixoEsquerda;
	private Campo campoCimaMeio;
	private Campo campoCimaDireita;
	private Campo campoCimaEsquerda;

	private Integer idTabuleiro;

	private List<TabuleiroObservador> observadores = new ArrayList<>();

	public Tabuleiro() {
		gerarCampos();
	}

	public void registrarObservador(TabuleiroObservador observador) {
		observadores.add(observador);
	}

	public void notificarObservadores(Tabuleiro tabuleiro) {
		for (TabuleiroObservador observador : observadores) {
			observador.alterouEstadoTabuleiro(this);
		}
	}

	public Campo getPonteiro() {
		return ponteiro;
	}

	public void setPonteiro(Campo ponteiro) {
		this.ponteiro = ponteiro;
	}

	public Integer getCampoMeio() {
		return campoMeio.getNumero();
	}
	
	public void setCampoMeio(Integer numero) {
		this.campoMeio.setNumero(numero);
	}

	public Integer getCampoMeioDireita() {
		return campoMeioDireita.getNumero();
	}
	
	public void setCampoMeioDireita(Integer numero) {
		this.campoMeioDireita.setNumero(numero);;
	}

	public Integer getCampoMeioEsquerda() {
		return campoMeioEsquerda.getNumero();
	}

	public void setCampoMeioEsquerda(Integer numero) {
		this.campoMeioEsquerda.setNumero(numero);;
	}
	
	public Integer getCampoBaixoMeio() {
		return campoBaixoMeio.getNumero();
	}

	public void setCampoBaixoMeio(Integer numero) {
		this.campoBaixoMeio.setNumero(numero);;
	}
	
	public Integer getCampoBaixoDireita() {
		return campoBaixoDireita.getNumero();
	}

	public void setCampoBaixoDireita(Integer numero) {
		this.campoBaixoDireita.setNumero(numero);;
	}
	
	public Integer getCampoBaixoEsquerda() {
		return campoBaixoEsquerda.getNumero();
	}

	public void setCampoBaixoEsquerda(Integer numero) {
		this.campoBaixoEsquerda.setNumero(numero);;
	}

	public Integer getCampoCimaMeio() {
		return campoCimaMeio.getNumero();
	}
	
	public void setCampoCimaMeio(Integer numero) {
		this.campoCimaMeio.setNumero(numero);;
	}
	
	public Integer getCampoCimaDireita() {
		return campoCimaDireita.getNumero();
	}

	public void setCampoCimaDireita(Integer numero) {
		this.campoCimaDireita.setNumero(numero);;
	}
	
	public Integer getCampoCimaEsquerda() {
		return campoCimaEsquerda.getNumero();
	}

	public void setCampoCimaEsquerda(Integer numero) {
		this.campoCimaEsquerda.setNumero(numero);
	}
	
	public Integer getIdTabuleiro() {
		return idTabuleiro;
	}

	public void setIdTabuleiro(Integer idTabuleiro) {
		this.idTabuleiro = idTabuleiro;
	}

	public void gerarCampos() {
		campoCimaEsquerda = new Campo(Integer.valueOf(7), this);
		campoCimaMeio = new Campo(Integer.valueOf(2), this);
		campoCimaDireita = new Campo(Integer.valueOf(4), this);
		campoMeioEsquerda = new Campo(Integer.valueOf(5), this);
		campoMeio = new Campo(Integer.valueOf(0), this);
		campoMeioDireita = new Campo(Integer.valueOf(6), this);
		campoBaixoEsquerda = new Campo(Integer.valueOf(8), this);
		campoBaixoMeio = new Campo(Integer.valueOf(3), this);
		campoBaixoDireita = new Campo(Integer.valueOf(1), this);

		associarVizinhos();
		setPonteiro(campoMeio);
	}

	private void associarVizinhos() {
		campoCimaEsquerda.setCampoDeBaixo(campoMeioEsquerda);
		campoCimaEsquerda.setCampoDaDireita(campoCimaMeio);

		campoCimaMeio.setCampoDeBaixo(campoMeio);
		campoCimaMeio.setCampoDaDireita(campoCimaDireita);
		campoCimaMeio.setCampoDaEsquerda(campoCimaEsquerda);

		campoCimaDireita.setCampoDeBaixo(campoMeioDireita);
		campoCimaDireita.setCampoDaEsquerda(campoCimaMeio);

		campoMeioEsquerda.setCampoDaDireita(campoMeio);
		campoMeioEsquerda.setCampoDeBaixo(campoBaixoEsquerda);
		campoMeioEsquerda.setCampoDeCima(campoCimaEsquerda);

		campoMeio.setCampoDeBaixo(campoBaixoMeio);
		campoMeio.setCampoDeCima(campoCimaMeio);
		campoMeio.setCampoDaDireita(campoMeioDireita);
		campoMeio.setCampoDaEsquerda(campoMeioEsquerda);

		campoMeioDireita.setCampoDeBaixo(campoBaixoDireita);
		campoMeioDireita.setCampoDeCima(campoCimaDireita);
		campoMeioDireita.setCampoDaEsquerda(campoMeio);

		campoBaixoEsquerda.setCampoDeCima(campoMeioEsquerda);
		campoBaixoEsquerda.setCampoDaDireita(campoBaixoMeio);

		campoBaixoMeio.setCampoDeCima(campoMeio);
		campoBaixoMeio.setCampoDaDireita(campoBaixoDireita);
		campoBaixoMeio.setCampoDaEsquerda(campoBaixoEsquerda);

		campoBaixoDireita.setCampoDeCima(campoMeioDireita);
		campoBaixoDireita.setCampoDaEsquerda(campoBaixoMeio);
	}

	@Override
	public String toString() {

		return String.format("|%d %d %d|\n|%d %d %d|\n|%d %d %d|", campoCimaEsquerda.getNumero(),
				campoCimaMeio.getNumero(), campoCimaDireita.getNumero(), campoMeioEsquerda.getNumero(),
				campoMeio.getNumero(), campoMeioDireita.getNumero(), campoBaixoEsquerda.getNumero(),
				campoBaixoMeio.getNumero(), campoBaixoDireita.getNumero());
	}
}
