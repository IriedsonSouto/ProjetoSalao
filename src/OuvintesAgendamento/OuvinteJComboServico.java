package OuvintesAgendamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Janelas.Util;
import JanelasAgendamento.JanelaCadastrarAgendamento;
import Programa.AssociaColabServ;

public class OuvinteJComboServico implements ActionListener{
	
	private JanelaCadastrarAgendamento janela;

	public OuvinteJComboServico(JanelaCadastrarAgendamento janela){
		this.janela = janela;
}
	
	public void actionPerformed(ActionEvent click) {
		int i = janela.getComboBoxServ().getSelectedIndex();
		ArrayList<AssociaColabServ> colabs = new ArrayList<AssociaColabServ>();
		for(AssociaColabServ elementoAssocia: janela.getSla().getCadastros().getTodosOsAssociaColabServ()){
			if(elementoAssocia.getServicosA().equals(janela.getServ()[i])){
				colabs.add(elementoAssocia);
			}
		}
		AssociaColabServ[] nomeColabs = new AssociaColabServ[colabs.size()];
		int j = 0;
		for(AssociaColabServ nome: colabs){
			nomeColabs[j++]=nome;
		}
		janela.setNomeColab(nomeColabs);
		janela.adicionarComboBoxColab();
	}	
}