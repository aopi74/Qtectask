package qtectask102;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class Qtectask102 {

     public static void main(String[] args) {
        // Path to the input text file
        String filePath = "input.txt";

        // TreeMap to store word counts in alphabetical order
        Map<String, Integer> wordCountMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using whitespace as delimiter
                String[] words = line.split("\\s+");

                // Process each word
                for (String word : words) {
                    // Remove punctuation marks and convert to lowercase
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    // Increment the count of the word in the map
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Display word counts in alphabetical order
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
