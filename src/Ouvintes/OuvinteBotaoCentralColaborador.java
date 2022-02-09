package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;
import JanelasColaborador.JanelaCentralColaborador;

public class OuvinteBotaoCentralColaborador implements ActionListener{

	private JanelaAdm janela;

	public OuvinteBotaoCentralColaborador(JanelaAdm janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCentralColaborador janelaCDC = new JanelaCentralColaborador(janela.getSla());
		this.janela.dispose();
	}

	
}