package Programa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendameto implements Comparable<Agendameto> {

	private String id; 
	private AssociaColabServ associaColabServ;
	private Cliente cliente;
	private String horaEMinuto;
	private String data;
	private Date lDate;
	private StatusAgenda status;
	
	
	// construtor
	public Agendameto(AssociaColabServ associaColabServ, Cliente cliente, String horaEMinuto, String data){
		this.id = "A"+String.valueOf(System.currentTimeMillis());
		this.associaColabServ = associaColabServ;
		this.cliente = cliente;
		this.status = StatusAgenda.PENDENTE;
		this.setData(data);
		this.horaEMinuto = horaEMinuto;
		try {
			setLDate(data, horaEMinuto);
		} catch (Exception e) {

		}
	}
	
	
	// Metodos get e set
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AssociaColabServ getAssociaColabServ() {
		return associaColabServ;
	}
	public void setAssociaColabServ(AssociaColabServ associaColabServ) {
		this.associaColabServ = associaColabServ;
	}
	
	public Date getLDate() {
		return lDate;
	}
	public void setLDate(String data, String horaEMinuto) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		sdf.setLenient(false);  
 		try{
 			Date data2 = sdf.parse(data+" "+horaEMinuto);    
 			this.lDate = data2;
 		}catch (Exception erro){
			throw new Exception("A data está errada.");
		}
 	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public StatusAgenda getStatus() {
		return status;
	}
	public void setStatus(StatusAgenda status) {
		this.status = status;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return horaEMinuto;
	}
	public void setHora(String horaEMinuto) {
		this.horaEMinuto = horaEMinuto;
	}
	
	// Sobreescrita metodo toString
	public String toString() {
		return "Cliente: "+getCliente().getNome()+""
			+ "\nColaborador: "+getAssociaColabServ().getColabA().getNome()
			+"\nServiço: "+getAssociaColabServ().getServicosA().getNome()
			+ "\nValor: "+getAssociaColabServ().getValor()
			+ "\nID: "+ getId()
			+ "\nData/Horario: "+ getData()+"  "+getHora();
	}
	
	// Sobreescrita metodo equals
	public boolean equals(Agendameto agenda) {
		if (getAssociaColabServ().getColabA().equals(agenda.getAssociaColabServ().getColabA())){
			if(getLDate().getTime() <= agenda.getLDate().getTime() && agenda.getLDate().getTime() 
					<= getLDate().getTime() + (getAssociaColabServ().getServicosA().getDuracaoMedia()*60000)){
				if(getStatus().equals(agenda.getStatus())){
					return true;
				}
			}
		}
		return false;
	}

	// Sobreescrita metodo compareTo
	public int compareTo(Agendameto agendamento) {
		if(getLDate().getTime() < agendamento.getLDate().getTime()){
			return -1;
		}else if(getLDate().getTime() > agendamento.getLDate().getTime()){
			return 1;
		}
		return 0;
	}
}
