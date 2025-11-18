//package com.object;
package model;

import model.Contato;
/*Projeto dos Estudantes do curso de licenciatura em Ciências da computação 
da UPE - Universidade de Pernambuco 
Disciplina: Programação II
sob a tutoria do Professor Dr. Austusto César F de M Oliveira

Licendiandos (por ordem alfabética):	
	Ednaldo Farias Gomes
	Jorge Enio Beserra Barbosa
	Renan Nunes Soares*/
public class Contato {
	private String nome;
	private String telefone;
	private String email;

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

	public void setEmail(String email) {
		this.email = email;
	}

	// Método toString()
	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
	}

	public Contato(String nome,  String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		
	}

}
