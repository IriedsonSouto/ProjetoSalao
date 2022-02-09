

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


import javax.swing.UIManager.LookAndFeelInfo;

import Janelas.JanelaCadastroADM;
import Janelas.JanelaLogin;

import Persistencia.Persistencia;
import Programa.Salao;


public class Main {

	public static void main(String[] args) {
		Persistencia percistencia = new Persistencia();
		Salao sla = null;
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		
		
		
		try{
			sla = (Salao) (percistencia.recuperarSalao("data-Salao.xml"));
			
		}catch(Exception erro) {
			sla = new Salao();
		}
		new JanelaLogin(sla);
		if (sla.getCadastros().getAdministrado() == null){
			new JanelaCadastroADM("Cadastro", sla);
		}
	}

}
