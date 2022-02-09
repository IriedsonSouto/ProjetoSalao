package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaEditarColaborador;
import JanelasColaborador.JanelaListarColaborador;

public class OuvinteBotaoDetalharDoListarColab implements ActionListener {

	private JanelaListarColaborador janela;
	
	public OuvinteBotaoDetalharDoListarColab(JanelaListarColaborador janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		int instancia = janela.getTabela().getSelectedRow();
		try{
			JOptionPane.showMessageDialog(janela, janela.getOrdem()[instancia]);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(janela, "Selecione um colaborador");
		}	
	}	
}
