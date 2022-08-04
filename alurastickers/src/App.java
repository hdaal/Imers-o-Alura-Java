import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //fazer uma conexão HTTP e buscar conteudo

        /*  remover comentários da seção para utilizar api do imdb 

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        ExtraiConteudos extrator = new ExtratorImdb();
        
        */
        
 

        /*  remover comentários da seção para utilizar api da nasa

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        ExtraiConteudos extrator = new ExtratorNasa();

        */

        String url = "http://localhost:8080/linguagens";
        ExtraiConteudos extrator = new ExtratorImdb();


        var http = new ClienteHttp();
        String json = http.BuscaDados(url);

        //exibir e manipular os dados
        
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        var gerador = new StickerMaker();

        for(int i = 0; i<3; i++){

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" +conteudo.getTitulo()+".png";

            gerador.gerar(inputStream, nomeArquivo);
    
            System.out.println(conteudo.getTitulo());
            System.out.println();

        }

    }
}
