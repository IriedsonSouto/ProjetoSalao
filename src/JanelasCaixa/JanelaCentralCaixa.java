package JanelasCaixa;
import Janelas.BMae;
import Janelas.JanelaMae;
import OuvinteCaixa.OuvinteCaixaSalao;
import Ouvintes.*;
import Programa.Salao;


public class JanelaCentralCaixa extends JanelaMae {
	
	//Atributos
	private Salao sla;
	

	//Construtor
	public JanelaCentralCaixa(Salao sla) {
		super("Central do Caixa");
		this.sla = sla;
		adicionarBHistoricoCaixa();
		adicionarBCaixaColaboradores();
		setVisible(true);
	}
	
	//Metodos get e set
	public Salao getSla() {
		return sla;
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBHistoricoCaixa() {
		BMae historicoCaixa = new BMae("Historico do caixa",65, 220, 250, 30);
		OuvinteCaixaSalao ouvinte = new OuvinteCaixaSalao(this);
		historicoCaixa.addActionListener(ouvinte);
		this.add(historicoCaixa);
	}
	private void adicionarBCaixaColaboradores() {
		BMae caixaColaboradores = new BMae("Caixa dos Colaboradores",65, 270, 250, 30);
		this.add(caixaColaboradores);
	}
}