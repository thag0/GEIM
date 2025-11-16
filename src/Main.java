import java.awt.Color;

import geim.Geim;
import geim.imagem.Imagem;

public class Main {
    static Geim geim = new Geim();

    public static void main(String[] args) {
        int altura  = 400;
        int largura = 400;

        Imagem img = new Imagem(altura, largura);

        geim.preencher(img, Color.MAGENTA);
        geim.desenhar(img, 1);
    }
}
