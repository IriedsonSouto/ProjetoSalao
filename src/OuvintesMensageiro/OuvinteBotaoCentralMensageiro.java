package OuvintesMensageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;
import JanelasMensageiro.JanelaCentralMensageiro;

public class OuvinteBotaoCentralMensageiro implements ActionListener{

	private JanelaAdm janela;

	public OuvinteBotaoCentralMensageiro(JanelaAdm janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCentralMensageiro janelaCDM = new JanelaCentralMensageiro(janela.getSla());
		this.janela.dispose();
	}
}
