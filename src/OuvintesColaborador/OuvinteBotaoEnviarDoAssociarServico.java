package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaAdicionarServicoNoColab;
import JanelasColaborador.JanelaListarColaborador;
import Persistencia.Persistencia;
import Programa.AssociaColabServ;
import Programa.Colaborador;
import Programa.Salao;
import Programa.Servico;

public class OuvinteBotaoEnviarDoAssociarServico implements ActionListener {

	private JanelaAdicionarServicoNoColab janela;
	
	public OuvinteBotaoEnviarDoAssociarServico(JanelaAdicionarServicoNoColab janela){
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent click) {
		Servico servico = janela.getSla().getCadastros().recuperarServico(janela.getIdServicoResposta().getText());
		if( servico != null){
			if(janela.getSla().getCadastros().cadastrarColabServ(new AssociaColabServ(janela.getColab()
					, servico, Float.parseFloat(janela.getValorServicoResposta().getText()))) == true){
				JOptionPane.showMessageDialog(janela, "Associado com sucesso");
				janela.getIdServicoResposta().setText("");
				janela.getValorServicoResposta().setText("");
				Persistencia percistencia = new Persistencia();
				janela.dispose();
				new JanelaAdicionarServicoNoColab("Serviços do colaborador", janela.getColab(), janela.getSla());
				try {
					percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(janela,"Não foi possivel salvar os arquivos.");
				}
			}else{
				JOptionPane.showMessageDialog(janela, "Associação já existente");
			}
		}else{
			JOptionPane.showMessageDialog(janela, "Falha, serviço não existe");
		}
	}
}
	