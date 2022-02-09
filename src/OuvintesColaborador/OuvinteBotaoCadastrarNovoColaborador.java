package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasColaborador.JanelaCadastroColab;
import JanelasColaborador.JanelaCentralColaborador;

public class OuvinteBotaoCadastrarNovoColaborador implements ActionListener {
	
	private JanelaCentralColaborador janela;

	public OuvinteBotaoCadastrarNovoColaborador(JanelaCentralColaborador janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCadastroColab janelaCC = new JanelaCadastroColab("Cadastro", janela.getSla());
	}

}
