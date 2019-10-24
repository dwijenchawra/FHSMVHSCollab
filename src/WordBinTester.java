public class WordBinTester {
    public static void main(String[] args) {
        WordBin wordBin = new WordBin();

        wordBin.addFromFile("data/discrimWords1.csv");
        wordBin.addWord("idiot");
        System.out.println(wordBin.getBlackList());
        System.out.println(wordBin.checkSentence("you are stupid"));


    }
}
