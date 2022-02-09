package Janelas;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaSimplesMae extends JFrame {

	//Construtor
	public JanelaSimplesMae(String titulo) {
		setTitle(titulo);
		setSize(510, 360);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Util.COR_PADRAO_FUNDO);
	}
	
	//Metodos de adição de elementos de layout
	public void adicionarJLabel(String nome, int xPosicao, int yPosicao, int xLargura) {
		JLabel texto = new JLabel(nome);
		this.add(texto);
		texto.setBounds(xPosicao, yPosicao, xLargura, 30);
		texto.setForeground(Util.COR_PADRAO_FONTE);
	}

}
