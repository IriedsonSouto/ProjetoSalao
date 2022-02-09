package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Janelas.JanelaConsultarAgendamentoClienteColab;
import Janelas.JanelaLogin;
import JanelasAgendamento.JanelaCentralAgendamento;
import JanelasAgendamento.JanelaConsultarAgendamento;

public class OuvinteBotaoAreaClienteColaborador implements ActionListener{

	private JanelaLogin janela;

	public OuvinteBotaoAreaClienteColaborador(JanelaLogin janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		JanelaConsultarAgendamentoClienteColab janelaCACC = new JanelaConsultarAgendamentoClienteColab("Consultar Agendamento", janela.getSla());		
	}
}