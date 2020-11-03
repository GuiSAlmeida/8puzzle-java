package br.ies.aps.jogooito.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ies.aps.jogooito.banco.SalvaNovoJogoBancoDAO;
import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public class JogoTelaPrincipal extends JFrame {
	private Tabuleiro tabuleiro;
	private Jogador jogador;

	public JogoTelaPrincipal() {
		String JogadorNome = JOptionPane.showInputDialog("Digite seu nome para jogar:");
		jogador = new Jogador(JogadorNome);
		tabuleiro = new Tabuleiro();
		organizarLayout(this.tabuleiro);
		salvaNovoJogoBanco(this.tabuleiro);
	}

	public static void main(String[] args) {
		new JogoTelaPrincipal();
	}

	private void organizarLayout(Tabuleiro tabuleiro) {
		TelaTabuleiro tela = new TelaTabuleiro(tabuleiro);

		ControleTabuleiro controle = new ControleTabuleiro(tabuleiro, tela, jogador);
		addKeyListener(controle);

		GridBagLayout gridBagLayout = (GridBagLayout) controle.getLayout();
		gridBagLayout.columnWidths = new int[] { 0, 200, 0, 0, 0, 0, 0 };
		controle.setPreferredSize(new Dimension(600, 100));

		getContentPane().setLayout(new BorderLayout());
		setTitle("Jogo do 8");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setFocusable(true);

		add(tela, BorderLayout.CENTER);
		add(controle, BorderLayout.SOUTH);
	}

	private void salvaNovoJogoBanco(Tabuleiro tabuleiro) {
		SalvaNovoJogoBancoDAO salvaNovoJogoBanco = new SalvaNovoJogoBancoDAO(tabuleiro, jogador);
		salvaNovoJogoBanco.salvar();
		tabuleiro.setIdTabuleiro(salvaNovoJogoBanco.getIdTabuleiro());
		jogador.setIdJogador(salvaNovoJogoBanco.getIdJogador());
	}

}
