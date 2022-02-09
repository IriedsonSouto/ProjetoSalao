package OuvintesColaborador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import JanelasColaborador.JanelaListarColaborador;


public class OuvinteAtualizarJanelaColab implements WindowListener{
	
	//Atributos
	private JanelaListarColaborador janela;
	private	int atualizar;
	
	//Construtor
	public OuvinteAtualizarJanelaColab(JanelaListarColaborador janela){
		this.janela = janela;
	}
	
	public void windowOpened(WindowEvent e) {
		atualizar = 0;
	}
	
	public void windowActivated(WindowEvent e) {
		if(atualizar == 1){
			janela.dispose();
			new JanelaListarColaborador("Tabela",janela.getSla());
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