package br.ies.aps.jogooito.view.swing.tela;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaCampo extends JLabel {

	private JLabel campoTela;

	public TelaCampo(Integer numero) {
		this.campoTela = new JLabel(numero.toString());
		this.campoTela.setForeground(Color.BLACK);
		this.campoTela.setHorizontalAlignment(SwingConstants.CENTER);
		this.campoTela.setFont(new Font("Open Sans", Font.BOLD, 72));
		this.campoTela.setBackground(Color.WHITE);
		this.campoTela.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public JLabel getCampoTela() {
		return campoTela;
	}

	public void setCampoTela(Integer numero) {
		this.campoTela.setText(numero.toString());
	}

}
