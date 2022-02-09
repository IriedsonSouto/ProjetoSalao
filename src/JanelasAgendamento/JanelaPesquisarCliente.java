package JanelasAgendamento;

import javax.swing.JTextField;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import OuvintesAgendamento.OuvinteBotaoEnviarDoPesquisarCliente;
import OuvintesColaborador.OuvinteBotaoEnviarDoPesquisarEditarColaborador;
import Programa.Salao;

public class JanelaPesquisarCliente extends JanelaSimplesMae{
	
	//Atributos
	private JTextField emailClienteResposta;
	private Salao sla;
	
	//Construtor
	public JanelaPesquisarCliente(String titulo, Salao sla) {
		super(titulo);
		this.setSize(500, 70);
		this.sla = sla;
		adicionarEmailClientebResposta();
		adicionarJLabel("Email Cliente", 10, 5, 120);
		BMae enviar = new BMae("Enviar", 380, 5, 100, 30);
		OuvinteBotaoEnviarDoPesquisarCliente ouvinte = new OuvinteBotaoEnviarDoPesquisarCliente(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);		
	}
	
	//Metodos get e set
	public Salao getSla(){
		return sla;
	}
	public JTextField getEmailColabResposta(){
		return emailClienteResposta;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarEmailClientebResposta() {
		emailClienteResposta = new JTextField();
		this.add(emailClienteResposta);
		emailClienteResposta.setBounds(120, 5, 250, 30);
	}
}