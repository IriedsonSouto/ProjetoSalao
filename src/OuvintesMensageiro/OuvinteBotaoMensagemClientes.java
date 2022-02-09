package OuvintesMensageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasMensageiro.JanelaCentralMensageiro;
import JanelasMensageiro.JanelaDeMensagemIndividual;
import Programa.Cliente;


public class OuvinteBotaoMensagemClientes implements ActionListener {
	
	private JanelaCentralMensageiro janela;
	
	public OuvinteBotaoMensagemClientes(JanelaCentralMensageiro janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		String contatos = "";
		for(Cliente cliente: janela.getSla().getCadastros().getClientes()){
			contatos = contatos + cliente.getEmail() + ", ";
		}
		JanelaDeMensagemIndividual janelaMI = new JanelaDeMensagemIndividual("Mensageiro", contatos);
	}

}