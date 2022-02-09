package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import JanelasServico.JanelaCadastroServicos;
import JanelasServico.JanelaCentralServico;


public class OuvinteBotaoCadastrarNovoServico implements ActionListener {

	private JanelaCentralServico janela;

	
	public OuvinteBotaoCadastrarNovoServico(JanelaCentralServico janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		JanelaCadastroServicos janelaCNS = new JanelaCadastroServicos("Cadastro", janela.getSla());
	}

}