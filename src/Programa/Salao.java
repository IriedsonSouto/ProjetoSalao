package Programa;
import java.util.ArrayList;

public class Salao {

	private Cadastros cadastros = new Cadastros();
	private ArrayList<Agendameto> agendametos = new ArrayList<>();
	private float caixa = 0;

	
	public Cadastros getCadastros() {
		return cadastros;
	}
	public ArrayList<Agendameto> getAgendametos() {
		return agendametos;
	}
	public void setAgendametos(ArrayList<Agendameto> agendametos) {
		this.agendametos = agendametos;
	}
	public float getCaixa() {
		return caixa;
	}
	public void setCaixa(float caixa) {
		this.caixa = caixa;
	}
	
	public boolean agendar(Agendameto agendamento){
		for(Agendameto agendamentos2: agendametos){
			if(agendamento.equals(agendamentos2)){
				return false;
			}
		}
		agendametos.add(agendamento);
		return true;
	}
	
	public Agendameto recuperarAgendamento(String ID){
		for(Agendameto agendamento: agendametos){
			if(ID.equals(agendamento.getId())){
				return agendamento;
			}
		}
		return null;
	}
	
}
