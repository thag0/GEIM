import geim.Geim;
import geim.Imagem;

public class Main {
    static Geim geim = new Geim();

    public static void main(String[] args) {
        int altura = 255;
        int largura = 255;
        Imagem img = new Imagem(altura, largura);

        for (int y = 0; y < img.altura(); y++) {
            for (int x = 0; x < img.largura(); x++) {
                int valR = (x+y)/2;
                int valG = (x+y)/2;
                int valB = (x+y)/2;
                img.set(x, y, valR, valG, valB);
            }
        }
        
        geim.paraPNG(img, "img.png");
    }
}
