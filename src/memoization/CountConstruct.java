package memoization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {
    public static void main(String[] args) {
        System.out.println(countConstruct_rec("abcdef", List.of("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct_rec("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar")));
        System.out.println("*************");
        System.out.println(countConstruct_mem("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), new HashMap<>()));
        System.out.println(countConstruct_mem("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar"), new HashMap<>()));
        System.out.println(countConstruct_mem("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee"), new HashMap<>()));
    }

    /**
     *
     * m: target.length
     * n: wordBank.length
     *
     * time: O(n^m * m)
     * space: O(m^2)
     *
     */

    public static Integer countConstruct_rec(String target, List<String> wordBank) {
        if (target.isEmpty()) return 1;

        Integer totalCount = 0;

        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                totalCount += countConstruct_rec(suffix, wordBank);
            }
        }
        return totalCount;
    }


    /**
     *
     * m: target.length
     * n: wordBank.length
     *
     * time: O(n * m * m)
     * space: O(m^2)
     *
     */
    public static Integer countConstruct_mem(String target, List<String> wordBank, Map<String, Integer> map) {
        if (map.containsKey(target)) return map.get(target);
        if (target.isEmpty()) return 1;

        Integer totalCount = 0;

        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                totalCount += countConstruct_mem(suffix, wordBank, map);
            }
        }

        map.put(target, totalCount);
        return totalCount;
    }

}
