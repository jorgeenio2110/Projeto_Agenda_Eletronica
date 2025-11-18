//package com.object;
package service;
import model.Contato;
import exception.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*Projeto dos Estudantes do curso de licenciatura em Ciências da computação 
da UPE - Universidade de Pernambuco 
Disciplina: Programação II
sob a tutoria do Professor Dr. Austusto César F de M Oliveira

Licendiandos (por ordem alfabética):	
	Ednaldo Farias Gomes
	Jorge Enio Beserra Barbosa
	Renan Nunes Soares*/
public class AgendaManager implements GerenciadorContatos{
	private List<Contato> contatos = new ArrayList<>();
	
	public AgendaManager() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void adicionarContato(Contato contato) throws ContatoExistenteException {
		for (Contato c : contatos) {
			if (c.getNome().equalsIgnoreCase(contato.getNome())) {
				throw new ContatoExistenteException("Contato já esxistente "+contato.getNome());
			}
		}
		contatos.add(contato);		
	}
	@Override
	public Contato buscarContato(String nome) throws ContatoNaoEncontradoException {
		for (Contato c : contatos) {
			if(c.getNome().equalsIgnoreCase(nome)) {
				return c;
			}
		}
		throw new ContatoNaoEncontradoException("Contato não encontrato-> "+nome);
		
	}
	@Override
	public void removerContato(String nome) throws ContatoNaoEncontradoException {
		Contato contato = buscarContato(nome);
		contatos.remove(contato);
		
	}
	@Override
	public List<Contato> listarTodosContatos() {
		return new ArrayList<>(contatos);
	}
	
	public void salvarContatosCSV(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Contato c : contatos) {
                writer.write(c.getNome() + ";" + c.getTelefone() + ";" + c.getEmail());
                writer.newLine();
            }
            System.out.println("Contatos salvos em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    public void carregarContatosCSV(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    try {
                        adicionarContato(new Contato(partes[0], partes[1], partes[2]));
                    } catch (ContatoExistenteException ignored) {}
                }
            }
            System.out.println("Contatos carregados de " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }
	//Método que lista os contatos por ordem alfabetica
    public List<Contato> listarContatosOrdenados() {
        List<Contato> ordenados = new ArrayList<>(contatos);
        ordenados.sort(Comparator.comparing(Contato::getNome, String.CASE_INSENSITIVE_ORDER));
        return ordenados;
    }
  
    //Método que lista os contatos por dominio de email (gmail, hotmail, etc)
    public List<Contato> buscarPorDominioEmail(String dominio) {
        List<Contato> resultado = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getEmail() != null && c.getEmail().toLowerCase().endsWith("@" + dominio.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }




	
}
