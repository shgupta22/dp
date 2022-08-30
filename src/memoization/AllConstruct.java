package memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstruct {
    public static void main(String[] args) {
        System.out.println(allConstruct_rec("purple", List.of("purp", "p", "ur", "le", "purpl")));
        System.out.println(allConstruct_rec("abcdef", List.of("ab", "abc", "cd", "def", "abcd","ef","c", "abcde")));
        System.out.println(allConstruct_rec("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar")));
        System.out.println("*************");
        System.out.println(allConstruct_mem("purple", List.of("purp", "p", "ur", "le", "purpl"), new HashMap<>()));
        System.out.println(allConstruct_rec("abcdef", List.of("ab", "abc", "cd", "def", "abcd","ef","c", "abcde")));
        System.out.println(allConstruct_mem("skateboard", List.of("bo", "rd", "ate", "t", "ska","sk","boar"), new HashMap<>()));
        System.out.println(allConstruct_mem("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeeee"), new HashMap<>()));
    }

    public static List<List<String>> allConstruct_rec(String target, List<String> wordBank) {
        if (target.isEmpty()) {
            List<List<String>> objects = new ArrayList<>();
            objects.add(new ArrayList<>());
            return objects;
        }

        List<List<String>> result = new ArrayList<>();

        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct_rec(suffix, wordBank);
                List<List<String>> targetWays = suffixWays.stream().peek(ways -> ways.add(0, word)).collect(Collectors.toList());
                result.addAll(targetWays);
            }
        }
        return result;
    }

    public static List<List<String>> allConstruct_mem(String target, List<String> wordBank, Map<String, List<List<String>>> map) {
        if (map.containsKey(target)) return map.get(target);

        if (target.isEmpty()) {
            List<List<String>> objects = new ArrayList<>();
            objects.add(new ArrayList<>());
            return objects;
        }

        List<List<String>> result = new ArrayList<>();

        for (String word: wordBank) {
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct_mem(suffix, wordBank, map);
                List<List<String>> targetWays = suffixWays.stream().peek(ways -> ways.add(0, word)).collect(Collectors.toList());
                result.addAll(targetWays);
            }
        }
        map.put(target, result);
        return result;
    }
}
