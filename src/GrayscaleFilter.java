public class GrayscaleFilter implements ImageTransformer {

    @Override
    public ImageMatrix apply(ImageMatrix image) {
        int width = image.getWidth();
        int height = image.getHeight();
        
        // Create a new blank matrix for the output
        ImageMatrix result = new ImageMatrix(width, height);
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel p = image.getPixel(x, y);
                
                // Calculate the average of the red, green, and blue values
                int average = (p.r + p.g + p.b) / 3;
                
                // Set the new pixel with the average value for all three colors
                result.setPixel(x, y, new Pixel(average, average, average));
            }
        }
        
        System.out.println("Applied Grayscale filter.");
        return result;
    }
}