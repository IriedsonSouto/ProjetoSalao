package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Janelas.*;
import JanelasAgendamento.JanelaCentralAgendamento;

public class OuvinteBotaoCentralAgenda implements ActionListener{

	private JanelaAdm janela;

	public OuvinteBotaoCentralAgenda(JanelaAdm janela) {
		this.janela = janela;
	}

	public void actionPerformed(ActionEvent click) {
		JanelaCentralAgendamento janelaCDA = new JanelaCentralAgendamento(janela.getSla());
		this.janela.dispose();
	}
}
