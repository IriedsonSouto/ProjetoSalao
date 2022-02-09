package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasAgendamento.JanelaCentralAgendamento;
import JanelasAgendamento.JanelaPesquisarCliente;


public class OuvinteNovoAgendamento implements ActionListener{

	private JanelaCentralAgendamento janela;

	public OuvinteNovoAgendamento(JanelaCentralAgendamento janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		JanelaPesquisarCliente janelaPC = new JanelaPesquisarCliente("Pesquisar Cliente", janela.getSla());		
	}
}
