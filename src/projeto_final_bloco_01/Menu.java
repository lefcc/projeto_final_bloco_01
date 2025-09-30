package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import projeto_final_bloco_01.model.Ebook;
import projeto_final_bloco_01.model.LivroFisico;
import projeto_final_bloco_01.util.Cores;



public class Menu {

	private static Scanner leia = new Scanner(System.in);
	
	public static void main(String[] args) {
		
				
		int opcao;

		LivroFisico f1 = new LivroFisico(1, "Teste", "autor", 29.99f, 1, 20.99f);
		f1.visualizar();
		Ebook e1 = new Ebook(2, "Teste2", "autor", 29.99f, 2, "pdf");
		e1.visualizar();
		
		//criarContasTeste();

		while (true) {

			System.out.println(Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND
					+ "\n*****************************************************");
			System.out.println("                                                     ");
			System.out.println("          Loja de Livros - LIVROMANIA                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Livro                      ");
			System.out.println("            2 - Listar todos os Livros               ");
			System.out.println("            3 - Buscar Livro por ID                  ");
			System.out.println("            4 - Atualizar Dados do Livro             ");
			System.out.println("            5 - Apagar Livro                         ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("\n\n" + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 1 e 6:");
				leia.nextLine();
			}

			if (opcao == 6) {
				System.out.println(Cores.TEXT_PURPLE_BOLD + "\nLivraria LivroMania - a maior coleção de livros do Brasil!");
				
				sobre();
				leia.close();
				System.exit(6);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE + "Cadastrar Livro\n\n");

				//cadastrarLivro();

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_PURPLE + "Listar todos os Livros\n\n");

				//listarLivros();

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_PURPLE + "Buscar Livro por ID\n\n");

				//buscarLivroId();

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_PURPLE + "Atualizar Dados do Livro\n\n");

				//atualizarLivro();

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_PURPLE + "Apagar Livro\n\n");

				//deletarLivro();

				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}

	}
	
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Letícia Campos");
		System.out.println("E-mail - leticiacamposwork@gmail.com");
		System.out.println("github.com/lefcc");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}



	
}
