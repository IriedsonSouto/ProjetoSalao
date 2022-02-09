package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasServico.JanelaCentralServico;
import JanelasServico.JanelaPesquisaEditarServico;
import Persistencia.Persistencia;
import Programa.Servico;

public class OuvinteBotaoEditarServico implements ActionListener {

	private JanelaCentralServico janela;

	
	public OuvinteBotaoEditarServico(JanelaCentralServico janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		JanelaPesquisaEditarServico janelaPES = new JanelaPesquisaEditarServico("Pesquisar", janela.getSla());
	}

}