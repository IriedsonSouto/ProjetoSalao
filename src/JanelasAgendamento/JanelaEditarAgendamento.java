package JanelasAgendamento;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import Janelas.Util;
import OuvintesAgendamento.OuvinteBotaoEnvirAgendamento;
import OuvintesAgendamento.OuvinteEnviarEditarAgendamento;
import OuvintesAgendamento.OuvinteJComboServico;
import Programa.Agendameto;
import Programa.AssociaColabServ;
import Programa.Cliente;
import Programa.Salao;
import Programa.Servico;
import Programa.StatusAgenda;

public class JanelaEditarAgendamento extends JanelaSimplesMae {

	//Atributos
	private Agendameto agendamento;
	private AssociaColabServ[] nomeColab;
	private StatusAgenda[] status = {StatusAgenda.PENDENTE, StatusAgenda.CONCLUIDO, StatusAgenda.CANCELADO};;
	private JFormattedTextField respostaData;
	private JFormattedTextField respostaHora;
	private JComboBox<StatusAgenda> comboBoxColabStatus;
	private JComboBox<AssociaColabServ> comboBoxColab;
	private JTextField servico;
	private Salao sla;
	
	//Construtor
	public JanelaEditarAgendamento (String titulo, Salao sla, Agendameto agendamento) {
		super(titulo);
		this.sla = sla;
		this.agendamento = agendamento;
		this.setSize(300,300);
		adicionarCaixaData();
		adicionarCaixaHora();
		adicionarComboBoxColabStatus();
		adicionarComboBoxColab();
		adicionarCaixaServico();
		adicionarJLabel("Serviço", 20, 20, 90);
		adicionarJLabel("Colaborador", 20, 60, 90);
		adicionarJLabel("Data", 20, 100, 50);
		adicionarJLabel("Hora", 180, 100, 50);
		adicionarJLabel("Status", 20, 140, 50);
		BMae enviar = new BMae("Enviar", 100, 200, 100, 30);
		OuvinteEnviarEditarAgendamento ouvinte = new OuvinteEnviarEditarAgendamento(this);
		enviar.addActionListener(ouvinte);
		add(enviar);
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla(){
		return sla;
	}
	public JFormattedTextField getRespostaData() {
		return respostaData;
	}
	public JFormattedTextField getRespostaHora() {
		return respostaHora;
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
	public Agendameto getAgendamento() {
		return agendamento;
	}
	public StatusAgenda[] getStatus() {
		return status;
	}
	public JComboBox<StatusAgenda> getComboBoxColabStatus() {
		return comboBoxColabStatus;
	}
	
	
	//Metodos de adição de elementos de layout
	private void adicionarCaixaData() {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			respostaData = new JFormattedTextField(mascara);
			respostaData.setText(agendamento.getData());
			this.add(respostaData);
			respostaData.setBounds(60, 100, 90, 30);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	private void adicionarCaixaHora() {
		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			respostaHora = new JFormattedTextField(mascara);
			respostaHora.setText(agendamento.getHora());
			this.add(respostaHora);
			respostaHora.setBounds(220, 100, 50, 30);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	private void adicionarCaixaServico() {
		servico = new JTextField(agendamento.getAssociaColabServ().getServicosA().getNome());
		servico.setEditable(false);
		this.add(respostaHora);
		servico.setBounds(110, 20, 160, 30);
		servico.setVisible(true);
	}
	
	private void adicionarComboBoxColabStatus(){
		comboBoxColabStatus = new JComboBox<StatusAgenda>(status);
		add(comboBoxColabStatus);
		comboBoxColabStatus.setBounds(110, 140, 160, 30);
		comboBoxColabStatus.setBackground(Util.COR_PADRAO_BMINI);
		comboBoxColabStatus.setForeground(Util.COR_PADRAO_FONTE2);
		comboBoxColabStatus.setVisible(true);	
	}
	
	public void adicionarComboBoxColab(){
		ArrayList<AssociaColabServ> colabs = new ArrayList<AssociaColabServ>();
		for(AssociaColabServ elementoAssocia: sla.getCadastros().getTodosOsAssociaColabServ()){
			if(elementoAssocia.getServicosA().equals(agendamento.getAssociaColabServ().getServicosA())){
				colabs.add(elementoAssocia);
			}
		}
		nomeColab = new AssociaColabServ[colabs.size()];
		int j = 0;
		for(AssociaColabServ nome: colabs){
			nomeColab[j++]=nome;
		}
		comboBoxColab = new JComboBox<AssociaColabServ>(nomeColab);
		add(comboBoxColab);
		comboBoxColab.setBounds(110, 60, 160, 30);
		comboBoxColab.setBackground(Util.COR_PADRAO_BMINI);
		comboBoxColab.setForeground(Util.COR_PADRAO_FONTE2);
		comboBoxColab.setVisible(true);	
	}
}