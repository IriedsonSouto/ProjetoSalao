package JanelasColaborador;

import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesColaborador.OuvinteBotaoEditarAssociacao;
import OuvintesColaborador.OuvinteBotaoEnviarDoEditarColab;
import Programa.Colaborador;
import Programa.Salao;

public class JanelaEditarColaborador extends JanelaSimplesMae {

	//Atributos
	private JTextField nomeDoColaboradorResposta;
	private JTextField emailColabResposta;
	private JFormattedTextField respostaTelefone;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBoxStatus;
	private Salao sla;
	private Colaborador colab;
	
	//Construtor
	public JanelaEditarColaborador (String titulo, Salao sla, Colaborador colab) {
		super(titulo);
		this.sla = sla;
		this.colab = colab;
		adicionarCaixaNomeColab();
		adicionarCaixaEmailColab();
		adicionarCaixaTelefone();
		adicionarComboBox();
		adicionarComboBoxStatus();
		adicionarJLabel("Nome", 50, 60, 90);
		adicionarJLabel("Email", 50, 100, 90);
		adicionarJLabel("Telefone", 50, 140, 90);
		BMae enviar = new BMae("Enviar", 200, 230, 100, 30);
		OuvinteBotaoEnviarDoEditarColab ouvinte = new OuvinteBotaoEnviarDoEditarColab(this);
		enviar.addActionListener(ouvinte);
		BMae associar = new BMae("Serviços",120, 180, 130, 30);
		OuvinteBotaoEditarAssociacao ouvinte2 = new OuvinteBotaoEditarAssociacao(this);
		associar.addActionListener(ouvinte2);
		add(enviar);
		add(associar);
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
	public JComboBox<String> getComboBoxStatus(){
		return comboBoxStatus;
	}
	public Salao getSla(){
		return sla;
	}
	public Colaborador getColab(){
		return colab;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarCaixaNomeColab() {
		nomeDoColaboradorResposta = new JTextField(colab.getNome());
		this.add(nomeDoColaboradorResposta);
		nomeDoColaboradorResposta.setBounds(120, 60, 300, 30);
	}
	private void adicionarCaixaEmailColab() {
		emailColabResposta = new JTextField(colab.getEmail());
		this.add(emailColabResposta);
		emailColabResposta.setBounds(120, 100, 300, 30);
	}
	private void adicionarCaixaTelefone() {
		try {
			MaskFormatter mascara = new MaskFormatter("(##)#.####-####");
			respostaTelefone = new JFormattedTextField(mascara);
			respostaTelefone.setText(colab.getTelefone());
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
		comboBox.setBounds(270, 140, 150, 30);
		comboBox.setBackground(Util.COR_PADRAO_BMINI);
		comboBox.setForeground(Util.COR_PADRAO_FONTE2);
	}
	
	private void adicionarComboBoxStatus() {
		String[] opcoes = {"Associado", "Desvinculado"};
		comboBoxStatus = new JComboBox<String>(opcoes);
		this.add(comboBoxStatus);
		comboBoxStatus.setBounds(270, 180, 150, 30);
		comboBoxStatus.setBackground(Util.COR_PADRAO_BMINI);
		comboBoxStatus.setForeground(Util.COR_PADRAO_FONTE2);
	}
}