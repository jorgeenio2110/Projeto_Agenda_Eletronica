package exception;
/*Projeto dos Estudantes do curso de licenciatura em Ciências da computação 
da UPE - Universidade de Pernambuco 
Disciplina: Programação II
sob a tutoria do Professor Dr. Austusto César F de M Oliveira

Licendiandos (por ordem alfabética):	
	Ednaldo Farias Gomes
	Jorge Enio Beserra Barbosa
	Renan Nunes Soares*/
@SuppressWarnings("serial")
public class ContatoExistenteException extends Exception {
	public ContatoExistenteException(String mensagem) {
		super(mensagem);
	}

}
