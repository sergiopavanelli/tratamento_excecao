public class App {
    public static void main(String[] args) throws Exception {


        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("Ronaldo");

        Livro livro1 = new Livro("1984");
        Livro livro2 = new Livro("O caçador de pipas");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

      
  


        


    }

}


        