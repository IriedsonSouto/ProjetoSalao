package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;

public class OuvinteBotaoVoltarJanelasCentral implements ActionListener{

	private JanelaMae janela;

	public OuvinteBotaoVoltarJanelasCentral(JanelaMae janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaAdm janelaAdm = new JanelaAdm();
		this.janela.dispose();
	}

	
}
