package projeto_final_bloco_01.model;

public class LivroFisico extends Livro{
	
	private float peso;
	
	
	public LivroFisico(int id, String titulo, String autor, float preco, int tipo, float peso) {
		super(id, titulo, autor, preco, tipo);
		this.peso = peso;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("\nPeso do Livro: %.2f kg %n%n", this.peso);
	}
	
	

}
