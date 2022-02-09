package Janelas;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Ouvintes.*;
import OuvintesMensageiro.OuvinteBotaoCentralMensageiro;
import Persistencia.Persistencia;
import Programa.Salao;

public class JanelaAdm extends JanelaMae {
	
	//Atributos
	private Salao sla;
	
	//Construtor
	public JanelaAdm() {
		super("Central do Administrador");
		adicionarBCentralServico();
		adicionarBCentralColaborador();
		adicionarBCentralAgenda();
		adicionarBCentralCaixa();
		adicionarBCentralRelatorio();
		adicionarBCentralMensageiro();
		setVisible(true);
		Persistencia percistencia = new Persistencia();
		try{
			sla = (Salao) (percistencia.recuperarSalao("data-Salao.xml"));
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(this, "Deu ruim meu parceiro");
		}
	}
	
	//Metodos get e set
	public Salao getSla(){
		return this.sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBCentralServico() {
		BMae centralServico = new BMae("Central de Serviço",65, 220, 250, 30);
		OuvinteBotaoCentralDeServico ouvinte = new OuvinteBotaoCentralDeServico(this);
		centralServico.addActionListener(ouvinte);
		this.add(centralServico);
	}
	private void adicionarBCentralColaborador() {
		BMae centralColaborador = new BMae("Central de Colaborador",65, 270, 250, 30);
		OuvinteBotaoCentralColaborador ouvinte = new OuvinteBotaoCentralColaborador(this);
		centralColaborador.addActionListener(ouvinte);
		this.add(centralColaborador);
	}
	private void adicionarBCentralAgenda() {
		BMae centralAgenda = new BMae("Central da Agenda",65, 320, 250, 30);
		OuvinteBotaoCentralAgenda ouvinte = new OuvinteBotaoCentralAgenda(this);
		centralAgenda.addActionListener(ouvinte);
		this.add(centralAgenda);
	}
	private void adicionarBCentralCaixa() {
		BMae centralCaixa = new BMae("Caixa",65, 370, 250, 30);
		OuvinteBotaoCentralCaixa ouvinte = new OuvinteBotaoCentralCaixa(this);
		centralCaixa.addActionListener(ouvinte);
		this.add(centralCaixa);
	}
	private void adicionarBCentralRelatorio() {
		BMae centralRelatorio = new BMae("Relatorios",65, 420, 250, 30);
		OuvinteBotaoCentralRelatorio ouvinte = new OuvinteBotaoCentralRelatorio(this);
		centralRelatorio.addActionListener(ouvinte);
		this.add(centralRelatorio);
	}
	private void adicionarBCentralMensageiro() {
		BMae centralMensageiro = new BMae("Mensageiro",65, 470, 250, 30);
		OuvinteBotaoCentralMensageiro ouvinte = new OuvinteBotaoCentralMensageiro(this);
		centralMensageiro.addActionListener(ouvinte);
		this.add(centralMensageiro);
	}
	
	//Sobrescrita Voltar
	public void adicionarBVoltar() {
	
	}	
}
