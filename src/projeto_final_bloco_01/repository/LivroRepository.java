package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Livro;

public interface LivroRepository {

	// Métodos do CRUD
	
	public void listarTodos();
	public void cadastrar(Livro livro);
	public void atualizar(Livro livro);
	public void procurarPorNumero(int id);
	public void deletar(int id);

		


}
