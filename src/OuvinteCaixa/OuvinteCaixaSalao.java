package OuvinteCaixa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Janelas.JanelaAdm;
import JanelasCaixa.JanelaCentralCaixa;

public class OuvinteCaixaSalao implements ActionListener{

	private JanelaCentralCaixa janela;
	
	public OuvinteCaixaSalao(JanelaCentralCaixa janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JOptionPane.showMessageDialog(null, "Saldo: "+ janela.getSla().getCaixa());	
	}
}
