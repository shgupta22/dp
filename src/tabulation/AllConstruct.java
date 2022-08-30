package tabulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {
        System.out.println(allConstruct("purple", List.of("purp", "p", "ur", "le", "purpl")));
//        System.out.println(allConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd","ef","c", "abcde")));
//        System.out.println(allConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar")));
//        System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee")));
    }

    public static List<List<String>> allConstruct(String target, List<String> wordBank) {
        List<List<List<String>>> table = new ArrayList<>(target.length() + 1);
        for(int i =0;  i <= target.length(); i++) table.add(new ArrayList<>());
        for(int i =0;  i <= target.length(); i++) {
            table.get(i).add(new ArrayList<>());
        }

        table.add(0, new ArrayList<>());

        for (int i=0; i<= target.length(); i ++) {
            for (String word: wordBank) {
                if (target.startsWith(word, i)) {
                    List<List<String>> lists = table.get(i);
                    ArrayList<List<String>> lists1 = new ArrayList<>(lists);
                    lists1.forEach(l -> l.add(word));
                    List<List<String>> lists2 = table.get(i + word.length());
//                    lists2.forEach();

                }
            }
        }

        return table.get(target.length());
    }
}
