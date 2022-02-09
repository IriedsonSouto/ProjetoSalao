package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaCadastrarAgendamento;
import JanelasAgendamento.JanelaEditarAgendamento;
import Persistencia.Persistencia;
import Programa.Agendameto;
import Programa.AssociaColabServ;
import Programa.Cliente;
import Programa.StatusAgenda;

public class OuvinteEnviarEditarAgendamento implements ActionListener {

	private JanelaEditarAgendamento janela;
	
	public OuvinteEnviarEditarAgendamento (JanelaEditarAgendamento janela){
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		AssociaColabServ colabServ = janela.getNomeColab()[janela.getComboBoxColab().getSelectedIndex()];
		try{
			Agendameto agendamentoTeste = new Agendameto(janela.getNomeColab()[janela.getComboBoxColab().getSelectedIndex()]
					, janela.getAgendamento().getCliente(), janela.getRespostaHora().getText(), janela.getRespostaData().getText());
			agendamentoTeste.setStatus(janela.getStatus()[janela.getComboBoxColabStatus().getSelectedIndex()]);
			
			boolean testeChoque = false;
			for(Agendameto agendamentos: janela.getSla().getAgendametos()){
				if(agendamentos.equals(agendamentoTeste)){
					testeChoque = true;
				}		
			}
			if(testeChoque == false){
				janela.getAgendamento().setStatus(janela.getStatus()[janela.getComboBoxColabStatus().getSelectedIndex()]);
				janela.getAgendamento().setAssociaColabServ(janela.getNomeColab()[janela.getComboBoxColab().getSelectedIndex()]);
				janela.getAgendamento().setData(janela.getRespostaData().getText());
				janela.getAgendamento().setHora(janela.getRespostaHora().getText());
				janela.getAgendamento().setLDate(janela.getRespostaData().getText(), janela.getRespostaHora().getText());

				if(janela.getStatus()[janela.getComboBoxColabStatus().getSelectedIndex()].equals(StatusAgenda.CONCLUIDO)){
					janela.getSla().setCaixa((janela.getSla().getCaixa() 
							+ janela.getAgendamento().getAssociaColabServ().getValor()));
					janela.getAgendamento().getAssociaColabServ().getColabA()
					.setCaixa((float) (janela.getAgendamento().getAssociaColabServ().getColabA().getCaixa() 
							+ (janela.getAgendamento().getAssociaColabServ().getValor()*0.80)));	
				}
				Persistencia percistencia = new Persistencia();
				percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
				JOptionPane.showMessageDialog(this.janela, "Mudança realizada com sucesso");
				janela.dispose();
			}else{
				JOptionPane.showMessageDialog(this.janela, "Choque de horario, porfavor tente novamente");
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(this.janela, "Data invalida");
		}	
	}
}
