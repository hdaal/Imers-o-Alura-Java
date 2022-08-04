import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

/*
import java.io.FileInputStream;
import java.net.URL;
*/

public class StickerMaker {
    

public void gerar(InputStream inputStream, String nomeArquivo) throws Exception{

    // ler arquivo
    //InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
    //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
    
    BufferedImage original = ImageIO.read(inputStream);


    // preparar imagem
    int largura = original.getWidth();
    int altura = original.getHeight();
    int novaAlt = altura+200;
    
    BufferedImage novaImagem = new BufferedImage(largura, novaAlt, BufferedImage.TRANSLUCENT);



    // copiar original pra nova
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(original, 0, 0, null);

    // setar fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    // editar texto da imagem
    graphics.drawString("vai lá vai lá", 100, novaAlt-100);

    // saída do arquivo
    new File("saida").mkdir();
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

}


}
