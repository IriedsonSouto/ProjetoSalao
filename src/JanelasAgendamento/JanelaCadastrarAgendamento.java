package JanelasAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesAgendamento.OuvinteBotaoEnvirAgendamento;
import OuvintesAgendamento.OuvinteJComboServico;
import Programa.*;

public class JanelaCadastrarAgendamento extends JanelaSimplesMae {

	//Atributos
	private Cliente cliente;
	private Servico[] serv;
	private AssociaColabServ[] nomeColab;
	private JFormattedTextField respostaData;
	private JFormattedTextField respostaHora;
	private JComboBox<String> comboBoxServ;
	private JComboBox<AssociaColabServ> comboBoxColab;
	private Salao sla;
	
	//Construtor
	public JanelaCadastrarAgendamento (String titulo, Salao sla, Cliente cliente) {
		super(titulo);
		this.sla = sla;
		this.cliente = cliente;
		this.setSize(300,300);
		adicionarCaixaData();
		adicionarCaixaHora();
		adicionarComboBoxServ();
		adicionarJLabel("Serviço", 20, 60, 90);
		adicionarJLabel("Colaborador", 20, 100, 90);
		adicionarJLabel("Data", 20, 140, 50);
		adicionarJLabel("Hora", 180, 140, 50);
		BMae enviar = new BMae("Enviar", 100, 200, 100, 30);
		OuvinteBotaoEnvirAgendamento ouvinte = new OuvinteBotaoEnvirAgendamento(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);
	}
	
	//Metodos get e set
	public JFormattedTextField getRespostaTelefone(){
		return respostaData;
	}	
	public Salao getSla(){
		return sla;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Servico[] getServ() {
		return serv;
	}
	public JFormattedTextField getRespostaData() {
		return respostaData;
	}
	public JFormattedTextField getRespostaHora() {
		return respostaHora;
	}
	public JComboBox<String> getComboBoxServ() {
		return comboBoxServ;
	}
	public JComboBox<AssociaColabServ> getComboBoxColab() {
		return comboBoxColab;
	}
	public AssociaColabServ[] getNomeColab() {
		return nomeColab;
	}
	public void setNomeColab(AssociaColabServ[] nomeColab) {
		this.nomeColab = nomeColab;
	}
	
	//Metodos de adição de elementos de layout

	private void adicionarCaixaData() {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			respostaData = new JFormattedTextField(mascara);
			this.add(respostaData);
			respostaData.setBounds(60, 140, 90, 30);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	private void adicionarCaixaHora() {
		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			respostaHora = new JFormattedTextField(mascara);
			this.add(respostaHora);
			respostaHora.setBounds(220, 140, 50, 30);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	private void adicionarComboBoxServ() {
		serv = new Servico[sla.getCadastros().getServicos().size()];
		int i = 0;
		for(Servico servico: sla.getCadastros().getServicos()){
			serv[i++]=servico;
		}
		Arrays.sort(serv);
		String[] opcoes = new String[serv.length];
		int k = 0;
		for(Servico nomes: serv){
			opcoes[k++] = nomes.getNome();
		}
		comboBoxServ = new JComboBox<String>(opcoes);
		this.add(comboBoxServ);
		comboBoxServ.setBounds(110, 60, 160, 30);
		comboBoxServ.setBackground(Util.COR_PADRAO_BMINI);
		comboBoxServ.setForeground(Util.COR_PADRAO_FONTE2);
		OuvinteJComboServico ouvinte = new OuvinteJComboServico(this);
		comboBoxServ.addActionListener(ouvinte);
	}
	public void adicionarComboBoxColab(){
		comboBoxColab = new JComboBox<AssociaColabServ>(nomeColab);
		add(comboBoxColab);
		comboBoxColab.setBounds(110, 100, 160, 30);
		comboBoxColab.setBackground(Util.COR_PADRAO_BMINI);
		comboBoxColab.setForeground(Util.COR_PADRAO_FONTE2);
		comboBoxColab.setVisible(true);	
	}
}