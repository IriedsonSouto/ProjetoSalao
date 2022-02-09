package JanelasRelatorio;
import Janelas.BMae;
import Janelas.JanelaMae;
import OuvinteRelatorios.OuvinteRelatorioColaboradores;
import OuvinteRelatorios.OuvinteRelatorioServico;
import Ouvintes.*;
import Programa.Salao;


public class JanelaCentralRelatorios extends JanelaMae {


	private Salao sla;
	
	//Construtor
	public JanelaCentralRelatorios(Salao sla) {
		super("Central de Relatorios");
		this.sla = sla;
		adicionarBGerarRelatorioServico();
		adicionarBGerarRelatorioColaborador();
		adicionarBGerarRelatorioCaixaS();
		adicionarBGerarRelatorioCaixaC();
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla() {
		return sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBGerarRelatorioServico() {
		BMae gerarRelatorioServico = new BMae("Gerar relatorio serviço",65, 220, 250, 30);
		OuvinteRelatorioServico ouvinte = new OuvinteRelatorioServico(this);
		gerarRelatorioServico.addActionListener(ouvinte);
		this.add(gerarRelatorioServico);
	}
	private void adicionarBGerarRelatorioColaborador() {
		BMae gerarRelatorioColaborador = new BMae("Gerar relatorio colaboradores",65, 270, 250, 30);
		OuvinteRelatorioColaboradores ouvinte = new OuvinteRelatorioColaboradores(this);
		gerarRelatorioColaborador.addActionListener(ouvinte);
		this.add(gerarRelatorioColaborador);
	}
	private void adicionarBGerarRelatorioCaixaS() {
		BMae gerarRelatorioCaixaS = new BMae("Gerar relatorio do caixa do salão",65, 320, 250, 30);
		this.add(gerarRelatorioCaixaS);
	}
	private void adicionarBGerarRelatorioCaixaC() {
		BMae gerarRelatorioCaixaC = new BMae("Gerar relatorio do caixa do colaborador",65, 370, 250, 30);
		this.add(gerarRelatorioCaixaC);
	}
}