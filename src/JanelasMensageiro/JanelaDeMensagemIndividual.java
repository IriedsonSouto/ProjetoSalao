package JanelasMensageiro;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesMensageiro.OuvinteBotaoEnviarMensageiro;
import Programa.Salao;

public class JanelaDeMensagemIndividual extends JanelaSimplesMae {

	//Atributos
	private JTextField contatoResposta;
	private JTextField assuntoResposta;
	private JTextArea textoResposta;
	
	//Construtores
	public JanelaDeMensagemIndividual (String titulo) {
		super(titulo);
		criarTela();
	}
	public JanelaDeMensagemIndividual (String titulo, String contato) {
		super(titulo);
		criarTela();
		this.contatoResposta.setText(contato);
	}
	
	//Metodos get e set
	public JTextField getContatoResposta() {
		return contatoResposta;
	}
	public JTextField getAssuntoResposta() {
		return assuntoResposta;
	}
	public JTextArea getTextoResposta() {
		return textoResposta;
	}

	//Metodos de adição de elementos de layout
	private void adicionarCaixaContado() {
		contatoResposta = new JTextField();
		this.add(contatoResposta);
		contatoResposta.setBounds(80, 20, 350, 30);
	}
	private void adicionarCaixaAssunto() {
		assuntoResposta = new JTextField();
		this.add(assuntoResposta);
		assuntoResposta.setBounds(80, 60, 350, 30);
	}
	private void adicionarCaixaTexto() {
		textoResposta = new JTextArea("Mensagem");
		this.add(textoResposta);
		textoResposta.setBounds(80, 100, 350, 150);
	}	
	private void criarTela() {
		adicionarCaixaContado();
		adicionarCaixaAssunto();
		adicionarCaixaTexto();
		adicionarJLabel("Email", 30, 20, 50);
		adicionarJLabel("Assunto", 30, 60, 50);
		BMae enviar = new BMae("Enviar", 200, 270, 100, 30);
		OuvinteBotaoEnviarMensageiro ouvinte = new OuvinteBotaoEnviarMensageiro(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);
	}
}
