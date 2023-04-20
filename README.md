# BibliotecaJava

<div>
  <img src="https://user-images.githubusercontent.com/112266976/233412875-e9c602f2-71d8-4eb5-9dfb-5824aee91e41.png" width="400" height="700">
  <img src="https://user-images.githubusercontent.com/112266976/233412865-5728d15c-1412-4bd7-a7c0-2b761799c699.png" width="400" height="700">
  <img src="https://user-images.githubusercontent.com/112266976/233412869-b3ee0e20-a366-4e82-8d0e-aabfa958cda0.png" width="400" height="700">
  <img src="https://user-images.githubusercontent.com/112266976/233412872-bc15b411-623e-42e7-94ab-21daac481c78.png" width="400" height="700">
</div>

<h2>💻 Introdução</h2>

<p>Este projeto foi desenvolvido para a disciplina de Projeto de Programação durante o curso superior.</p>
<p>Trata-se de uma aplicação simples de gerenciamento de reservas de livros para bibliotecas, na qual é possível cadastrar livros, usuários e reservas, além de gerar relatórios que listam os livros reservados e seus respectivos usuários.</p>
<p>O programa inicia mostrando um menu com as seguintes opções:</p>

<li>Cadastrar Livro</li>
<li>Cadastrar Usuário</li>
<li>Cadastrar Reserva</li>
<li>Relatório</li>
<li>Sair</li>

<p>A opção escolhida pelo usuário é capturada pelo Scanner e processada por meio de um switch case.</p>

<p>Na opção 1 permite cadastrar um novo livro. O usuário deve informar o título, autor, editora e número de páginas do livro. O programa verifica se já existe um livro cadastrado com o mesmo título e se o número de páginas informado é válido (maior que zero). Se tudo estiver correto, o livro é adicionado a uma lista de livros.</p>

<p>Na opção 2 permite cadastrar um novo usuário. O usuário deve informar o nome, endereço e telefone. Se tudo estiver correto, o usuário é adicionado a uma lista de usuários.</p>

<p>A opção 3 permite cadastrar uma nova reserva. O usuário deve informar o título do livro que quer reservar, o nome do usuário que irá realizar a reserva e a data em que a reserva será realizado. O programa verifica se o livro e o usuário estão cadastrados e se o livro está disponível para a reserva. Se tudo estiver correto, é criado uma nova reserva e o livro é marcado como indisponível.</p>

<p>A opção 0 finaliza o programa.</p>

<p>O programa utiliza classes como Livro, Usuario e Reserva para representar os objetos envolvidos na operação da biblioteca. Além disso, utiliza coleções como ArrayList para armazenar e manipular os objetos cadastrados. O programa também utiliza a classe SimpleDateFormat para fazer a leitura e a formatação das datas.</p>
