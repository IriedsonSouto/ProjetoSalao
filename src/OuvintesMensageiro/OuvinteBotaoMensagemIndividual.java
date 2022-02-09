package OuvintesMensageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasMensageiro.JanelaDeMensagemIndividual;
import Programa.Mensageiro;

public class OuvinteBotaoMensagemIndividual  implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		JanelaDeMensagemIndividual janelaMI = new JanelaDeMensagemIndividual("Mensageiro");
	}

}