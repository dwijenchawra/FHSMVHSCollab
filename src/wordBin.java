import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class wordBin {
    private ArrayList<String> blackList;

    public wordBin(){

    }

    public void addWord(String word){
        if(notInList(word)){
            blackList.add(word);
        }
    }

    private boolean notInList(String newWord) {
        for (String word:blackList) {
            if(word.equals(newWord)){
                return false;
            }
        }return true;
    }

    public void addFromFile(String filename){
        String text = readFileAsString(filename);
        String [] words = text.split(",");
        for (String word:words) {
            if(notInList(word)){
                blackList.add(word);
            }
        }
    }

    public static String readFileAsString(String filename) {
        Scanner scanner;
        StringBuilder output = new StringBuilder();

        try {
            scanner = new Scanner(new FileInputStream(filename), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                output.append(line.trim()+"\n");
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }

        return output.toString();
    }
}
