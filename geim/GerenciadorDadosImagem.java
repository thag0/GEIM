package geim;

import java.awt.image.BufferedImage;

/**
 * Gerenciador de dados de imagem para o Geim
 */
class GerenciadorDadosImagem {
	
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
	 * Retorna os dados de cor vermelha para todos os pixels da imagem.
	 * @param imagem imagem base.
	 * @return valores de cor vermelha.
	 */
	public int[][] getR(BufferedImage imagem) {
		int largura = imagem.getWidth();
		int altura = imagem.getHeight();

		int[][] r = new int[altura][largura];
		for(int y = 0; y < altura; y++){
			for(int x = 0; x < largura; x++){
				r[y][x] = getR(imagem, x, y);
			}
		}

		return r;
	}

	/**
	 * Retorna os dados de cor verde para todos os pixels da imagem.
	 * @param imagem imagem base.
	 * @return valores de cor verde.
	 */
	public int[][] getG(BufferedImage imagem) {
		int largura = imagem.getWidth();
		int altura = imagem.getHeight();

		int[][] g = new int[altura][largura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				g[y][x] = getG(imagem, x, y);
			}
		}

		return g;
	}

	/**
	 * Retorna os dados de cor azul para todos os pixels da imagem.
	 * @param imagem imagem base.
	 * @return valores de cor azul.
	 */
	public int[][] getB(BufferedImage imagem) {
		int largura = imagem.getWidth();
		int altura = imagem.getHeight();

		int[][] b = new int[altura][largura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				b[y][x] = getB(imagem, x, y);
			}
		}

		return b;
	}

	/**
	 * Retorna os dados de cor em escala de cinza para todos os pixels da imagem.
	 * @param imagem imagem base.
	 * @return valores de cor cinza.
	 */
	public int[][] getGray(BufferedImage imagem) {
		int largura = imagem.getWidth();
		int altura = imagem.getHeight();

		int[][] cinza = new int[altura][largura];
		for (int y = 0; y < altura; y++) {
			for (int x = 0; x < largura; x++) {
				int r = getR(imagem, x, y);
				int g = getG(imagem, x, y);
				int b = getB(imagem, x, y);
				int c = (r + g + b) / 3;
				cinza[y][x] = c;
			}
		}

		return cinza;
	}

	/**
	 * Retorna o valor de cor vermelha para um pixel específico da imagem.
	 * @param imagem imagem base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
	 * @return valor de instensidade da cor vermelha.
	 */
	public int getR(BufferedImage imagem, int x, int y) {
		int rgb = imagem.getRGB(x, y);
		int r = (rgb >> 16) & 0xFF;
		return r;
	}

	/**
	 * Retorna o valor de cor verde para um pixel específico da imagem.
	 * @param imagem imagem base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
	 * @return valor de instensidade da cor verde.
	 */
	public int getG(BufferedImage imagem, int x, int y) {
		int rgb = imagem.getRGB(x, y);
		int g = (rgb >> 8) & 0xFF;
		return g;
	}

	/**
	 * Retorna o valor de cor azul para um pixel específico da imagem.
	 * @param imagem imagem base.
	 * @param x posição vertical.
	 * @param y posição horizontal.
	 * @return valor de instensidade da cor azul.
	 */
	public int getB(BufferedImage imagem, int x, int y) {
		int rgb = imagem.getRGB(x, y);
		int b = rgb & 0xFF;
		return b;
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
