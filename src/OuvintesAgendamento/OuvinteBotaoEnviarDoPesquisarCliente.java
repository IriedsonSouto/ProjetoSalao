package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasAgendamento.JanelaCadastrarAgendamento;
import JanelasAgendamento.JanelaCadastrarCliente;
import JanelasAgendamento.JanelaCentralAgendamento;
import JanelasAgendamento.JanelaPesquisarCliente;
import Programa.Cliente;
import Programa.Salao;

public class OuvinteBotaoEnviarDoPesquisarCliente implements ActionListener{

	private JanelaPesquisarCliente janela;

	public OuvinteBotaoEnviarDoPesquisarCliente(JanelaPesquisarCliente janela){
		this.janela = janela;
	}
	

	public void actionPerformed(ActionEvent e) {
		janela.dispose();
		Cliente cliente = janela.getSla().getCadastros().recuperarCliente(janela.getEmailColabResposta().getText());
		if( cliente == null){
			JanelaCadastrarCliente janelaCC = new JanelaCadastrarCliente("Cadastro Cliente"
					, janela.getSla(), janela.getEmailColabResposta().getText());
		}else{
			JanelaCadastrarAgendamento janelaCA = new JanelaCadastrarAgendamento("Cadastrar Agendamento"
					,janela.getSla(), cliente);
		}
	}
}
