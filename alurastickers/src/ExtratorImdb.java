import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorImdb implements ExtraiConteudos {
    
    public List<Conteudo>extraiConteudo(String json){

        //filtrar os dados (título, poster e rating)
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // preenchendo a lista
        for (Map<String, String> atributo : listaAtributos) {
            String titulo = atributo.get("title");
            String urlImagem = atributo.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
           
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }

        return conteudos;
        
    }


}
