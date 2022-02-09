package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import Janelas.*;
import Programa.Administrado;
import Programa.EmailInvalidoException;
import Persistencia.Persistencia;

public class OuvinteBotaoEnviarTelaDeCadastroADM implements ActionListener {

	private JanelaCadastroADM janela;

	
	public OuvinteBotaoEnviarTelaDeCadastroADM(JanelaCadastroADM janela){
		this.janela = janela;
	}


	public void actionPerformed(ActionEvent click) {
		try {
			janela.getSla().getCadastros().cadastrarAdministrado(new Administrado(janela.getAdministradoResposta().getText()
							, janela.getEmailResposta().getText(), new String(janela.getSenhaResposta().getPassword())
							, new String(janela.getcSenhaResposta().getPassword())));
			Persistencia percistencia = new Persistencia();
			percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
			janela.dispose();
		} catch (EmailInvalidoException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());
		}catch(Exception erro) {
			System.out.println("Não foi possivel salvar os arquivos.");
		}
		
	}

}