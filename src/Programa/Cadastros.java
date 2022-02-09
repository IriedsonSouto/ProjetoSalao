package Programa;
import java.util.ArrayList;
import java.util.HashSet;

/**Classe responsavel por cadastrar e armazenar os elementos inclusos no programa.
* @author Iriedson Souto Maior de Moraes Vilar
* @version 1
* @since 22/08/2021
*/

public class Cadastros {

	/**Atributos referentes as listas dos elementos salvos
	*/
	private Administrado administrado = null;
	private HashSet<Cliente>  clientes = new HashSet<Cliente>();
	private HashSet<Colaborador> colaboradores = new HashSet<Colaborador>();
	private HashSet<Servico> servicos = new HashSet<Servico>();
	private ArrayList<AssociaColabServ> todosOsAssociaColabServ;

	/**Método para retornar lista de clientes
	* @return Lista de objetos do tipo Cliente.
	*/
	public HashSet<Cliente> getClientes() {
		return clientes;
	}
	/**Método para retornar lista de colaboradores
	* @return Lista de objetos do tipo Colaborador.
	*/
	public HashSet<Colaborador> getColaboradores() {
		return colaboradores;
	}
	/**Método para retornar lista de servicos
	* @return Lista de objetos do tipo Servico.
	*/
	public HashSet<Servico> getServicos() {
		return servicos;
	}
	/**Método para retornar objeto administrador
	* @return Objeto Administrado.
	*/
	public Administrado getAdministrado() {
		return administrado;
	}
	/**Método para retornar lista de todas associaçoes
	* @return Lista de objetos do tipo AssociaColabServ.
	*/
	public ArrayList<AssociaColabServ> getTodosOsAssociaColabServ() {
		return todosOsAssociaColabServ;
	}
	
	
	/**
	* Tenta adicionar o administrador
	* @param Objeto do tipo Administrador 
	*/
	public void cadastrarAdministrado(Administrado administrado){
		 this.administrado =  administrado;
	}
	
	/**
	* Tenta adicionar um cliente e retorna se esse cliente foi adicionado com sucesso
	* @param Objeto do tipo Cliente
	* @return valor boolean
	*/
	public boolean cadastrarCliente(Cliente cliente){
		if(clientes.contains(cliente)){
			return false;
	    }
		clientes.add(cliente);
		return true;
	}
	
	/**
	* Tenta adicionar um colaborador e retorna se esse colaborador foi adicionado com sucesso
	* @param Objeto do tipo Colaborador
	* @return valor boolean
	*/
	public boolean cadastrarColaborador(Colaborador colaborador){
		if(recuperarColaborador(colaborador.getEmail()) != null){
			return false;
	    }
		colaboradores.add(colaborador);
		return true;
	}
	
	/**
	* Tenta adicionar um servico e retorna se esse servico foi adicionado com sucesso
	* @param Objeto do tipo Servico
	* @return valor boolean
	*/
	public boolean cadastrarServico(Servico servico){
		if(servicos.contains(servico)){
			return false;
	    }
		servicos.add(servico);
		return true;
	}
	
	/**
	* Tenta adicionar uma associacao entre colaborador e servico e retorna se foi adicionado com sucesso
	* @param Objeto do tipo AssociaColabServ
	* @return valor boolean
	*/
	public boolean cadastrarColabServ(AssociaColabServ associacao){
		if (getTodosOsAssociaColabServ() == null){
			todosOsAssociaColabServ = new ArrayList<AssociaColabServ>();
		}
		if(recuperarAssociaColabServ(associacao.getId()) != null){
			return false;
		}
		todosOsAssociaColabServ.add(associacao);
		return true;
	}
	
	/**
	* Recupera um servico adicionado
	* @param String com o id do servico
	* @return Objeto do tipo Servico
	*/
	public Servico recuperarServico(String ID){
		for(Servico servico: servicos){
			if(ID.equals(servico.getId())){
				return servico;
			}
		}
		return null;
	}
	
	/**
	* Recupera um colaborador adicionado
	* @param String com o email do colaborador
	* @return Objeto do tipo Colaborador
	*/
	public Colaborador recuperarColaborador(String email){
		for(Colaborador colaborador: colaboradores){
			if(email.equals(colaborador.getEmail())){
				return colaborador;
			}
		}
		return null;
	}
	
	/**
	* Recupera um cliente adicionado
	* @param String com o email do cliente
	* @return Objeto do tipo Cliente
	*/
	public Cliente recuperarCliente(String email){
		for(Cliente cliente: clientes){
			if(email.equals(cliente.getEmail())){
				return cliente;
			}
		}
		return null;
	}
	
	/**
	* Recupera uma associacao de colaborador e servico
	* @param String com o id da associacao
	* @return Objeto do tipo AssociaColabServ
	*/
	public AssociaColabServ recuperarAssociaColabServ(String ID){
		for(AssociaColabServ colabServ: todosOsAssociaColabServ){
			if(ID.equals(colabServ.getId())){
				return colabServ;
			}
		}
		return null;
	}
}
