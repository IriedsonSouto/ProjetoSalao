package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;
import JanelasCaixa.JanelaCentralCaixa;

public class OuvinteBotaoCentralCaixa implements ActionListener{

	private JanelaAdm janela;

	public OuvinteBotaoCentralCaixa(JanelaAdm janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCentralCaixa janelaCC = new JanelaCentralCaixa(janela.getSla());
		this.janela.dispose();
	}
}
