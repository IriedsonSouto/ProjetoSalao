package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasColaborador.JanelaCentralColaborador;
import JanelasColaborador.JanelaPesquisarEditarColaborador;

public class OuvinteBotaoEditarColaborador implements ActionListener {

	private JanelaCentralColaborador janela;

	
	public OuvinteBotaoEditarColaborador(JanelaCentralColaborador janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		JanelaPesquisarEditarColaborador janelaPEC = new JanelaPesquisarEditarColaborador("Pesquisar", janela.getSla());
	}

}