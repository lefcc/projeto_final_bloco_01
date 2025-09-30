package projeto_final_bloco_01.model;

public class Ebook extends Livro {
	
	private String formato;
	
	public Ebook(int id, String titulo, String autor, float preco, int tipo, String formato) {
		super(id, titulo, autor, preco, tipo);
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("\nFormato do Livro: %s%n%n", this.formato);
	}
	
	
	
}
