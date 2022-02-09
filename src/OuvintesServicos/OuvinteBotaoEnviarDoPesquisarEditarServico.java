package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasServico.JanelaEditarServico;
import JanelasServico.JanelaPesquisaEditarServico;
import Programa.Salao;
import Programa.Servico;

public class OuvinteBotaoEnviarDoPesquisarEditarServico implements ActionListener{

	private JanelaPesquisaEditarServico janela;
	
	public OuvinteBotaoEnviarDoPesquisarEditarServico(JanelaPesquisaEditarServico janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		Servico servico = janela.getSla().getCadastros().recuperarServico(janela.getIdServicoResposta().getText());
		if(servico != null){
			JanelaEditarServico janelaES = new JanelaEditarServico ("Editar Servico", janela.getSla(), servico);
			janela.dispose();
		}else{
			JOptionPane.showMessageDialog(null, "Não existe esse serviço");
		}
	}
}
