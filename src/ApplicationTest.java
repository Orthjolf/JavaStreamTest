import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationTest {

    @Test
    public void readFileTest() throws IOException {
        List<String> actual = Main.readWordsFromFile("testCases/testCase0.txt");
        List<String> expected = Arrays.asList("стол", "Стол", "СтоЛ", "стоЛ", "Столы", "столы");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void processingTest() throws IOException {
        List<String> words = Main.readWordsFromFile("testCases/testCase0.txt");
        Map<String, Integer> actual = Main.getWordsSortedByCount(words);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("стоЛ", 1);
        expected.put("стол", 1);
        expected.put("Столы", 1);
        expected.put("столы", 1);
        expected.put("СтоЛ", 1);
        expected.put("Стол", 1);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void processingTest2() throws IOException {
        List<String> words = Main.readWordsFromFile("testCases/testCase2.txt");
        Map<String, Integer> actual = Main.getWordsSortedByCount(words);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Aa", 1);
        expected.put("a", 1);
        expected.put("aaaa", 1);
        expected.put("aaa", 2);
        expected.put("aa", 2);
        Assert.assertEquals(actual, expected);
    }
}
