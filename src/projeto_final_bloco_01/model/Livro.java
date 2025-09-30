package projeto_final_bloco_01.model;

public abstract class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private float preco;
	private int tipo;
	
	
	

	public Livro(int id, String titulo, String autor, float preco, int tipo) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Livro Físico";
		case 2 -> tipo = "Livro Virtual - EBook";
		default -> tipo = "Desconhecido";
		}

		System.out.println("\n********************************************");
		System.out.println("Dados do Livro");
		System.out.println("**********************************************");
		System.out.printf("Número do Livro: %d%n", this.id);
		System.out.printf("Título do Livro:: %s%n", this.titulo);
		System.out.printf("Nome do Autor: %s%n", this.autor);
		System.out.printf("Preço do Livro: %.2f%n", this.preco);
		System.out.printf("Tipo do Livro: %s", tipo);
	}
	
	
	
}
