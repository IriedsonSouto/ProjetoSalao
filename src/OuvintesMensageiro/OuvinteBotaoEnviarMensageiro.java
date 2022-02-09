package OuvintesMensageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Janelas.JanelaSimplesMae;
import JanelasMensageiro.JanelaDeMensagemIndividual;
import Programa.Mensageiro;

public class OuvinteBotaoEnviarMensageiro implements ActionListener {

	private JanelaDeMensagemIndividual janela;
	
	public OuvinteBotaoEnviarMensageiro(JanelaDeMensagemIndividual janela) {
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		Mensageiro.enviarMensagemIndividual(janela.getContatoResposta().getText()
				, janela.getTextoResposta().getText(), janela.getAssuntoResposta().getText());
		janela.getContatoResposta().setText("");
		janela.getTextoResposta().setText("");
		janela.getAssuntoResposta().setText("");
	}

}
