package JanelasAgendamento;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Janelas.BMae;
import Janelas.JanelaSimplesMae;
import OuvintesAgendamento.OuvinteEditarAgendamento;
import OuvintesAgendamento.OuvintePesquisarConsultarAgendamento;
import OuvintesAgendamento.OuvintePesquisarConsultarClienteAgendamento;
import Programa.Agendameto;
import Programa.Salao;

public class JanelaConsultarHistoricoCliente extends JanelaSimplesMae{
	


	//Atributos
	private Salao sla;
	private JTextField respostaEmail;
	private JTable tabela;
	private JScrollPane conteiner;
	private Agendameto[] ordem;

	//Construtor
	public JanelaConsultarHistoricoCliente(String titulo, Salao sla) {
		super(titulo);
		this.sla = sla;
		adicionarCaixaEmail();
		adicionarJLabel("Email", 20, 10, 50);
		BMae pesquisar = new BMae("Pesquisar", 300, 10, 100, 30);
		OuvintePesquisarConsultarClienteAgendamento ouvinte = new OuvintePesquisarConsultarClienteAgendamento(this);
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
	public JTextField getRespostaData() {
		return respostaEmail;
	}
	public JScrollPane getConteiner() {
		return conteiner;
	}
	public Agendameto[] getOrdem() {
		return ordem;
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
				if(agendamentos.getCliente().getEmail().equals(respostaEmail.getText())){
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
			JOptionPane.showMessageDialog(this, "Não existe agendamento para este cliente");
		}
		
	}

	private void adicionarCaixaEmail() {
			respostaEmail = new JTextField();
			this.add(respostaEmail);
			respostaEmail.setBounds(60, 10, 200, 30);
	}
}