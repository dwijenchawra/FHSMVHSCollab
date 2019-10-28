import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class WordBinTester {
    private static WordBin wordBin = new WordBin();

    public static void main(String[] args) {


        wordBin.addFromFiles("data/discrimWords1.csv", "data/determining_phrases.csv");
        wordBin.addWord("idiot");

        System.out.println(wordBin.getBlackList());
        System.out.println(wordBin.getDeterminingPhrases());
        System.out.println(wordBin.checkSentence("you are stupid idiot"));
        errorChecker("");
        interactiveMode();


    }

    private static double errorChecker(String filePath) {
        ArrayList<String> dicscriminatoryPhrases = new ArrayList<>();
        //todo add way to get phrases from csv
        for (String phrase : dicscriminatoryPhrases) {

        }
    }

    private static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        String sentence = "";
        ArrayList<String> inputs = new ArrayList<>();
        while (!sentence.equals("x")) {
            System.out.println("Enter a sentence to say (enter x to exit): ");
            sentence = scanner.nextLine();
            if (wordBin.checkSentence(sentence)) {
                String answer;
                do {
                    System.out.println("Are you sure you want to say this? This may be harmful. (y/n): ");
                    answer = scanner.next();
                    if (answer.equals("y")) {
                        inputs.add(sentence);
                    }
                } while (!answer.equals("y") && !answer.equals("n"));
            }
        }
        System.out.println("\nYOUR CONVERSATION:");
        for (String input : inputs) {
            System.out.println(input);
        }
    }

    public static String readFileAsString(String filename) {
        Scanner scanner;
        StringBuilder output = new StringBuilder();

        try {
            scanner = new Scanner(new FileInputStream(filename), StandardCharsets.UTF_8);
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
