public class ImageMatrix {
    private Pixel[][] pixels;
    private int width;
    private int height;

    public ImageMatrix(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new Pixel[height][width];
    }

    public void setPixel(int x, int y, Pixel p) {
        pixels[y][x] = p;
    }

    public Pixel getPixel(int x, int y) {
        return pixels[y][x];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}