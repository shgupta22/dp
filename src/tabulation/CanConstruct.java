package tabulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println(canConstruct("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar")));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee")));
    }

    public static boolean canConstruct(String target, List<String> wordBank) {
        List<Boolean> table = new ArrayList<>(target.length() + 1);
        for(int i =0;  i <= target.length(); i++) table.add(false);
        table.add(0, true);

        for (int i =0; i <= target.length(); i++) {
            if (table.get(i)) {
                for (String word : wordBank) {
                    if (target.startsWith(word, i)) {
                        table.set(i + word.length(), true);
                    }
                }
            }
        }
        return table.get(target.length());
    }
}
