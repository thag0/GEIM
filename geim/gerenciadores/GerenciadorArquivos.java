package geim.gerenciadores;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

/**
 * Gerenciador de arquivos do Geim
 */
public class GerenciadorArquivos {
	
	/**
	 * Contém as implementações de gestão de arquivos do Geim
	 */
	public GerenciadorArquivos() {}

	/**
	 * Lê um arquivo de imagem.
	 * @param caminho caminho do arquivo.
	 * @return imagem lida.
	 */
	public BufferedImage lerImagem(String caminho) {
		File arquivo = new File(caminho);
		if (!arquivo.exists()) {
			throw new IllegalArgumentException(
				"\nDiretório \"" + caminho + "\" não encontrado."
			);
		}
  
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new FileInputStream(arquivo));
		} catch (IOException e) {
			System.out.println("\nErro ao ler a imagem \"" + caminho + "\"");
			e.printStackTrace();
		}
  
		return img;
	}
  	
}
