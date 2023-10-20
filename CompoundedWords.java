import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

public class CompoundedWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a list of words: ");
        List<String> words = new ArrayList<>();
        String input;

        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                break; 
            }
            words.add(input);
        }

        words = words.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        String longestCompoundedWord = findLongestCompoundedWord(words);
        String secondLongestCompoundedWord = findSecondLongestCompoundedWord(words, longestCompoundedWord);

        System.out.println("Longest Compound Word: " + longestCompoundedWord);
        System.out.println("Second Longest Compound Word: " + secondLongestCompoundedWord);
    }

    private static boolean isCompounded(String word, Set<String> wordSet, Map<String, Boolean> memo) {
        if (word.isEmpty()) {
            return true;
        }
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (wordSet.contains(prefix)) {
                String suffix = word.substring(i);
                if (wordSet.contains(suffix) || isCompounded(suffix, wordSet, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }
        memo.put(word, false);
        return false;
    }

    private static String findLongestCompoundedWord(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        for (int i = words.size() - 1; i >= 0; i--) {
            String word = words.get(i);
            wordSet.remove(word); // Exclude the current word from wordSet
            if (isCompounded(word, wordSet, new HashMap<>())) {
                return word;
            }
            wordSet.add(word); // Add back the word for future checks
        }
        return "";
    }

    private static String findSecondLongestCompoundedWord(List<String> words, String longestWord) {
        Set<String> wordSet = new HashSet<>(words);
        boolean longestFound = false;
        for (int i = words.size() - 1; i >= 0; i--) {
            String word = words.get(i);
            wordSet.remove(word); // Exclude the current word from wordSet
            if (isCompounded(word, wordSet, new HashMap<>())) {
                if (longestFound) {
                    return word;
                } else if (word.equals(longestWord)) {
                    longestFound = true;
                }
            }
            wordSet.add(word); // Add back the word for future checks
        }
        return "";
    }
}