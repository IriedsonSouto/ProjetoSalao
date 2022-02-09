package JanelasAgendamento;

import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesAgendamento.OuvinteEnviarCadastroCliente;
import Programa.Salao;

public class JanelaCadastrarCliente extends JanelaSimplesMae {

	//Atributos
	private JTextField nomeDoClienteResposta;
	private JTextField emailClienteResposta;
	private JFormattedTextField respostaTelefone;
	private JComboBox<String> comboBox;
	private Salao sla;
	
	//Construtor
	public JanelaCadastrarCliente (String titulo, Salao sla, String email) {
		super(titulo);
		this.sla = sla;
		adicionarCaixaNomeColab();
		adicionarCaixaEmailColab();
		emailClienteResposta.setText(email);
		adicionarCaixaTelefone();
		adicionarComboBox();
		adicionarJLabel("Nome", 50, 60, 90);
		adicionarJLabel("Email", 50, 100, 90);
		adicionarJLabel("Telefone", 50, 140, 90);
		BMae enviar = new BMae("Enviar", 200, 200, 100, 30);
		OuvinteEnviarCadastroCliente ouvinte = new OuvinteEnviarCadastroCliente(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);
	}
	
	//Metodos get e set
	public JTextField getNomeDoClienteResposta() {
		return nomeDoClienteResposta;
	}
	public JTextField getEmailClienteResposta() {
		return emailClienteResposta;
	}
	public JFormattedTextField getRespostaTelefone(){
		return respostaTelefone;
	}	
	public JComboBox<String> getComboBox(){
		return comboBox;
	}
	public Salao getSla(){
		return sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarCaixaNomeColab() {
		nomeDoClienteResposta = new JTextField();
		this.add(nomeDoClienteResposta);
		nomeDoClienteResposta.setBounds(120, 60, 300, 30);
	}
	private void adicionarCaixaEmailColab() {
		emailClienteResposta = new JTextField();
		this.add(emailClienteResposta);
		emailClienteResposta.setBounds(120, 100, 300, 30);
	}
	private void adicionarCaixaTelefone() {
		try {
			MaskFormatter mascara = new MaskFormatter("(##)#.####-####");
			respostaTelefone = new JFormattedTextField(mascara);
			this.add(respostaTelefone);
			respostaTelefone.setBounds(120, 140, 130, 30);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	private void adicionarComboBox() {
		String[] opcoes = {"Masculino", "Feminino"};
		comboBox = new JComboBox<String>(opcoes);
		this.add(comboBox);
		comboBox.setBounds(290, 140, 130, 30);
		comboBox.setBackground(Util.COR_PADRAO_BMINI);
		comboBox.setForeground(Util.COR_PADRAO_FONTE2);
	}
}