public class SepiaFilter implements ImageTransformer {

    @Override
    public ImageMatrix apply(ImageMatrix image) {
        int width = image.getWidth();
        int height = image.getHeight();
        ImageMatrix result = new ImageMatrix(width, height);
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel p = image.getPixel(x, y);
                
                // Standard sepia matrix formulas
                int sepiaRed = (int)(0.393 * p.r + 0.769 * p.g + 0.189 * p.b);
                int sepiaGreen = (int)(0.349 * p.r + 0.686 * p.g + 0.168 * p.b);
                int sepiaBlue = (int)(0.272 * p.r + 0.534 * p.g + 0.131 * p.b);
                
                // The Pixel class constructor automatically caps these at 255
                result.setPixel(x, y, new Pixel(sepiaRed, sepiaGreen, sepiaBlue));
            }
        }
        
        System.out.println("Applied Sepia filter.");
        return result;
    }
}