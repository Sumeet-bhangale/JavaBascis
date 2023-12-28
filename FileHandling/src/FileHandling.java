import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read from a file
        readFile("example.txt");

        // Write to a file
        System.out.println("Enter content to write to the file:");
        String contentToWrite = scanner.nextLine();
        writeFile("example.txt", contentToWrite);

        // Append to a file
        System.out.println("Enter content to append to the file:");
        String contentToAppend = scanner.nextLine();
        appendFile("example.txt", contentToAppend);

        // Read again after write and append
        readFile("example.txt");

        scanner.close();
    }

    static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading from file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    static void appendFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("\n" + content); // Append on a new line
            System.out.println("File appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending to the file.");
            e.printStackTrace();
        }
    }
}
