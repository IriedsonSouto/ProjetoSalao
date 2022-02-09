package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasAgendamento.JanelaCadastrarAgendamento;
import JanelasAgendamento.JanelaCadastrarCliente;
import JanelasColaborador.JanelaAdicionarServicoNoColab;
import JanelasColaborador.JanelaCadastroColab;
import Persistencia.Persistencia;
import Programa.Cliente;
import Programa.Colaborador;
import Programa.EmailInvalidoException;
import Programa.Sexo;

public class OuvinteEnviarCadastroCliente implements ActionListener {

	private JanelaCadastrarCliente janela;
	
	public OuvinteEnviarCadastroCliente(JanelaCadastrarCliente janela){
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent click) {
		Sexo[] sexo = {Sexo.MASCULINO, Sexo.FEMININO};
		try{
			Cliente cliente = new Cliente(janela.getNomeDoClienteResposta().getText()
					, janela.getRespostaTelefone().getText(), janela.getEmailClienteResposta().getText()
					, sexo[janela.getComboBox().getSelectedIndex()]);
			janela.getSla().getCadastros().getClientes().add(cliente);

			Persistencia percistencia = new Persistencia();
			percistencia.salvarSalao(janela.getSla(), "data-Salao.xml");
			janela.dispose();
			
			JanelaCadastrarAgendamento janelaCA = new JanelaCadastrarAgendamento("Cadastrar Agendamento"
					,janela.getSla(), cliente);

		}catch(EmailInvalidoException erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Não foi possivel salvar os arquivos.");
		}
	}
}
