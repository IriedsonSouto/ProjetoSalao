package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaCentralAgendamento;
import JanelasAgendamento.JanelaConsultarHistoricoCliente;
import Programa.Salao;

public class OuvinteConsultarHistoricoCliente implements ActionListener{

	private JanelaCentralAgendamento janela;

	public OuvinteConsultarHistoricoCliente(JanelaCentralAgendamento janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		JanelaConsultarHistoricoCliente janelaCHC = new JanelaConsultarHistoricoCliente("Consultar Historico Cliente", janela.getSla());
	}
}