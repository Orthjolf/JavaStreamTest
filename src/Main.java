import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        final List<String> words = Main.readWordsFromFile("testCases/testCase1.txt");
        final Map<String, Integer> map = Main.getWordsSortedByCount(words);

        map.forEach((k, v) -> System.out.println(k + ' ' + v));
    }

    /**
     * Get count of each word in list and put it to sorted map
     *
     * @param words - list of words to count
     * @return - map of sorted words by count
     */
    public static Map<String, Integer> getWordsSortedByCount(List<String> words) {
        return new HashSet<>(words).stream()
                .collect(Collectors.toMap(s -> s, s -> words.stream().filter(x -> x.equals(s)).toArray().length))
                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    /**
     * Read file and get all words from it
     *
     * @param filePath - path to file with words
     * @return - ArrayList of words, separated by \n
     * @throws IOException - exception if file not found
     */
    public static List<String> readWordsFromFile(String filePath) throws IOException {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            return Arrays.asList(content.split("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
