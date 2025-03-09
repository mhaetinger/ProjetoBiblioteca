public class ProjetoBiblioteca {
    public static void main(String[] args) {

        System.out.println("Bem vindo ao sistema de biblioteca");


        Biblioteca bib = new Biblioteca("Biblioteca Central");
        bib.addLivro("Contato", "CarlSegan", "01/01/1980", EnumCategoria.FICCAO);
        bib.addLivro("O senhor dos Aneis", "Tolkien", "01/01/1980", EnumCategoria.FICCAO );
        bib.addLivro("O mundo assombrado pelos demônios", "Carl Segan", "01/01/1980", EnumCategoria.DIDATICO);


        System.out.println(bib.toString());

    }
}