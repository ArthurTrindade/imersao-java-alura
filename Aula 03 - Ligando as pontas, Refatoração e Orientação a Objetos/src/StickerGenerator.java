import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    
    public void createSticker(InputStream inputStream, String nomeArquivo) throws Exception {

        // Lendo uma imagem
        // InputStream inputStream = new FileInputStream(new File("assets/filme.jpg"));
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // pegando a largura da imagem
        int largura = imagemOriginal.getWidth();

        // pegando a altura da imagem
        int altura = imagemOriginal.getHeight();

        // definindo a nova altura da imagem, aumenta 10% em relação a imagem original 
        int novaAltura = (int) (altura + (altura * 0.1));

        // criando um buffer de uma imagem transparente
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiando a imagem original para o buffer novaImagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        int diferenca = novaAltura - altura;
        int tamFonte = (int) (diferenca * (0.5));

        // definindo uma nova fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, tamFonte);
        graphics.setFont(fonte);

        // pegando o tamanho do texto
        String texto = "TOPZERA";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int) retangulo.getWidth();

        // definindo as posições das imagens
        int posX = (largura - larguraTexto) / 2;
        int posY = novaAltura - (diferenca / 3);

        // desenhando o texto na novaImagem
        graphics.drawString(texto, posX, posY);

        // escrevendo a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("assets/" + nomeArquivo));
    }

}
