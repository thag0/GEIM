import geim.GImg;

public class Main {
    public static void main(String[] args) {
        GImg img = new GImg(10, 10);
        var pixel = img.get(0, 0);
        pixel.setB(10);
        System.out.println(pixel);
    }
}
