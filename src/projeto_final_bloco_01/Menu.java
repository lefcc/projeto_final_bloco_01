package projeto_final_bloco_01;

import java.util.InputMismatchException;
import java.util.Scanner;


import projeto_final_bloco_01.controller.LivroController;
import projeto_final_bloco_01.model.Ebook;
import projeto_final_bloco_01.model.Livro;
import projeto_final_bloco_01.model.LivroFisico;
import projeto_final_bloco_01.util.Cores;



public class Menu {

	private static Scanner leia = new Scanner(System.in);
	private static final LivroController livroController = new LivroController();
	
	public static void main(String[] args) {
		
				
		int opcao;

		/*LivroFisico f1 = new LivroFisico(1, "Teste", "autor", 29.99f, 1, 20.99f);
		f1.visualizar();
		Ebook e1 = new Ebook(2, "Teste2", "autor", 29.99f, 2, "pdf");
		e1.visualizar(); */
		
		//criarLivrosTeste();

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
				System.out.println("\nDigite um id inteiro entre 1 e 6:");
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

				cadastrarLivro();

				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_PURPLE + "Listar todos os Livros\n\n");

				listarTodos();

				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_PURPLE + "Buscar Livro por ID\n\n");

				buscarLivroId();

				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_PURPLE + "Atualizar Dados do Livro\n\n");

				atualizarLivro();

				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_PURPLE + "Apagar Livro\n\n");

				deletarLivro();

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


	private static void listarTodos() {
		livroController.listarTodos();
	}

	private static void cadastrarLivro() {

		System.out.print("Digite o Título do Livro: ");
		String titulo = leia.nextLine();

		System.out.print("Digite o nome do autor Livro: ");
		String autor = leia.nextLine();

		System.out.print("Digite o preço do Livro: ");
		float preco = leia.nextFloat();
		
		System.out.print("Digite o Tipo de Livro (1 - Físico | 2 - Virtual): ");
		int tipo = leia.nextInt();

		switch (tipo) {
		case 1 -> {
			System.out.print("Digite o Peso do Livro: ");
			float peso = leia.nextFloat();
			leia.nextLine();
			livroController
					.cadastrar(new LivroFisico(livroController.gerarId(), titulo, autor, preco, tipo, peso));
		}

		case 2 -> {
			System.out.print("Digite o Formato do Livro: ");
			leia.skip("\\R"); 
			String formato = leia.nextLine();
			livroController.cadastrar(
					new Ebook(livroController.gerarId(), titulo, autor, preco, tipo, formato));
		}

		default -> System.out.println(Cores.TEXT_RED + "Tipo de livro inválido!" + Cores.TEXT_RESET);
		}
	}

	private static void buscarLivroId() {

		System.out.print("Digite o ID do livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		livroController.procurarPorId(id);
	}

	private static void deletarLivro() {

		System.out.print("Digite o ID do livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		Livro livro = livroController.buscarNaCollection(id); 

		if (livro != null) {

			System.out.print("\nTem certeza que deseja excluir este livro? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				livroController.deletar(id);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nO livro ID %d não foi encontrado!", id);
		}
	}

	private static void atualizarLivro() {

		System.out.print("Digite o ID do livro: ");
		int id = leia.nextInt();
		leia.nextLine();

		Livro livro = livroController.buscarNaCollection(id);

		if (livro != null) {

			String titulo = livro.getTitulo();
			String autor = livro.getAutor();
			float preco = livro.getPreco();
			int tipo = livro.getTipo();
			
			
			System.out.printf("O Titulo atual do Livro é %s\nNovo Titulo (Pressione ENTER para manter o valor atual): ",
					titulo);
			String entrada = leia.nextLine();
			titulo = entrada.isEmpty() ? titulo : entrada;

			System.out.printf("O Autor atual é %.2f\nNovo Autor (Pressione ENTER para manter o valor atual): ", autor);
			entrada = leia.nextLine();
			autor = entrada.isEmpty() ? autor : entrada;

			System.out.printf("O Preço atual do Livro é %.2f\nNovo Preço (Pressione ENTER para manter o valor atual): ", preco);
			entrada = leia.nextLine();
			preco = entrada.isEmpty() ? preco : Float.parseFloat(entrada);
			
			switch (tipo) {
			case 1 -> {
				float peso = ((LivroFisico) livro).getPeso();

				System.out.printf("O Peso atual é %.2f\nNovo Peso (Pressione ENTER para manter o valor atual): ",
						peso);
				entrada = leia.nextLine();
				peso = entrada.isEmpty() ? peso : Float.parseFloat(entrada);
				livroController.atualizar(new LivroFisico(id, titulo, autor, preco, tipo, peso));
			}
			case 2 -> {

				String formato = ((Ebook) livro).getFormato();

				System.out.printf(
						"O Formato atual é %d\nNovo Formato (Pressione ENTER para manter o valor atual): ",
						formato);
				entrada = leia.nextLine();
				formato = entrada.isEmpty() ? formato : entrada;
				livroController.atualizar(new Ebook(id, titulo, autor, preco, tipo, formato));
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de livro inválido!" + Cores.TEXT_RESET);
			}

		} else {
			System.out.printf("\nA livro id %d não foi encontrada!", id);
		}

	}

		
}
