package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaAdicionarServicoNoColab;
import JanelasColaborador.JanelaEditarColaborador;
import Persistencia.Persistencia;

public class OuvinteBotaoExcluirDoListarServicoDoColab implements ActionListener {

	private JanelaAdicionarServicoNoColab janela;
	
	public OuvinteBotaoExcluirDoListarServicoDoColab(JanelaAdicionarServicoNoColab janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent e) {
		int instancia = janela.getTabela().getSelectedRow();
		try{
			janela.getSla().getCadastros().getTodosOsAssociaColabServ().remove(janela.getOrdem()[instancia]);
			janela.dispose();
			JanelaAdicionarServicoNoColab janelaSNC= new JanelaAdicionarServicoNoColab("Serviços do Colaborador"
					, janela.getOrdem()[instancia].getColabA(), janela.getSla());
			Persistencia percistencia = new Persistencia();
			percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
		}catch(Exception erro){
			JOptionPane.showMessageDialog(janela, "Selecione um colaborador");
		}
			
	}
}
