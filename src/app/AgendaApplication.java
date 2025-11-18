package app;

import model.Contato;
import service.AgendaManager;
import exception.ContatoExistenteException;
import exception.ContatoNaoEncontradoException;
//import service.GerenciadorContatos.ContatoNaoEncontradoException;
import java.util.List;
import java.util.Scanner;
/*Projeto dos Estudantes do curso de licenciatura em Ciências da computação 
da UPE - Universidade de Pernambuco 
Disciplina: Programação II
sob a tutoria do Professor Dr. Austusto César F de M Oliveira

Licendiandos (por ordem alfabética):
	Ednaldo Farias Gomes
	Jorge Enio Beserra Barbosa
	Renan Nunes Soares*/
public class AgendaApplication {

	public AgendaApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws service.GerenciadorContatos.ContatoNaoEncontradoException, ContatoNaoEncontradoException {
		AgendaManager agenda = new AgendaManager();
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Adicionar Contato");
			System.out.println("2. Buscar Contato");
			System.out.println("3. Remover Contato");
			System.out.println("4. Listar Todos os Contatos");
			System.out.println("5. Salvar em CSV");
			System.out.println("6. Carregar de CSV");
			System.out.println("7. Listar Contatos Ordenados");
			System.out.println("8. Buscar por domínio de e-mail");
			System.out.println("9. Sair");
			System.out.print("Escolha uma opção: ");
			if (!scanner.hasNextInt()) {
				System.out.println("Entrada inválida. Digite um número.");
				scanner.nextLine(); // limpa entrada inválida
				continue;
			}
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Nome ");
				String nome = scanner.nextLine();
				System.out.println("Telefone ");
				String telefone = scanner.nextLine();
				System.out.println("Email ");
				String email = scanner.nextLine();
				try {
					agenda.adicionarContato(new Contato(nome, telefone, email));
					System.out.println("Contato adicionado com sucesso!");
				} catch (ContatoExistenteException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Nome do contato ");
				nome = scanner.nextLine();
				Contato contato = agenda.buscarContato(nome);
				System.out.println(contato);
				break;
			case 3:
				System.out.println("Nome do contato ");
				nome = scanner.nextLine();
				agenda.removerContato(nome);
				System.out.println("Contato removido!");
				break;
			case 4:
				for (Contato c : agenda.listarTodosContatos()) {
					System.out.println(c);
				}
				break;
			case 5:
				System.out.println("Nome do Arquivo .csv para salvar.");
				String arquivoSalvar = scanner.nextLine();
				agenda.salvarContatosCSV(arquivoSalvar+".csv");
				break;
			case 6:
				System.out.println("Nome do arquivo .csv para carregar (não precisa do .csv): ");
				String arquivoCarregar = scanner.nextLine();
				agenda.carregarContatosCSV(arquivoCarregar+".csv");
				break;
			case 7:
				System.out.println("\nContatos ordenados:");
				for (Contato c : agenda.listarContatosOrdenados()) {
					System.out.println(c);
				}
				break;
			case 8:
				System.out.print("Digite o domínio de email (ex: gmail.com): ");
				String dominio = scanner.nextLine();
				List<Contato> encontrados = agenda.buscarPorDominioEmail(dominio);
				if (encontrados.isEmpty()) {
					System.out.println("Nenhum contato encontrado com o domínio: " + dominio);
				} else {
					for (Contato c : encontrados) {
						System.out.println(c);
					}
				}
				break;
			case 9:
				System.out.println("Finalizando o sistema....");
				break;
			default:
				System.out.println("Opção inválida." + opcao);
			}

		} while (opcao != 9);
		scanner.close();
	}

}
