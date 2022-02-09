package JanelasAgendamento;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import OuvintesAgendamento.OuvinteEditarAgendamento;
import OuvintesAgendamento.OuvintePesquisarConsultarAgendamento;
import Programa.*;

public class JanelaConsultarAgendamento extends JanelaSimplesMae{
	
	//Atributos
	private Salao sla;
	private JFormattedTextField respostaData;
	private JTable tabela;
	private Agendameto[] ordem;
	private JScrollPane conteiner;

	//Construtor
	public JanelaConsultarAgendamento(String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarCaixaData();
		adicionarBotaoEdiatr();
		adicionarJLabel("Data", 20, 10, 50);
		BMae pesquisar = new BMae("Pesquisar", 260, 10, 100, 30);
		OuvintePesquisarConsultarAgendamento ouvinte = new OuvintePesquisarConsultarAgendamento(this);
		pesquisar.addActionListener(ouvinte);
		add(pesquisar);
		setVisible(true);	
	}
	
	// Metodos get e set
	public Salao getSla() {
		return this.sla;
	}
	public JTable getTabela() {
		return tabela;
	}
	public Agendameto[] getOrdem() {
		return ordem;
	}
	public JFormattedTextField getRespostaData() {
		return respostaData;
	}
	public JScrollPane getConteiner() {
		return conteiner;
	}
	
	//Metodos de adição de elementos de layout
	public void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		modelo.addColumn("Cliente");
		modelo.addColumn("Serviço");
		modelo.addColumn("Colaborador");
		modelo.addColumn("Horario");
		modelo.addColumn("Status");

		if(sla.getAgendametos() != null){
			ArrayList<Agendameto> arrayAgendamento = new ArrayList<Agendameto>();
			for(Agendameto agendamentos: sla.getAgendametos()){
				if(agendamentos.getData().equals(respostaData.getText())){
					arrayAgendamento.add(agendamentos);
				}			
			}
			ordem = new Agendameto[arrayAgendamento.size()];
			int i = 0;
			for(Agendameto agendamentos: arrayAgendamento){
				ordem[i++]=agendamentos;
			}
			Arrays.sort(ordem);
			
			for(Agendameto tAgendameto: ordem){
				Object[] linha = new Object[]{tAgendameto.getCliente().getNome(),
												tAgendameto.getAssociaColabServ().getServicosA().getNome(),
												tAgendameto.getAssociaColabServ().getColabA().getNome(),
												tAgendameto.getHora(),
												tAgendameto.getStatus()
											};
				modelo.addRow(linha);
			}
			conteiner = new JScrollPane(tabela);
			this.add(conteiner);
			conteiner.setBounds(10, 40, 480, 200);
		}else{
			JOptionPane.showMessageDialog(this, "Não existe agendamento para esta data");
		}
		
	}

	private void adicionarCaixaData() {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			respostaData = new JFormattedTextField(mascara);
			this.add(respostaData);
			respostaData.setBounds(60, 10, 90, 30);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	protected void adicionarBotaoEdiatr(){
		BMae editar = new BMae("Editar", 380, 10, 100, 30);
		OuvinteEditarAgendamento ouvinte = new OuvinteEditarAgendamento(this);
		editar.addActionListener(ouvinte);
		add(editar);
	}
}
