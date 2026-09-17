public class BlurFilter implements ImageTransformer {

    @Override
    public ImageMatrix apply(ImageMatrix image) {
        int width = image.getWidth();
        int height = image.getHeight();
        ImageMatrix result = new ImageMatrix(width, height);
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int sumRed = 0, sumGreen = 0, sumBlue = 0;
                int count = 0;
                
                // Check a 3x3 grid around the current pixel
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int currentY = y + dy;
                        int currentX = x + dx;
                        
                        // Ensure we don't go out of bounds on the edges
                        if (currentY >= 0 && currentY < height && currentX >= 0 && currentX < width) {
                            Pixel p = image.getPixel(currentX, currentY);
                            sumRed += p.r;
                            sumGreen += p.g;
                            sumBlue += p.b;
                            count++;
                        }
                    }
                }
                
                result.setPixel(x, y, new Pixel(sumRed / count, sumGreen / count, sumBlue / count));
            }
        }
        
        System.out.println("Applied Blur filter.");
        return result;
    }
}