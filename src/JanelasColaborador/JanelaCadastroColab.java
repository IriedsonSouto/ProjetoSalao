package JanelasColaborador;

import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesColaborador.OuvinteBotaoEnviarCadastrarColab;
import OuvintesServicos.OuvinteBotaoEnviarDoCadastroDoServico;
import Programa.Salao;

public class JanelaCadastroColab extends JanelaSimplesMae {

	//Atributos
	private JTextField nomeDoColaboradorResposta;
	private JTextField emailColabResposta;
	private JFormattedTextField respostaTelefone;
	private JComboBox<String> comboBox;
	private Salao sla;
	
	//Construtor
	public JanelaCadastroColab (String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarCaixaNomeColab();
		adicionarCaixaEmailColab();
		adicionarCaixaTelefone();
		adicionarComboBox();
		adicionarJLabel("Nome", 50, 60, 90);
		adicionarJLabel("Email", 50, 100, 90);
		adicionarJLabel("Telefone", 50, 140, 90);
		BMae enviar = new BMae("Enviar", 200, 200, 100, 30);
		OuvinteBotaoEnviarCadastrarColab ouvinte = new OuvinteBotaoEnviarCadastrarColab(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);
	}
	
	//Metodos get e set
	public JTextField getNomeDoColaboradorResposta() {
		return nomeDoColaboradorResposta;
	}
	public JTextField getEmailColabResposta() {
		return emailColabResposta;
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
		nomeDoColaboradorResposta = new JTextField();
		this.add(nomeDoColaboradorResposta);
		nomeDoColaboradorResposta.setBounds(120, 60, 300, 30);
	}
	private void adicionarCaixaEmailColab() {
		emailColabResposta = new JTextField();
		this.add(emailColabResposta);
		emailColabResposta.setBounds(120, 100, 300, 30);
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