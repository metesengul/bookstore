package bookstore;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

    static String directory = "./src/data/";

    // Reads from file and returns it as string.
    public static String read(String file) {
        String result = "";
        try {
            FileReader reader = new FileReader(File.directory + file);
            int character;

            while ((character = reader.read()) != -1) {
                result = result + (char) character;
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Writes string content to a file.
    public static void write(String file, String content) {
        try {
            FileWriter writer = new FileWriter(File.directory + file, false);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adds string content to a file.
    public static void append(String file, String content) {
        try {
            FileWriter writer = new FileWriter(File.directory + file, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
