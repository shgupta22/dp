package memoization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct_rec("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println(canConstruct_rec("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar")));
        System.out.println("*************");
        System.out.println(canConstruct_mem("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), new HashMap<>()));
        System.out.println(canConstruct_mem("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar"), new HashMap<>()));
        System.out.println(canConstruct_mem("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee"), new HashMap<>()));
    }

    /**
     * m: target.length
     * n: wordBank.length
     *
     * time: O(n^m + m)
     * space: O(m * m)
     */

    public static boolean canConstruct_rec(String target, List<String> wordBank) {
        if (target.isEmpty()) return true;

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstruct_rec(suffix, wordBank)) return true;
            }
        }

        return false;
    }

    /**
     * m: target.length
     * n: wordBank.length
     *
     * time: O(n * m2)
     * space: O(m2)
     */

    public static boolean canConstruct_mem(String target, List<String> wordBank, Map<String, Boolean> map) {
        if (map.containsKey(target)) return map.get(target);
        if (target.isEmpty()) return true;

        for (String word : wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if (canConstruct_mem(suffix, wordBank, map)) {
                    map.put(target, true);
                    return true;
                }
            }
        }

        map.put(target, false);
        return false;
    }
}
