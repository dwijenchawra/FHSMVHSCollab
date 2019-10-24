import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBin {
    private ArrayList<String> blackList;
    private ArrayList<String> determiningPhrases;

    public WordBin() {
        blackList = new ArrayList<>();
        determiningPhrases = new ArrayList<>();
    }

    public boolean checkSentence (String sentence) {
        boolean referringToSomeone = false;
        boolean hasDiscriminatoryWord = false;

        for (String word : determiningPhrases) {
            if (sentence.contains(word)) {
                referringToSomeone = true;
            }
        }

        for (String word : blackList) {
            if (sentence.contains(word)) {
                hasDiscriminatoryWord = true;
            }
        }

        return referringToSomeone && hasDiscriminatoryWord;
    }

    public void addWord(String word) {
        if (!blackList.contains(word)) {
            blackList.add(word);
        }
    }

    public ArrayList<String> getDeterminingPhrases() {
        return determiningPhrases;
    }

    public void addFromFiles(String blacklistWords, String determiningPhrasesWords) {
        String text = readFileAsString(blacklistWords);
        String[] words = text.split(",");
        for (String word : words) {
            if (!blackList.contains(word)) {
                blackList.add(word);
            }
        }
        String text2 = readFileAsString(determiningPhrasesWords);
        String[] words2 = text.split(",");
        for (String word : words2) {
            if (!determiningPhrases.contains(word)) {
                determiningPhrases.add(word);
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
