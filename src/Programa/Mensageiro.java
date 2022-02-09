package Programa;



public abstract class Mensageiro {

	public static void enviarMensagemAoADM(String contato, String mensagem){
		JavaMail email = new JavaMail();
		email.enviarEmail("sua senha", "seu email", contato, mensagem, "Beauty's SalaoMe");
	}
	
	public static void enviarMensagemIndividual(String email, String mensagem, String assunto){
		JavaMail email2 = new JavaMail();
		email2.enviarEmail("sua senha", "seu email", email, mensagem, "Beauty's SalaoMe: "+assunto);
	}
}
