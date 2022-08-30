package tabulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct("purple", List.of("purp", "p", "ur", "le", "purpl")));
        System.out.println(countConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar")));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee")));
    }

    public static Long countConstruct(String target, List<String> wordBank) {
        List<Long> table = new ArrayList<>(target.length() + 1);
        for(int i =0;  i <= target.length(); i++) table.add(0L);
        table.add(0, 1L);

        for (int i = 0; i <= target.length(); i++) {
            if (table.get(i) != 0) {
                for (String word: wordBank) {
                    if (target.startsWith(word, i)) {
                        table.set(i + word.length(), table.get(i + word.length()) + table.get(i) );
                    }
                }
            }
        }
        return table.get(target.length());
    }
}
