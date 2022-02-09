package Programa;

public class Pessoa implements Comparable<Pessoa>{

	//Atributos
	private String nome;
	private String telefone;
	private String email;
	private Sexo sexo;
	
	// Metodos get e set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws EmailInvalidoException {
		Autenticacao.validarEmail(email);
		this.email = email;	
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	// construtores Pessoa
	public Pessoa(){
		
	}
	
	// Sobreescrita metodo equals
	public boolean equals(Pessoa pessoa) {
		if (getEmail().equals(pessoa.getEmail())){
			return true;
		}
		return false;
	}
	
	// Sobreescrita metodo compareTo
    public int compareTo(Pessoa pessoa) {
        return this.getNome().compareTo(pessoa.getNome());
    }
	
	
}
