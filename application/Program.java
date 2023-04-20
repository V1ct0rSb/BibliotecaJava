package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Livro;
import entities.Reserva;
import entities.StatusLivro;
import entities.Usuario;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ArrayList<Livro> livros = new ArrayList<Livro>();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Reserva> reservas = new ArrayList<>();

		int opcao = -1;

		while (opcao != 0) {
			System.out.println("========== Menu Biblioteca ==========");
			System.out.println("1 - Cadastrar Livro");
			System.out.println("2 - Cadastrar Usuário");
			System.out.println("3 - Cadastrar Rserva");
			System.out.println("4 - Relatório");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				cadastrarLivro(livros, sc);
				break;
			case 2:
				cadastrarUsuario(usuarios, sc);
				break;
			case 3:
				cadastrarReserva(reservas, livros, usuarios, sc);
				break;
			case 4:
				relatorio(reservas, livros, usuarios, sc);
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
			System.out.println();
		}

		sc.close();
	}

	public static void cadastrarLivro(ArrayList<Livro> livros, Scanner sc) {
		System.out.println("=-=-Cadastrar Livro-=-=");

		System.out.print("Titulo: ");
		sc.nextLine();
		String titulo = sc.nextLine();

		// Verificar se tem livro já cadastrado com mesmo titulo
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				System.out.println("Já existe um livro cadastrado com esse titulo!!");
				return;
			}
		}

		System.out.print("Autor: ");
		String autor = sc.nextLine();
		System.out.print("Editora: ");
		String editora = sc.nextLine();
		System.out.print("Numero de páginas: ");
		int numPag = sc.nextInt();
		if (numPag <= 0) {
			System.out.println("Valor informado é invalido!!");
			return;
		}

		// Estanciar
		Livro novoLivro = new Livro(titulo, autor, editora, numPag);

		// Add na lista
		livros.add(novoLivro);
		System.out.println("Livro cadastrado com sucesso!!");
	}

	public static void cadastrarUsuario(ArrayList<Usuario> usuarios, Scanner sc) {
		System.out.println("=-=-Cadastrar Usuario-=-=");

		System.out.println("Nome: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("Endereço: ");
		String endereço = sc.nextLine();
		System.out.println("Telefone: ");
		int telefone = sc.nextInt();

		// Estanciar
		Usuario novoUsuario = new Usuario(nome, endereço, telefone);

		// Add na lista
		usuarios.add(novoUsuario);
		System.out.println("Usuário cadastrado com sucesso!!");
	}

	public static void cadastrarReserva(ArrayList<Reserva> reservas, ArrayList<Livro> livros,
			ArrayList<Usuario> usuarios, Scanner sc) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("=-=-Cadastrar Reserva-=-=");

		System.out.print("Titulo: ");
		sc.nextLine();
		String tituloLivro = sc.nextLine();

		// Verificar se o livro já foi cadastrado
		Livro livroReserva = null; // variável para guardar o livro que será reservado
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(tituloLivro)) {
				livroReserva = livro;
				break;
			}
		}

		if (livroReserva == null) {
			System.out.println("Livro não cadastrado!!");
			return;
		} else if (livroReserva.getStatus() != StatusLivro.DISPONIVEL) {
			System.out.println("Livro não está disponível para reservar!!");
			return;
		}

		System.out.print("Nome do usuário: ");
		String nomeUsuario = sc.nextLine();
		// Verificar se o usuário já foi cadastrado
		Usuario usuarioReserva = null; // variável para guardar o usuário que irá fazer a reserva
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nomeUsuario)) {
				usuarioReserva = usuario;
				break;
			}
		}

		if (usuarioReserva == null) {
			System.out.println("Usuário não cadastrado!!");
			return;
		}

		System.out.print("Informe a data da reserva (dd/mm/aaaa): ");
		Date dataReserva = sdf.parse(sc.nextLine());

		// Estanciar
		Reserva novaReserva = new Reserva(usuarioReserva, livroReserva, dataReserva);
		// Add na lista
		reservas.add(novaReserva);

		// Atualizar o status do livro
		livroReserva.setStatus(StatusLivro.NAO_DISPONIVEL);
		System.out.println("Reserva realizado com sucesso!!");
	}

	public static void relatorio(ArrayList<Reserva> reservas, ArrayList<Livro> livros, ArrayList<Usuario> usuarios,
			Scanner sc) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("=-=-=-Livros-=-=-=");
		if (livros.isEmpty()) {
			System.out.println("Não há livros cadastrados!!");
		} else {
			int numeroLivro = 1;
			for (Livro livro : livros) {
				System.out.println("#" + numeroLivro);
				System.out.println("Titulo: " + livro.getTitulo());
				System.out.println("Autor: " + livro.getAutor());
				System.out.println("Editora: " + livro.getEditora());
				System.out.println("Numero de páginas: " + livro.getNumPag());
				System.out.println("Status: " + livro.getStatus());
				numeroLivro++;
			}
		}
		System.out.println();

		System.out.println("=-=-=-Usuarios-=-=-=");
		if (usuarios.isEmpty()) {
			System.out.println("Não há usuários cadastrados!!");
		} else {
			for (Usuario usuario : usuarios) {
				System.out.println("Nome: " + usuario.getNome());
			}
		}
		System.out.println();

		System.out.println("=-=-=-Reserva-=-=-=");
		if (reservas.isEmpty()) {
			System.out.println("Não foi feito nenhum Reserva!!");
		} else {
			for (Reserva reserva : reservas) {
				System.out.println("Livro: " + reserva.getLivro().getTitulo());
				System.out.println("Usuario: " + reserva.getUsuario().getNome());
				System.out.println("Data da reserva: " + sdf.format(reserva.getDataReserva()));
				System.out.println();
			}
		}
	}
}
