package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import JanelasServico.JanelaListarServicos;

public class OuvinteBotaoDetalharDoListarServ implements ActionListener {

	private JanelaListarServicos janela;
	
	public OuvinteBotaoDetalharDoListarServ(JanelaListarServicos janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		int instancia = janela.getTabela().getSelectedRow();
		try{
			JOptionPane.showMessageDialog(janela, janela.getOrdem()[instancia]);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(janela, "Selecione um serviço");
		}	
	}
}