package Cliente;

import java.util.ArrayList;
import java.util.List;

import Livro.Livro;

public class Cliente {

	private String cpf;
	private String nome;
	private String endereco;
	private String numero;
	private int maxAlug = 0;
	private double totalCarrinho = 0;

	public double getTotalCarrinho() {
		return totalCarrinho;
	}

	List<Livro> lista = new ArrayList<Livro>();

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente(String cpf, String nome, String endereco, String numero) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void alugar(Livro livro) {
		// int quant = livro.getQtd();
		maxAlug++;
		if (maxAlug< 3) {
			lista.add(livro);
			
			
		} else {
			System.out.println("Limite de livros emprestados atingido.");
		}
		/*
		 * for (int i=0;i<lista.size();i++) {
		 * System.out.println(lista.get(i).getTitulo()); }
		 */
	}

	public void comprar(Livro livro) {
		totalCarrinho += livro.getPreco();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public int getMaxAlug() {
		return maxAlug;
	}

	public Object pegarCod(Livro livro) {
		return livro.getCod();
	}
}
