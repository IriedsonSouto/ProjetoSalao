package JanelasColaborador;
import Janelas.BMae;
import Janelas.JanelaMae;
import Ouvintes.*;
import OuvintesColaborador.OuvinteBotaoCadastrarNovoColaborador;
import OuvintesColaborador.OuvinteBotaoEditarColaborador;
import OuvintesColaborador.OuvinteBotaoListarColaboradores;
import Programa.Salao;

public class JanelaCentralColaborador extends JanelaMae {
	
	//Atributos
	private Salao sla;

	//Construtor
	public JanelaCentralColaborador(Salao sla) {
		super("Central de Colaborador");
		this.sla = sla;
		adicionarBCadastrarNColaborador();
		adicionarBListarColaborador();
		adicionarBEditarColaborador();
		setVisible(true);	
	}
	
	//Metodos get e set
	public Salao getSla(){
		return this.sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBCadastrarNColaborador() {
		BMae cadastrarColaborador = new BMae("Cadastrar novo colaborador",65, 220, 250, 30);
		OuvinteBotaoCadastrarNovoColaborador ouvinte = new OuvinteBotaoCadastrarNovoColaborador(this);
		cadastrarColaborador.addActionListener(ouvinte);
		this.add(cadastrarColaborador);
	}
	private void adicionarBListarColaborador() {
		BMae listarColaborador = new BMae("Listar colobarodaor",65, 270, 250, 30);
		OuvinteBotaoListarColaboradores ouvinte = new OuvinteBotaoListarColaboradores(this);
		listarColaborador.addActionListener(ouvinte);
		this.add(listarColaborador);
	}
	private void adicionarBEditarColaborador() {
		BMae editarColaborador = new BMae("Editar colaborador",65, 320, 250, 30);
		OuvinteBotaoEditarColaborador ouvinte = new OuvinteBotaoEditarColaborador (this);
		editarColaborador.addActionListener(ouvinte);
		this.add(editarColaborador);
	}
}