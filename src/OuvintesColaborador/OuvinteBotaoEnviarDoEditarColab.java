package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaEditarColaborador;
import Persistencia.Persistencia;
import Programa.*;

public class OuvinteBotaoEnviarDoEditarColab implements ActionListener{

	private JanelaEditarColaborador  janela;

	
	public OuvinteBotaoEnviarDoEditarColab(JanelaEditarColaborador  janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		Sexo[] sexo = {Sexo.MASCULINO, Sexo.FEMININO};
		StatusColaborador[] status = {StatusColaborador.ASSOCIADO, StatusColaborador.DESVINCULADO};
		try {
			janela.getColab().setNome(janela.getNomeDoColaboradorResposta().getText());
			janela.getColab().setEmail(janela.getEmailColabResposta().getText());
			janela.getColab().setTelefone(janela.getRespostaTelefone().getText());
			janela.getColab().setSexo(sexo[janela.getComboBox().getSelectedIndex()]);
			janela.getColab().setAssociado(status[janela.getComboBoxStatus().getSelectedIndex()]);
			
			HashSet<AssociaColabServ> associaColabServCancelados = new HashSet<AssociaColabServ>();
			
			if(janela.getColab().getAssociado().equals(StatusColaborador.DESVINCULADO)){
				for(AssociaColabServ associacao: janela.getSla().getCadastros().getTodosOsAssociaColabServ()){
					if(janela.getColab().equals(associacao.getColabA())){
						associaColabServCancelados.add(associacao);
						janela.getSla().getCadastros().getTodosOsAssociaColabServ().remove(associacao);
					}
				}
			}
			
			for(Agendameto agendamentos: janela.getSla().getAgendametos()){
				for(AssociaColabServ associacao: associaColabServCancelados){
					if(agendamentos.getAssociaColabServ().equals(associacao)){
						agendamentos.setStatus(StatusAgenda.CANCELADO);
						Mensageiro.enviarMensagemIndividual(agendamentos.getCliente().getEmail()
								, "O agendamento:\n"+ agendamentos.toString()+"\nFoi cancelado.", "Agendamento cancelado");
					}
				}
			}
			
			
			Persistencia percistencia = new Persistencia();
			percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
			janela.dispose();
		}catch (EmailInvalidoException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());
		} catch (Exception erro2) {
			JOptionPane.showMessageDialog(null, "Não foi possivel salvar alteração");
		}
	}

}