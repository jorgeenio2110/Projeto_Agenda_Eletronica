//package com.object;
package service;
import model.Contato;
import exception.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/*Projeto dos Estudantes do curso de licenciatura em Ciências da computação 
da UPE - Universidade de Pernambuco 
Disciplina: Programação II
sob a tutoria do Professor Dr. Austusto César F de M Oliveira

Licendiandos (por ordem alfabética):	
	Ednaldo Farias Gomes
	Jorge Enio Beserra Barbosa
	Renan Nunes Soares*/
public interface GerenciadorContatos {
	void adicionarContato(Contato contato) throws ContatoExistenteException;

	Contato buscarContato(String nome) throws ContatoNaoEncontradoException;

	void removerContato(String nome) throws ContatoNaoEncontradoException;

	List<Contato> listarTodosContatos();

//	public class ContatoExistenteException extends Exception {
//		public ContatoExistenteException(String mensagem) {
//			super(mensagem);
//		}
//	}

	@SuppressWarnings("serial")
	public class ContatoNaoEncontradoException extends Exception {
		public ContatoNaoEncontradoException(String mensagem) {
			super(mensagem);
		}

	}

	public static void salvarContatosCSV(List<Contato> contatos, String nomeArquivo) {
		try (FileWriter writer = new FileWriter(nomeArquivo)) {
			writer.write("Nome,Telefone,email\n");
			for (Contato c : contatos) {
				writer.write(c.getNome() + "," + c.getTelefone() +","+c.getEmail()+ "\n");
			}
			System.out.println("Contatos salvos em " + nomeArquivo);
		} catch (IOException e) {
			System.out.println("Erro ao salvar contatos: " + e.getMessage());
		}
	}

}
