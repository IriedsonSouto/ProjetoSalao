package Programa;

public class AssociaColabServ {

	private String id; 
	private Servico servicosA;
	private Colaborador colabA;
	private float valor;
	
	// construtor
	public AssociaColabServ(Colaborador colab, Servico servico, float valor){
		this.id = "ACS"+String.valueOf(System.currentTimeMillis());
		this.colabA = colab;
		this.servicosA = servico;
		this.valor = valor;
	}
	
	
	// Metodos get e set
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Servico getServicosA() {
		return this.servicosA;
	}
	public void setServicosA(Servico servicosA) {
		this.servicosA = servicosA;
	}
		
	public Colaborador getColabA() {
		return this.colabA;
	}
	public void setColabA(Colaborador colabA) {
		this.colabA = colabA;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	// Sobreescrita metodo toString
	public String toString() {
		return getColabA().getNome()+", "+getValor()+" R$ " + "\nID: "+ getId();
	}
	
	// Sobreescrita metodo equals
	public boolean equals (AssociaColabServ associacao){
		if ((this.getColabA().equals(associacao.getColabA())) 
				&& (this.getServicosA().equals(associacao.getServicosA()))){
			return true;
		}
		return false;
	}
}