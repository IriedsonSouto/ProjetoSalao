package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;
import JanelasRelatorio.JanelaCentralRelatorios;

public class OuvinteBotaoCentralRelatorio implements ActionListener{

	private JanelaAdm janela;

	public OuvinteBotaoCentralRelatorio(JanelaAdm janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCentralRelatorios janelaCDR = new JanelaCentralRelatorios(janela.getSla());
		this.janela.dispose();
	}
}
