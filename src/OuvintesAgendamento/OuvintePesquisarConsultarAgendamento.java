package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaCentralAgendamento;
import JanelasAgendamento.JanelaConsultarAgendamento;

public class OuvintePesquisarConsultarAgendamento implements ActionListener{

	private JanelaConsultarAgendamento janela;

	public OuvintePesquisarConsultarAgendamento(JanelaConsultarAgendamento janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  
		try{
			Date data = sdf.parse(janela.getRespostaData().getText());
			if(janela.getOrdem()!=null){
				janela.remove(janela.getConteiner());
			}
			janela.adicionarTabela();
		}catch (Exception erro){
			JOptionPane.showMessageDialog(this.janela, "Data invalida");
		}
	}
}