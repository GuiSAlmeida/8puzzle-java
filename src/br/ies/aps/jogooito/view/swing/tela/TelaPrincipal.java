package br.ies.aps.jogooito.view.swing.tela;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ies.aps.jogooito.modelo.Jogador;
import br.ies.aps.jogooito.modelo.Tabuleiro;
import br.ies.aps.jogooito.modelo.DAO.JogadorDAO;
import br.ies.aps.jogooito.modelo.DAO.SalvaNovoJogoBancoDAO;
import br.ies.aps.jogooito.modelo.DAO.TabuleiroDAO;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	private Tabuleiro tabuleiro;
	private Jogador jogador;

	public void IniciaJogo() {
		String JogadorNome = JOptionPane.showInputDialog("Digite seu nome para jogar:");
		jogador = new Jogador(JogadorNome);
		tabuleiro = new Tabuleiro();
		organizarLayout(this.tabuleiro);
		salvaNovoJogoBanco(this.tabuleiro);
		finalizaJogo(this.tabuleiro, this.jogador);
	}

	private void organizarLayout(Tabuleiro tabuleiro) {
		TelaTabuleiro telaTabuleiro = new TelaTabuleiro(tabuleiro);
		TelaControle telaControle = new TelaControle(tabuleiro, telaTabuleiro, jogador);
		addKeyListener(telaControle);

		GridBagLayout gridBagLayout = (GridBagLayout) telaControle.getLayout();
		gridBagLayout.columnWidths = new int[] { 0, 200, 0, 0, 0, 0, 0 };
		telaControle.setPreferredSize(new Dimension(600, 100));

		getContentPane().setLayout(new BorderLayout());
		setTitle("Jogo do 8");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);

		add(telaTabuleiro, BorderLayout.CENTER);
		add(telaControle, BorderLayout.SOUTH);
	}

	private void salvaNovoJogoBanco(Tabuleiro tabuleiro) {
		SalvaNovoJogoBancoDAO salvaNovoJogoBanco = new SalvaNovoJogoBancoDAO(tabuleiro, jogador);
		salvaNovoJogoBanco.salvar();
		tabuleiro.setIdTabuleiro(salvaNovoJogoBanco.getIdTabuleiro());
		jogador.setIdJogador(salvaNovoJogoBanco.getIdJogador());
	}
	
	private void finalizaJogo(Tabuleiro tabuleiro, Jogador jogador) {		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(null, 
		            "Tem certeza que quer sair do jogo?", "Fechar janela?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		    		try {
		    			TabuleiroDAO tabuleiroDAO = new TabuleiroDAO(tabuleiro);
		    			JogadorDAO jogadorDAO = new JogadorDAO(jogador);
		    			tabuleiroDAO.atualizaBanco(tabuleiro.getIdTabuleiro());
						jogadorDAO.atualizaBanco(jogador.getIdJogador());
						
						setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			            System.exit(0);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		        	
		        } else {
		        	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		        }
		    }
		});		
	}
}

