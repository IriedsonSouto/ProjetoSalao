package JanelasServico;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesServicos.OuvinteBotaoEnviarDoCadastroDoServico;
import Programa.Salao;

public class JanelaCadastroServicos extends JanelaSimplesMae {

	//Atributos
	private JTextField nomeDoServicoResposta;
	private JTextField descricaoDoServicoResposta;
	private JTextField duracaoMediaS;
	private Salao sla;
	
	//Construtor
	public JanelaCadastroServicos (String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarCaixaNomeServico();
		adicionarCaixaDescicaoServico();
		adicionarCaixaDuracaoMedia();
		adicionarJLabel("Nome", 50, 60, 90);
		adicionarJLabel("Descrição", 50, 100, 90);
		adicionarJLabel("Duração media", 120, 140, 90);
		BMae enviar = new BMae("Enviar", 200, 200, 100, 30);
		OuvinteBotaoEnviarDoCadastroDoServico ouvinte = new OuvinteBotaoEnviarDoCadastroDoServico(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
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

	//Metodos de adição de elementos de layout
	private void adicionarCaixaNomeServico() {
		nomeDoServicoResposta = new JTextField();
		this.add(nomeDoServicoResposta);
		nomeDoServicoResposta.setBounds(120, 60, 300, 30);
	}	
	private void adicionarCaixaDescicaoServico() {
		descricaoDoServicoResposta = new JTextField();
		this.add(descricaoDoServicoResposta);
		descricaoDoServicoResposta.setBounds(120, 100, 300, 30);
	}	
	private void adicionarCaixaDuracaoMedia() {
			duracaoMediaS = new JTextField();
			OuvinteInternoJTextDuracaoMedia ouvinte = new OuvinteInternoJTextDuracaoMedia();
			duracaoMediaS.addKeyListener(ouvinte);
			this.add(duracaoMediaS);
			duracaoMediaS.setBounds(220, 140, 120, 30);
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