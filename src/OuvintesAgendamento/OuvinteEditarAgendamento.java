package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaConsultarAgendamento;
import JanelasAgendamento.JanelaEditarAgendamento;

public class OuvinteEditarAgendamento implements ActionListener{

	private JanelaConsultarAgendamento janela;

	public OuvinteEditarAgendamento(JanelaConsultarAgendamento janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		int instancia = janela.getTabela().getSelectedRow();
		JanelaEditarAgendamento janelaEA = new JanelaEditarAgendamento("Editar Agendamento"
				, janela.getSla(),janela.getOrdem()[instancia]);
	}
}