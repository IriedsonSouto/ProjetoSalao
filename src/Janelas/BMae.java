package Janelas;


import java.awt.Font;

import javax.swing.JButton;

public class BMae extends JButton {
	
	// construtor com os elementos de designer de botão generico
	public BMae(String titulo, int x, int y, int a, int l) {
		setBackground(Util.COR_PADRAO_BMINI);
		setBounds(x, y, a, l);
		setText(titulo);
		setForeground(Util.COR_PADRAO_FONTE2);
	}	
}
