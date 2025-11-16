package geim;

import java.awt.image.BufferedImage;

import geim.desenho.DrawFrame;

/**
 * <p>
 *    Gerenciador de Imagens.
 * </p>
 * Oferece utilitários para manipulação e processamento de imagens em formato RGB ou escala de cinza.
 * Permite ler imagens, gerar estruturas de dados a partir das imagens, configurar cores, exibir informações 
 * de cores, exportar imagens em formato PNG e ampliar imagens usando uma rede neural treinada.
 */
public class Geim {

	private GerenciadorArquivos ga;
	private GerenciadorDadosImagem gdi;

	/**
	 * Objeto responsável por fazer operações com imagens.
	 * <p>
	 *    Trabalha com imagens no formato {@code Imagem}.
	 * </p>
	 */
	public Geim() {
		ga = new GerenciadorArquivos();
		gdi = new GerenciadorDadosImagem();
	}

	/**
	 * Lê uma imagem do caminho fornecido e retorna a imagem como um objeto BufferedImage.
	 * @param caminho o caminho da imagem a ser lida. Deve ser um caminho relativo ou absoluto para o arquivo de imagem, deve
	 * conter a extensão do arquivo.
	 * @return a imagem lida como um objeto BufferedImage.
	 * @throws IllegalArgumentException se ocorrer um erro durante a leitura da imagem ou se a imagem não puder ser encontrada.
	 */
	public BufferedImage lerImagem(String caminho) {
		return ga.lerImagem(caminho);
	}

	/**
	 * Gera uma estrutura de dados do tipo {@code Imagem} contendo as informações de cada cor 
	 * em cada pixel da imagem.
	 * <p>
	 *    Todos os valores de cores da imagem serão copiados para a estrutura de dados.
	 * </p>
	 * @param imagem imagem com suas dimensões e cores.
	 * @return estrutura de dados baseada na imagem.
	 * @throws IllegalArgumentException se a imagem for nula.
	 * @throws IllegalArgumentException se a largura da imagem for menor ou igual a zero.
	 * @throws IllegalArgumentException se a altura da imagem for menor ou igual a zero.
	 */
	public Imagem gerarEstruturaImagem(BufferedImage imagem) {
		return gdi.gerarImagem(imagem);
	}

	/**
	 * Gera uma estrutura de dados do tipo {@code Pixel[][]}, a estrutura terá seus elementos inicializados
	 * como 0.
	 * @param largura largura desejada para a estrutura da imagem.
	 * @param altura altura desejada para a estrutura da imagem.
	 * @return estrutura de dados baseada no tamanho fornecido.
	 * @throws IllegalArgumentException se os valores de altura e largura forem menores ou iguais a zero.
	 */
	public Imagem gerarEstruturaImagem(int largura, int altura) {
		return gdi.gerarImagem(largura, altura);
	}

	/**
	 * Define a configuração de cor RGB em um pixel específico da estrutura da imagem.
	 * @param img {@code Imagem} base.
	 * @param x coordenada x do pixel.
	 * @param y cooredana y do pixel.
	 * @param r valor de intensidade da cor vermelha no pixel especificado.
	 * @param g valor de intensidade da cor verde no pixel especificado.
	 * @param b valor de intensidade da cor azul no pixel especificado.
	 * @throws IllegalArgumentException se a estrutura de dados da imagem estiver nula.
	 * @throws IllegalArgumentException se o valor de x ou y estiver fora dos índices válidos de acordo 
	 * com o tamanho da estrutura da imagem.
	 */
	public void setCor(Imagem img, int x, int y, int r, int g, int b) {
		gdi.setCor(img, x, y, r, g, b);
	}

	/**
	 * Preenche todos os dados da estrutura de imagem com o mesmo valor
	 * de cor RGB.
	 * @param img {@code Imagem} base.
     * @param r intensidade da cor vermelha.
     * @param g intensidade da cor verde.
     * @param b intensidade da cor azul.
	 */
	public void preencher(Imagem img, int r, int g, int b) {
		gdi.preencher(img, r, g, b);
	}

	/**
	 * Captura o valor de cor vermelha de cada pixel da imagem.
	 * @param img imagem com os valore de cores.
	 * @return matriz com o valor de cor vermelha de cada pixel.
	 */
	public int[][] getR(BufferedImage img) {
		return gdi.getR(img);
	}

	/**
	 * Captura o valor de cor verde de cada pixel da imagem.
	 * @param img imagem com os valore de cores.
	 * @return matriz com o valor de cor verde de cada pixel.
	 */
	public int[][] getG(BufferedImage img) {
		return gdi.getG(img);
	}

	/**
	 * Captura o valor de cor azul de cada pixel da imagem.
	 * @param img imagem com os valore de cores.
	 * @return matriz com o valor de cor azul de cada pixel.
	 */
	public int[][] getB(BufferedImage img) {
		return gdi.getB(img);
	}

	/**
	 * Captura o valor de escala de cinza de cada pixel da imagem.
	 * @param img imagem com os valore de cores.
	 * @return matriz com o valor de escala de cinza de cada pixel.
	 */
	public int[][] getGray(BufferedImage img) {
		return gdi.getGray(img);
	}

	/**
	 * Exibe via terminal os valores de intensidade de cor vermelha, verde e azul 
	 * de cada elemento da estrutura da imagem.
	 * @param img estrutura de dados da imagem.
	 */
	public void desenhar(Imagem img, double escala) {
		int w = (int) (img.largura() * escala);
		int h = (int) (img.altura() * escala);
		DrawFrame df = new DrawFrame(w, h);
		df.exibir(img);
	}

	/**
	 * Salva a estrutura de imagem em um arquivo de imagem {@code png}.
	 * @param img {@code Imagem} base.
	 * @param caminho caminho relativo, deve conter o nome do arquivo, sem extensão
	 */
	public void paraPNG(Imagem img, String caminho) {
		img.paraPNG(caminho);
	}

	/**
	 * Captura os dados das posições dos pixeis e seus valores de cor rgb,
	 * de acordo com o seguinte formato:
	 * <pre>
	 *    linha = [x][y][r][g][b]
	 * </pre>
	 * Cada linha representará a informação de um pixel individual.
	 * @param imagem imagem desejada
	 * @return estrutura de dados baseada na imagem.
	 */
	public int[][] obterDadosImagem(BufferedImage imagem) {
		return gdi.getDadosImagem(imagem);
	}

}
