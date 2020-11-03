package br.ies.aps.jogooito.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.ies.aps.jogooito.modelo.Jogador;
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
	private Jogador jogador;
	private TelaTabuleiro telaTabuleiro;
	private JLabel jogadasLabel;
	private BotaoMovimentoCima botaoCima;
	private BotaoMovimentoBaixo botaoBaixo;
	private BotaoMovimentoDireita botaoDireita;
	private BotaoMovimentoEsquerda botaoEsquerda;

	public ControleTabuleiro(Tabuleiro tabuleiro, TelaTabuleiro telaTabuleiro, Jogador jogador) {
		this.tabuleiro = tabuleiro;
		this.telaTabuleiro = telaTabuleiro;
		this.jogador = jogador;

		geraControleTabuleiro();
		this.tabuleiro.registrarObservador(this);
	}

	private void geraControleTabuleiro() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints posicao = new GridBagConstraints();
		posicao.fill = GridBagConstraints.HORIZONTAL;

		setLayout(layout);

		posicao.gridy = 0;
		posicao.gridx = 0;
		JLabel jogadorLabel = new JLabel(String.format("Jogador: %s", jogador.getJogadorNome()));
		add(jogadorLabel, posicao);

		posicao.gridy = 1;
		posicao.gridx = 0;
		posicao.gridwidth = 3;
		jogadasLabel = new JLabel(String.format("Jogadas: %d", jogador.getJogadas()));
		add(jogadasLabel, posicao);

		posicao.gridwidth = 1;
		posicao.gridy = 0;
		posicao.gridx = 5;
		botaoCima = new BotaoMovimentoCima("↑", tabuleiro, telaTabuleiro, this, jogador);
		add(botaoCima, posicao);

		posicao.gridy = 2;
		posicao.gridx = 5;
		botaoBaixo = new BotaoMovimentoBaixo("↓", tabuleiro, telaTabuleiro, this, jogador);
		add(botaoBaixo, posicao);

		posicao.gridy = 1;
		posicao.gridx = 6;
		botaoDireita = new BotaoMovimentoDireita("→", tabuleiro, telaTabuleiro, this, jogador);
		add(botaoDireita, posicao);

		posicao.gridy = 1;
		posicao.gridx = 4;
		botaoEsquerda = new BotaoMovimentoEsquerda("←", tabuleiro, telaTabuleiro, this, jogador);
		add(botaoEsquerda, posicao);
	}

	public void atualizaJogadas(Integer numero) {
		jogadasLabel.setText(String.format("Jogadas: %d", numero));
	}

	public void finalizaJogadas(Integer numero) {
		jogadasLabel.setText(String.format("Venceu o jogo com %d jogadas!!", numero));
	}

	public void verificaFimJogo(Tabuleiro tabuleiro) {
		if (tabuleiro.getCampoCimaEsquerda().equals(Integer.valueOf(1))
				&& tabuleiro.getCampoCimaMeio().equals(Integer.valueOf(2))
				&& tabuleiro.getCampoCimaDireita().equals(Integer.valueOf(3))
				&& tabuleiro.getCampoMeioEsquerda().equals(Integer.valueOf(4))
				&& tabuleiro.getCampoMeio().equals(Integer.valueOf(5))
				&& tabuleiro.getCampoMeioDireita().equals(Integer.valueOf(6))
				&& tabuleiro.getCampoBaixoEsquerda().equals(Integer.valueOf(7))
				&& tabuleiro.getCampoBaixoMeio().equals(Integer.valueOf(8))
				&& tabuleiro.getCampoBaixoDireita().equals(Integer.valueOf(0))) {
			finalizaJogadas(jogador.getJogadas() + 1);
			jogador.setGanhador(true);
		} else {
			atualizaJogadas(jogador.getJogadas() + 1);
		}
	}

	@Override
	public void alterouEstadoTabuleiro(Tabuleiro tabuleiro) {
		verificaFimJogo(tabuleiro);
	};

	@Override
	public void keyPressed(KeyEvent event) {
		Map<Integer, Runnable> mapa = new HashMap<Integer, Runnable>();

		mapa.put(KeyEvent.VK_DOWN, new Runnable() {
			@Override
			public void run() {
				try {
					botaoBaixo.alteraEstadoTabuleiro();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		});
		mapa.put(KeyEvent.VK_UP, new Runnable() {
			@Override
			public void run() {
				try {
					botaoCima.alteraEstadoTabuleiro();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		});
		mapa.put(KeyEvent.VK_RIGHT, new Runnable() {
			@Override
			public void run() {
				try {
					botaoDireita.alteraEstadoTabuleiro();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		});
		mapa.put(KeyEvent.VK_LEFT, new Runnable() {
			@Override
			public void run() {
				try {
					botaoEsquerda.alteraEstadoTabuleiro();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
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
