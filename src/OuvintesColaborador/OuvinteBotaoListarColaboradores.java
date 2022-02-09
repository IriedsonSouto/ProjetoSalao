package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasColaborador.JanelaCentralColaborador;
import JanelasColaborador.JanelaListarColaborador;
import JanelasServico.JanelaCentralServico;

public class OuvinteBotaoListarColaboradores implements ActionListener {

	private JanelaCentralColaborador janela;

	
	public OuvinteBotaoListarColaboradores(JanelaCentralColaborador janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		JanelaListarColaborador janelaLS = new JanelaListarColaborador("Tabela", janela.getSla());
	}

}