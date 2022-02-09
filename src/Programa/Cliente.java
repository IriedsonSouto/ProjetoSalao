package Programa;

public class Cliente extends Pessoa {

	//private ArrayList lista;
	
	public Cliente(String nome, String telefone, String email, Sexo sexo) throws EmailInvalidoException {
		super();
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
		setSexo(sexo);
	}
	
	// Sobreescrita metodo toString
	public String toString() {
		return "Colaborador: "+getNome()+""
			+ "\nE-mail: "+getEmail()
			+ "\nTelefone: "+getTelefone()+""
			+ "\nSexo: "+getSexo();
	}
	
	// Sobreescrita metodo equals
	public boolean equals(Cliente cliente) {
		if (getEmail().equals(cliente.getEmail())){
			return true;
		}
		return false;
	}
}
