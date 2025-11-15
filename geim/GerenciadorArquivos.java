package geim;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

/**
 * Gerenciador de arquivos do Geim
 */
class GerenciadorArquivos {
	
	/**
	 * Contém as implementações de gestão de arquivos do Geim
	 */
	public GerenciadorArquivos() {}

	/**
	 * 
	 * @param caminho
	 * @return
	 */
	public BufferedImage lerImagem(String caminho) {
		File arquivo = new File(caminho);
		if (!arquivo.exists()) {
			throw new IllegalArgumentException(
				"Diretório \"" + caminho + "\" não encontrado."
			);
		}
  
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new FileInputStream(arquivo));
		} catch (IOException e) {
			System.out.println("Erro ao ler a imagem \"" + caminho + "\"");
			e.printStackTrace();
		}
  
		return img;
	}
  
	/**
	 * 
	 * @param estruturaImagem
	 * @param caminho
	 */
	public void exportarPng(Pixel[][] estruturaImagem, String caminho) {
		int alturaImagem = estruturaImagem.length;
		int larguraImagem = estruturaImagem[0].length;

		BufferedImage imagem = new BufferedImage(larguraImagem, alturaImagem, BufferedImage.TYPE_INT_RGB);

		int r = 0;
		int g = 0;
		int b = 0;
		int rgb = 0;

		for (int y = 0; y < alturaImagem; y++) {
			for (int x = 0; x < larguraImagem; x++) {
				r = estruturaImagem[y][x].getR();
				g = estruturaImagem[y][x].getG();
				b = estruturaImagem[y][x].getB();

				rgb = (r << 16) | (g << 8) | b;
				imagem.setRGB(x, y, rgb);
			}
		}

		try {
			File arquivo = new File((caminho + ".png"));
			ImageIO.write(imagem, "png", arquivo);

		} catch (Exception e) {
			System.out.println("Erro ao exportar imagem");
			e.printStackTrace();
		}
	}
	
}
