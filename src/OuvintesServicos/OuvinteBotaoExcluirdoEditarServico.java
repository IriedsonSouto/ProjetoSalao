package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasServico.JanelaEditarServico;
import Persistencia.Persistencia;
import Programa.Servico;

public class OuvinteBotaoExcluirdoEditarServico implements ActionListener{

	private JanelaEditarServico janela;
	private Servico servico;
	
	public OuvinteBotaoExcluirdoEditarServico(JanelaEditarServico janela, Servico servico){
		this.janela = janela;
		this.servico = servico;
	}

	public void actionPerformed(ActionEvent e) {
		janela.getSla().getCadastros().getServicos().remove(servico);
		try {
			Persistencia percistencia = new Persistencia();
			percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
			janela.dispose();
			new JanelaEditarServico ("Editar Servico", janela.getSla(), servico);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Não foi possivel salver alteração");
		}
	}

}