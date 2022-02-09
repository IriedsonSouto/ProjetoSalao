package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasServico.JanelaEditarServico;
import JanelasServico.JanelaListarServicos;


public class OuvinteBotaoEditarDoListarServico implements ActionListener {

	private JanelaListarServicos janela;

	
	public OuvinteBotaoEditarDoListarServico(JanelaListarServicos janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		int instancia = janela.getTabela().getSelectedRow();
		try{
			JanelaEditarServico janelaES = new JanelaEditarServico ("Editar Servico", janela.getSla(), janela.getOrdem()[instancia]);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(janela, "Selecione um serviço");
		}
		
	}

}