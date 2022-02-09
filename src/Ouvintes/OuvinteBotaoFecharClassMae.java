package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Janelas.JanelaMae;

public class OuvinteBotaoFecharClassMae implements ActionListener  {
	
	private JanelaMae janela;
	
	public OuvinteBotaoFecharClassMae(JanelaMae janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		this.janela.dispose();
		System.exit(0);
	}

}
