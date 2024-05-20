import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private Map<String, Livro> livros;

    public Biblioteca() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.put(livro.getTitulo(), livro);
    }

    public void emprestarLivro(String titulo, Usuario usuario) throws LivroNaoEncontradoException, LivroJaEmprestadoException {
        Livro livro = livros.get(titulo);
        if (livro == null) {
            throw new LivroNaoEncontradoException("O livro '" + titulo + "' não foi encontrado na biblioteca.");
        }
        livro.emprestar();
        System.out.println("Livro '" + titulo + "' emprestado para " + usuario.getNome());
    }

    public void devolverLivro(String titulo, Usuario usuario) throws LivroNaoEncontradoException, LivroNaoEmprestadoException {
        Livro livro = livros.get(titulo);
        if (livro == null) {
            throw new LivroNaoEncontradoException("O livro '" + titulo + "' não foi encontrado na biblioteca.");
        }
        livro.devolver();
        System.out.println("Livro '" + titulo + "' devolvido por " + usuario.getNome());
    }

    public void verificarDisponibilidade(String titulo) throws LivroNaoEncontradoException {
        Livro livro = livros.get(titulo);
        if (livro == null) {
            throw new LivroNaoEncontradoException("O livro '" + titulo + "' não foi encontrado na biblioteca.");
        }
        String status = livro.isEmprestado() ? "emprestado" : "disponível";
        System.out.println("O livro '" + titulo + "' está " + status + ".");
    }
}