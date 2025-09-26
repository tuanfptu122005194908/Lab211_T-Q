
import java.util.*;
import java.util.StringTokenizer;
import java.util.Locale;

public class LetterAndCharacterCount {

    private String input;
    private Map<String, Integer> wordCount;
    private Map<Character, Integer> letterCount;

    public LetterAndCharacterCount(String input) {
        this.input = input;
        this.wordCount = new LinkedHashMap<>();
        this.letterCount = new LinkedHashMap<>();
    }

    // Đếm từ
    public void analyzeWords() {
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            // loại bỏ ký tự đặc biệt ở đầu/cuối
            String cleaned = token.replaceAll("[^\\p{L}\\p{Nd}]+", "");
            if (cleaned.isEmpty()) {
                continue;
            }
            cleaned = cleaned.toLowerCase(Locale.ROOT);
            wordCount.put(cleaned, wordCount.getOrDefault(cleaned, 0) + 1);
        }
    }

    // Đếm chữ cái
    public void analyzeLetters() {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                letterCount.put(lower, letterCount.getOrDefault(lower, 0) + 1);
            }
        }
    }

    // In kết quả
    public void displayResult() {
        System.out.println(wordCount);
        System.out.println(letterCount);
    }
}
