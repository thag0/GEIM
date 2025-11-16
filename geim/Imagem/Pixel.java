package geim.Imagem;

/**
 * Pixel RGB.
 */
public class Pixel {

   /**
    * intensidade da cor vermelha.
    */
   private int r;
    
   /**
    * intensidade da cor verde.
    */
   private int g;

   /**
    * intensidade da cor azul.
    */
   private int b;

   /**
    * Cria uma intância de um pixel.
    * <p>
    *    Os valores de intensidade de cada cor serão inicializados de acordo
    *    com os valores fornecidos.
    * </p>
    * @param r intensidade da cor vermelha.
    * @param g intensidade da cor verde.
    * @param b intensidade da cor azul.
    */
   public Pixel(int r, int g, int b) {
      setR(r);
      setG(g);
      setB(b);
   }

   /**
    * Cria uma intância de um pixel.
    * <p>
    *    Os valores de intensidade de cada cor serão inicializados como 0.
    * </p>
    */
   public Pixel() {
      this(0, 0, 0);
   }

   /**
    * Configura o valor de cor vermelha do pixel.
    * <p><strong>
    *    Valores acima de 255 serão automaticamente configurados como 255.
    * </strong></p>
    * <p><strong>
    *    Valores abaixo de 0 serão automaticamente configurados como 0.
    * </strong></p>
    * @param r novo valor de cor vermelha.
    */
   public void setR(int r) {
      int val = Math.clamp(r, 0, 255);
      this.r = val;
   }

   /**
    * Configura o valor de cor verde do pixel.
    * <p><strong>
    *    Valores acima de 255 serão automaticamente configurados como 255.
    * </strong></p>
    * <p><strong>
    *    Valores abaixo de 0 serão automaticamente configurados como 0.
    * </strong></p>
    * @param g novo valor de cor verde.
    */
   public void setG(int g) {
      int val = Math.clamp(g, 0, 255);
      this.g = val;
   }

   /**
    * Configura o valor de cor azul do pixel.
    * <p><strong>
    *    Valores acima de 255 serão automaticamente configurados como 255.
    * </strong></p>
    * <p><strong>
    *    Valores abaixo de 0 serão automaticamente configurados como 0.
    * </strong></p>
    * @param b novo valor de cor azul.
    */
   public void setB(int b) {
      int val = Math.clamp(b, 0, 255);
      this.b = val;
   }

   /**
    * Configura os valores de cor do pixel.
    * @param r intensidade da cor vermelha.
    * @param g intensidade da cor verde.
    * @param b intensidade da cor azul.
    */
   public void setRGB(int r, int g, int b) {
      setR(r);
      setG(g);
      setB(b);
   }

   /**
    * Retorna o valor de intensidade da cor vermelha do pixel.
    * @return valor de intensidade da cor vermelha do pixel.
    */
   public int getR() {
      return r;
   }

   /**
    * Retorna o valor de intensidade da cor verde do pixel.
    * @return valor de intensidade da cor verde do pixel.
    */
   public int getG() {
      return g;
   }

   /**
    * Retorna o valor de intensidade da cor azul do pixel.
    * @return valor de intensidade da cor azul do pixel.
    */
   public int getB() {
      return b;
   }

   /**
    * Monta as informaçãoes sobre o pixel para exibição.
    * @return informações geradas.
    */
   private String info() {
      StringBuilder sb = new StringBuilder();

      String pad = " ".repeat(4);

      sb.append("Pixel = [\n");
      sb.append(pad).append("R: ").append(r).append("\n");
      sb.append(pad).append("G: ").append(g).append("\n");
      sb.append(pad).append("B: ").append(b).append("\n");
      sb.append("]\n");

      return sb.toString();
   }

   /**
    * Exibe via terminal o conteúdo do pixel.
    */
   public void print() {
      System.out.println(info());
   }

   @Override
   public String toString() {
      return info();
   }

}
