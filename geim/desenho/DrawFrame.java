package geim.desenho;

import javax.swing.JFrame;

import geim.Imagem.Imagem;

public class DrawFrame extends JFrame {
    
    /**
     * Painel de desenho de imagem;
     */
    DrawPanel dp;

    /**
     * Inicializa uma jane para desenho de {@code Imagem} em interface gráfica.
     * @param w largura da janela.
     * @param h altura da janela.
     */
    public DrawFrame(int w, int h) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dp = new DrawPanel(w, h);
		
        setVisible(true);
		add(dp);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
    }

    /**
     * Exibe uma imagem em janela gráfica.
     * @param img {@code Imagem} base.
     * @param titulo título da janela.
     */
    public void exibir(Imagem img, String titulo) {
        dp.exibir(img);

        if (titulo != null) {
            setTitle(titulo);
        }

        setVisible(true);
    }

    /**
     * Exibe uma imagem em janela gráfica.
     * @param img {@code Imagem} base.
     */
    public void exibir(Imagem img) {
        exibir(img, "Imagem");
    }
}
