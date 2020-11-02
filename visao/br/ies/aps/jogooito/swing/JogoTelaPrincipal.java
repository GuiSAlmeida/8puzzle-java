package br.ies.aps.jogooito.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.swing.tela.TelaTabuleiro;

@SuppressWarnings("serial")
public class JogoTelaPrincipal extends JFrame {

	public JogoTelaPrincipal() {
		organizarLayout();
	}

	public static void main(String[] args) {
		new JogoTelaPrincipal();
	}

	private void organizarLayout() {
		Tabuleiro tabuleiro = new Tabuleiro();
		TelaTabuleiro tela = new TelaTabuleiro(tabuleiro);

		ControleTabuleiro controle = new ControleTabuleiro(tabuleiro, tela);
		addKeyListener(controle);

		controle.setPreferredSize(new Dimension(600, 100));

		setLayout(new BorderLayout());

		setTitle("Jogo do 8");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setFocusable(true);

		add(tela, BorderLayout.CENTER);
		add(controle, BorderLayout.SOUTH);
	}

}
