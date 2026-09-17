import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageIOHandler {
    
    // Reads an image file from the hard drive and converts it into our ImageMatrix
    public static ImageMatrix loadImage(String filepath) {
        try {
            File file = new File(filepath);
            BufferedImage img = ImageIO.read(file);
            
            int width = img.getWidth();
            int height = img.getHeight();
            ImageMatrix matrix = new ImageMatrix(width, height);
            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color color = new Color(img.getRGB(x, y));
                    matrix.setPixel(x, y, new Pixel(color.getRed(), color.getGreen(), color.getBlue()));
                }
            }
            System.out.println("Successfully loaded: " + filepath);
            return matrix;
            
        } catch (IOException e) {
            System.out.println("Error loading image. Please check the file path.");
            System.out.println("Details: " + e.getMessage());
            return null; // Gracefully handles the error instead of crashing
        }
    }

    // Converts our ImageMatrix back into an image file and saves it
    public static void saveImage(ImageMatrix matrix, String filepath) {
        if (matrix == null) {
            System.out.println("Error: Cannot save an empty image.");
            return;
        }

        try {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Pixel p = matrix.getPixel(x, y);
                    Color color = new Color(p.r, p.g, p.b);
                    img.setRGB(x, y, color.getRGB());
                }
            }
            
            File outputFile = new File(filepath);
            ImageIO.write(img, "jpg", outputFile); 
            System.out.println("Successfully saved to: " + filepath);
            
        } catch (IOException e) {
            System.out.println("Error saving image.");
            System.out.println("Details: " + e.getMessage());
        }
    }
}