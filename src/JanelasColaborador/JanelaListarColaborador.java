package JanelasColaborador;

import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import OuvintesColaborador.OuvinteAtualizarJanelaColab;
import OuvintesColaborador.OuvinteBotaoDetalharDoListarColab;
import OuvintesColaborador.OuvinteBotaoEditarDoListarColab;
import Programa.Salao;
import Programa.Colaborador;

public class JanelaListarColaborador extends JanelaSimplesMae {

	//Atributos
	private Salao sla;
	private JTable tabela;
	private Colaborador[] ordem;
	

	//Construtor
	public JanelaListarColaborador (String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarTabela();
		adicionarBotaoDetalhe();
		adicionarBotaoEditar();
		OuvinteAtualizarJanelaColab ouvinte = new OuvinteAtualizarJanelaColab(this);
		addWindowListener(ouvinte);
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla(){
		return sla;
	}
	public JTable getTabela() {
		return tabela;
	}
	public Colaborador[] getOrdem() {
		return ordem;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		modelo.addColumn("Nome");
		modelo.addColumn("Email");
		modelo.addColumn("Telefone");
		modelo.addColumn("Status");

		ordem = new Colaborador[sla.getCadastros().getColaboradores().size()];
		int i = 0;
		for(Colaborador colab: sla.getCadastros().getColaboradores()){
			ordem[i++]=colab;
		}
		Arrays.sort(ordem);
				
		for(Colaborador colab: ordem){
			Object[] linha = new Object[]{colab.getNome(),
											colab.getEmail(),
											colab.getTelefone(),
											colab.getAssociado()
										};
			modelo.addRow(linha);
		}
		JScrollPane conteiner = new JScrollPane(tabela);
		this.add(conteiner);
		conteiner.setBounds(5, 5, 495, 250);	
	}
	
	public void adicionarBotaoDetalhe(){
		BMae detalhar = new BMae("Detalhar", 110, 280, 100, 30);
		OuvinteBotaoDetalharDoListarColab ouvinte = new OuvinteBotaoDetalharDoListarColab(this);
		detalhar.addActionListener(ouvinte);
		add(detalhar);
	}
	
	public void adicionarBotaoEditar(){
		BMae editar = new BMae("Editar", 300, 280, 100, 30);
		OuvinteBotaoEditarDoListarColab ouvinte = new OuvinteBotaoEditarDoListarColab(this);
		editar.addActionListener(ouvinte);
		add(editar);
	}
}