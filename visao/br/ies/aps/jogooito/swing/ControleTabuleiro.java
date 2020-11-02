package br.ies.aps.jogooito.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.modelo.TabuleiroObservador;
import br.ies.aps.jogooito.swing.botao.BotaoMovimentoBaixo;
import br.ies.aps.jogooito.swing.botao.BotaoMovimentoCima;
import br.ies.aps.jogooito.swing.botao.BotaoMovimentoDireita;
import br.ies.aps.jogooito.swing.botao.BotaoMovimentoEsquerda;
import br.ies.aps.jogooito.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public class ControleTabuleiro extends JPanel implements KeyListener, TabuleiroObservador {
	private Tabuleiro tabuleiro;
	private TelaTabuleiro telaTabuleiro;
	private JTextField entradaNomeJogador;
	private JLabel jogadasLabel;
	private JButton botaoSalvar;
	private BotaoMovimentoCima botaoCima;
	private BotaoMovimentoBaixo botaoBaixo;
	private BotaoMovimentoDireita botaoDireita;
	private BotaoMovimentoEsquerda botaoEsquerda;

	public ControleTabuleiro(Tabuleiro tabuleiro, TelaTabuleiro telaTabuleiro) {
		this.tabuleiro = tabuleiro;
		this.telaTabuleiro = telaTabuleiro;

		geraControleTabuleiro();
		this.tabuleiro.registrarObservador(this);
	}

	private void geraControleTabuleiro() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints posicao = new GridBagConstraints();
		posicao.fill = GridBagConstraints.BOTH;

		setLayout(layout);

		posicao.gridy = 0;
		posicao.gridx = 0;
		JLabel jogadorLabel = new JLabel("Jogador:");
		add(jogadorLabel, posicao);

		posicao.gridy = 0;
		posicao.gridx = 1;
		entradaNomeJogador = new JTextField();
		add(entradaNomeJogador, posicao);
		entradaNomeJogador.setColumns(20);

		posicao.gridy = 1;
		posicao.gridx = 0;
		posicao.gridwidth = 2;
		jogadasLabel = new JLabel(String.format("Jogadas: %d", tabuleiro.getJogadas()));
		add(jogadasLabel, posicao);

		posicao.gridwidth = 1;
		posicao.gridy = 2;
		posicao.gridx = 0;
		botaoSalvar = new JButton("Salvar");
		add(botaoSalvar, posicao);

		posicao.gridy = 0;
		posicao.gridx = 4;
		botaoCima = new BotaoMovimentoCima("↑", this.tabuleiro, this.telaTabuleiro, this);
		add(botaoCima, posicao);

		posicao.gridy = 2;
		posicao.gridx = 4;
		botaoBaixo = new BotaoMovimentoBaixo("↓", this.tabuleiro, this.telaTabuleiro, this);
		add(botaoBaixo, posicao);

		posicao.gridy = 1;
		posicao.gridx = 5;
		botaoDireita = new BotaoMovimentoDireita("→", this.tabuleiro, this.telaTabuleiro, this);
		add(botaoDireita, posicao);

		posicao.gridy = 1;
		posicao.gridx = 3;
		botaoEsquerda = new BotaoMovimentoEsquerda("←", this.tabuleiro, this.telaTabuleiro, this);
		add(botaoEsquerda, posicao);
	}

	public void atualizaJogadas(Integer numero) {
		jogadasLabel.setText(String.format("Jogadas: %d", numero));
	}

	public void finalizaJogadas(Integer numero) {
		jogadasLabel.setText(String.format("Venceu o jogo com %d jogadas!!", numero));
	}

	public void verificaFimJogo(Tabuleiro tabuleiro) {	
		
		if (tabuleiro.getCampoCimaEsquerda().equals(Integer.valueOf(1)) &&
			tabuleiro.getCampoCimaMeio().equals(Integer.valueOf(2)) &&
			tabuleiro.getCampoCimaDireita().equals(Integer.valueOf(3)) &&
			tabuleiro.getCampoMeioEsquerda().equals(Integer.valueOf(4)) &&
			tabuleiro.getCampoMeio().equals(Integer.valueOf(5)) &&
			tabuleiro.getCampoMeioDireita().equals(Integer.valueOf(6)) &&
			tabuleiro.getCampoBaixoEsquerda().equals(Integer.valueOf(7)) &&
			tabuleiro.getCampoBaixoMeio().equals(Integer.valueOf(8)) && 
			tabuleiro.getCampoBaixoDireita().equals(Integer.valueOf(0))) {
			finalizaJogadas(tabuleiro.getJogadas() + 1);
		} else {
			atualizaJogadas(tabuleiro.getJogadas() + 1);
		}
	}

	@Override
	public void alterouEstadoTabuleiro(Tabuleiro tabuleiro) {
		System.out.println(tabuleiro.getJogadas());
		verificaFimJogo(tabuleiro);
	};

	@Override
	public void keyPressed(KeyEvent event) {

		Map<Integer, Runnable> mapa = new HashMap<Integer, Runnable>();

		mapa.put(KeyEvent.VK_DOWN, new Runnable() {
			@Override
			public void run() {
				botaoBaixo.alteraEstadoTabuleiro();
			}
		});
		mapa.put(KeyEvent.VK_UP, new Runnable() {
			@Override
			public void run() {
				botaoCima.alteraEstadoTabuleiro();
			}
		});
		mapa.put(KeyEvent.VK_RIGHT, new Runnable() {
			@Override
			public void run() {
				botaoDireita.alteraEstadoTabuleiro();
			}
		});
		mapa.put(KeyEvent.VK_LEFT, new Runnable() {
			@Override
			public void run() {
				botaoEsquerda.alteraEstadoTabuleiro();
			}
		});

		mapa.get(event.getKeyCode()).run();
	}

	@Override
	public void keyReleased(KeyEvent event) {
	};

	@Override
	public void keyTyped(KeyEvent event) {
	}
}
