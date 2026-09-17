import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Image Filtering Engine ---");
        System.out.print("Enter the path to the source image (e.g., input.jpg): ");
        String inputPath = scanner.nextLine();

        // 1. Load the image
        ImageMatrix sourceImage = ImageIOHandler.loadImage(inputPath);

        // If the image loaded successfully, proceed with the filter
        if (sourceImage != null) {
            // 2. Apply the filter using the Interface
            ImageTransformer grayscale = new GrayscaleFilter();
            ImageMatrix processedImage = grayscale.apply(sourceImage);

            // 3. Save the new image
            System.out.print("Enter the path to save the new image (e.g., output.jpg): ");
            String outputPath = scanner.nextLine();
            ImageIOHandler.saveImage(processedImage, outputPath);
            
            System.out.println("Processing complete!");
        } else {
            System.out.println("Failed to load the image. Exiting program.");
        }

        scanner.close();
    }
}