package JanelasServico;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesServicos.OuvinteBotaoEnviarDoPesquisarEditarServico;
import Programa.Colaborador;
import Programa.Salao;

public class JanelaPesquisaEditarServico extends JanelaSimplesMae{
	
	//Atributos
	private JTextField idServicoResposta;
	private Salao sla;
	
	//Construtor
	public JanelaPesquisaEditarServico(String titulo, Salao sla) {
		super(titulo);
		this.setSize(500, 70);
		this.sla = sla;
		adicionarIdServicoResposta();
		adicionarJLabel("ID Serviço", 10, 5, 70);
		BMae enviar = new BMae("Enviar", 350, 5, 100, 30);
		OuvinteBotaoEnviarDoPesquisarEditarServico ouvinte = new OuvinteBotaoEnviarDoPesquisarEditarServico(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);		
	}
	
	//Metodos get e set
	public Salao getSla(){
		return sla;
	}
	public JTextField getIdServicoResposta(){
		return idServicoResposta;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarIdServicoResposta() {
		idServicoResposta = new JTextField();
		this.add(idServicoResposta);
		idServicoResposta.setBounds(70, 5, 250, 30);
	}
}