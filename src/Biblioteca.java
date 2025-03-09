import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<Livro> acervo;


    public Biblioteca(String nome) {
        this.nome = nome;
        this.acervo = new ArrayList<Livro>();
    }

    public void addLivro(String titulo, String autor, String dataPublicacao, EnumCategoria categoria) {

        Livro livro = new Livro();

        livro.setId(this.acervo.size()+1);
        livro.setAutor(titulo);
        livro.setAutor(autor);
        livro.setDataPublicacao(dataPublicacao);
        livro.setCategoria(categoria);

        this.acervo.add(livro);
    }

    @Override
    public String toString() {
        String ret = "nome: " + this.nome;
        ret += "\nAcervo\n";
        for (Livro o : acervo) {
            ret += o.toString() + "\n";
        }
        return ret;
    }
}
