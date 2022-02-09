package OuvintesServicos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasServico.JanelaCadastroServicos;
import Persistencia.Persistencia;
import Programa.Servico;

public class OuvinteBotaoEnviarDoCadastroDoServico implements ActionListener {

	private JanelaCadastroServicos janela;

	
	public OuvinteBotaoEnviarDoCadastroDoServico(JanelaCadastroServicos janela){
		this.janela = janela;

	}

	public void actionPerformed(ActionEvent click) {
		try{
			if (janela.getSla().getCadastros().cadastrarServico(new Servico(janela.getNomeDoServicoResposta().getText()
					, janela.getDescricaoDoServicoResposta().getText(), Integer.parseInt(janela.getDuracaoMediaS().getText())))){
				Persistencia percistencia = new Persistencia();
				percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
				janela.dispose();
			}else{
				JOptionPane.showMessageDialog(this.janela, "Serviço já existente");
			}
		}catch(Exception erro) {
			System.out.println("Não foi possivel salvar os arquivos.");
		}
	}

}