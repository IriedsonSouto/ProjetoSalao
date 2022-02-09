package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Janelas.JanelaMae;

public class OuvinteBotaoMinimizarClassMae implements ActionListener {

private JanelaMae janela;
	
	public OuvinteBotaoMinimizarClassMae(JanelaMae janela){
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		this.janela.setExtendedState(JFrame.ICONIFIED);
	}
}
