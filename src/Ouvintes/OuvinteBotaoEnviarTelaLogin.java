package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Janelas.*;

public class OuvinteBotaoEnviarTelaLogin implements ActionListener {

	private JanelaLogin janela;

	
	public OuvinteBotaoEnviarTelaLogin(JanelaLogin janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {

		if(janela.getUsuarioResposta().getText().equals(janela.getSla().getCadastros().getAdministrado().getEmail())){
			if(janela.getSenhaResposta().getText().equals(janela.getSla().getCadastros().getAdministrado().getcSenha())) {
				JanelaAdm janelaAdm = new JanelaAdm();
				janela.dispose();
			}else {
				JOptionPane.showMessageDialog(janela, "Senha invalida");
			}
		}else {
			JOptionPane.showMessageDialog(janela, "Usuario invalido");
		}
	}

}
