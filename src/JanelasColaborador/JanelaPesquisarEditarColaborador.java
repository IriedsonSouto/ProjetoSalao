package JanelasColaborador;

import javax.swing.JTextField;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import OuvintesColaborador.OuvinteBotaoEnviarDoPesquisarEditarColaborador;
import Programa.Salao;

public class JanelaPesquisarEditarColaborador extends JanelaSimplesMae{
	
	//Atributos
	private JTextField emailColabResposta;
	private Salao sla;
	
	//Construtor
	public JanelaPesquisarEditarColaborador(String titulo, Salao sla) {
		super(titulo);
		this.setSize(500, 70);
		this.sla = sla;
		adicionarEmailColabResposta();
		adicionarJLabel("Email Colaborador", 10, 5, 120);
		BMae enviar = new BMae("Enviar", 380, 5, 100, 30);
		OuvinteBotaoEnviarDoPesquisarEditarColaborador ouvinte = new OuvinteBotaoEnviarDoPesquisarEditarColaborador(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);		
	}
	
	//Metodos get e set
	public Salao getSla(){
		return sla;
	}
	public JTextField getEmailColabResposta(){
		return emailColabResposta;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarEmailColabResposta() {
		emailColabResposta = new JTextField();
		this.add(emailColabResposta);
		emailColabResposta.setBounds(120, 5, 250, 30);
	}
}