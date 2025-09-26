
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content:");
        String input = sc.nextLine();

        LetterAndCharacterCount analyzer = new LetterAndCharacterCount(input);

        analyzer.analyzeWords();
        analyzer.analyzeLetters();
        analyzer.displayResult();
    }
}
