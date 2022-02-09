package Programa;

public class Colaborador extends Pessoa{
	
	//Atributos
	private StatusColaborador associado;
	private float caixa = 0; 
	
	
	// construtores Colaborador
	public Colaborador(String nome, String telefone, String email, Sexo sexo) throws EmailInvalidoException {
		super();
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
		setSexo(sexo);
		setAssociado(StatusColaborador.ASSOCIADO);
	}
		
	
	// Metodos get e set
	public StatusColaborador getAssociado() {
		return associado;
	}
	public void setAssociado(StatusColaborador associado) {
		this.associado = associado;
	}
	public float getCaixa() {
		return caixa;
	}
	public void setCaixa(float caixa) {
		this.caixa = caixa;
	}
	
	
	// Sobreescrita metodo toString
	public String toString() {
		return "Colaborador: "+getNome()
			+"\nE-mail: "+getEmail()
			+ "\nTelefone: "+getTelefone()
			+ "\nSexo: "+getSexo()
			+ "\nStatus: "+getAssociado();
	}
	
	// Sobreescrita metodo equals
	public boolean equals(Colaborador colab) {
		if (getEmail().equals(colab.getEmail())){
			return true;
		}
		return false;
	}
}