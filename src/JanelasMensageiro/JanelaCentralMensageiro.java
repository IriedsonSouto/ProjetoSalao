package JanelasMensageiro;
import Janelas.BMae;
import Janelas.JanelaMae;
import Ouvintes.*;
import OuvintesMensageiro.OuvinteBotaoMensagemClientes;
import OuvintesMensageiro.OuvinteBotaoMensagemColaboradores;
import OuvintesMensageiro.OuvinteBotaoMensagemIndividual;
import Programa.Salao;


public class JanelaCentralMensageiro extends JanelaMae {
	
	//Atributos
	private Salao sla;
	
	//Construtor
	public JanelaCentralMensageiro(Salao sla) {
		super("Central de Mensagens");
		this.sla = sla;
		adicionarBEnviarMensagem();
		adicionarBEnviarMensagemTClientes();
		adicionarBEnviarMensagemTColaboradores();
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla(){
		return sla;
	}

	//Metodos de adição de elementos de layout
	private void adicionarBEnviarMensagem() {
		BMae enviarMensagem = new BMae("Enviar mensagem",65, 220, 250, 30);
		OuvinteBotaoMensagemIndividual ouvinte = new OuvinteBotaoMensagemIndividual();
		enviarMensagem.addActionListener(ouvinte);
		this.add(enviarMensagem);
	}
	private void adicionarBEnviarMensagemTClientes() {
		BMae enviarMensagemTClientes = new BMae("Enviar mensagem todos clientes",65, 270, 250, 30);
		OuvinteBotaoMensagemClientes ouvinte = new OuvinteBotaoMensagemClientes(this);
		enviarMensagemTClientes.addActionListener(ouvinte);
		this.add(enviarMensagemTClientes);
	}
	private void adicionarBEnviarMensagemTColaboradores() {
		BMae enviarMensagemTColaboradores = new BMae("Enviar mensagem todos colaboradores",65, 320, 250, 30);
		OuvinteBotaoMensagemColaboradores ouvinte = new OuvinteBotaoMensagemColaboradores(this);
		enviarMensagemTColaboradores.addActionListener(ouvinte);
		this.add(enviarMensagemTColaboradores);
	}
}