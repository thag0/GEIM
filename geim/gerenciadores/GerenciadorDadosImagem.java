package geim.gerenciadores;

import java.awt.Color;
import java.awt.image.BufferedImage;

import geim.imagem.Imagem;

/**
 * Gerenciador de dados de imagem para o Geim
 */
public class GerenciadorDadosImagem {
	
	/**
	 * Contém implementações de manuseio de dados de imagem.
	 */
	public GerenciadorDadosImagem() {}

	/**
	 * Gera uma imagem com todos os valores de cor zerados.
	 * @param largura largura desejada.
	 * @param altura altura desejada.
	 * @return {@code Imagem} criada.
	 */
	public Imagem gerarImagem(int largura, int altura) {
		if (largura <= 0 || altura <= 0) {
			throw new IllegalArgumentException(
				"Os valores de altura e largura fornecidos são inválidos"
			);
		}

		Imagem img = new Imagem(altura, largura);

		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				img.set(x, y, 0, 0, 0);
			}
		}

		return img;
	}

	/**
	 * Gera uma imagem a partir de uma BufferedImage.
	 * @param img imagem base.
	 * @return {@code Imagem} criada.
	 */
	public Imagem gerarImagem(BufferedImage img) {
		if (img == null) {
			throw new IllegalArgumentException("A imagem fornecida é nula.");
		}
		if (img.getWidth() < 1) {
			throw new IllegalArgumentException("A largura da imagem não pode ser menor ou igual a zero.");
		}
		if (img.getHeight() < 1) {
			throw new IllegalArgumentException("A altura da imagem não pode ser menor ou igual a zero.");
		}
		
		int largura = img.getWidth();
		int altura = img.getHeight();
		Imagem imagem = new Imagem(altura, largura);

		for (int y = 0; y < altura; y++) {         
			for (int x = 0; x < largura; x++) {
				imagem.set(
					x, 
					y,
					getR(img, x, y),
					getG(img, x, y),
					getB(img, x, y)
				);}
		}

		return imagem;
	}

	/**
	 * Altera o valor rbg de um pixel específico da imagem.
	 * @param img {@code Imagem} base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
     * @param r intensidade da cor vermelha.
     * @param g intensidade da cor verde.
     * @param b intensidade da cor azul.
	 */
	public void setCor(Imagem img, int x, int y, int r, int g, int b) {
		if (img == null) {
			throw new IllegalArgumentException("A estrutura da imagem é nula");
		}
		if (x < 0 || x > img.largura()) {
			throw new IllegalArgumentException("O valor y de fornecido está fora de alcance.");
		}
		if (y < 0 || y >= img.altura()) {
			throw new IllegalArgumentException("O valor x de fornecido está fora de alcance.");
		}

		img.set(x, y, r, g, b);
	}

	/**
	 * Preenche todo o conteúdo da imagem usando uma configuração RBG.
	 * @param img {@code Imagem} base.
     * @param r intensidade da cor vermelha.
     * @param g intensidade da cor verde.
     * @param b intensidade da cor azul.
	 */
	public void preencher(Imagem img, int r, int g, int b) {
		for (int y = 0; y < img.altura(); y++) {
			for (int x = 0; x < img.largura(); x++) {
				img.set(x, y, r, g, b);
			}
		}
	}

	/**
	 * Preenche todo o conteúdo da imagem usando uma configuração RBG.
	 * @param img {@code Imagem} base.
     * @param rgb valor de cor rgb.
	 */
	public void preencher(Imagem img, int rgb) {
		for (int y = 0; y < img.altura(); y++) {
			for (int x = 0; x < img.largura(); x++) {
				img.set(x, y, getBitR(rgb), getBitG(rgb), getBitB(rgb));
			}
		}
	}

	/**
	 * Preenche todo o conteúdo da imagem usando uma configuração RBG.
	 * @param img {@code Imagem} base.
     * @param c cor base.
	 */
	public void preencher(Imagem img, Color c) {
		for (int y = 0; y < img.altura(); y++) {
			for (int x = 0; x < img.largura(); x++) {
				int rgb = c.getRGB();
				img.set(x, y, getBitR(rgb), getBitG(rgb), getBitB(rgb));
			}
		}
	}

	/**
	 * Retorna os dados de cor vermelha para todos os pixels da imagem.
	 * @param img imagem base.
	 * @return valores de cor vermelha.
	 */
	public int[][] getR(BufferedImage img) {
		int largura = img.getWidth();
		int altura = img.getHeight();

		int[][] r = new int[altura][largura];
		for(int y = 0; y < altura; y++){
			for(int x = 0; x < largura; x++){
				r[y][x] = getR(img, x, y);
			}
		}

		return r;
	}

	/**
	 * Retorna os dados de cor verde para todos os pixels da imagem.
	 * @param img imagem base.
	 * @return valores de cor verde.
	 */
	public int[][] getG(BufferedImage img) {
		int largura = img.getWidth();
		int altura = img.getHeight();

		int[][] g = new int[altura][largura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				g[y][x] = getG(img, x, y);
			}
		}

		return g;
	}

	/**
	 * Retorna os dados de cor azul para todos os pixels da imagem.
	 * @param img imagem base.
	 * @return valores de cor azul.
	 */
	public int[][] getB(BufferedImage img) {
		int largura = img.getWidth();
		int altura = img.getHeight();

		int[][] b = new int[altura][largura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				b[y][x] = getB(img, x, y);
			}
		}

		return b;
	}

	/**
	 * Retorna os dados de cor em escala de cinza para todos os pixels da imagem.
	 * @param img imagem base.
	 * @return valores de cor cinza.
	 */
	public int[][] getGray(BufferedImage img) {
		int largura = img.getWidth();
		int altura = img.getHeight();

		int[][] cinza = new int[altura][largura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				int r = getR(img, x, y);
				int g = getG(img, x, y);
				int b = getB(img, x, y);
				int c = (r + g + b) / 3;
				cinza[y][x] = c;
			}
		}

		return cinza;
	}

	/**
	 * Retorna o valor de cor vermelha para um pixel específico da imagem.
	 * @param img imagem base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
	 * @return valor de instensidade da cor vermelha.
	 */
	public int getR(BufferedImage img, int x, int y) {
		int rgb = img.getRGB(x, y);
		int r = getBitR(rgb);
		return r;
	}

	/**
	 * Retorna o valor de cor verde para um pixel específico da imagem.
	 * @param img imagem base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
	 * @return valor de instensidade da cor verde.
	 */
	public int getG(BufferedImage img, int x, int y) {
		int rgb = img.getRGB(x, y);
		int g = getBitG(rgb);
		return g;
	}

	/**
	 * Retorna o valor de cor azul para um pixel específico da imagem.
	 * @param img imagem base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
	 * @return valor de instensidade da cor azul.
	 */
	public int getB(BufferedImage img, int x, int y) {
		int rgb = img.getRGB(x, y);
		int b = getBitB(rgb);
		return b;
	}

	/**
	 * Converte o valor RGB para cor Vermelha usando bit shift.
	 * @param rgb valor de cor rgb.
	 * @return parte da cor vermelha.
	 */
	private int getBitR(int rgb) {
		return (rgb >> 16) & 0xFF;
	}

	/**
	 * Converte o valor RGB para cor Verde usando bit shift.
	 * @param rgb valor de cor rgb.
	 * @return parte da cor verde.
	 */
	private int getBitG(int rgb) {
		return (rgb >> 8) & 0xFF;
	}

	/**
	 * Converte o valor RGB para cor Azul usando bit shift.
	 * @param rgb valor de cor rgb.
	 * @return parte da cor azul.
	 */
	private int getBitB(int rgb) {
		return rgb & 0xFF;
	}

	/**
	 * Retorna um conjunto contendo os valores rgb para cada pixel da imagem.
	 * @param imagem imagem base.
	 * @return conjunto de dados.
	 */
	public int[][] getDadosImagem(BufferedImage imagem) {
		int largura = imagem.getWidth();
		int altura = imagem.getHeight();
		int info = 1 + 1 + 3;// x + y + r + g + b
		
		int[][] dados = new int[largura*altura][info];
		
		for (int y = 0; y < largura; y++) {
			for (int x = 0; x < altura; x++) {
				int r = getR(imagem, x, y);
				int g = getG(imagem, x, y);
				int b = getB(imagem, x, y);
			
				int linha = y * largura + x;
				dados[linha][0] = x;
				dados[linha][1] = y;
				dados[linha][2] = r;
				dados[linha][3] = g;
				dados[linha][4] = b;
			}
		}
		
		return dados;
	}

}
