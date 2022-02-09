package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasAgendamento.JanelaCentralAgendamento;
import JanelasAgendamento.JanelaConsultarAgendamento;
import JanelasAgendamento.JanelaPesquisarCliente;

public class OuvinteConsultarAgendamento implements ActionListener{

	private JanelaCentralAgendamento janela;

	public OuvinteConsultarAgendamento(JanelaCentralAgendamento janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		JanelaConsultarAgendamento janelaCA = new JanelaConsultarAgendamento("Consultar Agendamento", janela.getSla());		
	}
}