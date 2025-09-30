package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto_final_bloco_01.model.Livro;
import projeto_final_bloco_01.repository.LivroRepository;

public class LivroController implements LivroRepository{
	
	private List<Livro> listaLivros = new ArrayList<Livro>();
	int id = 0;

	
	@Override
	public void listarTodos() {
		for (var livro : listaLivros) {
			livro.visualizar();    //método visualizar da classe livro
		}

	}

	@Override
	public void cadastrar(Livro livro) {
		listaLivros.add(livro);
		System.out.println("\nLivro cadastrado com sucesso!");

	}

	@Override
	public void atualizar(Livro livro) {

		var buscarLivro = buscarNaCollection(livro.getId());

		if(buscarLivro != null) {
			listaLivros.set(listaLivros.indexOf(buscarLivro), livro);
			System.out.printf("\nO livro id %d foi atualizado com sucesso!%n", livro.getId());
		} else {
			System.out.printf("\nO livro id %d não foi encontrado.%n", livro.getId());
		}
		
	}

	
	@Override
	public void procurarPorId(int id) {
		
		var livro = buscarNaCollection(id);
		
		if(livro != null) {
			livro.visualizar();
		}else {
			System.out.printf("\nO livro id %d não foi encontrado!%n", id);
		}
		
	}
	
	

	@Override
	public void deletar(int id) {
		
		var livro = buscarNaCollection(id);
		
		if(livro != null) {
			if(listaLivros.remove(livro) == true) {
				System.out.printf("\nO livro id %d foi deletado com sucesso!%n", id);
			}
		}else {
			System.out.printf("\nO livro id %d não foi encontrado!%n", id);
		}
		
	}
	

	
	// Métodos Auxiliares
	public int gerarId() {
		return ++ id;
	}
	
	
	public Livro buscarNaCollection(int id) {
		
		for(var livro : listaLivros) {
			if(livro.getId() == id) {
				return livro;
			}
		}
		
		return null;
	}


	


}
