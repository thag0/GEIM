package geim;

public class GImg {
    Pixel[] dados;
    int altura;
    int largura;

    public GImg(int altura, int largura) {
        if (altura < 1 || largura < 1) {
            throw new IllegalArgumentException(
                "\nAltura e Largura devem ser maiores que zero."
            );
        }

        this.altura = altura;
        this.largura = largura;

        dados = new Pixel[this.altura * this.largura];
        for (int i = 0; i < dados.length; i++) {
            dados[i] = new Pixel();
        }
    }

    public Pixel get(int x, int y) {
        int id = y * altura + x;
        return dados[id];
    }
}
