package OuvintesMensageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasMensageiro.JanelaCentralMensageiro;
import JanelasMensageiro.JanelaDeMensagemIndividual;
import Programa.Colaborador;

public class OuvinteBotaoMensagemColaboradores implements ActionListener {
	
	private JanelaCentralMensageiro janela;
	private String contatos = "";
	
	public OuvinteBotaoMensagemColaboradores(JanelaCentralMensageiro janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		int c = 0;
		for(Colaborador colaboradores: janela.getSla().getCadastros().getColaboradores()){
			contatos = contatos + colaboradores.getEmail() + ", ";
		}
		JanelaDeMensagemIndividual janelaMI = new JanelaDeMensagemIndividual("Mensageiro", contatos);
	}

}