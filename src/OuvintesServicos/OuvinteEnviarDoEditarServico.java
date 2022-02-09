package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasServico.JanelaEditarServico;
import JanelasServico.JanelaPesquisaEditarServico;
import Persistencia.Persistencia;
import Programa.Salao;
import Programa.Servico;

public class OuvinteEnviarDoEditarServico implements ActionListener{

	private JanelaEditarServico janela;
	private Servico servico;
	
	public OuvinteEnviarDoEditarServico(JanelaEditarServico janela, Servico servico){
		this.janela = janela;
		this.servico = servico;
	}

	public void actionPerformed(ActionEvent e) {
		servico.setNome(janela.getNomeDoServicoResposta().getText());
		servico.setDescricao(janela.getDescricaoDoServicoResposta().getText());
		servico.setDuracaoMedia(Integer.parseInt(janela.getDuracaoMediaS().getText()));
		try {
			Persistencia percistencia = new Persistencia();
			percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
			janela.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Não foi possivel salver alteração");
		}
	}

}