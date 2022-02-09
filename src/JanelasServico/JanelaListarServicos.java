package JanelasServico;


import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesServicos.OuvinteAtualizarJanela;
import OuvintesServicos.OuvinteBotaoDetalharDoListarServ;
import OuvintesServicos.OuvinteBotaoEditarDoListarServico;
import Programa.Salao;
import Programa.Servico;

public class JanelaListarServicos extends JanelaSimplesMae {

	//Atributos
	private Salao sla;
	private JTable tabela;
	private Servico[] ordem;
	
	
	//Construtor
	public JanelaListarServicos (String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarTabela();
		adicionarBotaoDetalhe();
		adicionarBotaoEditar();
		OuvinteAtualizarJanela ouvinte = new OuvinteAtualizarJanela(this);
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
	public Servico[] getOrdem() {
		return ordem;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		modelo.addColumn("Serviço");
		modelo.addColumn("Descrição");
		modelo.addColumn("Duração");
		modelo.addColumn("ID");

		ordem = new Servico[sla.getCadastros().getServicos().size()];
		int i = 0;
		for(Servico serv: sla.getCadastros().getServicos()){
			ordem[i++]=serv;
		}
		Arrays.sort(ordem);
		
		
		for(Servico servico: ordem){
			Object[] linha = new Object[]{servico.getNome(),
											servico.getDescricao(),
											servico.getDuracaoMedia(), 
											servico.getId()
										};
			modelo.addRow(linha);
		}
		JScrollPane conteiner = new JScrollPane(tabela);
		this.add(conteiner);
		conteiner.setBounds(5, 5, 495, 250);
	}
	
	public void adicionarBotaoDetalhe(){
		BMae detalhar = new BMae("Detalhar", 110, 280, 100, 30);
		OuvinteBotaoDetalharDoListarServ ouvinte = new OuvinteBotaoDetalharDoListarServ(this);
		detalhar.addActionListener(ouvinte);
		add(detalhar);
	}
	
	public void adicionarBotaoEditar(){
		BMae editar = new BMae("Editar", 300, 280, 100, 30);
		OuvinteBotaoEditarDoListarServico ouvinte = new OuvinteBotaoEditarDoListarServico(this);
		editar.addActionListener(ouvinte);
		add(editar);
	}
	
}