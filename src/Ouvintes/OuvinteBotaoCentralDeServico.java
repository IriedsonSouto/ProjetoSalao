package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;
import JanelasServico.JanelaCentralServico;
import Programa.Salao;

public class OuvinteBotaoCentralDeServico implements ActionListener{

	private JanelaAdm janela;

	public OuvinteBotaoCentralDeServico(JanelaAdm janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCentralServico janelaCDS = new JanelaCentralServico(janela.getSla());
		this.janela.dispose();
	}

	
}