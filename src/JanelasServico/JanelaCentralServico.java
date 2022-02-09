package JanelasServico;
import Janelas.BMae;
import Janelas.JanelaMae;
import Ouvintes.*;
import OuvintesServicos.*;
import Programa.Salao;

public class JanelaCentralServico extends JanelaMae {
	
	//Atributos
	private Salao sla;

	//Construtor
	public JanelaCentralServico(Salao sla) {
		super("Central de Servi�o");
		this.sla = sla;
		adicionarBCadastrarNServico();
		adicionarBListarServico();
		adicionarBEditarServico();
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla(){
		return this.sla;
	}
	
	//Metodos de adi��o de elementos de layout
	private void adicionarBCadastrarNServico() {
		BMae cadastrarServico = new BMae("Cadastrar novo servi�o",65, 220, 250, 30);
		OuvinteBotaoCadastrarNovoServico ouvinte = new OuvinteBotaoCadastrarNovoServico(this);
		cadastrarServico.addActionListener(ouvinte);
		this.add(cadastrarServico);
	}
	private void adicionarBListarServico() {
		BMae listarServico = new BMae("Listar servi�o",65, 270, 250, 30);
		OuvinteBotaoListarNovoServico ouvinte = new OuvinteBotaoListarNovoServico(this);
		listarServico.addActionListener(ouvinte);
		this.add(listarServico);
	}
	private void adicionarBEditarServico() {
		BMae editarServico = new BMae("Editar servi�o",65, 320, 250, 30);
		OuvinteBotaoEditarServico ouvinte = new OuvinteBotaoEditarServico(this);
		editarServico.addActionListener(ouvinte);
		this.add(editarServico);
	}
}

