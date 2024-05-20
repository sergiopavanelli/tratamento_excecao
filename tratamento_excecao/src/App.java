public class App {
    public static void main(String[] args) throws Exception {


        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("Ronaldo");

        Livro livro1 = new Livro("1984");
        Livro livro2 = new Livro("O caçador de pipas");
        Livro livro3 = new Livro("Crime e castigo");

        // Adicionar livros

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);     
        biblioteca.adicionarLivro(livro3);


        try {

            biblioteca.verificarDisponibilidade("1984");
            biblioteca.emprestarLivro("1984", usuario);
            biblioteca.verificarDisponibilidade("1984");

            // Tentar emprestar novamente o mesmo livro
            biblioteca.emprestarLivro("1984", usuario);

        } catch (LivroJaEmprestadoException | LivroNaoEncontradoException e) {  
            System.out.println(e.getMessage()); 
        }

        try {

            biblioteca.devolverLivro("1984", usuario);
            biblioteca.verificarDisponibilidade("1984");

            // Tentar devolver o livro novamente
            biblioteca.devolverLivro("1984", usuario);

        } catch (LivroNaoEncontradoException | LivroNaoEmprestadoException e) {
            System.out.println(e.getMessage());       

        }

        try {

            // Consultar um livro inexistente

            biblioteca.verificarDisponibilidade("A volta dos que não foram");

        } catch (LivroNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }
}       