package Programa;

public class Administrado extends Pessoa {
	
	//Atributos
	private String senha;
	private String cSenha;

	
	// Metodos get e set
	public String getcSenha() {
		return cSenha;
	}
	public void setcSenha(String cSenha) {
		this.cSenha = cSenha;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha, String cSenha) throws EmailInvalidoException {
		String senhaAutentic = Autenticacao.validarSenha(senha, cSenha);
		this.senha = senhaAutentic;
		this.cSenha = senhaAutentic;
	}
	
	// construtores Administrado	
	public Administrado(String nome, String email, String senha, String cSenha) throws EmailInvalidoException {
		super();
		setNome(nome);
		setEmail(email);
		this.senha = senha;
		this.cSenha = cSenha;
		setSenha(this.senha, this.cSenha);
		
		
	}

}
