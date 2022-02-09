package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Janelas.JanelaLogin;
import Programa.Mensageiro;

public class OuvinteBotaoEsqueceuASenhaLogin implements ActionListener {

	private JanelaLogin janela;

	public OuvinteBotaoEsqueceuASenhaLogin(JanelaLogin janela){
		this.janela = janela;
	}
	
	
	public void actionPerformed(ActionEvent click) {
		try{
			Mensageiro.enviarMensagemAoADM(janela.getSla().getCadastros().getAdministrado().getEmail()
					, "Sua senha: "+janela.getSla().getCadastros().getAdministrado().getcSenha());
		}catch(Exception erro){
			JOptionPane.showMessageDialog(janela, "Não há usuario cadastrado");
		}	
	}
}
