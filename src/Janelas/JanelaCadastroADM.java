package Janelas;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Ouvintes.OuvinteBotaoEnviarTelaDeCadastroADM;
import Programa.Salao;

public class JanelaCadastroADM extends JanelaSimplesMae {
	
	//Atributos
	private JTextField administradoResposta;
	private JTextField emailResposta;
	private JPasswordField senhaResposta;
	private JPasswordField cSenhaResposta;
	private Salao sla;
	
	//Construtor
	public JanelaCadastroADM (String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarCaixaAdministrado();
		adicionarEmail();
		adicionarSenha();
		adicionarConfirmarSenha();
		adicionarJLabel("Nome", 30, 60, 50);
		adicionarJLabel("Email", 30, 100, 50);
		adicionarJLabel("Senha", 30, 140, 50);
		adicionarJLabel("Confirmar Senha", 210, 140, 110);
		BMae enviar = new BMae("Enviar", 200, 200, 100, 30);
		OuvinteBotaoEnviarTelaDeCadastroADM ouvinte = new OuvinteBotaoEnviarTelaDeCadastroADM(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	//Metodos get e set
	public JTextField getAdministradoResposta() {
		return administradoResposta;
	}
	public JTextField getEmailResposta() {
		return emailResposta;
	}
	public JPasswordField getSenhaResposta() {
		return senhaResposta;
	}
	public JPasswordField getcSenhaResposta() {
		return cSenhaResposta;
	}
	public Salao getSla(){
		return sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarCaixaAdministrado() {
		administradoResposta = new JTextField();
		this.add(administradoResposta);
		administradoResposta.setBounds(80, 60, 350, 30);
	}
	private void adicionarEmail() {
		emailResposta = new JTextField();
		this.add(emailResposta);
		emailResposta.setBounds(80, 100, 350, 30);
	}
	private void adicionarSenha() {
		senhaResposta = new JPasswordField();
		this.add(senhaResposta);
		senhaResposta.setBounds(80, 140, 120, 30);
	}
	private void adicionarConfirmarSenha() {
		cSenhaResposta = new JPasswordField();
		this.add(cSenhaResposta);
		cSenhaResposta.setBounds(310, 140, 120, 30);
	}
}
