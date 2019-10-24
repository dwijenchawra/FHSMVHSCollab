import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBin {
    private ArrayList<String> blackList;

    public WordBin() {
        blackList = new ArrayList<>();
    }

    public void checkSentence (String sentence) {
//        boolean directedAt = false;
//        if (sentence.contains("")) {
//            //TODO: get dataset with determining phrases
//            directedAt = true;
//        }
        for (String word : blackList) {
            if (sentence.contains(word)) { //and if directed at someone
                System.out.println("Sentence is discriminatory because of word: "+word);
            }
        }
    }

    public void addWord(String word) {
        if (!blackList.contains(word)) {
            blackList.add(word);
        }
    }

    public void addFromFile(String filename) {
        String text = readFileAsString(filename);
        String[] words = text.split(",");
        for (String word : words) {
            if (!blackList.contains(word)) {
                blackList.add(word);
            }
        }
    }

    public ArrayList<String> getBlackList() {
        return blackList;
    }

    public static String readFileAsString(String filename) {
        Scanner scanner;
        StringBuilder output = new StringBuilder();

        try {
            scanner = new Scanner(new FileInputStream(filename), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.append(line.trim() + "\n");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }

        return output.toString();
    }
}
