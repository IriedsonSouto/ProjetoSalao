package JanelasColaborador;

import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesColaborador.OuvinteBotaoDetalharDoListarColab;
import OuvintesColaborador.OuvinteBotaoEditarDoListarColab;
import OuvintesColaborador.OuvinteBotaoEnviarCadastrarColab;
import OuvintesColaborador.OuvinteBotaoEnviarDoAssociarServico;
import OuvintesColaborador.OuvinteBotaoExcluirDoListarServicoDoColab;
import Programa.AssociaColabServ;
import Programa.Colaborador;
import Programa.Salao;
import Programa.Servico;

public class JanelaAdicionarServicoNoColab extends JanelaSimplesMae{
	
	//Atributos
	private Colaborador colab;
	private Salao sla;
	private JTextField idServicoResposta;
	private JTextField valorServicoResposta;
	private JTable tabela;
	private AssociaColabServ[] ordem;

	//Construtor
	public JanelaAdicionarServicoNoColab(String titulo, Colaborador colab, Salao sla) {
		super(titulo);
		this.colab = colab;
		this.sla = sla;
		adicionarIdServicoResposta();
		adicionarValorServicoResposta();
		adicionarTabela();
		adicionarJLabel("ID Serviço", 20, 5, 60);
		adicionarJLabel("Valor", 250, 5, 30);
		BMae enviar = new BMae("Adicionar", 380, 5, 100, 30);
		OuvinteBotaoEnviarDoAssociarServico ouvinte = new OuvinteBotaoEnviarDoAssociarServico(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);	
	}
	
	// Metodos get e set
	public Colaborador getColab() {
		return this.colab;
	}
	public Salao getSla() {
		return this.sla;
	}
	public JTextField getIdServicoResposta(){
		return this.idServicoResposta;
	}
	public JTextField getValorServicoResposta(){
		return this.valorServicoResposta;
	}
	public JTable getTabela() {
		return tabela;
	}

	public AssociaColabServ[] getOrdem() {
		return ordem;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		modelo.addColumn("Serviço");
		modelo.addColumn("Descrição");
		modelo.addColumn("Valor");

		if(sla.getCadastros().getTodosOsAssociaColabServ() != null){
			ordem = new AssociaColabServ[sla.getCadastros().getTodosOsAssociaColabServ().size()];
			int i = 0;
			for(AssociaColabServ associa: sla.getCadastros().getTodosOsAssociaColabServ()){
				if(colab.equals(associa.getColabA())){
					ordem[i++]=associa;
				}			
			}

			for(AssociaColabServ associa: ordem){
				Object[] linha = new Object[]{associa.getServicosA().getNome(),
												associa.getServicosA().getDescricao(),
												associa.getValor()
											};
				modelo.addRow(linha);
			}
			JScrollPane conteiner = new JScrollPane(tabela);
			this.add(conteiner);
			conteiner.setBounds(10, 40, 480, 200);
			adicionarBotaoExcluir();
		}
		
	}

	private void adicionarIdServicoResposta() {
		idServicoResposta = new JTextField();
		this.add(idServicoResposta);
		idServicoResposta.setBounds(90, 5, 150, 30);
	}
	private void adicionarValorServicoResposta() {
		valorServicoResposta = new JTextField();
		this.add(valorServicoResposta);
		valorServicoResposta.setBounds(290, 5, 60, 30);
	}
	
	private void adicionarBotaoExcluir(){
		BMae excluir = new BMae("Excluir", 220, 260, 100, 30);
		OuvinteBotaoExcluirDoListarServicoDoColab ouvinte = new OuvinteBotaoExcluirDoListarServicoDoColab(this);
		excluir.addActionListener(ouvinte);
		add(excluir);
	}
}
