import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LongestCompoundWord {
    public static void main(String[] args) throws IOException {
        ArrayList<String> dictionary = new ArrayList<>();
        Trie trie = new Trie();
        long startTime = System.currentTimeMillis(); // starting time
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input_01.txt")); // Replace with file path
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line
                String[] lineStrings = line.split("\\s+");
                for (String word : lineStrings) {
                    dictionary.add(word);
                    trie.insert(word);
                }
            }

            reader.close();
        } catch (IOException err) {
            System.out.println("Error reading the file: " + err.getMessage());
        }

        // String longestWord = trie.getLongestCompoundWord(); // find longest compound
        // word
        // String secondLongest = trie.getSecondLongestCompoundWord(); // find second
        // longest compound word

        String[] ans = trie.findLongestCompoundWords(dictionary);

        long endTime = System.currentTimeMillis(); // end time
        long totalTime = endTime - startTime;

        System.out.println("Longest compound word: " + ans[0]);
        System.out.println("Second longest compound word: " + ans[1]);
        System.out.println("Total time taken: " + totalTime);
    }

}