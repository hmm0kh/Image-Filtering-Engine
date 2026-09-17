import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Image Filtering Engine ---");
        System.out.print("Enter source image path (e.g., input.jpg): ");
        String inputPath = scanner.nextLine();

        ImageMatrix sourceImage = ImageIOHandler.loadImage(inputPath);

        if (sourceImage != null) {
            System.out.println("\nSelect a filter:");
            System.out.println("1. Grayscale");
            System.out.println("2. Sepia");
            System.out.println("3. Blur");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            // Use the Interface to apply the chosen strategy dynamically
            ImageTransformer filter;
            if (choice == 2) {
                filter = new SepiaFilter();
            } else if (choice == 3) {
                filter = new BlurFilter();
            } else {
                filter = new GrayscaleFilter();
            }
            
            ImageMatrix processedImage = filter.apply(sourceImage);

            System.out.print("Enter save path (e.g., output.jpg): ");
            String outputPath = scanner.nextLine();
            ImageIOHandler.saveImage(processedImage, outputPath);
            
            System.out.println("Processing complete!");
        } else {
            System.out.println("Failed to load the image.");
        }

        scanner.close();
    }
}