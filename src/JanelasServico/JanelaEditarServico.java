package JanelasServico;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesServicos.OuvinteBotaoEnviarDoCadastroDoServico;
import OuvintesServicos.OuvinteBotaoExcluirdoEditarServico;
import OuvintesServicos.OuvinteEnviarDoEditarServico;
import Programa.Salao;
import Programa.Servico;

public class JanelaEditarServico extends JanelaSimplesMae {

	//Atributos
	private JTextField nomeDoServicoResposta;
	private JTextField descricaoDoServicoResposta;
	private JTextField duracaoMediaS;
	private Salao sla;
	private Servico servico;
	
	//Construtor
	public JanelaEditarServico (String titulo, Salao sla, Servico servico) {
		super(titulo);
		this.sla = sla;
		this.servico = servico;
		adicionarCaixaNomeServico();
		adicionarCaixaDescicaoServico();
		adicionarCaixaDuracaoMedia();
		adicionarJLabel("Nome", 50, 60, 90);
		adicionarJLabel("Descrição", 50, 100, 90);
		adicionarJLabel("Duração media", 120, 140, 90);
		adicionarBotaoEditar();
		adicionarBotaoExcluir();
		setVisible(true);
	}
	
	//Metodos get e set
	public JTextField getNomeDoServicoResposta() {
		return nomeDoServicoResposta;
	}
	public JTextField getDescricaoDoServicoResposta() {
		return descricaoDoServicoResposta;
	}
	public JTextField getDuracaoMediaS(){
		return duracaoMediaS;
	}
	public Salao getSla(){
		return sla;
	}	
	public Servico getServico(){
		return servico;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarCaixaNomeServico() {
		nomeDoServicoResposta = new JTextField(servico.getNome());
		this.add(nomeDoServicoResposta);
		nomeDoServicoResposta.setBounds(120, 60, 300, 30);
	}	
	private void adicionarCaixaDescicaoServico() {
		descricaoDoServicoResposta = new JTextField(servico.getDescricao());
		this.add(descricaoDoServicoResposta);
		descricaoDoServicoResposta.setBounds(120, 100, 300, 30);
	}	
	private void adicionarCaixaDuracaoMedia() {
			duracaoMediaS = new JTextField(Integer.toString(servico.getDuracaoMedia()));
			OuvinteInternoJTextDuracaoMedia ouvinte = new OuvinteInternoJTextDuracaoMedia();
			duracaoMediaS.addKeyListener(ouvinte);
			this.add(duracaoMediaS);
			duracaoMediaS.setBounds(220, 140, 120, 30);
	}
	private void adicionarBotaoEditar() {
		BMae editar = new BMae("Editar", 120, 200, 100, 30);
		OuvinteEnviarDoEditarServico ouvinte = new OuvinteEnviarDoEditarServico(this, servico);
		editar.addActionListener(ouvinte);
		add(editar);
	}
	private void adicionarBotaoExcluir() {
		BMae excluir = new BMae("Excluir", 300, 200, 100, 30);
		OuvinteBotaoExcluirdoEditarServico ouvinte = new OuvinteBotaoExcluirdoEditarServico(this, servico);
		excluir.addActionListener(ouvinte);
		add(excluir);
	}
	
	//Ouvinte interno
	private class OuvinteInternoJTextDuracaoMedia implements KeyListener{

		public void keyPressed(KeyEvent digitar) {	
		}
		public void keyReleased(KeyEvent digitar) {	
		}
		public void keyTyped(KeyEvent digitar) {
			char c = digitar.getKeyChar();
			if(!Character.isDigit(c)  || duracaoMediaS.getText().length() > 2 ){
				digitar.consume();
			}
		}
	}
}