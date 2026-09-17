public class Pixel {
    int r, g, b;

    public Pixel(int r, int g, int b) {
        this.r = truncate(r);
        this.g = truncate(g);
        this.b = truncate(b);
    }

    // Ensures color values stay within valid byte bounds
    private int truncate(int value) {
        if (value < 0) return 0;
        if (value > 255) return 255;
        return value;
    }
}