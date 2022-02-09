package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaCadastrarAgendamento;
import Persistencia.Persistencia;
import Programa.AssociaColabServ;
import Programa.*;

public class OuvinteBotaoEnvirAgendamento implements ActionListener {

	private JanelaCadastrarAgendamento janela;
	
	public OuvinteBotaoEnvirAgendamento(JanelaCadastrarAgendamento janela){
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		AssociaColabServ colabServ = janela.getNomeColab()[janela.getComboBoxColab().getSelectedIndex()];
		try{
			Agendameto agendamento = new Agendameto(colabServ ,janela.getCliente(), janela.getRespostaHora().getText()
					, janela.getRespostaData().getText());
			if(janela.getSla().agendar(agendamento) == true){
				JOptionPane.showMessageDialog(this.janela, "Agendamento realizado");
				Persistencia percistencia = new Persistencia();
				percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
				janela.dispose();
			}else{
				JOptionPane.showMessageDialog(this.janela, "Choque de horario, porfavor tente novamente");
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(this.janela, "Data invalida");
		}	
	}
}
