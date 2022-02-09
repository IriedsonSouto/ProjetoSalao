package OuvintesServicos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import JanelasServico.JanelaListarServicos;

public class OuvinteAtualizarJanela implements WindowListener{
	
	//Atributos
	private JanelaListarServicos janela;
	private	int atualizar;
	
	//Construtor
	public OuvinteAtualizarJanela(JanelaListarServicos janela){
		this.janela = janela;
	}
	
	public void windowOpened(WindowEvent e) {
		atualizar = 0;
	}
	
	public void windowActivated(WindowEvent e) {
		if(atualizar == 1){
			janela.dispose();
			new JanelaListarServicos("Tabela",janela.getSla());
			atualizar = 0;
		}	
	}
	public void windowDeactivated(WindowEvent e) {
		atualizar = 1;
	}
	
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	
}