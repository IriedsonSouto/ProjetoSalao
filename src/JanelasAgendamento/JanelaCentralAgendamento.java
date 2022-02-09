package JanelasAgendamento;

import java.awt.Color;

import javax.swing.JButton;

import Janelas.BMae;
import Janelas.JanelaMae;
import Ouvintes.*;
import OuvintesAgendamento.OuvinteConsultarAgendamento;
import OuvintesAgendamento.OuvinteConsultarHistoricoCliente;
import OuvintesAgendamento.OuvinteNovoAgendamento;
import Programa.Salao;

public class JanelaCentralAgendamento extends JanelaMae {

	//Atributos
	private Salao sla;
	
	
	//Construtor
	public JanelaCentralAgendamento(Salao sla) {
		super("Central da Agenda");
		this.sla = sla;
		adicionarBNovoAgendamento();
		adicionarBConsultaAgendamento();
		adicionarBConsultarHCliente();
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla(){
		return this.sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBNovoAgendamento() {
		BMae novoAgendamento = new BMae("Novo agendamento",65, 220, 250, 30);
		OuvinteNovoAgendamento ouvinte = new OuvinteNovoAgendamento(this);
		novoAgendamento.addActionListener(ouvinte);
		this.add(novoAgendamento);
	}
	private void adicionarBConsultaAgendamento() {
		BMae consultaAgendamento = new BMae("Consulta de agendamento",65, 270, 250, 30);
		OuvinteConsultarAgendamento ouvinte = new OuvinteConsultarAgendamento(this);
		consultaAgendamento.addActionListener(ouvinte);
		this.add(consultaAgendamento);
	}
	private void adicionarBConsultarHCliente() {
		BMae consultarHCliente = new BMae("Consultar historico do cliente",65, 320, 250, 30);
		OuvinteConsultarHistoricoCliente ouvinte = new  OuvinteConsultarHistoricoCliente(this);
		consultarHCliente.addActionListener(ouvinte);
		this.add(consultarHCliente);
	}
}