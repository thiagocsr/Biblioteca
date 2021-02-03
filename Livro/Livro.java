package Livro;

import java.util.Collection;
import java.util.HashSet;

public class Livro {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

	Collection<Livro> livros = new HashSet<Livro>();

	private int cod;
	private String titulo;
	private String autor;
	private String genero;
	private double preco;
	private int qtd;

	int alug = 0;

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Livro(int cod, String titulo, String autor, String genero, double preco, int qtd) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.preco = preco;
		this.qtd = qtd;

	}

	public int getCod() {
		return cod;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean checaLivro(Livro livro) {
		for (Livro livro1 : livros) {
			if (alug == livro1.getCod()) {
				// System.out.println("Livro: " + livro1.getTitulo() + " alugado.");
				return true;
			} else if (alug != livro1.getCod()) {
				// System.out.println("Livro não cadastrado.");
				return false;
			}
			return false;
		}
		return false;
	}
}
