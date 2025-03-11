import java.util.ArrayList;
import java.util.Scanner;
public class ProjetoBiblioteca {
    public static void main(String[] args) {

        //Biblioteca bib = new Biblioteca("Biblioteca Central");
        //bib.addLivro("Contato", "CarlSegan", "01/01/1980", EnumCategoria.FICCAO);
        //bib.addLivro("O senhor dos Aneis", "Tolkien", "01/01/1980", EnumCategoria.FICCAO );
        //bib.addLivro("O mundo assombrado pelos demônios", "Carl Segan", "01/01/1980", EnumCategoria.DIDATICO);
        //System.out.println(bib.toString());



        //declaracao de variavel
        boolean menu = true;
        boolean menuBiblioteca = true;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de biblioteca");

        ArrayList<Biblioteca> bibliotecas = new ArrayList<>(); //Lista de bibliotecas


        //Menu
        do {

            System.out.println("1 - Criar no biblioteca");
            System.out.println("2 - Entrar em uma biblioteca");
            System.out.println("3 - Excluir uma biblioteca");
            System.out.println("0 - Sair do programa");

            int opcao = entrada.nextInt();
            entrada.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("\nDigite o nome da biblioteca");
                    String nomeNovaBiblioteca = entrada.nextLine();
                    bibliotecas.add(new Biblioteca(nomeNovaBiblioteca));
                    System.out.println("\nBiblioteca '" + nomeNovaBiblioteca + "' criada");
                    break;

                case 2:
                    if (bibliotecas.isEmpty()){
                        System.out.println("\nNenhuma biblioteca disponível");
                    } else {
                        System.out.println("\nBibliotecas disponiveis: ");
                        for (int i = 0; i < bibliotecas.size(); i++) {
                            System.out.println((i + 1) + " - " + bibliotecas.get(i));
                        }

                        System.out.println("\nDigite o numero da biblioteca que deseja acessar: ");
                        int escolha = entrada.nextInt();
                        entrada.nextLine();

                        if (escolha > 0 && escolha <= bibliotecas.size()){
                            Biblioteca bibliotecaSelecionada = bibliotecas.get(escolha-1);
                            System.out.println("\nVocê entrou na biblioteca: " + bibliotecaSelecionada.getNome());
                            do {
                                System.out.println("\n\nVocê está na biblioteca: " + bibliotecaSelecionada.getNome());
                                System.out.println("Selecione o que deseja fazer: \n");
                                System.out.println("1 - Adicionar livro");
                                System.out.println("2 - Remover livro");
                                System.out.println("3 - Ver lista de livros");
                                System.out.println("4 - Total de livros");
                                System.out.println("5 - Excluir toda a biblioteca");
                                System.out.println("0 - Sair da biblioteca");
                                int opcao2 = entrada.nextInt();
                                entrada.nextLine();

                                switch (opcao2){
                                    case 1:
                                        System.out.println("\nDigite o título do livro: ");
                                        String tituloLivro = entrada.nextLine();

                                        System.out.println("\nDigite o autor do livro: ");
                                        String autorLivro = entrada.nextLine();

                                        System.out.println("\nDigite a data de publicação (ex: 01/01/2000): ");
                                        String dataPublicacao = entrada.nextLine();

                                        EnumCategoria categoria = null;
                                        boolean entradaValida = false;

                                        while (!entradaValida) {
                                            try {
                                                System.out.println("\nSelecione a categoria do livro:");
                                                for (EnumCategoria cat : EnumCategoria.values()) {
                                                    System.out.println("- " + cat);
                                                }

                                                System.out.print("\nDigite a categoria: ");
                                                String inputCategoria = entrada.nextLine().toUpperCase().replace(" ", "_");

                                                categoria = EnumCategoria.valueOf(inputCategoria);
                                                entradaValida = true; // Se chegou aqui, o valor está correto!

                                            } catch (IllegalArgumentException e) {
                                                System.out.println("\nCategoria inválida! Digite exatamente como mostrado.");
                                            }
                                        }


                                        bibliotecaSelecionada.addLivro(tituloLivro, autorLivro, dataPublicacao, categoria);

                                        break;

                                    case 2:
                                        System.out.println("\nDigite o ID do livro que deseja remover: ");
                                        int id = entrada.nextInt();
                                        entrada.nextLine();
                                        bibliotecaSelecionada.removerLivro(id);
                                        break;
                                    case 3:
                                        bibliotecaSelecionada.listarLivros();
                                        break;
                                    case 4:
                                        System.out.println("\nTotal de livros na biblioteca é" + bibliotecaSelecionada.contarLivros());
                                        break;
                                    case 5:
                                        System.out.println("\nBiblioteca excluida com sucesso!");
                                        return;
                                    case 0:
                                        System.out.println("\nSaindo...");
                                        return;
                                    default:
                                        System.out.println("\nOpção invalida");
                                }

                            }while (menuBiblioteca);
                        } else {
                            System.out.println("\nOpção invalida");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nDigite o id da biblioteca que deseja remover: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();
                    break;
                case 0:
                    System.out.println("\nSaindo...");
                    break;


                default:
                    System.out.println("\nOpção invalida");
            }




        }while (menu);

    }
}