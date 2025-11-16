package geim.desenho;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import geim.Imagem;
import geim.Pixel;

public class DrawPanel extends JPanel {

    /**
     * Imagem base para desenho.
     */
    BufferedImage img;

    /**
     * Inicializa um novo painel para desenho.
     * @param w largura.
     * @param h altura.
     */
    public DrawPanel(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        setFocusable(true);
        setEnabled(true);
    }

    /**
     * Transforma uma {@code Imagem} em {@code BufferedImage} para desenho.
     * @param img {@code Imagem} base.
     * @return {@code BufferedImage} convertida.
     */
    private BufferedImage imagemParaBufferedImgage(Imagem img) {
        BufferedImage bi = new BufferedImage(img.largura(), img.altura(), BufferedImage.TYPE_INT_RGB);
        
        for (int y = 0; y < img.altura(); y++) {
            for (int x = 0; x < img.largura(); x++) {
                Pixel p = img.get(x, y);
                int rgb = p.getR() << 16 | p.getG() << 8 | p.getB();
                bi.setRGB(x, y, rgb);
            }
        }

        return bi;
    }

    /**
     * Exibe uma imagem em janela gráfica.
     * @param img {@code Imagem} base.
     */
    public void exibir(Imagem img) {
        this.img = imagemParaBufferedImgage(img);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

}
