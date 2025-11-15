package geim;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Estrutura para mapear uma imagem RBG usando Pixels.
 */
public class Imagem {

    /**
     * Conjunto de dados.
     */
    private Pixel[] dados;

    /**
     * Altura da imagem.
     */
    private int altura;

    /**
     * Largura da imagem.
     */
    private int largura;

    /**
     * Inicializa uma imagem a partir de um tamanho predefinido com pixels zerados.
     * @param altura altura desejada.
     * @param largura largura desejada.
     */
    public Imagem(int altura, int largura) {
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

    /**
     * Calcula o índice interno do elemento no conjunto de dados.
     * @param x valor horizontal.
     * @param y valor vertical.
     * @return índice calculado.
     */
    private int indice(int x, int y) {
        if (x < 0 || x >= this.largura) {
            throw new IllegalArgumentException("\nValor de x (" + x + ") fora de alcance.");
        }
        if (y < 0 || y >= this.largura) {
            throw new IllegalArgumentException("\nValor de y (" + y + ") fora de alcance.");
        }

        return y * altura + x;
    }

    /**
     * Retorna um pixel a partir da posição dada.
     * @param x valor horizontal.
     * @param y valor vertical.
     * @return {@code Pixel} correspondente.
     */
    public Pixel get(int x, int y) {
        return dados[indice(x, y)];
    }

    /**
     * Altera o valor RGB de um pixel.
     * @param x valor horizontal.
     * @param y valor vertical.
     * @param r intensidade da cor vermelha.
     * @param g intensidade da cor verde.
     * @param b intensidade da cor azul.
     */
    public void set(int x, int y, int r, int g, int b) {
        Pixel p = dados[indice(x, y)];
        p.setRGB(r, g, b);
    }

    /**
     * Altera o valor RGB de um pixel a partir de outro pixel.
     * @param x valor horizontal.
     * @param y valor vertical.
     * @param pixel pixel base.
     */
    public void set(int x, int y, Pixel pixel) {
        Pixel p = dados[indice(x, y)];
        p.setRGB(pixel.getR(), pixel.getG(), pixel.getB());
    }

    /**
     * Retorna a altura da imagem.
     * @return valor de altura.
     */
    public int altura() {
        return altura;
    }
    
    /**
     * Retorna a largura da imagem.
     * @return valor de largura.
     */
    public int largura() {
        return largura;
    }

	/**
	 * Salva a imagem em um arquivo externo {@code png}.
	 * @param img {@code Imagem} base.
	 * @param caminho caminho desejado.
	 */
	public void paraPNG(String caminho) {
		if (!caminho.endsWith(".png")) {
			throw new IllegalArgumentException(
				"\nCaminho deve conter a extensão .png"
			);
		}

		int altura = altura();
		int largura = largura();

		BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

		int r = 0;
		int g = 0;
		int b = 0;
		int rgb = 0;

		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				Pixel p = get(x, y);
				r = p.getR();
				g = p.getG();
				b = p.getB();
				rgb = (r << 16) | (g << 8) | b;
				imagem.setRGB(x, y, rgb);
			}
		}

		try {
			File arquivo = new File((caminho));
			ImageIO.write(imagem, "png", arquivo);

		} catch (Exception e) {
			System.out.println("\nErro ao exportar imagem");
			e.printStackTrace();
		}
	}

}
