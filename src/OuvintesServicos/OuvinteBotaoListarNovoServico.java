package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasServico.JanelaCentralServico;
import JanelasServico.JanelaListarServicos;

public class OuvinteBotaoListarNovoServico implements ActionListener {

	private JanelaCentralServico janela;

	
	public OuvinteBotaoListarNovoServico(JanelaCentralServico janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		JanelaListarServicos janelaLS = new JanelaListarServicos("Tabela", janela.getSla());
	}

}