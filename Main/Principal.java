package Main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Cliente.Cliente;
import Es.Es;
import Livro.Livro;

public class Principal extends Es {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		int aux = 0;
		int opc = 0;

		String cpft;
		String nomet;
		String enderecot;
		String numerot = "01";
		Calendar data, entrega;

		int codt;
		String titulot;
		String autort;
		String generot;
		double precot;
		int qtdt;

		Collection<Cliente> clientes = new HashSet<Cliente>();
		Collection<Livro> livros = new HashSet<Livro>();
		List<Livro> listaCompra = new ArrayList<Livro>();
		List<Livro> listaAlugados = new ArrayList<Livro>();

		Scanner e = new Scanner(System.in);
		e.useDelimiter(System.lineSeparator());

		Cliente c1 = new Cliente("1", "Fulano", "Endereco 1", "123");
		clientes.add(c1);

		Cliente c2 = new Cliente("2", "Beltrano", "Endereco 2", "213");
		clientes.add(c2);

		Livro l1 = new Livro(001, "O nome do Vento", "Patrick Rothfuss", "Fantasia", 31, 5);
		livros.add(l1);
		Livro l2 = new Livro(002, "Game of Thrones", "George R. R. Martin", "Fantasia", 40, 2);
		livros.add(l2);
		Livro l3 = new Livro(003, "Peter Pan", "J. M. Barrie", "Infantil", 44, 2);
		livros.add(l3);
		Livro l4 = new Livro(004, "Trilogia Senhor dos Aneis", "J. R. R. Tolkien", "Alta fantasia", 100, 1);
		livros.add(l4);
		Livro l5 = new Livro(005, "Robin Hood", "Howard Pyle", "Aventura", 32, 0);
		livros.add(l5);
//----------------------------------------------------------------------------------------------------------------//
		do {

			System.out.println("1-Cadastro Cliente, 2-Cadastro Livro, 3-Alugar livro, 4-Comprar livro.");
			try {
				aux = e.nextInt();
			} catch (InputMismatchException x) {
				System.out.println("Opção invalida.");
				aux = 4;
			}

			switch (aux) {
			case 1:
				String continuar = "s";

				while ("s".equalsIgnoreCase(continuar)) {
					System.out.println("Digite o cpf do novo cliente.");
					cpft = e.next();
					System.out.println("Digite o nome do novo cliente.");
					nomet = e.next();
					System.out.println("Digite o endereco do novo cliente.");
					enderecot = e.next();
					System.out.println("Digite o numero do novo cliente.");
					numerot = e.next();

					Cliente c = new Cliente(cpft, nomet, enderecot, numerot);
					if (clientes.contains(c)) {
						System.out.println("Cliente ja cadastrado!");
					} else {
						clientes.add(c);
						System.out.println("Cliente cadastrado com sucesso.");
					}

					System.out.println("Deseja adicionar outro cliente? s/n");
					continuar = e.next();
				}

				System.out.println("Pressione 1 pra sair ou qualquer outro numero para continuar");

				opc = e.nextInt();

				if (opc == 1) {
					aux = 4;
				} else {
					aux = 5;
				}
				break;
			case 2:
				String continuar2 = "s";

				while ("s".equalsIgnoreCase(continuar2)) {

					System.out.println("Digite o codigo do novo livro.");
					codt = e.nextInt();
					System.out.println("Digite o titulo do novo livro.");
					titulot = e.next();
					System.out.println("Digite o autor do novo livro.");
					autort = e.next();
					System.out.println("Digite o genero do novo livro.");
					generot = e.next();
					System.out.println("Digite o preço do novo livro.");
					precot = e.nextDouble();
					System.out.println("Digite o estoque do novo livro.");
					qtdt = e.nextInt();

					Livro l = new Livro(codt, titulot, autort, generot, precot, qtdt);
					if (livros.contains(l)) {
						System.out.println("Livro ja cadastrado!");
					} else {
						livros.add(l);
						System.out.println("Livro cadastrado com sucesso.");
					}

					System.out.println("Deseja adicionar outro livro? s/n");
					continuar2 = e.next();

				}
				System.out.println("Pressione 1 pra sair ou qualquer outro numero para continuar");

				opc = e.nextInt();

				if (opc == 1) {
					aux = 4;
				} else {
					aux = 5;
				}
				break;
			case 3:
				String continuar3 = "s";
				while ("s".equalsIgnoreCase(continuar3)) {
					System.out.println("Qual livro deseja alugar?");
					int alug = e.nextInt();
					int miss = 0;
					for (Livro livro : livros) {
						if (alug == livro.getCod()) {
							miss = alug;
							if (c1.getMaxAlug() < 3) {
								c1.alugar(livro);
								listaAlugados.add(livro);
								data = Calendar.getInstance();
								entrega = Calendar.getInstance();
								entrega.add(Calendar.DATE, +15);
								System.out.printf("%tD\n", data);
								System.out.printf("Livro: " + livro.getTitulo() + " alugado no dia: " + "%tD\n", data);
								System.out.printf("Entrega para dia: " + "%tD\n", entrega);
								System.out.println(listaAlugados);

								System.out.println(c1.getMaxAlug());
							} else {
								System.out.println("Limite de livros emprestados atingido.");
							}
						}
					}
					if (miss == 0) {
						System.out.println("Livro não cadastrado!");
					}
					System.out.println("Deseja alugar outro livro? s/n");
					continuar3 = e.next();
				}
				System.out.println("Pressione 1 pra sair ou qualquer outro numero para continuar");
				opc = e.nextInt();

				if (opc == 1) {
					aux = 4;
				} else {
					aux = 5;
				}
				break;
			case 4:
				String continuar4 = "s";
				while ("s".equalsIgnoreCase(continuar4)) {
					int cmp = 0;
					System.out.println("Qual livro deseja comprar?");
					int comp = e.nextInt();
					for (Livro livro : livros) {
						if (comp == livro.getCod()) {
							cmp = comp;
							System.out.println("Livro: " + livro.getTitulo() + " adicionado no carrinho.");
							listaCompra.add(livro);
							c1.comprar(livro);
						} 
					}
					if (cmp == 0) {
						System.out.println("Livro não cadastrado!");
					}
					System.out.println("Deseja adicionar outro livro no carrinho? s/n");
					continuar4 = e.next();
				}
				System.out.println("Livros no carrinho: ");
				for (Livro livro : listaCompra) {
					System.out.println(livro.getTitulo());
				}
				System.out.println("Total a pagar: " + c1.getTotalCarrinho());
				System.out.println("Pressione 1 pra sair ou qualquer outro numero para continuar");
				opc = e.nextInt();

				if (opc == 1) {
					aux = 4;
				} else {
					aux = 5;
				}
				break;
			}

		} while (aux != 4);

		e.close();
	}

}
