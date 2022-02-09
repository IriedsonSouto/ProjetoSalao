package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaEditarColaborador;
import JanelasColaborador.JanelaPesquisarEditarColaborador;
import Programa.Colaborador;


public class OuvinteBotaoEnviarDoPesquisarEditarColaborador implements ActionListener{

	private JanelaPesquisarEditarColaborador janela;
	
	public OuvinteBotaoEnviarDoPesquisarEditarColaborador(JanelaPesquisarEditarColaborador janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		Colaborador colab = janela.getSla().getCadastros().recuperarColaborador(janela.getEmailColabResposta().getText());
		if(colab != null){
			JanelaEditarColaborador janelaEC = new JanelaEditarColaborador("Editar Colaborador", janela.getSla(), colab);
			janela.dispose();
		}else{
			JOptionPane.showMessageDialog(janela, "Não existe esse colaborador");
		}
	}
}