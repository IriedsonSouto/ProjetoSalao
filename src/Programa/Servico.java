package Programa;

public class Servico implements Comparable<Servico> {

	//Atributos
	private String id; 
	private String nome; 
	private String descricao; 
	private int duracaoMedia;
	
	// Metodos get e set
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getDuracaoMedia() {
		return this.duracaoMedia;
	}
	public void setDuracaoMedia(int duracaoMedia) {
		this.duracaoMedia = duracaoMedia;
	}
	
	// construtores Serviços
	public Servico(String nome, String descricao, int duracaoMedia) {
		this.id = "S"+String.valueOf(System.currentTimeMillis());
		this.nome = nome;
		this.descricao = descricao;
		this.duracaoMedia = duracaoMedia;
	}
	
	// Sobreescrita metodo toString
	public String toString() {
		return "Serviço: "+getNome()+""
				+ "\nDescrição: "+getDescricao()
				+ "\nDuração: "+getDuracaoMedia()+""
				+ "\nIndetificação: "+getId();
	}
	
	// Sobreescrita metodo equals
	public boolean equals (String ID){
		if (this.id.equals(ID)){
			return true;
		}
		return false;
	}
	
	// Sobreescrita metodo compareTo
    public int compareTo(Servico servico) {
        return this.getNome().compareTo(servico.getNome());
    }
	
}