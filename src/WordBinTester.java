public class WordBinTester {
    public static void main(String[] args) {
        WordBin wordBin = new WordBin();

        wordBin.addFromFiles("data/discrimWords1.csv", "data/determining_phrases.csv");
        wordBin.addWord("idiot");
        System.out.println(wordBin.getBlackList());
        System.out.println(wordBin.getDeterminingPhrases());
        System.out.println(wordBin.checkSentence("you are stupid"));


    }
}
