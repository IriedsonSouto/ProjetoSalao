package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaAdicionarServicoNoColab;
import JanelasColaborador.JanelaCadastroColab;
import Persistencia.Persistencia;
import Programa.Colaborador;
import Programa.EmailInvalidoException;
import Programa.Salao;
import Programa.Servico;
import Programa.Sexo;

public class OuvinteBotaoEnviarCadastrarColab implements ActionListener {

	private JanelaCadastroColab janela;
	
	public OuvinteBotaoEnviarCadastrarColab(JanelaCadastroColab janela){
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent click) {
		Sexo[] sexo = {Sexo.MASCULINO, Sexo.FEMININO};
		try{
			Colaborador colab = new Colaborador(janela.getNomeDoColaboradorResposta().getText()
					, janela.getRespostaTelefone().getText(), janela.getEmailColabResposta().getText()
					, sexo[janela.getComboBox().getSelectedIndex()]);

			if (janela.getSla().getCadastros().cadastrarColaborador(colab) == true){
				Persistencia percistencia = new Persistencia();
				percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
				janela.dispose();
				JanelaAdicionarServicoNoColab janelaASC = new JanelaAdicionarServicoNoColab("Serviços do Colaborador"
						,colab,janela.getSla());
			}else{
				JOptionPane.showMessageDialog(this.janela, "Colaborador já existente");
			}
		}catch(EmailInvalidoException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Não foi possivel salvar os arquivos.");
		}
	}
}
