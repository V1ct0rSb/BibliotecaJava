package entities;

public class Livro {
	private String titulo;
	private String autor;
	private String editora;
	private Integer numPag;
	private StatusLivro status;

	public Livro() {

	}

	public Livro(String titulo, String autor, String editora, Integer numPag) {
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.numPag = numPag;
		// Definindo o Status do livro padrão como Disponivel
		this.status = StatusLivro.DISPONIVEL;
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

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getNumPag() {
		return numPag;
	}

	public void setNumPag(Integer numPag) {
		this.numPag = numPag;
	}

	public StatusLivro getStatus() {
		return status;
	}

	public void setStatus(StatusLivro status) {
		this.status = status;
	}

}
