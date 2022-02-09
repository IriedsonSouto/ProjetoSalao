package OuvintesColaborador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import JanelasColaborador.JanelaAdicionarServicoNoColab;
import JanelasColaborador.JanelaEditarColaborador;



public class OuvinteBotaoEditarAssociacao implements ActionListener {

	private JanelaEditarColaborador janela;
	
	public OuvinteBotaoEditarAssociacao(JanelaEditarColaborador janela){
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent click) {
		JanelaAdicionarServicoNoColab janelaASC = new JanelaAdicionarServicoNoColab("Serviços do Colaborador"
				,janela.getColab(),janela.getSla());
	}
}