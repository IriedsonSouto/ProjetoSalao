package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaConsultarAgendamento;
import JanelasAgendamento.JanelaConsultarHistoricoCliente;

public class OuvintePesquisarConsultarClienteAgendamento implements ActionListener{

	private JanelaConsultarHistoricoCliente janela;

	public OuvintePesquisarConsultarClienteAgendamento(JanelaConsultarHistoricoCliente janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		if(janela.getOrdem()!=null){
			janela.remove(janela.getConteiner());
		}
		janela.adicionarTabela();
	}
}