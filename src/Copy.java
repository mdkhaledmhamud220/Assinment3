import java.io.*;
import java.nio.file.*;

public class Copy {

    public static void copyFile(String sourcePath, String destPath) {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            // Check if source file exists
            if (!sourceFile.exists()) {
                System.out.println("Error: Source file does not exist.");
                return;
            }

            // Copy file
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Success message
            System.out.println("Source file copied to destination successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred - " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Error: Permission denied - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Copy <source file> <destination file>");
            return;
        }

        String sourcePath = args[0];
        String destPath = args[1];

        copyFile(sourcePath, destPath);
    }
}

