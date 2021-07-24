package br.ies.aps.jogooito.view.swing.tela;

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
import br.ies.aps.jogooito.modelo.DAO.JogadorDAO;
import br.ies.aps.jogooito.view.swing.botao.BotaoMovimentoBaixo;
import br.ies.aps.jogooito.view.swing.botao.BotaoMovimentoCima;
import br.ies.aps.jogooito.view.swing.botao.BotaoMovimentoDireita;
import br.ies.aps.jogooito.view.swing.botao.BotaoMovimentoEsquerda;

@SuppressWarnings("serial")
public class TelaControle extends JPanel implements KeyListener, TabuleiroObservador {
	private Tabuleiro tabuleiro;
	private Jogador jogador;
	private TelaTabuleiro telaTabuleiro;
	private JLabel jogadasLabel;
	private BotaoMovimentoCima botaoCima;
	private BotaoMovimentoBaixo botaoBaixo;
	private BotaoMovimentoDireita botaoDireita;
	private BotaoMovimentoEsquerda botaoEsquerda;

	public TelaControle(Tabuleiro tabuleiro, TelaTabuleiro telaTabuleiro, Jogador jogador) {
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
		if (tabuleiro.verificaFimJogo()) {
			finalizaJogadas(jogador.getJogadas() + 1);
			jogador.setGanhador(true);
			JogadorDAO jogadorDAO = new JogadorDAO(jogador);
			try {
				jogadorDAO.atualizaBanco(jogador.getIdJogador());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		// TODO verificar se há tecla pressionada no hashmap
		mapa.get(event.getKeyCode()).run();
	}

	@Override
	public void keyReleased(KeyEvent event) {
	};

	@Override
	public void keyTyped(KeyEvent event) {
	}
}
