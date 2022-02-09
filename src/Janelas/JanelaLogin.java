package Janelas;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Ouvintes.OuvinteBotaoAreaClienteColaborador;
import Ouvintes.OuvinteBotaoEnviarTelaLogin;
import Ouvintes.OuvinteBotaoEsqueceuASenhaLogin;
import Ouvintes.OuvinteBotaoVoltarJanelasCentral;
import Programa.Salao;

public class JanelaLogin extends JanelaMae{
	
	//Atributos
	private JTextField usuarioResposta;
	private JPasswordField senhaResposta;
	private Salao sla;

	//Construtor
	public JanelaLogin(Salao sla) {
		super("Bem vindo!");
		this.sla = sla;
		adicionarBEnviar();
		adicionarFigura();
		adicionarFigura2();
		setVisible(true);
	}
		
	//Metodos get e set	
	public Salao getSla() {
		return sla;
	}
	public JTextField getUsuarioResposta() {
		return usuarioResposta;
	}
	public JTextField getSenhaResposta() {
		return senhaResposta;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBEnviar() {
		BMae enviar = new BMae("Enviar",230, 400, 100, 30);
		OuvinteBotaoEnviarTelaLogin ouvinte = new OuvinteBotaoEnviarTelaLogin(this);
		enviar.addActionListener(ouvinte);
		this.add(enviar);
	}		
	private void adicionarFigura() {
		JLabel figura = new JLabel(Util.CIRCUFERENCIA_1);
		this.add(figura);
		figura.setBounds(50, 130, 450, 450);
		adicionarCaixaUsuario(figura);
		adicionarCaixaSenha(figura);
		adicionarJLabel(figura,"Email", 90, 170, 50);
		adicionarJLabel(figura, "Senha", 90, 210, 50);
		BMae esqueceu = new BMae("Esqueceu a senha?", 250, 320, 160, 30);
		esqueceu.setContentAreaFilled(false);
		esqueceu.setForeground(Util.COR_PADRAO_FONTE);
		OuvinteBotaoEsqueceuASenhaLogin ouvinte = new OuvinteBotaoEsqueceuASenhaLogin(this);
		esqueceu.addActionListener(ouvinte);
		figura.add(esqueceu);
	}	
	private void adicionarFigura2() {
		JLabel figura = new JLabel(Util.CIRCUFERENCIA_2);
		this.add(figura);
		figura.setBounds(530, 160, 350, 350);
		adicionarBText(figura);
	}	
	private void adicionarBText(JLabel figura){		
		JButton texButton = new JButton();
		figura.add(texButton);
		texButton.setContentAreaFilled(false);
		texButton.setBounds(20, 20, 300, 300);
		texButton.setText("<html><div align=center>Clientes<br>e<br>Colaboradores</html>");
		texButton.setFont(new Font( "Arial", Font.BOLD, 30));
		texButton.setForeground(Util.COR_PADRAO_FONTE);
		OuvinteBotaoAreaClienteColaborador ouvinte = new OuvinteBotaoAreaClienteColaborador(this);
		texButton.addActionListener(ouvinte);
	}	
	private void adicionarCaixaUsuario(JLabel figura) {
		usuarioResposta = new JTextField();
		figura.add(usuarioResposta);
		usuarioResposta.setBounds(140, 170, 200, 30);
		
	}	
	private void adicionarCaixaSenha(JLabel figura) {
		senhaResposta = new JPasswordField();
		figura.add(senhaResposta);
		senhaResposta.setBounds(140, 210, 200, 30);
	}	
	private void adicionarJLabel(JLabel figura, String nome, int xPosicao, int yPosicao, int xLargura) {
		JLabel texto = new JLabel(nome);
		this.add(texto);
		figura.add(texto);
		texto.setBounds(xPosicao, yPosicao, xLargura, 30);
		texto.setForeground(Util.COR_PADRAO_FONTE);
	}
	
	//Sobrescrita Voltar
	public void adicionarBVoltar() {
		
	}
}
