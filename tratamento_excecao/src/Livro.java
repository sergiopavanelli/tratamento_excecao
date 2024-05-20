public class Livro {
    private String titulo;
    private boolean emprestado;

    public Livro(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() throws LivroJaEmprestadoException {
        if (emprestado) {
            throw new LivroJaEmprestadoException("O livro '" + titulo + "' já está emprestado.");
        }
        this.emprestado = true;
    }

    public void devolver() throws LivroNaoEmprestadoException {
        if (!emprestado) {
            throw new LivroNaoEmprestadoException("O livro '" + titulo + "' não está emprestado.");
        }
        this.emprestado = false;
    }
}